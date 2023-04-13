package pe.edu.sistemas.sisbusqdoc.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PERIODO")
public class Periodo {
	@Id
	@Column(name="IDPERIODO")
	private int id;
	@Column(name="PERIODO_NOMBRE")
	private String nombre;
	@Column(name="PERIODO_FECHA_INICIO")
	private LocalDate fechaInicio;
	@Column(name="PERIODO_FECHA_FIN")
	private LocalDate fechaFin;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Periodo(int id, String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
		this.id = id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	public Periodo() {
	}
	
}
