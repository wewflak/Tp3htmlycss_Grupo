package ar.edu.unju.edm.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
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
   private Double costo;
   private Integer valoracion;

	private String contrasena;
	@NotNull
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Boolean estado;
	public Curso() {
		// TODO Auto-generated constructor stub
	}
	@NotEmpty
	//Guardad canedas
	private String nombre;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechadeI;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechadeF;
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
	public LocalDate getFechadeI() {
		return fechadeI;
	}
	public void setFechadeI(LocalDate fechadeI) {
		this.fechadeI = fechadeI;
	}
	public LocalDate getFechadeF() {
		return fechadeF;
	}
	public void setFechadeF(LocalDate fechadeF) {
		this.fechadeF = fechadeF;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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

	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
}
