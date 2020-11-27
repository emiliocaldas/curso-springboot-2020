package com.mitocode.javaweb.mybatis.usuario.infraestructure.web;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ChangePasswordForm {
	
	@NotBlank(message = "{changepwd.forms.email.notempty}")
	@Email(message = "{changepwd.forms.email.format}")	
	private String username;
	
	@NotBlank(message = "{changepwd.forms.oldpassword.notempty}")
	private String oldPassword;
	
	@NotBlank(message = "{changepwd.forms.newpassword.notempty}")
	private String newPassword;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
}
