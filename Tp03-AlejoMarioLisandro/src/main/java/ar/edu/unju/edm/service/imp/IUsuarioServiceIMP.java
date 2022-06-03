package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.repository.UsuarioRepository;
import ar.edu.unju.edm.service.IUsuarioService;
import ar.edu.unju.edm.util.ListadoUsuarios;
@Service
public class IUsuarioServiceIMP implements IUsuarioService {
	@Autowired
	UsuarioRepository usuariorepository;
	@Autowired

	ListadoUsuarios lista;
	@Override
	public void guardarUsuario(Usuario usuarioparaguardar) {
		// TODO Auto-generated method stub
		usuarioparaguardar.setEstado(true);
		lista.getListado().add(usuarioparaguardar);
	}

	@Override
	public List<Usuario> mostrarUsuarios() {
		// TODO Auto-generated method stub
		List<Usuario> activos = new ArrayList<>();
		for(int i=0; i< lista.getListado().size(); i++) {
			if(lista.getListado().get(i).getEstado()==true) {
				activos.add(lista.getListado().get(i));
				
			}else {
			}
	}	return activos;
	}

	@Override
	public void eliminarUsuario(Long dni) {
		// TODO Auto-generated method stub
		Usuario auxiliar = new Usuario();
		auxiliar = buscarUsuario(dni);
		auxiliar.setEstado(false);
	}

//	@Override
////	public void modificarUsuario(Usuario user, Long dni) {
////		// TODO Auto-generated method stub
////		Usuario auxiliar = new Usuario();
////		auxiliar = buscarUsuario(dni);
////	}

	@Override
	public Usuario buscarUsuario(Long dni) {
		// TODO Auto-generated method stub
		Usuario auxiliar = new Usuario();
		for(int i=0; i<= lista.getListado().size(); i++) {
			if(lista.getListado().get(i).getDni().equals(dni)) {
				auxiliar = lista.getListado().get(i);
				
			}else {
				return null;
			}
	}	return auxiliar;
	}
	

}
