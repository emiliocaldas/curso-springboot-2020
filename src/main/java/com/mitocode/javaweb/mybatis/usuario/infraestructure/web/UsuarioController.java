package com.mitocode.javaweb.mybatis.usuario.infraestructure.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mitocode.javaweb.mybatis.usuario.application.UsuarioCreateService;
import com.mitocode.javaweb.mybatis.usuario.application.UsuarioFinderService;
import com.mitocode.javaweb.mybatis.usuario.application.UsuarioUpdateService;
import com.mitocode.javaweb.mybatis.usuario.domain.Usuario;
import com.mitocode.javaweb.mybatis.usuario.domain.exception.UsuarioAlreadyExistsException;
import com.mitocode.javaweb.mybatis.usuario.domain.exception.UsuarioBadCredentialsException;
import com.mitocode.javaweb.mybatis.usuario.domain.exception.UsuarioNotFoundException;

@Controller
@PropertySource("classpath:messages.properties")
public class UsuarioController {

	@Autowired
	private UsuarioFinderService usuarioFinderService;

	@Autowired
	private UsuarioUpdateService usuarioUpdateService;

	@Autowired
	private UsuarioCreateService usuarioCreateService;

	@Value("${register.forms.confirmpassword.notequal}")
	private String msjErrorConfirmacionPassword;

	@GetMapping("/listar")
	public void listarUsuarios(Model model) {
		model.addAttribute("usuarios", usuarioFinderService.findAll());
	}

	@GetMapping("/resetpassword")
	public String reestablecerContrasenia(ResetPasswordForm resetPasswordForm) {
		return "login/forgot-password";
	}

	@PostMapping("/resetpassword")
	public String reestablecerContrasenia(@Valid ResetPasswordForm resetPasswordForm, BindingResult bindingResult,
			ModelMap modelMap) {

		if (!bindingResult.hasErrors()) {
			try {
				usuarioUpdateService.resetPassword(resetPasswordForm.getEmail());

				modelMap.put("resetpwdsuccess", true);
			} catch (UsuarioNotFoundException e) {
				modelMap.put("usernotfound", true);
			}
		}

		return "login/forgot-password";
	}

	@GetMapping("/changepassword")
	public String cambiarContrasenia(ChangePasswordForm changePwdForm) {
		return "login/change-password";
	}

	@PostMapping("/changepassword")
	public String cambiarContrasenia(@Valid ChangePasswordForm changePwdForm, BindingResult bindingResult,
			ModelMap modelMap) {

		if (!bindingResult.hasErrors()) {
			try {
				usuarioUpdateService.updatePassword(changePwdForm.getUsername(), changePwdForm.getOldPassword(),
						changePwdForm.getNewPassword());

				modelMap.put("changepwdsuccess", true);
			} catch (UsuarioBadCredentialsException e) {
				modelMap.put("badcredentials", true);
			}
		}

		return "login/change-password";
	}

	@GetMapping("/registeruser")
	public String registrarUsuario(RegisterForm registerForm) {
		return "login/register";
	}

	@PostMapping("/registeruser")
	public String registrarUsuario(@Valid RegisterForm registerForm, BindingResult bindingResult, ModelMap modelMap) {

		if (!bindingResult.hasErrors()) {

			if (registerForm.isPasswordAndConfirmEquals()) {
				Usuario usuario = new Usuario(registerForm.getEmail(), registerForm.getFullName(),
						registerForm.getPassword());

				try {
					usuarioCreateService.save(usuario);

					modelMap.put("registersuccess", true);
				} catch (UsuarioAlreadyExistsException e) {
					modelMap.put("useralreadyexists", true);
				}
			} else {
				bindingResult.addError(new FieldError("registerForm", "confirmPassword", msjErrorConfirmacionPassword));
			}
		}

		return "login/register";
	}

}
