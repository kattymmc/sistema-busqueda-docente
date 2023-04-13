package pe.edu.sistemas.sisbusqdoc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="DOCENTE")
public class Docente {
	@Id
	@Column(name="IDDOCENTE")
	private int id;
	@OneToOne
	@JoinColumn(name="PERSONA_ID_PERSONA",referencedColumnName="ID_PERSONA")
	private Persona persona;
	@Column(name="DOCENTE_REGULAR")
	private int idCategoriaDocente;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public int getIdCategoriaDocente() {
		return idCategoriaDocente;
	}
	public void setIdCategoriaDocente(int idCategoriaDocente) {
		this.idCategoriaDocente = idCategoriaDocente;
	}
	public Docente(int id, Persona persona, int idCategoriaDocente) {
		super();
		this.id = id;
		this.persona = persona;
		this.idCategoriaDocente = idCategoriaDocente;
	}
	public Docente() {
		super();
	}
	
}
