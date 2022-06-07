package ar.edu.unju.edm.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.Curso;
import ar.edu.unju.edm.service.ICursoService;


@Controller
public class CursoController {
private static final Log GUSTAVO = LogFactory.getLog(CursoController.class);

@Autowired
Curso nuevoUsuario;

@Autowired
ICursoService usuarioService;
	
@GetMapping("/nuevoCurso")
public ModelAndView addUser() {
	GUSTAVO.info("ingresando al metodo: bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
	ModelAndView modelView = new ModelAndView("usuarios");
	//modelView.addObject("index");
	modelView.addObject("unUsuario", nuevoUsuario);
	modelView.addObject("editMode",false);
	//modelView.addObject("formUsuarioErrorMessage","HOLA");
	
	return modelView;
}

//diferenciar Valid y Validated
@PostMapping("/guardarCurso")
public String saveUser(@Valid @ModelAttribute("unUsuario") Curso usuarioNuevo, BindingResult resultado, ModelMap model) {			
		// VERIFICACION DEL NOMBRE Y DNI	
	if (resultado.hasErrors()) {
		GUSTAVO.fatal("ERROR DE VALIDACION");			
		model.addAttribute("unUsuario", usuarioNuevo);			
		return "usuarios";
	}		
	try {
		usuarioService.guardarCurso(usuarioNuevo);
	} catch (Exception e) {			
		model.addAttribute("formUsuarioErrorMessage", e.getMessage());
		model.addAttribute("unUsuario", usuarioNuevo);
		GUSTAVO.error("saliendo del metodo: eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		return "usuarios";		
	}		
	
	model.addAttribute("formUsuarioErrorMessage", "Usuario guardado correctamente");
	model.addAttribute("unUsuario", nuevoUsuario);			
	return "usuarios";
	}

@GetMapping("/listadoCurso")	
// opcion 1
public ModelAndView showUser() {
	ModelAndView vista = new ModelAndView("getUsers");		
	vista.addObject("listadoCursos", usuarioService.listarCursos());	
	GUSTAVO.info("ingresando al metodo: cvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv"+usuarioService.listarCursos().get(0).getNombre());
	return vista;
}

@GetMapping("/eliminarCurso/{id}")
public String eliminar(@PathVariable Integer id, Model model) {	
	try {
	usuarioService.eliminarCurso(id);
	}catch(Exception e) {
		GUSTAVO.error("encontrando: eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		model.addAttribute("formUsuarioErrorMessage", e.getMessage());
		return "redirect:/nuevoUsuario";			
	}
	return "redirect:/listadoCurso";
}

@GetMapping("/editarCurso/{dni}")
public ModelAndView ObtenerFormularioEditarUsuario(Model model, @PathVariable(name="dni") Integer dni) throws Exception {
	//buscar usuario en el listado
	Curso usuarioEncontrado = new Curso();
	usuarioEncontrado = usuarioService.buscarCurso(dni);	
	ModelAndView modelView = new ModelAndView("usuarios");
	modelView.addObject("unUsuario", usuarioEncontrado);
	GUSTAVO.error("saliendo del metodo: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+ usuarioEncontrado.getDni());
	modelView.addObject("editMode",true);		
	return modelView;
}



@PostMapping("/editarCurso")
public ModelAndView postEditarUsuario(@ModelAttribute("usuarioF") Curso usuarioModificado) {		
			
			//model.addAttribute("usuarioF", usuario);
			//model.addAttribute("editMode", "false");
		//} catch (Exception e) {
		//	model.addAttribute("formUsuarioErrorMessage", e.getMessage());
		//	model.addAttribute("userForm", usuario);
		//	model.addAttribute("editMode", "true");
		//}
	//}

	//model.addAttribute("usuarios", usuarioService.listarUsuario());
	usuarioService.modificarCurso(usuarioModificado);
	ModelAndView vista = new ModelAndView("getUsers");		
	vista.addObject("listadoCursos", usuarioService.listarCursos());	
	vista.addObject("formUsuarioErrorMessage","Usuario Guardado Correctamente");
	return vista;
}
}
