package com.zinespace.autocines.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zinespace.autocines.modelo.entidadpelicula;

public interface peliculaRepositorio extends JpaRepository<entidadpelicula, Long> {
	//entidadpelicula findById(Long id);
}
