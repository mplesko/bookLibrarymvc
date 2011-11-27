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
		if (isEmpty(username, password)) {
			return User.getInvalidUser("incomplete");
		}
		User user = userDao.findByUsername(username);
		if (user == null) {
			return userDao.save(username, password, email);
		} else {
			return User.getInvalidUser("duplicate username");			
		}		
	}

	@Override
	public Collection<Book> getLibraryBooks(String username) {
		User user = userDao.findByUsername(username);
		return user.getBooks();
	}

	@Override
	public Author addAuthor(String authorFirstName, String authorLastName) {
		if (isEmpty(authorFirstName, authorLastName)) {
			return Author.getInvalidAuthor("incomplete");
		}
		Author author = authorDao.find(authorFirstName, authorLastName);
		if (author == null) {
			return authorDao.save(authorFirstName, authorLastName);
		} else {
			return Author.getInvalidAuthor("duplicate author");			
		}		
	}
	
	/**
	 * @param strings
	 * @return true if any strings are null or zero length
	 */
	public static boolean isEmpty(String ... strings) {
		for (String value : strings) {
			if (value == null || value.length() == 0) {
				return true;
			}
		}
		return false;
	}



}
