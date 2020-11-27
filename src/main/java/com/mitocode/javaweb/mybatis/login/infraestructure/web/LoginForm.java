package com.mitocode.javaweb.mybatis.login.infraestructure.web;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class LoginForm {
	
	@NotBlank(message = "{login.forms.email.notempty}")
	@Email(message = "{login.forms.email.format}")
	private String username;

	@NotBlank(message = "{login.forms.password.notempty}")
	private String password;

	private boolean rememberMe;

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

	public boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	@Override
	public String toString() {
		return "LoginForm [username=" + username + ", password=" + password + ", rememberMe=" + rememberMe + "]";
	}

}
