package com.logansrings.booklibrary.web;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class RegisterBean {
	
	@NotEmpty
	@Length(max=20)
	private String username = "";
	
	@NotEmpty
	@Length(max=20)
	private String password = "";
	
	@NotEmpty
	@Length(max=20)
	private String passwordConfirm = "";
	
	@NotEmpty
	@Length(max=50)
	@Email
	private String email = "";
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	public boolean validPasswords() {
		return password.equals(passwordConfirm);
	}

}
