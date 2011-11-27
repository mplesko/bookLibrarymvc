package com.logansrings.booklibrary.dao;

import java.util.Collection;

import com.logansrings.booklibrary.model.Author;
import com.logansrings.booklibrary.model.Book;

public interface BookDao {

	Collection<Book> getBooks();
	Book addBook(String title, Author author);

}
