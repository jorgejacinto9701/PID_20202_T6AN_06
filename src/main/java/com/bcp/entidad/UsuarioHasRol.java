package com.bcp.entidad;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_has_rol")
public class UsuarioHasRol {

	@EmbeddedId
	private UsuarioHasRolPK usuarioHasRolPk;

	@ManyToOne
	@JoinColumn(name = "idusuario", nullable = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "idrol", nullable = false)
	private Rol rol;
	
	public UsuarioHasRolPK getUsuarioHasRolPk() {
		return usuarioHasRolPk;
	}

	public void setUsuarioHasRolPk(UsuarioHasRolPK usuarioHasRolPk) {
		this.usuarioHasRolPk = usuarioHasRolPk;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
}
