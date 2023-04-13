package pe.edu.sistemas.sisbusqdoc.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="HORARIO_CLASE")
public class HorarioClase {
	@Id
	@GeneratedValue
	@Column(name="IDHORARIO_CLASE")
	private int id;
	
	@Column(name="HORA_INICIO")
	private LocalTime horaInicio;
	
	@Column(name="HORA_FIN")
	private LocalTime horaFin;
	
	@ManyToOne
	@JoinColumn(name="GRUPO_IDGRUPO",referencedColumnName="IDGRUPO")
	private Grupo grupo;
	
	@Column(name="AULA")
	private String aula;
	
	@Column(name="DIA")
	private Integer  dia;
	
	@ManyToOne
	@JoinColumn(name="DOCENTE_IDDOCENTE",referencedColumnName="IDDOCENTE")
	private Docente  docente;
	
	@Column(name="HORARIO_CLASE_TIPO")
	private String tipoHorario;
	
	@Column(name="HORARIO_CLASE_PERIODO")
	private String periodoHorario;
	
	@Column(name="AULA_IDAULA")
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

	public HorarioClase(int id, LocalTime horaInicio, LocalTime horaFin, Grupo grupo, String aula, Integer dia,
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

	public HorarioClase() {
	}
	
	
	
	
	
}
	