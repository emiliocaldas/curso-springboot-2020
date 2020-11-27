package com.mitocode.javaweb.mybatis.usuario.domain;

public class Usuario {

	private Integer id;

	private String usuario;

	private String nombres;

	private String claveUsuario;
	
	private UsuarioEstadoEnum estado;
	
	public Usuario() {
		this.estado = UsuarioEstadoEnum.ACTIVO;
	}

	public Usuario(String usuario, String nombres, String claveUsuario) {
		this.usuario = usuario;
		this.nombres = nombres;
		this.claveUsuario = claveUsuario;
		this.estado = UsuarioEstadoEnum.ACTIVO;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getClaveUsuario() {
		return claveUsuario;
	}

	public void setClaveUsuario(String clave) {
		this.claveUsuario = clave;
	}

	public UsuarioEstadoEnum getEstado() {
		return estado;
	}

	public void setEstado(UsuarioEstadoEnum estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", nombres=" + nombres + ", claveUsuario=" + claveUsuario + ", estado="
				+ estado + "]";
	}

}
