package com.mitocode.javaweb.mybatis.usuario.infraestructure.web;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class RegisterForm {

	@NotBlank(message = "{register.forms.fullname.notempty}")
	private String fullName;
	
	@NotBlank(message = "{register.forms.email.notempty}")
	@Email(message = "{register.forms.email.format}")		
	private String email;
	
	@NotBlank(message = "{register.forms.password.notempty}")
	private String password;
	
	@NotBlank(message = "{register.forms.confirmpassword.notempty}")
	private String confirmPassword;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String username) {
		this.fullName = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public Boolean isPasswordAndConfirmEquals() {
		return password.equals(confirmPassword);
	}
	
}
