package com.logansrings.booklibrary.web;

//import org.springmodules.validation.bean.conf.loader.annotation.handler.Email;
//import org.springmodules.validation.bean.conf.loader.annotation.handler.Expression;
//import org.springmodules.validation.bean.conf.loader.annotation.handler.MaxLength;
//import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;

public class RegisterBean {
	private String username = "";
	private String password = "";
	private String passwordConfirmation;
	private String email = "";
	
//	@NotBlank
//	@MaxLength(20)
//	private String username = "";
//	
//	@NotBlank
//	@MaxLength(20)
//	@Expression(value = "password equals passwordConfirmation", errorCode = "password.not.match")
//	private String password = "";
//	private String passwordConfirmation;
//	
//	@NotBlank
//	@MaxLength(80)
//	@Email
//	private String email = "";
	
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
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

}
