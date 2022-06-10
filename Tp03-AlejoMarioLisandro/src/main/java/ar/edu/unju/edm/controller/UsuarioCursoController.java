package ar.edu.unju.edm.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.UsuarioCurso;
import ar.edu.unju.edm.service.ICursoService;
import ar.edu.unju.edm.service.IUsuarioCursoService;
import ar.edu.unju.edm.service.IUsuarioService;



@Controller
public class UsuarioCursoController {
	private static final Log SRT = LogFactory.getLog(CursoController.class);
	@Autowired
	IUsuarioCursoService serviceusercourse;
	@Autowired
	IUsuarioService serviceuser;
	@Autowired
	ICursoService servicecourse;
	@GetMapping({"/cargarInscripcion"})
	public ModelAndView addRoll() {
		ModelAndView vista = new ModelAndView("cargarInscripcion");
		vista.addObject("unUsuarioCurso", serviceusercourse.nuevoUsuarioCurso());
		vista.addObject("usuarios", serviceuser.mostrarUsuarios());
		vista.addObject("cursos", servicecourse.listarCursos());
		vista.addObject("editMode", false);
		return vista;
	}
	@PostMapping("/guardarInscripcion")
	public ModelAndView saveRoll(@Valid @ModelAttribute("unUsuarioCurso") UsuarioCurso usuariocursoNuevo, BindingResult resultado) {			
			// VERIFICACION DEL NOMBRE Y DNI	
		ModelAndView vista = new ModelAndView();
		if (resultado.hasErrors()) {
			SRT.fatal("ERROR DE VALIDACION" + usuariocursoNuevo.getIdUsuarioCurso());			
			vista.addObject("unUsuarioCurso", usuariocursoNuevo);
			vista.setViewName("cargarInscripcion");
			return vista;
		}		
		try {
				serviceusercourse.guardarUsuarioCurso(usuariocursoNuevo);
		} catch (Exception e) {			
			SRT.error("Error al cargar curso");
			vista.addObject("formCursoErrorMessage", e.getMessage());
			vista.addObject("unUsuarioCurso", usuariocursoNuevo);
			SRT.error("No se pudo guardar el curso");
			vista.setViewName("cargarInscripcion");
			return vista;		
		}		
		vista.addObject("formCursoErrorMessage", "Curso guardado correctamente");
		vista.addObject("unUsuarioCurso", serviceusercourse.nuevoUsuarioCurso());
		SRT.fatal(usuariocursoNuevo.getIdUsuarioCurso());
		vista.setViewName("cargarInscripcion");
		return vista;
		}
}
