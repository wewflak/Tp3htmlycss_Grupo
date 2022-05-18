package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;


import org.springframework.ui.Model;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.util.ListadoUsuarios;

@Controller
public class UsuarioController {
	@Autowired
	Usuario nuevoUsuario;
	@Autowired
	ListadoUsuarios lista;
	@GetMapping("/cargarusuario")
	public ModelAndView addUser() {
		ModelAndView vista = new ModelAndView("cargarusuario");
		vista.addObject("usuario", "nuevoUsuario");
		return vista;
		
	}
	
	@GetMapping("/mostrarusuario")
	public String saveUser(@ModelAttribute ("usuario") Usuario usuarioparaguardar, Model model) {
		lista.getListado().add(usuarioparaguardar);
		System.out.print("Tamaño listado: " + lista.getListado().size());
		model.addAttribute("listadoUsuarios", lista.getListado());
		return "mostrarusuario";
	}

}
