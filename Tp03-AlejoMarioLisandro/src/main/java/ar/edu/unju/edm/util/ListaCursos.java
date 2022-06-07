package ar.edu.unju.edm.util;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.edm.model.Curso;

@Component
public class ListaCursos {
	//Attributes
	private static List<Curso> listed = new ArrayList<>(); 

	//Constructors
	public ListaCursos() {
	}

	//Getters and Setters
	public List<Curso> getListed() {
		return listed;
	}

	public void setListed(List<Curso> listed) {
		ListaCursos.listed = listed;
	}

}

