package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.edm.model.Curso;
import ar.edu.unju.edm.repository.CursoRepository;
import ar.edu.unju.edm.service.ICursoService;
import ar.edu.unju.edm.util.ListaCursos;

@Service
public class ICursoServiceImp implements ICursoService{

	@Autowired
	ListaCursos lista;
	@Autowired
	CursoRepository cursoRepository;
	@Override
	public void guardarCurso(Curso cursoparaguardar) {
		// TODO Auto-generated method stub
		cursoparaguardar.setEstado(true);
		cursoRepository.save(cursoparaguardar);
	}

	@Override
	public void eliminarCurso(Long id) throws Exception {
		// TODO Auto-generated method stub		
		Curso auxiliar = new Curso();
		auxiliar = buscarCurso(id);
		auxiliar.setEstado(false);
		cursoRepository.save(auxiliar);
	}

	@Override
	public void modificarCurso(Curso Curso) {
		// TODO Auto-generated method stub
		
		//usuario.setEstado(true);

		Curso.setEstado(true);
		cursoRepository.save(Curso);
	}

	@Override
	public List<Curso> listarCursos() {
		// TODO Auto-generated method stub
		List<Curso> activos = new ArrayList<>();
		List<Curso> activos2 = new ArrayList<>();
		activos=(List<Curso>) cursoRepository.findAll();
			for(int i=0; i< activos.size(); i++) {
				if(activos.get(i).getEstado()==true){
					activos2.add(activos.get(i));			
				}
		}
		return activos2;
	}

	

	@Override
	public Curso buscarCurso(Long id) throws Exception {
		// TODO Auto-generated method stub
		Curso cursoEncontrado = new Curso();
		cursoEncontrado=cursoRepository.findById(id).orElseThrow(()->new Exception("Curso No encontrado"));
		return cursoEncontrado;
	}

}