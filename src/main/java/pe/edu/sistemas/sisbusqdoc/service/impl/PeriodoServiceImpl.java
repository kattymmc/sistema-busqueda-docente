package pe.edu.sistemas.sisbusqdoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pe.edu.sistemas.sisbusqdoc.entity.Periodo;
import pe.edu.sistemas.sisbusqdoc.repository.PeriodoRepository;
import pe.edu.sistemas.sisbusqdoc.service.PeriodoService;

@Service
public class PeriodoServiceImpl implements PeriodoService {
	@Autowired
	@Qualifier("periodoRepository")
	private PeriodoRepository periodoRepo;
	
	@Override
	public Periodo getUltimoPeriodo() {
		
		return periodoRepo.findTopByOrderByIdDesc();
	}

}
