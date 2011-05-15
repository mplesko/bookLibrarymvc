package com.logansrings.booklibrary.dao;

import com.logansrings.booklibrary.model.User;

public interface UserDao {

	User save(String userName, String password, String email);
	public User findByUsername(String username);
	public User findByEmail(String email);

}