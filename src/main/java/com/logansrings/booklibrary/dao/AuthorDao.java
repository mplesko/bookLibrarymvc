package com.logansrings.booklibrary.dao;

import java.util.Collection;

import com.logansrings.booklibrary.model.Author;

public interface AuthorDao {

	Collection<Author> getAuthors();
	Author save(String authorFirstName, String authorLastName);
	Author find(String authorFirstName, String authorLastName);

}
