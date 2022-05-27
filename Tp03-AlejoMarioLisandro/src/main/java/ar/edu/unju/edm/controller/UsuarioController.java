package ar.edu.unju.edm.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.service.IUsuarioService;

@Controller
public class UsuarioController {
	private static final Log SRT = LogFactory.getLog(UsuarioController.class);
	@Autowired
	Usuario nuevoUsuario;
	@Autowired
	IUsuarioService serviceuser;
	@GetMapping("/cargarusuario")//entrega usuarios
	public ModelAndView addUser() {
		ModelAndView vista = new ModelAndView("cargarusuario");
		vista.addObject("usuario", nuevoUsuario);

		vista.addObject("band", "false");
		return vista;
		
	}
	
	@PostMapping("/guardarusuario")//recibe datos
	public String saveUser(@Valid @ModelAttribute ("usuario") Usuario usuarioparaguardar, BindingResult resultado, Model model) {
		SRT.info("Ingresando al metodo guardar Usuario: "+usuarioparaguardar.getDni());
		if(resultado.hasErrors()) {
			SRT.fatal("Error de validacion"+usuarioparaguardar.getApellido());
			model.addAttribute("usuario", usuarioparaguardar);
			return "cargarusuario";
		}else {
		try {

			serviceuser.guardarUsuario(usuarioparaguardar);
			}
		catch(Exception error){
			SRT.error("No se pudo cargar"); 
		}
		System.out.println(usuarioparaguardar.getApellido()+usuarioparaguardar.getEmail());
		return "redirect:/cargarusuario";
	}
	}
	
	@GetMapping("/mostrarusuario")
	public ModelAndView showuser() {
		ModelAndView vista = new ModelAndView("mostrarusuario");
		vista.addObject("listausuarios", serviceuser.mostrarUsuarios());
		return vista;
	}
//	@GetMapping("/editarUsuario/{dni}")
//	public ModelAndView edituser(@PathVariable(name="dni")Long dni) {
//		Usuario usuarioEncontrado = new Usuario();
//		for(int i=0; i<=lista.getListado().size(); i++) {
//			if(lista.getListado().get(i).getDni().equals(dni)) {
//				usuarioEncontrado = lista.getListado().get(i);
//			}
//		}
//		ModelAndView encontrado = new ModelAndView("cargarusuario");
//		encontrado.addObject("usuario", usuarioEncontrado);
//		encontrado.addObject("band", "true");
//		return encontrado;
//	}
//	@PostMapping("ModificarUsuario")
//	public String subUser(@Valid @ModelAttribute ("Usuario") Usuario usuariomodificar, BindingResult resultado, Model model) {
//		SRT.info("Ingresando al metodo guardar Usuario: "+usuariomodificar.getApellido());
//		if(resultado.hasErrors()) {
//			SRT.fatal("Error de validacion");
//			model.addAttribute("usuario", usuariomodificar);
//			return "cargarusuario";
//		}else {
//			for(int i=0; i<=lista.getListado().size(); i++) {
//				if(lista.getListado().get(i).getDni().equals(usuariomodificar.getDni())) {
//				lista.getListado().set(i, usuariomodificar);
//				}
//			}
//		lista.getListado().add(usuariomodificar);
//		SRT.error("Tamaño listado: " + lista.getListado().size());
//		
//		return "redirect:/mostrarusuario";
//	}
//	}
	@GetMapping("/eliminarUsuario/{dni}")
	public String deleteuser(@PathVariable(name="dni")Long dni) {
		try {
		serviceuser.eliminarUsuario(dni);
		}catch(Exception error){
			SRT.error("No se pudo eliminar el usuario");
		}
		return "redirect:/mostrarusuarios";
	}
	}
//	@PostMapping("descartarUsuario")
//	public String descUser(@Valid @ModelAttribute ("Usuario") Usuario usuarioeliminar, BindingResult resultado, Model model) {
//		SRT.info("Ingresando al metodo guardar Usuario: "+usuarioeliminar.getApellido());
//		if(resultado.hasErrors()) {
//			SRT.fatal("Error de validacion");
//			model.addAttribute("usuario", usuarioeliminar);
//			return "cargarusuario";
//		}else {
//			for(int i=0; i<=lista.getListado().size(); i++) {
//				if(lista.getListado().get(i).getDni().equals(usuarioeliminar.getDni())) {
//				lista.getListado().set(i, usuarioeliminar);
//				}
//			}
//		lista.getListado().add(usuarioeliminar);
//		SRT.error("Tamaño listado: " + lista.getListado().size());
//		
//		return "redirect:/mostrarusuario";
//	}
//}
//}
//	
