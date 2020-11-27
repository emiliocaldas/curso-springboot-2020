package com.mitocode.javaweb.mybatis.usuario.infraestructure.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mitocode.javaweb.mybatis.usuario.domain.Usuario;

@Mapper
public interface UsuarioDaoMapper {

	@Select("SELECT id, usuario, nombres, clave, estado FROM usuario")
	@Results({ @Result(column = "clave", property = "claveUsuario") })
	public List<Usuario> findAll();

	@Select("SELECT id, usuario, nombres, clave, estado FROM usuario WHERE id = #{id}")
	@Results({ @Result(column = "clave", property = "claveUsuario") })
	public Usuario findById(Integer id);

	@Select("SELECT id, usuario, nombres, clave, estado FROM usuario WHERE usuario = #{identificador}")
	@Results({ @Result(column = "clave", property = "claveUsuario") })
	public Usuario findByUsuario(@Param("identificador") String usuario);

	@Insert("INSERT INTO usuario(usuario, nombres, clave, estado) VALUES ( #{usuario}, #{nombres}, #{claveUsuario}, #{estado} ) ")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	public int save(Usuario usuarioInsert);

	@Delete("DELETE FROM usuario WHERE id = #{id}")
	public int delete(Integer id);

	@Update("UPDATE usuario SET usuario=#{usuario}, nombres=#{nombres}, clave=#{claveUsuario}, estado=#{estado} WHERE id = #{id}")
	public int update(Usuario usuarioUpdate);

	@Select("SELECT id, usuario, nombres, clave as claveUsuario, estado FROM usuario WHERE usuario = #{usuario} AND clave = #{clave}")
	public Usuario findByUsuarioAndClaveUsuario(String usuario, String clave);

	@Update("UPDATE usuario SET clave=#{nuevaClave} WHERE id = #{id}")
	public int updatePassword(Integer id, String nuevaClave);

}
