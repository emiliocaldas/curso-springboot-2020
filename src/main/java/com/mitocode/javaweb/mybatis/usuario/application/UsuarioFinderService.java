package com.mitocode.javaweb.mybatis.usuario.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mitocode.javaweb.mybatis.usuario.domain.Usuario;
import com.mitocode.javaweb.mybatis.usuario.domain.UsuarioRepository;
import com.mitocode.javaweb.mybatis.usuario.domain.exception.UsuarioNotFoundException;

@Service
public class UsuarioFinderService {

	private UsuarioRepository usuarioRepository;

	public UsuarioFinderService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public Optional<List<Usuario>> findAll() {
		return Optional.ofNullable(usuarioRepository.findAll());
	}

	public Usuario findByUsuario(String usuario) throws UsuarioNotFoundException {
		// ..
		// ..
		// ..
		
		return usuarioRepository.findByUsuario(usuario).orElseThrow(UsuarioNotFoundException::new);
	}
}
