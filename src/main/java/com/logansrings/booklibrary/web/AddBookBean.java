package com.logansrings.booklibrary.web;

import com.logansrings.booklibrary.model.Author;

public class AddBookBean {
	
	private String bookTitle = "";
	private Long authorId;
	private Author author;
	
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public Long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("bookTitle: ").append(bookTitle).append(" ");
		if (author != null) {
			sb.append(author.toString()); 
		}
		return sb.toString();
	}

}
