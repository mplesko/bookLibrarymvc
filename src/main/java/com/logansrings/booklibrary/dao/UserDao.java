package com.logansrings.booklibrary.dao;

import com.logansrings.booklibrary.model.Book;
import com.logansrings.booklibrary.model.User;

public interface UserDao {

	User save(String userName, String password, String email);
	User findByUsername(String username);
	User findByEmail(String email);
	void update(User user);

}
