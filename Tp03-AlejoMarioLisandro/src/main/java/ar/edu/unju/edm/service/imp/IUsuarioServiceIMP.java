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
	ListadoUsuarios lista;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public void guardarUsuario(Usuario usuarioparaguardar) {
		// TODO Auto-generated method stub
		usuarioparaguardar.setEstado(true);
		//lista.getListado().add(usuarioparaguardar);
		usuarioRepository.save(usuarioparaguardar);
	}

	@Override
	public List<Usuario> mostrarUsuarios() {
		// TODO Auto-generated method stub
		List<Usuario> activos = new ArrayList<>();
		List<Usuario> activos2 = new ArrayList<>();
//		for(int i=0; i< lista.getListado().size(); i++) {
//			if(lista.getListado().get(i).getEstado()==true) {
//				activos.add(lista.getListado().get(i));
//				
//			}else {
//			}
//	}	
		activos=(List<Usuario>) usuarioRepository.findAll();
			for(int i=0; i< activos.size(); i++) {
				if(activos.get(i).getEstado()==true){
					activos2.add(activos.get(i));			
				}
		}
		return activos2;
	}

	@Override
	public void eliminarUsuario(Long dni) throws Exception {
		// TODO Auto-generated method stub
		Usuario auxiliar = new Usuario();
		auxiliar = buscarUsuario(dni);
		auxiliar.setEstado(false);
		usuarioRepository.save(auxiliar);
	}

	@Override
	public void modificarUsuario(Usuario user) {
		// TODO Auto-generated method stub
		user.setEstado(true);
		usuarioRepository.save(user);
	}

	@Override
	public Usuario buscarUsuario(Long dni) throws Exception {
		// TODO Auto-generated method stub
		Usuario usuarioencontrado = new Usuario();
		usuarioencontrado=usuarioRepository.findById(dni).orElseThrow(()->new Exception("Usuario No encontrado"));
		return usuarioencontrado;
	}

}
