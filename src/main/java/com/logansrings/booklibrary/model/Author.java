package com.logansrings.booklibrary.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.logansrings.booklibrary.ApplicationUtilities;

@Entity
@Table( name = "AUTHORS" )
public class Author implements Comparable<Author> {
	@Id
	@Column(name = "id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Integer id;
	@Version
    @Column(name="VERSION")
    private Integer version;

	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;

	@Transient
	private boolean valid = true;
	@Transient
	private String context = "";
	@Transient
	private static final String UNINITIALIZED = "must have firstName and lastName";
	
	Author() {}
	
	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		if (ApplicationUtilities.isEmpty(firstName, lastName)) {
			valid = false;
			context = UNINITIALIZED;
		} else {
			valid = true;
		}
	}
	
	public String toString() {
		return String.format("[%s] id:%d firstName:%s lastName:%s valid:%s context:%s version:%d",
				"Author", id, firstName, lastName, valid, context, version);
	}

	public static Author getTestAuthor() {
		Author author = new Author();
		author.id = 1;
		author.firstName = "authorFirstName";
		author.lastName = "authorLastName";
		author.valid = true;
		author.context = "a context";
		author.version = 1;
		return author;
	}
	public static Author getTestAuthor(String firstName, String lastName) {
		Author author = new Author();
		author.firstName = firstName;
		author.lastName = lastName;
		author.valid = true;
		author.context = "a context";
		author.version = 1;
		return author;
	}

	public boolean isValid() {return valid;}
	public boolean isNotValid() {return ! isValid();}

	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}

	public String getAuthorName() {
		return firstName + " " + lastName;
	}
	public String getDisplayName() {
		return getAuthorName();
	}

	public String getAuthorLastNameFirstName() {
		return lastName + ", " + firstName;
	}

	public String getContext() {return context;}
	
	public void setId(Integer id) {this.id = id;}
	public Integer getId() {return id;}
	
    public Integer getVersion() {return version;}	
    public void setVersion(Integer version) {this.version = version;}	

	public boolean equals(Object other) {
		if (other == null || !(other instanceof Author)) {
			return false;
		}		
		final Author that = (Author)other;
		return this == that ||
				(this.firstName.equals(that.firstName) && 
						this.lastName.equals(that.lastName));
	}
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + (null == firstName ? 0 : firstName.hashCode());
		hash = 31 * hash + (null == lastName ? 0 : lastName.hashCode());
		return hash;
	}
	
	public static Author getInvalidAuthor(String context) {
		Author author = new Author();
		author.valid = false;
		author.context = context;
		return author;
	}

	@Override
	public int compareTo(Author author) {
		if (author == null) {return 0;}
		return getAuthorLastNameFirstName().compareTo(
				author.getAuthorLastNameFirstName());
	}
}