package pe.edu.sistemas.sisbusqdoc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.sistemas.sisbusqdoc.entity.Persona;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<Persona, Serializable>{

	public abstract Persona findByUsername(String username);
}

