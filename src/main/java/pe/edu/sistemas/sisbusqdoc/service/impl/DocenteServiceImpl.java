package pe.edu.sistemas.sisbusqdoc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pe.edu.sistemas.sisbusqdoc.entity.Docente;
import pe.edu.sistemas.sisbusqdoc.repository.DocenteRepository;
import pe.edu.sistemas.sisbusqdoc.service.DocenteService;

@Service
public class DocenteServiceImpl implements DocenteService{
	@Autowired
	@Qualifier("docenteRepository")
	private DocenteRepository repo;
	@Override
	public List<Docente> mostrarTodo() {
	
		return repo.findAll();
	}
}
