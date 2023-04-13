package pe.edu.sistemas.sisbusqdoc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CURSO_PERIODO")
public class Curso {
	@Id
	@Column(name="IDCURSO_PERIODO")
	private int id;
	@Column(name="CURSO_PERIODO_NOMBRE")
	private String nombre;
	@ManyToOne
	@JoinColumn(name="PERIODO_IDPERIODO",referencedColumnName="IDPERIODO")
	private Periodo periodo;
	@Column(name="CURSO_PERIODO_CURSOC_CODCOMUN")
	private Integer codigoCursoComun;
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
	public Periodo getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	public Integer getCodigoCursoComun() {
		return codigoCursoComun;
	}
	public void setCodigoCursoComun(Integer codigoCursoComun) {
		this.codigoCursoComun = codigoCursoComun;
	}
	public Curso(int id, String nombre, Periodo periodo, Integer codigoCursoComun) {

		this.id = id;
		this.nombre = nombre;
		this.periodo = periodo;
		this.codigoCursoComun = codigoCursoComun;
	}
	public Curso() {
		
	}
	
	
}
