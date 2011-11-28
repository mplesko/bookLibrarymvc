package com.logansrings.booklibrary.dao;

import java.util.Collection;

import com.logansrings.booklibrary.model.Author;
import com.logansrings.booklibrary.model.Book;

public interface BookDao {

	Collection<Book> getBooks();
	Book addBook(String title, Author author);
	Book find(String title, Author author);
	Book save(String title, Author author);
	Book find(Integer bookId);

}
