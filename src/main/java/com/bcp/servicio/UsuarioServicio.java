package com.bcp.servicio;

import java.util.List;

import com.bcp.entidad.Opcion;
import com.bcp.entidad.Rol;
import com.bcp.entidad.Usuario;

public interface UsuarioServicio {

	public abstract Usuario login(Usuario bean);

	public abstract List<Opcion> traerEnlacesDeUsuario(int idUsuario);

	public abstract List<Rol> traerRolesDeUsuario(int idUsuario);
	
}
