package pe.edu.sistemas.sisbusqdoc.service;

import java.util.List;

import pe.edu.sistemas.sisbusqdoc.entity.HorarioClase;
import pe.edu.sistemas.sisbusqdoc.model.HorarioClaseModel;

public interface HorarioClaseService {
	public enum tiposBusqueda {
		profesor{
			@Override
			public String getFrase() {
				return "codigo o nombre";
			}
		},
		curso {
			@Override
			public String getFrase() {
				// TODO Auto-generated method stub
				return "nombre del curso";
			}
		},
		dia {
			@Override
			public String getFrase() {
				return "dia de la semana";
			}
		};
		public abstract String getFrase();
	}
	public abstract List<HorarioClaseModel> mostrarTodo();
	public abstract List<HorarioClaseModel> buscarPorNombre(String nombre);
	public abstract List<HorarioClaseModel> buscarPorCodigo(String codigo);
	public abstract List<HorarioClaseModel> mostrarPeriodoActual();
	public abstract List<HorarioClaseModel> buscarPorCodigoOrNombre (String busqueda);
	public abstract List<HorarioClaseModel> buscarPorDia (Integer dia);
	public abstract List<HorarioClaseModel> buscarPorCurso (String nombreCurso);
}
