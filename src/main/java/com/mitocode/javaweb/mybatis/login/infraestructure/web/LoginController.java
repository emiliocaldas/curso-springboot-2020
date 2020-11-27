package com.mitocode.javaweb.mybatis.login.infraestructure.web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mitocode.javaweb.mybatis.login.application.LoginService;
import com.mitocode.javaweb.mybatis.login.domain.exception.BadCredentialsException;
import com.mitocode.javaweb.mybatis.login.domain.exception.UserBlockedException;
import com.mitocode.javaweb.mybatis.shared.domain.SessionKeys;
import com.mitocode.javaweb.mybatis.usuario.domain.Usuario;
import com.mitocode.javaweb.mybatis.usuario.domain.dto.UsuarioDto;
import com.mitocode.javaweb.mybatis.usuario.infraestructure.dto.UsuarioDtoMapper;

@Controller
public class LoginController {
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	@Autowired
	private UsuarioDtoMapper usuarioDtoMapper;

	@GetMapping("/login")
	public String login(LoginForm loginForm) {
		loginForm.setUsername("juanpablo@mitocodenetwork.com");
		
		return "login/login";
	}
	
	@PostMapping("/login")
	public String iniciarSesion(@Valid LoginForm loginForm, BindingResult bindingResult, ModelMap modelMap,
			HttpSession session) {
		String pageResult = "login/login";
		
		log.info(loginForm.toString());
		
		try {
			if(!bindingResult.hasErrors()) {
				Usuario usuario = loginService.validarUsuarioClave(loginForm.getUsername(), loginForm.getPassword());
				
				session.setAttribute(SessionKeys.LOGIN_USUARIO, usuarioDtoMapper.toUsuarioDto(usuario));
				
				pageResult = "home/home";
			}
		} catch (BadCredentialsException e) {
			modelMap.put("badcredentials", true);
		} catch (UserBlockedException e) {
			modelMap.put("userblocked", true);
		}
		
		return pageResult;
	}
	

	@GetMapping("/logout")
	public String cerrarSesion(HttpSession session) {
		UsuarioDto usuarioDto = (UsuarioDto) session.getAttribute(SessionKeys.LOGIN_USUARIO);
		log.debug(usuarioDto != null ? usuarioDto.toString() : "");
		
		usuarioDto = null;
		session.removeAttribute(SessionKeys.LOGIN_USUARIO);

		return "home/home";
	}
}
