package pe.edu.sistemas.sisbusqdoc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.sistemas.sisbusqdoc.entity.Docente;

public interface DocenteRepository extends JpaRepository <Docente,Serializable> {

}
