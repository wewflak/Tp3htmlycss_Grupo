package ar.edu.unju.edm.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Curso {
	//agregado
  
   private String docente;
   private Integer duracion;
   private String descripcion;
   private Integer cupo;
   private double costo;
   private Integer valoracion;
   ///
	private String mail;
	private String contrasena;
	@NotEmpty
	private String nombre;
	@Max (value = 99999999, message="DNI debe ser menor que 99999999")
	@Min(value = 1000000, message="DNI debe ser mayor que 1000000")
	@Id
	private Integer dni;
	private Boolean estado;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	  private LocalDate fechaInicio;
	  private LocalDate fechaFinal;
	public Curso() {
		// TODO Auto-generated constructor stub
	}
	private int Id;
	@NotEmpty
	//Guardad canedas
	private String nombre;
	@NotEmpty
	private String descripcion;
	private String valoracion;
	private String Docente;
	//Guarda numeros
	private float costo;
	private double duracion;
	private int cupo;
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
	private LocalDate fechadeI;
	private Boolean estado;
	public Usuario(int id, String nombre, String apellido, String nombreUsuario, String contrasena, String email, Long dni, LocalDate fechadeN) {
		super();
		Id = id;
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
