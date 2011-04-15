package com.logansrings.booklibrary.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.logansrings.booklibrary.model.Author;

@Repository("authorDao")
public class AuthorDaoImpl implements AuthorDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public Collection<Author> getAuthors() {
		List<Author> list = sessionFactory.getCurrentSession().createCriteria(Author.class).list();
		return list;
	}

}
