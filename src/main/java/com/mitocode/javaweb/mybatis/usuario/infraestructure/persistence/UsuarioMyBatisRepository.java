package com.mitocode.javaweb.mybatis.usuario.infraestructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mitocode.javaweb.mybatis.usuario.domain.Usuario;
import com.mitocode.javaweb.mybatis.usuario.domain.UsuarioRepository;

@Repository
public class UsuarioMyBatisRepository implements UsuarioRepository {
	
	private UsuarioDaoMapper usuarioDaoMapper;
	
	public UsuarioMyBatisRepository(UsuarioDaoMapper usuarioDaoMapper) {
		this.usuarioDaoMapper = usuarioDaoMapper;
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioDaoMapper.findAll();
	}

	@Override
	public Optional<Usuario> findById(Integer id) {
		return Optional.ofNullable(usuarioDaoMapper.findById(id));
	}

	@Override
	public Optional<Usuario> findByUsuario(String usuario) {
		return Optional.ofNullable(usuarioDaoMapper.findByUsuario(usuario));
	}

	@Override
	public int save(Usuario usuario) {
		return usuarioDaoMapper.save(usuario);
	}

	@Override
	public boolean login(String usuario, String clave) {
		Optional<Usuario> oUsuario = Optional.ofNullable(usuarioDaoMapper.findByUsuarioAndClaveUsuario(usuario, clave));
		if(oUsuario.isPresent()) {
			return true;
		}
		return false;
	}

	@Override
	public int updatePassword(Integer id, String nuevaClave) {
		return usuarioDaoMapper.updatePassword(id, nuevaClave);
	}

}
