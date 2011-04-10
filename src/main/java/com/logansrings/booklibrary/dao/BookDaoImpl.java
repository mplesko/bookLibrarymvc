package com.logansrings.booklibrary.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.logansrings.booklibrary.model.Book;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public Collection<Book> getBooks() {
		List list = sessionFactory.getCurrentSession().createCriteria(Book.class).list();
		return (List<Book>) sessionFactory.getCurrentSession().createCriteria(Book.class).list();
	}

}
