package ar.edu.unju.edm.util;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import ar.edu.unju.edm.model.Usuario;
@Component
public class ListadoUsuarios {
	private List <Usuario> listado = new ArrayList<>();
	
	public ListadoUsuarios() {
		// TODO Auto-generated constructor stub
	}
		public List<Usuario> getListado() {
		return listado;
		}
		public void setListado(List<Usuario> listado) {
		this.listado = listado;
		}
	
}