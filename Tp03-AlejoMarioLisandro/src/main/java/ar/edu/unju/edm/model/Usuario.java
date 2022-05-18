package ar.edu.unju.edm.model;

import org.springframework.stereotype.Component;

@Component
public class Usuario {
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	private int Id;
	private String nombre;
	private String contrasena;
	public Usuario(int id, String nombre, String contrasena) {
		super();
		Id = id;
		this.nombre = nombre;
		this.contrasena = contrasena;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
}
