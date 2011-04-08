package com.logansrings.booklibrary.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.logansrings.booklibrary.model.Author;

@Repository("authorDao")
public class AuthorDaoImpl implements AuthorDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public Collection<Author> getAuthors() {
		return (List<Author>) sessionFactory.getCurrentSession().createCriteria(Author.class).list();
	}

}
