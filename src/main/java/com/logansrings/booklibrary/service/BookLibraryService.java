package com.logansrings.booklibrary.service;

import java.util.Collection;
import com.logansrings.booklibrary.model.*;

public interface BookLibraryService {

	Collection<Book> getBooks();
	Collection<Author> getAuthors();
	Author addAuthor(String authorFirstName, String authorLastName);
	User register(String username, String password, String email);
	Collection<Book> getLibraryBooks(String username);
	
}
