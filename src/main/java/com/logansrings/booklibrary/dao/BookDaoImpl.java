package com.logansrings.booklibrary.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.logansrings.booklibrary.model.Author;
import com.logansrings.booklibrary.model.Book;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public Collection<Book> getBooks() {
		try {
			List<Book> list = sessionFactory.getCurrentSession().createCriteria(Book.class).list();
			return list;
		} catch (Throwable t) {
			System.out.println("junk");
			return null;
		}
	}

	@Transactional(readOnly=false)
	public Book addBook(String title, Author author) {
		Book book = new Book(title, author);
		if (book.isNotValid()) {
			return book;
		}
		sessionFactory.getCurrentSession().save(book);
		return book;
	}

	@Transactional(readOnly=true)
	public Book find(String title, Author author) {
		Book book = new Book(title, author);
		List list = sessionFactory.getCurrentSession().createCriteria(
				book.getClass())
				.add( Example.create(book))
				.list();
		if (list.isEmpty()) {
			return null;
		} else {
			return (Book) list.get(0);
		}
	}

	@Transactional(readOnly=false)
	public Book save(String title, Author author) {
		Book book = new Book(title, author);
		if (book.isNotValid()) {
			return book;
		}
		sessionFactory.getCurrentSession().save(book);
		return book;
	}

	@Transactional(readOnly=true)
	public Book find(Integer bookId) {
		Book book =	(Book) sessionFactory.getCurrentSession().get(
				Book.class, bookId);
		return book;
	}

}
