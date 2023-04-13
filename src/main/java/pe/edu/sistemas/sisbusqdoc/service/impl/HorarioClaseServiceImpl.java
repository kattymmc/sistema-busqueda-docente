package pe.edu.sistemas.sisbusqdoc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pe.edu.sistemas.sisbusqdoc.converter.HorarioClaseConverter;
import pe.edu.sistemas.sisbusqdoc.entity.HorarioClase;
import pe.edu.sistemas.sisbusqdoc.model.HorarioClaseModel;
import pe.edu.sistemas.sisbusqdoc.repository.HorarioClaseRepository;
import pe.edu.sistemas.sisbusqdoc.service.HorarioClaseService;

@Service
public class HorarioClaseServiceImpl implements HorarioClaseService{
	@Autowired
	@Qualifier("horarioClaseRepository")
	private HorarioClaseRepository repo;
	
	@Autowired
	@Qualifier("periodoServiceImpl")
	private PeriodoServiceImpl periodoService;
	
	@Autowired
	@Qualifier("horarioClaseConverter")
	private HorarioClaseConverter horarioConverter;
	
	@Override
	public List<HorarioClaseModel> mostrarTodo() {
	
		return horarioConverter.EntityList2ModelList(repo.findAll());
	}
	@Override
	public List<HorarioClaseModel> buscarPorNombre(String nombre) {
		return horarioConverter.EntityList2ModelList(repo.findByDocente_persona_fullNameContainingIgnoreCaseAndGrupo_curso_periodo(nombre,periodoService.getUltimoPeriodo()));
		//return repo.findByDocente_persona_nombreOrDocente_persona_apellidoPaternoOrDocentePersonaApellidoMaternoContainingIgnoreCase(nombre,nombre,nombre) ;
	}
	@Override
	public List<HorarioClaseModel> buscarPorCodigo(String codigo) {
		
		return horarioConverter.EntityList2ModelList(repo.findByDocente_persona_codigoAndGrupo_curso_periodo(codigo, periodoService.getUltimoPeriodo()));
	}
	@Override
	public List<HorarioClaseModel> mostrarPeriodoActual() {
		return horarioConverter.EntityList2ModelList(repo.findByGrupo_curso_periodo(periodoService.getUltimoPeriodo()));
	}
	
	@Override
	public List<HorarioClaseModel> buscarPorCodigoOrNombre (String busqueda){
		if (busqueda.matches(".*\\d.*")) {
			return buscarPorCodigo(busqueda);
		} else {
			return buscarPorNombre(busqueda);
		}
	}
	@Override
	public List<HorarioClaseModel> buscarPorDia(Integer dia) {

		return horarioConverter.EntityList2ModelList(repo.findByDiaAndGrupo_curso_periodo (dia, periodoService.getUltimoPeriodo()));
	}
	@Override
	public List<HorarioClaseModel> buscarPorCurso(String nombreCurso) {
		System.out.println(nombreCurso);
		return horarioConverter.EntityList2ModelList(repo.findByGrupo_curso_nombreContainingIgnoreCaseAndGrupo_curso_periodo (nombreCurso, periodoService.getUltimoPeriodo()));
	}
	
	
	
	
}
