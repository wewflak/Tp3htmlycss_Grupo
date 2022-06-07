package ar.edu.unju.edm.model;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
@Entity
@Component
public class Usuario {
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	@NotEmpty
	@Size (min=5, max=30, message="El nombre de contener entre 5 a 30 caracteres")
	private String nombre;
	@NotEmpty
	private String apellido;
	@NotEmpty
	private String nombreUsuario;
	private String email;
	@NotEmpty //Para String
	private String contrasena;
	@Min(value=1000000, message="El DNI debe ser mayor que un millon")
	@Max(value=99999999, message="El DNI debe ser menor que un 100 millones")
	@NotNull //Para numeros
	private Long dni;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechadeN;
	private Boolean estado;
	public Usuario(String nombre, String apellido, String nombreUsuario, String contrasena, String email, Long dni, LocalDate fechadeN) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.email = email;
		this.dni = dni;
		this.fechadeN = fechadeN;
	}
	public LocalDate getFechadeN() {
		return fechadeN;
	}
	public void setFechadeN(LocalDate fechadeN) {
		this.fechadeN = fechadeN;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	
}
