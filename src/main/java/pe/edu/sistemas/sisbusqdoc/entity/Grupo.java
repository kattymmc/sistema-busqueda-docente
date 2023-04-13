package pe.edu.sistemas.sisbusqdoc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="GRUPO")
public class Grupo {
	@Id
	@Column(name="IdGRUPO")
	private int id;
	@ManyToOne
	@JoinColumn(name="CURSO_IDCURSO",referencedColumnName="IDCURSO_PERIODO")
	private Curso curso;
	@Column(name="GRUPO_NUMERO")
	private Integer numeroCurso;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Integer getNumeroCurso() {
		return numeroCurso;
	}
	public void setNumeroCurso(Integer numeroCurso) {
		this.numeroCurso = numeroCurso;
	}
	public Grupo(int id, Curso curso, Integer numeroCurso) {

		this.id = id;
		this.curso = curso;
		this.numeroCurso = numeroCurso;
	}
	public Grupo() {
	
	}
	
	
}
