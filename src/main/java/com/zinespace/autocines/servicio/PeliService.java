package com.zinespace.autocines.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zinespace.autocines.modelo.entidadpelicula;
import com.zinespace.autocines.repositorio.peliculaRepositorio;

@Service
public class PeliService {
	private peliculaRepositorio PeliculaRepositorio;

    @Autowired
    public PeliService(peliculaRepositorio PeliculaRepositorio) {
        this.PeliculaRepositorio = PeliculaRepositorio;
    }

    //public List<entidadpelicula> obtenerTodasLasPeliculas() {
    //}

    public entidadpelicula obtenerPeliculaPorId(Long id) {
        return PeliculaRepositorio.findById(id).orElse(null);
    }

    public entidadpelicula agregarPelicula(entidadpelicula pelicula) {
        return PeliculaRepositorio.save(pelicula);
    }

    public void eliminarPelicula(Long id) {
        PeliculaRepositorio.deleteById(id);
    }

}
