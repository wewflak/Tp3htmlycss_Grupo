package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.controller.CursoController;
import ar.edu.unju.edm.model.Curso;
import ar.edu.unju.edm.service.ICursoService;
import ar.edu.unju.edm.util.ListaCursos;

@Service
public class ICursoServiceImp implements ICursoService{

	private static final Log GUSTAVO = LogFactory.getLog(CursoController.class);
	
	@Autowired
	ListaCursos lista;
	
	@Override
	public void guardarCurso(Curso usuario) {
		// TODO Auto-generated method stub
		usuario.setEstado(true);
		lista.getListed().add(usuario);
	}

	@Override
	public void eliminarCurso(Integer id) {
		// TODO Auto-generated method stub		
		for (int i = 0; i < lista.getListed().size(); i++) {			
			if (lista.getListed().get(i).getDni().equals(id)) {				
				lista.getListed().get(i).setEstado(false);		
			}            
        }		
	}

	@Override
	public void modificarCurso(Curso usuario) {
		// TODO Auto-generated method stub
		
		//usuario.setEstado(true);
		for (int i = 0; i < lista.getListed().size(); i++) {			
			if (lista.getListed().get(i).getDni().equals(usuario.getDni())) {
				GUSTAVO.error("encontrando: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				lista.getListed().set(i, usuario);			
			}            
        }
	}

	@Override
	public List<Curso> listarCursos() {
		// TODO Auto-generated method stub
		List<Curso> auxiliar = new ArrayList<>();
		GUSTAVO.info("ingresando al metodo: iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		for (int i = 0; i < lista.getListed().size(); i++) {
			GUSTAVO.error("recorriendo: oooooooooooooooooooooooooooo"+lista.getListed().get(i).getDni());
			
			if (lista.getListed().get(i).getEstado()==true) {
				//GUSTAVO.error("encontrando: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				auxiliar.add(lista.getListed().get(i));		
			}            
        }
		return auxiliar;
	}

	

	@Override
	public Curso buscarCurso(Integer id) {
		// TODO Auto-generated method stub
		Curso usuarioEncontrado = new Curso();
		for (int i = 0; i < lista.getListed().size(); i++) {
//			GUSTAVO.error("recorriendo: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+dni);
			
			if (lista.getListed().get(i).getDni().equals(id)) {
				//GUSTAVO.error("encontrando: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				usuarioEncontrado = lista.getListed().get(i);		
			}            
        }
		return usuarioEncontrado;
	}

}