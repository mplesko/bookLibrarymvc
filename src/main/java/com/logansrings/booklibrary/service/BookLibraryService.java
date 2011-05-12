package com.logansrings.booklibrary.service;

import java.util.Collection;
import com.logansrings.booklibrary.model.*;

public interface BookLibraryService {

	Collection<Book> getBooks();
	Collection<Author> getAuthors();
	User register(String username, String password, String email);
	
}
