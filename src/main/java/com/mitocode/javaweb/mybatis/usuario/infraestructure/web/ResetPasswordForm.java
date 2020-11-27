package com.mitocode.javaweb.mybatis.usuario.infraestructure.web;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ResetPasswordForm {

	@NotBlank(message = "{resetpwd.forms.email.notempty}")
	@Email(message = "{resetpwd.forms.email.format}")		
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
