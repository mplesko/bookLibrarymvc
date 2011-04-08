package com.logansrings.booklibrary.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.logansrings.booklibrary.dao.AuthorDao;
import com.logansrings.booklibrary.model.Author;
import com.logansrings.booklibrary.model.Book;

public class BookLibraryServiceImpl implements BookLibraryService {

	@Autowired
	private AuthorDao authorDao;
	
	public Collection<Book> getBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Author> getAuthors() {
		return authorDao.getAuthors();
	}

}
