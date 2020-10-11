package com.bcp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bcp.entidad.Opcion;
import com.bcp.entidad.Rol;
import com.bcp.entidad.Usuario;
import com.bcp.servicio.UsuarioServicio;

@Controller
public class LoginController {

	@Autowired
	private UsuarioServicio servicio;

	@RequestMapping("/verLogin")
	public String verLogin() {
		return "login";
	}

	//Administración
	@RequestMapping("/verCrudProveedor")
	public String verCrudProveedor() {
		return "intranetCrudProveedor";
	}

	@RequestMapping("/verCrudUsuario")
	public String verCrudUsuario() {
		return "intranetCrudUsuario";
	}

	@RequestMapping("/verCrudTipoDeReclamo")
	public String verCrudTipoDeReclamo() {
		return "intranetCrudTipoDeReclamo";
	}

	@RequestMapping("/verCrudPais")
	public String verCrudPais() {
		return "intranetCrudPais";
	}

	@RequestMapping("/verCrudMarca")
	public String verCrudMarca() {
		return "intranetCrudMarca";
	}

	@RequestMapping("/verCrudRol")
	public String verCrudRol() {
		return "intranetCrudRol";
	}

	@RequestMapping("/verCrudOpcion")
	public String verCrudOpcion() {
		return "intranetCrudOpcion";
	}

	@RequestMapping("/verCrudUbigeo")
	public String verCrudUbigeo() {
		return "intranetCrudUbigeo";
	}

	@RequestMapping("/verCrudCliente")
	public String verCrudCliente() {
		return "intranetCrudCliente";
	}

	@RequestMapping("/verCrudProducto")
	public String verCrudProducto() {
		return "intranetCrudProducto";
	}

	@RequestMapping("/verIntranetHome")
	public String verIntranetHome() {
		return "intranetHome";
	}

	// --Consultar
	@RequestMapping("/verConsultaPedido")
	public String verConsultaPedido() {
		return "intranetConsultaPedido";
	}

	@RequestMapping("/verConsultaCliente")
	public String verConsultaCliente() {
		return "intranetConsultaCliente";
	}

	@RequestMapping("/verConsultaComprobante")
	public String verConsultaComprobante() {
		return "intranetConsultaComprobante";
	}

	@RequestMapping("/verConsultaProducto")
	public String verConsultaProducto() {
		return "intranetConsultaProducto";
	}

	// --Registrar

	@RequestMapping("/verRegistroCliente")
	public String verRegistraCliente() {
		return "intranetRegistroCliente";
	}

	@RequestMapping("/verRegistroComprobante")
	public String verRegistraComprobante() {
		return "intranetRegistroComprobante";
	}

	@RequestMapping("/verRegistroPedido")
	public String verRegistraPedido() {
		return "intranetRegistroPedido";
	}

	@RequestMapping("/verRegistroProducto")
	public String verRegistraProducto() {
		return "intranetRegistroProducto";
	}

	@RequestMapping("/verRegistroReclamo")
	public String verRegistraReclamo() {
		return "intranetRegistroReclamo";
	}

	@RequestMapping("/login")
	public String login(Usuario user, HttpSession session, HttpServletRequest request) {
		Usuario usuario = servicio.login(user);
		if (usuario == null) {
			request.setAttribute("mensaje", "El usuario no existe");
			return "login";
		} else {
			List<Opcion> menus = servicio.traerEnlacesDeUsuario(usuario.getIdUsuario());
			List<Rol> roles = servicio.traerRolesDeUsuario(usuario.getIdUsuario());

			session.setAttribute("objUsuario", usuario);
			session.setAttribute("objMenus", menus);
			session.setAttribute("objRoles", roles);

			return "intranetHome";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		session.invalidate();

		response.setHeader("Cache-control", "no-cache");
		response.setHeader("Expires", "0");
		response.setHeader("Pragma", "no-cache");

		request.setAttribute("mensaje", "El usuario salió de sesión");
		return "login";

	}

}
