package com.zinespace.autocines.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zinespace.autocines.repositorio.peliculaRepositorio;
import com.zinespace.autocines.modelo.entidadpelicula;

@Service
public class PeliService {
	@Autowired
    private peliculaRepositorio PeliculaRepositorio;

	 public entidadpelicula buscarPorId(Long id) {
	        return PeliculaRepositorio.findById(id).orElse(null);
	    }

	    public void guardarPelicula(entidadpelicula entidadPelicula) {
	        PeliculaRepositorio.save(entidadPelicula);
	    }

	    public void eliminarPelicula(Long id) {
	        PeliculaRepositorio.deleteById(id);
	    }
}
