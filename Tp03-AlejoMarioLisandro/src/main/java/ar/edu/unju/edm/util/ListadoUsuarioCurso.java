package ar.edu.unju.edm.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.edm.model.UsuarioCurso;
@Component
public class ListadoUsuarioCurso {
	private static List<UsuarioCurso> listado = new ArrayList<>(); 

	//Constructors
public ListadoUsuarioCurso() {
	// TODO Auto-generated constructor stub
}

public static List<UsuarioCurso> getListado() {
	return listado;
}

public static void setListado(List<UsuarioCurso> listado) {
	ListadoUsuarioCurso.listado = listado;
}


}
