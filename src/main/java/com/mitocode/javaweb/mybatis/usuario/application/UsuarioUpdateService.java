package com.mitocode.javaweb.mybatis.usuario.application;

import java.util.Optional;
import java.util.Random;
import org.springframework.stereotype.Service;
import com.mitocode.javaweb.mybatis.usuario.domain.Usuario;
import com.mitocode.javaweb.mybatis.usuario.domain.UsuarioRepository;
import com.mitocode.javaweb.mybatis.usuario.domain.exception.UsuarioBadCredentialsException;
import com.mitocode.javaweb.mybatis.usuario.domain.exception.UsuarioNotFoundException;

@Service
public class UsuarioUpdateService {

	private UsuarioRepository usuarioRepository;

	public UsuarioUpdateService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public int resetPassword(String usuario) throws UsuarioNotFoundException {
		Optional<Usuario> oUsuario = usuarioRepository.findByUsuario(usuario);

		if (oUsuario.isPresent()) {
			Integer random = new Random(100).nextInt(1000);

			return usuarioRepository.updatePassword(oUsuario.get().getId(), random.toString());
		} else {
			throw new UsuarioNotFoundException();
		}
	}

	public int updatePassword(String usuario, String claveActual, String nuevaClave)
			throws UsuarioBadCredentialsException {
		boolean resultado = usuarioRepository.login(usuario, claveActual);

		if (!resultado) {
			throw new UsuarioBadCredentialsException();
		} else {
			Usuario oUsuario = usuarioRepository.findByUsuario(usuario).get();
			oUsuario.setClaveUsuario(nuevaClave);

			return usuarioRepository.updatePassword(oUsuario.getId(), oUsuario.getClaveUsuario());
		}
	}

}
