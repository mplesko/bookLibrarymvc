package com.logansrings.booklibrary.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logansrings.booklibrary.dao.AuthorDao;
import com.logansrings.booklibrary.dao.BookDao;
import com.logansrings.booklibrary.dao.UserDao;
import com.logansrings.booklibrary.model.Author;
import com.logansrings.booklibrary.model.Book;
import com.logansrings.booklibrary.model.User;

@Service
public class BookLibraryServiceImpl implements BookLibraryService {

	@Autowired
	private AuthorDao authorDao;
	@Autowired
	private BookDao bookDao;
	@Autowired
	private UserDao userDao;
	
	public Collection<Book> getBooks() {
		return bookDao.getBooks();
	}

	public Collection<Author> getAuthors() {
		return authorDao.getAuthors();
	}

	public User register(String username, String password, String email) {
		User user = userDao.findByUsername(username);
		if (user == null) {
			// ok, expected
		} else {
			User invalidUser = User.getInvalidUser("duplicate username");
			
		}
		return userDao.register(username, password, email);
	}

}
