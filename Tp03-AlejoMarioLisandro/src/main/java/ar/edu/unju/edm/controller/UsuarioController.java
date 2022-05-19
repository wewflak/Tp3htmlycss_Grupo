package ar.edu.unju.edm.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.util.ListadoUsuarios;

@Controller
public class UsuarioController {
	private static final Log SRT = LogFactory.getLog(UsuarioController.class);
	@Autowired
	Usuario nuevoUsuario;
	@Autowired
	ListadoUsuarios lista;
	@GetMapping("/cargarusuario")//entrega usuarios
	public ModelAndView addUser() {
		ModelAndView vista = new ModelAndView("cargarusuario");
		vista.addObject("usuario", nuevoUsuario);
		return vista;
		
	}
	
	@PostMapping("/guardarusuario")//recibe datos
	public String saveUser(@Valid @ModelAttribute ("usuario") Usuario usuarioparaguardar, BindingResult resultado, Model model) {
		SRT.info("Ingresando al metodo guardar Usuario: "+usuarioparaguardar.getApellido());
		if(resultado.hasErrors()) {
			SRT.fatal("Error de validacion");
			model.addAttribute("usuario", usuarioparaguardar);
			return "cargarusuario";
		}else {
		lista.getListado().add(usuarioparaguardar);
		SRT.error("Tamaño listado: " + lista.getListado().size());
		
		return "redirect:/cargarusuario";
	}
	}
	@GetMapping("/mostrarusuario")
	public ModelAndView showuser() {
		ModelAndView vista = new ModelAndView("mostrarusuario");
		vista.addObject(lista.getListado());
		return vista;
	}
}
