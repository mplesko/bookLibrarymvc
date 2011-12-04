package com.logansrings.booklibrary.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import javax.persistence.CascadeType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "userdetails" )
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Integer id;
	
	@Column(name = "username")
	private String username = "";
	@Column(name = "password")
	private String password = "";
	@Column(name = "enabled")
	private boolean enabled = true;
	
	@Transient
	private String email = "";

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER)
	@JoinTable(name = "USERBOOKS",
			joinColumns = {@JoinColumn(name = "USER_ID")},
			inverseJoinColumns = {@JoinColumn(name = "BOOK_ID")})
	private Set<Book> books = new HashSet<Book>();
	public void setBooks(Set<Book> books) {this.books = books;}
	public Set<Book> getBooks() {return books;}
	
	@Transient
	private boolean valid;
	@Transient
	private String context = "";
	@Transient
	private String persistMode = "";

	public User() {}
	
	public User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.valid = true;
	}
	
	public boolean isValid() {return valid;}

	public boolean isNotValid() {return ! isValid();}

	public String getContext() {return context;}

	public String toString() {
		StringBuilder returnValue = new StringBuilder();
		returnValue.append(
				String.format("[%s] id:%d userName:%s valid:%s context:%s bookCount:%d",
				"User", id, username, valid, context, books.size()));
		for (Book book : this.books) {
			returnValue.append("\n");
			returnValue.append(book.toString());
		}
		return returnValue.toString();
	}

	public static User getTestUser() {
		User user = new User();
		user.id = 1;
		user.username = "userName";
		user.password = "password";
		user.valid = true;
		user.context = "context";
		return user;
	}

	public boolean equals(Object other) {
		if (other == null || !(other instanceof User)) {
			return false;
		}		
		final User that = (User)other;
		return this == that || (this.username.equals(that.username));
	}
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + (null == username ? 0 : username.hashCode());
		return hash;
	}
	public static User getInvalidUser(String context) {
		User user = new User();
		user.valid = false;
		user.context = context;
		return user;
	}
}