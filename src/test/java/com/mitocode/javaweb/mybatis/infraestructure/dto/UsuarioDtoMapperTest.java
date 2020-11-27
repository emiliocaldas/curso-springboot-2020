package com.mitocode.javaweb.mybatis.infraestructure.dto;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mitocode.javaweb.mybatis.usuario.domain.Usuario;
import com.mitocode.javaweb.mybatis.usuario.domain.dto.UsuarioDto;
import com.mitocode.javaweb.mybatis.usuario.infraestructure.dto.UsuarioDtoMapper;

@SpringBootTest
public class UsuarioDtoMapperTest {

	private static final Logger log = LoggerFactory.getLogger(UsuarioDtoMapperTest.class);

	@Autowired
	private UsuarioDtoMapper usuarioDtoMapper;
	
	@Test
	public void mapperToUsuarioDto() {
		Usuario usuario = new Usuario("diegojoel", "Diego Requejo", "123");
		
		UsuarioDto dto = usuarioDtoMapper.toUsuarioDto(usuario);
		
		assertNotNull(dto);
		
		log.debug("mapperToUsuario(): " + dto.toString());
	}
	
	@Test
	public void mapperToUsuario() {
		UsuarioDto dto = new UsuarioDto("diegojoel", "Diego Requejo", "123");
		
		Usuario usuario = usuarioDtoMapper.toUsuario(dto);
		
		assertNotNull(usuario);
		
		log.debug("mapperToUsuarioDto: " +usuario.toString());
		
	}
}
