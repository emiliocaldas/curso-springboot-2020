package com.mitocode.javaweb.mybatis.usuario.domain;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {

	public List<Usuario> findAll();

	public Optional<Usuario> findById(Integer id);

	public Optional<Usuario> findByUsuario(String usuario);

	public int save(Usuario usuario);

	public boolean login(String usuario, String clave);

	public int updatePassword(Integer id, String nuevaClave);

}
