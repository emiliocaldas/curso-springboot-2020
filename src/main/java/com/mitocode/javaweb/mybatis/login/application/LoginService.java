package com.mitocode.javaweb.mybatis.login.application;

import org.springframework.stereotype.Service;

import com.mitocode.javaweb.mybatis.login.domain.exception.BadCredentialsException;
import com.mitocode.javaweb.mybatis.login.domain.exception.UserBlockedException;
import com.mitocode.javaweb.mybatis.usuario.domain.Usuario;
import com.mitocode.javaweb.mybatis.usuario.domain.UsuarioEstadoEnum;
import com.mitocode.javaweb.mybatis.usuario.domain.UsuarioRepository;

@Service
public class LoginService {

	private UsuarioRepository usuarioRepository;
	
	public LoginService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public Usuario validarUsuarioClave(String usuario, String clave) throws BadCredentialsException, UserBlockedException {
		boolean resultado = usuarioRepository.login(usuario, clave);
		
		if(!resultado) {
			throw new BadCredentialsException();
		} else {
			Usuario oUsuario = usuarioRepository.findByUsuario(usuario).get();
			
			if(oUsuario.getEstado().equals(UsuarioEstadoEnum.BLOQUEADO)) {
				throw new UserBlockedException();
			} else {
				return oUsuario;
			}
		}
	}
}
