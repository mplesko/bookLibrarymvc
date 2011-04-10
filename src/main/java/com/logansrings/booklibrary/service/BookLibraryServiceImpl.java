package com.logansrings.booklibrary.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logansrings.booklibrary.dao.AuthorDao;
import com.logansrings.booklibrary.dao.BookDao;
import com.logansrings.booklibrary.model.Author;
import com.logansrings.booklibrary.model.Book;

@Service
public class BookLibraryServiceImpl implements BookLibraryService {

	@Autowired
	private AuthorDao authorDao;
	@Autowired
	private BookDao bookDao;
	
	public Collection<Book> getBooks() {
		return bookDao.getBooks();
	}

	public Collection<Author> getAuthors() {
		return authorDao.getAuthors();
	}

}
