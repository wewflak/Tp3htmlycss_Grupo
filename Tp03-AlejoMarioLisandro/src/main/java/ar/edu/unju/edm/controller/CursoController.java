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
private static final Log SRT = LogFactory.getLog(CursoController.class);

@Autowired
Curso nuevoCurso;

@Autowired
ICursoService servicecourse;
	
@GetMapping("/usuarios")
public ModelAndView addUser() {
	ModelAndView vista = new ModelAndView("usuarios");
	vista.addObject("unCurso", nuevoCurso);

	vista.addObject("editMode", false);
	return vista;
}
//diferenciar Valid y Validated
@PostMapping("/guardarCurso")
public String saveUser(@Valid @ModelAttribute("unCurso") Curso cursoNuevo, BindingResult resultado, Model model) {			
		// VERIFICACION DEL NOMBRE Y DNI	
	if (resultado.hasErrors()) {
		SRT.fatal("ERROR DE VALIDACION" + cursoNuevo.getId());			
		model.addAttribute("unCurso", cursoNuevo);			
		return "usuarios";
	}		
	try {
			servicecourse.guardarCurso(cursoNuevo);
	} catch (Exception e) {			
		SRT.error("Error al cargar curso");
		model.addAttribute("formCursoErrorMessage", e.getMessage());
		model.addAttribute("unCurso", cursoNuevo);
		SRT.error("No se pudo guardar el curso");
		return "usuarios";		
	}		
	model.addAttribute("formCursoErrorMessage", "Curso guardado correctamente");
	model.addAttribute("unCurso", nuevoCurso);
	SRT.fatal(cursoNuevo.getId());
	return "usuarios";
	}

@GetMapping("/getUsers")	
// opcion 1
public ModelAndView showUser() {
	ModelAndView vista = new ModelAndView("getUsers");		
	vista.addObject("listadoCursos", servicecourse.listarCursos());	
	SRT.info("ingresando al metodo: cvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
	return vista;
}

@GetMapping("/eliminarCurso/{id}")
public String eliminar(@PathVariable Long id, Model model) {	
	try {
	servicecourse.eliminarCurso(id);
	}catch(Exception error){
		SRT.error("No se pudo eliminar el usuario");
		return "redirect:/usuarios";
	}
	return "redirect:/getUsers";
}

@GetMapping("/editarCurso/{dni}")
public ModelAndView ObtenerFormularioEditarUsuario(Model model, @PathVariable(name="id") Long id) throws Exception {
	//buscar usuario en el listado
	Curso cursoEncontrado = new Curso();
	try {
		cursoEncontrado = servicecourse.buscarCurso(id);
	}catch(Exception e) {
		model.addAttribute("formUsuarioErrorMessage", e.getMessage());
	}
	ModelAndView encontrado = new ModelAndView("cargarusuario");
	encontrado.addObject("usuario", cursoEncontrado);
	SRT.error("usuario: " + cursoEncontrado);
	encontrado.addObject("editMode", true);
	return encontrado;
}



@PostMapping("ModificarCurso")
public ModelAndView subUser(@Valid @ModelAttribute ("unCurso") Curso cursomodificar, Model model) {
	servicecourse.modificarCurso(cursomodificar);
	SRT.info("Ingresando al metodo guardar Usuario: "+cursomodificar.getNombre());
	ModelAndView vista = new ModelAndView ("mostrarusuario");
	vista.addObject("listaUsuario", servicecourse.listarCursos());
	vista.addObject("formUsuarioErrorMessage", "Usuario guardado correctamente");
	return vista;
}
}
