package com.mitocode.javaweb.mybatis.application;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mitocode.javaweb.mybatis.usuario.application.UsuarioFinderService;
import com.mitocode.javaweb.mybatis.usuario.domain.Usuario;
import com.mitocode.javaweb.mybatis.usuario.domain.UsuarioRepository;
import com.mitocode.javaweb.mybatis.usuario.domain.exception.UsuarioNotFoundException;

@SpringBootTest
public class UsuarioFinderServiceTest {
	
	private static final Logger log = LoggerFactory.getLogger(UsuarioFinderServiceTest.class);

	@Autowired
	private UsuarioFinderService usuarioFinderService;
	
	@MockBean
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	public static void setUp() {
		log.info("setUp()");
	}
	
	@BeforeEach
	public void init() {
		log.info("init()");
		Usuario usuario = new Usuario("juanpablo", "Juan Pablo Mock", "123");
		Mockito.when(usuarioRepository.findByUsuario(usuario.getUsuario())).thenReturn(Optional.of(usuario));
		Mockito.when(usuarioRepository.findAll()).thenReturn(Arrays.asList(usuario));
		
		usuarioFinderService = new UsuarioFinderService(usuarioRepository);
	}
	
	@Test
	@DisplayName("Prueba que invoca la lista de usuarios")
	@Disabled
	public void obtenerLaListaDeUsuarios() {
		Optional<List<Usuario>> lista = usuarioFinderService.findAll();
		
		assertTrue(lista.isPresent());
		assertFalse(lista.get().isEmpty());
		
		lista.get().forEach(user -> log.debug(user.toString()));
	}
	
	@Test
	public void consultarPorUsuario() throws UsuarioNotFoundException {
		Usuario usuario = usuarioFinderService.findByUsuario("juanpablo");
		
		assertNotNull(usuario);
		
		log.debug(usuario.toString());
	}

}
