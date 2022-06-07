package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Usuario;

@Service
public interface IUsuarioService {
	/*El service guarda el usuario*/
	public void guardarUsuario (Usuario user);
	//Muestra usuarios
	public List<Usuario> mostrarUsuarios();
	//Elminar Usuario
	public void eliminarUsuario(Long dni) throws Exception;
	//Modifica los datos del usuario
	public void modificarUsuario(Usuario user);
	//Busca usuarios
	public Usuario buscarUsuario(Long dni) throws Exception;
}
