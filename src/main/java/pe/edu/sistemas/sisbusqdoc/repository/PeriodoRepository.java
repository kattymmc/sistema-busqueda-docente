package pe.edu.sistemas.sisbusqdoc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.sistemas.sisbusqdoc.entity.Periodo;

@Repository
public interface PeriodoRepository  extends JpaRepository <Periodo,Serializable>{
	public Periodo findTopByOrderByIdDesc();
}
