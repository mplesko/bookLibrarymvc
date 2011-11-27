package com.logansrings.booklibrary.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "BOOKS" )
public class Book {
	@Id
	@Column(name = "id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Integer id;
	@Version
	@Column(name="VERSION")
	private Integer version;

	@Column(name = "TITLE")
	private String title = "";

	@ManyToOne(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="AUTHOR_ID")
	private Author author;

//	@Transient
//	private Long authorId;
	@Transient
	private boolean valid;
	@Transient
	private String context = "";

	protected Book() {}

//	Book(Long bookId) {
//		this.id = bookId;
//		valid = true;
//	}

	private Book(String title, Author author) {
		this.title = title;
		this.author = author;		
//		if (ApplicationUtilities.isEmpty(title)) {
//			valid = false;
//			context = "must have title";
//		} else {
//			if (author == null) {
//				valid = false;
//				context = "must have author";
//			} else {
//				valid = true;
//			}
//		}
	}


	public String getToString() {
		return toString();
	}
	public String toString() {
		return String.format("[%s] id:%d title:%s valid:%s context:%s  version:%d author:%s",
				"Book", id, title, valid, context, version, author.toString());
	}

	public static Book getTestBook() {
		Book book = new Book();
		book.id = 1;
		book.title = "bookTitle";
		book.author = Author.getTestAuthor();		
		book.valid = true;
		book.context = "a context";
		book.version = 1;
		return book;
	}

	public static Book getTestBook(String title, Author author) {
		Book book = new Book();
		book.title = title;
		book.author = author;		
		book.valid = true;
		book.context = "a context";
		book.version = 1;
		return book;
	}

	public String getTitle() {return title;}

	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}

//	Long getAuthorId() {return authorId;}

	public String getAuthorFirstName() {return author.getFirstName();}
	public String getAuthorLastName() {return author.getLastName();}
	public String getAuthorName() {return author.getAuthorName();}

	public boolean isValid() {return valid;}
	public boolean isNotValid() {return ! isValid();}

//	public Integer getVersion() {return version;}
//	public void setVersion(Integer version) {this.version = version;}

	public boolean equals(Object other) {
		if (other == null || !(other instanceof Book)) {
			return false;
		}		
		final Book that = (Book)other;
		return this == that ||
		(this.title.equals(that.title) && 
				this.author.equals(that.author));
	}
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + (null == title ? 0 : title.hashCode());
		hash = 31 * hash + (null == author ? 0 : author.hashCode());
		return hash;
	}

//	public void setAssociatedPersistable(Persistable associatedPersistable) {
//		author = (Author)associatedPersistable;		
//	}
}
