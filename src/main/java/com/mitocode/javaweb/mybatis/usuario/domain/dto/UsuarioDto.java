package com.mitocode.javaweb.mybatis.usuario.domain.dto;

import com.mitocode.javaweb.mybatis.usuario.domain.UsuarioEstadoEnum;

public class UsuarioDto {
	
	private Integer id;

	private String usuario;

	private String nombres;

	private String clave;

	private UsuarioEstadoEnum estado;
	
	public UsuarioDto() {
		this.estado = UsuarioEstadoEnum.ACTIVO;
	}
	
	public UsuarioDto(String usuario, String nombres, String clave) {
		this.usuario = usuario;
		this.nombres = nombres;
		this.clave = clave;
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

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public UsuarioEstadoEnum getEstado() {
		return estado;
	}

	public void setEstado(UsuarioEstadoEnum estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "UsuarioDto [id=" + id + ", usuario=" + usuario + ", nombres=" + nombres + ", clave=" + clave
				+ ", estado=" + estado + "]";
	}
	
	
	
}
