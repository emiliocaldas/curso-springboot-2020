package com.mitocode.javaweb.mybatis.usuario.infraestructure.dto;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.mitocode.javaweb.mybatis.usuario.domain.Usuario;
import com.mitocode.javaweb.mybatis.usuario.domain.dto.UsuarioDto;

@Mapper(componentModel = "spring")
public interface UsuarioDtoMapper {

	@Mappings({
		@Mapping(source = "clave", target = "claveUsuario"),
		@Mapping(target = "id", defaultValue = "-1")
	})
	public Usuario toUsuario(UsuarioDto usuarioDto);
	
	@InheritInverseConfiguration
	@Mapping(target = "id", defaultValue = "-1")
	public UsuarioDto toUsuarioDto(Usuario usuario);
	
	public List<Usuario> toUsuarios(List<UsuarioDto> usuarioDtos);
	
	public List<UsuarioDto> toUsuarioDtos(List<Usuario> usuarios);
	
}
