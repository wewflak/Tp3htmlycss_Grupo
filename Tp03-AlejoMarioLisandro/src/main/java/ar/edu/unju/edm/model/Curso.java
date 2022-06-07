package ar.edu.unju.edm.model;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
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
	private Integer dni;
	private Boolean estado;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	  private LocalDate fechaInicio;
	  private LocalDate fechaFinal;
	public Curso() {
		// TODO Auto-generated constructor stub
	}
    ///AGREGANDO DE APOCO
	public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	
public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(LocalDate fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public Integer getCupo() {
		return cupo;
	}
	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public Integer getValoracion() {
		return valoracion;
	}
	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}
	//FIN DE AGREGADO POCO A POCO
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}	

}
