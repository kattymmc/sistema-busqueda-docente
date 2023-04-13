package pe.edu.sistemas.sisbusqdoc.model;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import pe.edu.sistemas.sisbusqdoc.entity.Docente;
import pe.edu.sistemas.sisbusqdoc.entity.Grupo;

public class HorarioClaseModel {
	

	private int id;
	

	private LocalTime horaInicio;
	

	private LocalTime horaFin;
	

	private Grupo grupo;
	

	private String aula;
	

	private Integer  dia;

	private Docente  docente;
	

	private String tipoHorario;
	

	private String periodoHorario;
	

	private Integer  idAula;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public Integer getDia() {
		return dia;
	}
	

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public String getTipoHorario() {
		return tipoHorario;
	}

	public void setTipoHorario(String tipoHorario) {
		this.tipoHorario = tipoHorario;
	}

	public String getPeriodoHorario() {
		return periodoHorario;
	}

	public void setPeriodoHorario(String periodoHorario) {
		this.periodoHorario = periodoHorario;
	}

	public Integer getIdAula() {
		return idAula;
	}

	public void setIdAula(Integer idAula) {
		this.idAula = idAula;
	}

	public HorarioClaseModel(int id, LocalTime horaInicio, LocalTime horaFin, Grupo grupo, String aula, Integer dia,
			Docente docente, String tipoHorario, String periodoHorario, Integer idAula) {
		this.id = id;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.grupo = grupo;
		this.aula = aula;
		this.dia = dia;
		this.docente = docente;
		this.tipoHorario = tipoHorario;
		this.periodoHorario = periodoHorario;
		this.idAula = idAula;
	}

	public HorarioClaseModel() {
	}
	
	public String getDiaTexto() {
		switch (this.dia){
			case 1:
				return "Lunes";
			case 2:
				return "Martes";
			case 3:
				return "Miercoles";
			case 4:
				return "Jueves";
			case 5:
				return "Viernes";
			case 6:
				return "Sabado";
			case 7:
				return "Domingo";
			default:
				return "N/A";
		}
	}
	
}
