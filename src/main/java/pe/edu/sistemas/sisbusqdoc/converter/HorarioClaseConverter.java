package pe.edu.sistemas.sisbusqdoc.converter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.edu.sistemas.sisbusqdoc.entity.Docente;
import pe.edu.sistemas.sisbusqdoc.entity.Grupo;
import pe.edu.sistemas.sisbusqdoc.entity.HorarioClase;
import pe.edu.sistemas.sisbusqdoc.model.HorarioClaseModel;

@Component
public class HorarioClaseConverter {
	public HorarioClase Model2Entity(HorarioClaseModel horario) {
		HorarioClase h = new HorarioClase();
		h.setId(horario.getId());
		h.setDia(horario.getDia());
		h.setAula(horario.getAula());
		h.setDocente(horario.getDocente());
		h.setGrupo(horario.getGrupo());
		h.setHoraFin(horario.getHoraFin());
		h.setHoraInicio(horario.getHoraInicio());
		h.setPeriodoHorario(horario.getPeriodoHorario());
		h.setTipoHorario(horario.getTipoHorario());
		return h;
	}
	public HorarioClaseModel Entity2Model(HorarioClase horario) {
		HorarioClaseModel h = new HorarioClaseModel();
		h.setId(horario.getId());
		h.setDia(horario.getDia());
		h.setAula(horario.getAula());
		h.setDocente(horario.getDocente());
		h.setGrupo(horario.getGrupo());
		h.setHoraFin(horario.getHoraFin());
		h.setHoraInicio(horario.getHoraInicio());
		h.setPeriodoHorario(horario.getPeriodoHorario());
		h.setTipoHorario(horario.getTipoHorario());
		return h;
	}
	public List<HorarioClase> modelList2EntityList(List<HorarioClaseModel> listaHorario){
		List<HorarioClase> h = new ArrayList<HorarioClase>();
		 listaHorario.forEach(a -> h.add(Model2Entity(a)));
		 return h;
	}
	public List<HorarioClaseModel> EntityList2ModelList(List<HorarioClase> listaHorario){
		List<HorarioClaseModel> h = new ArrayList<HorarioClaseModel>();
		 listaHorario.forEach(a -> h.add(Entity2Model(a)));
		 return h;
	}
}
