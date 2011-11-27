package com.logansrings.booklibrary.web;

public class AddBookBean {
	
	private String bookTitle = "";
	private Integer authorId;
	
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("bookTitle: ").append(bookTitle).append(" ").append(authorId);
		return sb.toString();
	}
}
