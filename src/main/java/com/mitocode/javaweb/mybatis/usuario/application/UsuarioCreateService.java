package com.mitocode.javaweb.mybatis.usuario.application;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mitocode.javaweb.mybatis.usuario.domain.Usuario;
import com.mitocode.javaweb.mybatis.usuario.domain.UsuarioRepository;
import com.mitocode.javaweb.mybatis.usuario.domain.exception.UsuarioAlreadyExistsException;

@Service
public class UsuarioCreateService {

	private UsuarioRepository usuarioRepository;

	public UsuarioCreateService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public int save(Usuario usuario) throws UsuarioAlreadyExistsException {

		Optional<Usuario> oUsuario = usuarioRepository.findByUsuario(usuario.getUsuario());

		if (oUsuario.isPresent()) {
			throw new UsuarioAlreadyExistsException();
		}

		int result = usuarioRepository.save(usuario);

		if (result > 0) {
			usuario.setId(usuario.getId());
		}
		return result;
	}

}
