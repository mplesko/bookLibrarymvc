package com.logansrings.booklibrary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "authorities" )
public class UserAuthority {
	
	@Id
	@GeneratedValue
//	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;
	@Column(name = "username")
	private String username = "";
	@Column(name = "authority")
	private String authority = "";

	public static UserAuthority getDefaultAuthority(String username) {
		UserAuthority userAuthority = new UserAuthority();
		userAuthority.username = username;
		userAuthority.authority = "ROLE_USER";
		return userAuthority;
	}
	
	public String toString() {
		return new String(username + " " + authority);
	}
}
