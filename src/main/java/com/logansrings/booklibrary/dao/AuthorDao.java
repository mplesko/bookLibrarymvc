package com.logansrings.booklibrary.dao;

import java.util.List;

import com.logansrings.booklibrary.model.Author;

public interface AuthorDao {

	List<Author> getAuthors();
	Author save(String authorFirstName, String authorLastName);
	Author find(String authorFirstName, String authorLastName);
	Author find(Integer authorId);

}
