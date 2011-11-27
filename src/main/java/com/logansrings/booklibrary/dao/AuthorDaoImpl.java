package com.logansrings.booklibrary.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.logansrings.booklibrary.model.Author;
import com.logansrings.booklibrary.model.User;
import com.logansrings.booklibrary.model.UserAuthority;

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
	
	@Transactional(readOnly=true)
	public Author find(String authorFirstName, String authorLastName) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Author where firstName = ? and lastName = ?");
		query.setParameter(0, authorFirstName);
		query.setParameter(1, authorLastName);
		return (Author) query.uniqueResult();
	}


	@Transactional(readOnly=false)
	public Author save(String authorFirstName, String authorLastName) {
		Author author = new Author(authorFirstName, authorLastName);
		if (author.isNotValid()) {
			return author;
		}
		sessionFactory.getCurrentSession().save(author);
		return author;
	}	


}
