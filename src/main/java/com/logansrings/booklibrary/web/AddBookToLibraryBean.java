package com.logansrings.booklibrary.web;

public class AddBookToLibraryBean {
	
	private Integer bookId;
		
	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("bookId: ").append(bookId);
		return sb.toString();
	}
}
