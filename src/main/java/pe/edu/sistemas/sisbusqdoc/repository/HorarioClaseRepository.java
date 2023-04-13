package pe.edu.sistemas.sisbusqdoc.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.sistemas.sisbusqdoc.entity.HorarioClase;
import pe.edu.sistemas.sisbusqdoc.entity.Periodo;
@Repository
public interface HorarioClaseRepository extends JpaRepository <HorarioClase,Serializable> {
	
	/**
	*@deprecated usar findbyfullname
	*busca profesores en la tabla horario, la palabra clave debe de estar contenida en 
	*docente.persona.nombre o docente.persona.apellidopaterno o  docente.persona.apellidomaterno
	*ignora mayusculas
	*@param nombre nombre de la persona a buscar
	*@return Lista con los horarios que coincidan con el criterio de busqueda
	*/
	public abstract List<HorarioClase> 
				findByDocente_persona_nombreOrDocente_persona_apellidoPaternoOrDocentePersonaApellidoMaternoContainingIgnoreCase(String nombre, String apellidoPaterno, String apellidoMaterno);
	
	//@Query("SELECT * FROM HorarioClase e WHERE CONCAT(e.docente.persona.nombre, ' ', e.docente.persona.apellidoPaterno) LIKE %?1%")
	//public abstract List<HorarioClase> findByNombreCompleto(String nombre);
	/**
	 * busca por codigo del docente
	 * @param codigo codigo del profesor
	 * @return Lista con los horarios que coincidan con el codigo del profesor
	 */
	public abstract List<HorarioClase>
			findByDocente_persona_codigoAndGrupo_curso_periodo(String codigo, Periodo periodo);
	
	/**
	*busca profesores en la tabla horario, la palabra clave debe de estar contenida en el nombre completo y del periodo academico elegido
	*ignora mayusculas
	*@param nombre nombre de la persona a buscar
	*@param periodo selecciona el periodo academico
	*@return List con los horarios que coincidan con el criterio de busqueda
	*/
	public abstract List<HorarioClase> findByDocente_persona_fullNameContainingIgnoreCaseAndGrupo_curso_periodo(String fullname, Periodo periodo);

	public abstract List<HorarioClase> findByGrupo_curso_periodo(Periodo periodo);
	public abstract List<HorarioClase> findByGrupo_curso_nombreContainingIgnoreCaseAndGrupo_curso_periodo(String nombreCurso,Periodo periodo);
	public abstract List<HorarioClase> findByDiaAndGrupo_curso_periodo(Integer dia,Periodo periodo);
}
