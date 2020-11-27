package com.mitocode.javaweb.mybatis.application;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.javaweb.mybatis.usuario.application.UsuarioCreateService;
import com.mitocode.javaweb.mybatis.usuario.domain.Usuario;
import com.mitocode.javaweb.mybatis.usuario.domain.exception.UsuarioAlreadyExistsException;

@SpringBootTest
@Transactional
public class UsuarioCreateServiceTest {

	private static final Logger log = LoggerFactory.getLogger(UsuarioCreateServiceTest.class);

	@Autowired
	private UsuarioCreateService usuarioCreateService;

	@Test
//	@Commit // Sirve para confirmar la transaccion
	public void crearUsuarioCOnTodosLosCampos() {
		Usuario usuario = new Usuario();
		usuario.setUsuario("diegojoel");
		usuario.setNombres("Diego Requejo");
		usuario.setClaveUsuario("123");

		int filas = 0;
		try {
			filas = usuarioCreateService.save(usuario);
		} catch (UsuarioAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotEquals(0, filas);
		assertNotNull(usuario.getId());

		log.debug(usuario.toString());

	}
}
