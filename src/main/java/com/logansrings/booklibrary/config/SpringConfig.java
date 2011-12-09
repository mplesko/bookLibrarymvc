package com.logansrings.booklibrary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.logansrings.booklibrary.dao.AuthorDao;
import com.logansrings.booklibrary.dao.AuthorDaoImpl;
import com.logansrings.booklibrary.dao.BookDao;
import com.logansrings.booklibrary.dao.BookDaoImpl;
import com.logansrings.booklibrary.dao.UserDao;
import com.logansrings.booklibrary.dao.UserDaoImpl;
import com.logansrings.booklibrary.service.BookLibraryService;
import com.logansrings.booklibrary.service.BookLibraryServiceImpl;

/**
 * @author mplesko
 * 
 * Configuration component for Spring
 * Another way to define Spring Beans - note the @Configuration annotation
 * Usage defined in a config.xml file with :
 * <context:component-scan base-package="com.logansrings.booklibrary.config" />
 */
@Configuration
public class SpringConfig {

	/**
	 * Main interface for Book Library App
	 * @return
	 */
	@Bean
	public BookLibraryService bookLibraryService() {
		return new BookLibraryServiceImpl();
	}
	/**
	 * Manages the data access for Authors
	 * @return
	 */
	@Bean
	public AuthorDao authorDao() {
		return new AuthorDaoImpl();
	}
	/**
	 * Manages the data access for Books
	 * @return
	 */
	@Bean
	public BookDao bookDao() {
		return new BookDaoImpl();
	}
	/**
	 * Manages the data access for Users
	 * @return
	 */
	@Bean
	public UserDao userDao() {
		return new UserDaoImpl();
	}
}
