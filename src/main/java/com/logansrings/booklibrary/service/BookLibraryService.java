package com.logansrings.booklibrary.service;

import java.util.Collection;
import com.logansrings.booklibrary.model.*;

public interface BookLibraryService {

	Collection<Book> getBooks();
	Collection<Author> getAuthors();
	Author addAuthor(String authorFirstName, String authorLastName);
	User register(String userName, String password, String email);
	Collection<Book> getLibraryBooks(String userName);
	Book addBook(String title, Author author);
	Author getAuthor(Integer authorId);
	Book addBookToLibrary(String userName, Integer bookId);
	
}
