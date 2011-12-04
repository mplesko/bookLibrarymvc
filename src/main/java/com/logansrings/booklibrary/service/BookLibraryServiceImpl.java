package com.logansrings.booklibrary.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
		List<Book> books = bookDao.getBooks();
		Collections.sort(books);
		return books;
	}

	public Collection<Author> getAuthors() {
		List<Author> authors = authorDao.getAuthors();
		Collections.sort(authors);
		return authors;
	}

	public User register(String userName, String password, String email) {
		User user = userDao.findByUsername(userName);
		if (user == null) {
			return userDao.save(userName, password, email);
		} else {
			return User.getInvalidUser("duplicate username");			
		}		
	}

	@Override
	public Collection<Book> getLibraryBooks(String userName) {
		User user = userDao.findByUsername(userName);
		List<Book> books = new ArrayList<Book>(user.getBooks());
		Collections.sort(books);
		return books;
	}

	@Override
	public Author addAuthor(String authorFirstName, String authorLastName) {
		Author author = authorDao.find(authorFirstName, authorLastName);
		if (author == null) {
			return authorDao.save(authorFirstName, authorLastName);
		} else {
			return Author.getInvalidAuthor("duplicate author");			
		}		
	}

	@Override
	public Book addBook(String title, Author author) {
		Book book = bookDao.find(title, author);
		if (book == null) {
			return bookDao.save(title, author);
		} else {
			return Book.getInvalidBook("duplicate book");
		}
	}

	@Override
	public Author getAuthor(Integer authorId) {
		Author author = authorDao.find(authorId);
		if (author == null) {
			author = Author.getInvalidAuthor("not found");
		}
		return author;
	}

	@Override
	public Book getBook(Integer bookId) {
		Book book = bookDao.find(bookId);
		if (book == null) {
			book = Book.getInvalidBook("not found");
		}
		return book;
	}

	@Override
	public Book addBookToLibrary(String userName, Integer bookId) {
		User user = userDao.findByUsername(userName);
		Book book = bookDao.find(bookId);
		if (book == null) {
			return Book.getInvalidBook("not found");
		}
		user.getBooks().add(book);
		userDao.update(user);
		return book;
	}

	@Override
	public void deleteBooksFromLibrary(String userName, int[] selectedBookIds) {
		User user = userDao.findByUsername(userName);
		for (int bookId : selectedBookIds) {
			Book book = getBook(bookId);
			if (user.getBooks().contains(book)) {
				user.getBooks().remove(book);
			}
		}
		userDao.update(user);
	}
	
}
