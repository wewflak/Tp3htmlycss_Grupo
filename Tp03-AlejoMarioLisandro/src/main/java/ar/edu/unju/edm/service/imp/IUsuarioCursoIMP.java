package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.UsuarioCurso;
import ar.edu.unju.edm.repository.UsuarioCursoRepository;
import ar.edu.unju.edm.service.IUsuarioCursoService;
@Service
public class IUsuarioCursoIMP implements IUsuarioCursoService{
	@Autowired
	UsuarioCurso usuariocurso;
	@Autowired
	UsuarioCursoRepository usuariocursoRepository;
	@Override
	public UsuarioCurso nuevoUsuarioCurso() {
		
		return usuariocurso;
		
	}
	public void guardarUsuarioCurso(UsuarioCurso usercourse) {
		// TODO Auto-generated method stub
		//usuariocurso.setEstado(true);
		usuariocursoRepository.save(usercourse);
	}

	@Override
	public List<UsuarioCurso> mostrarUsuariosCurso() {
		// TODO Auto-generated method stub
		List<UsuarioCurso> activos = new ArrayList<>();
		List<UsuarioCurso> activos2 = new ArrayList<>();
		activos=(List<UsuarioCurso>) usuariocursoRepository.findAll();
			for(int i=0; i< activos.size(); i++) {
				if(activos.get(i).getEstado()==true){
					activos2.add(activos.get(i));			
				}
		}
		return activos2;
	}

	@Override
	public void eliminarUsuarioCurso(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarUsuarioCurso(UsuarioCurso usercourse) {
		// TODO Auto-generated method stub
	}

	@Override
	public UsuarioCurso buscarUsuarioCurso(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return usuariocursoRepository.findById(id).orElseThrow(()->new Exception("UsuarioCurso no encontrado"));
	}

}
