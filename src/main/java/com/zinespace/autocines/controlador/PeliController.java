package com.zinespace.autocines.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.zinespace.autocines.modelo.entidadpelicula;
import com.zinespace.autocines.servicio.PeliService;

@RestController
@RequestMapping("/peliculas")
public class PeliController {
	private PeliService peliService;

    @Autowired
    public PeliController(PeliService peliService) {
        this.peliService = peliService;
    }

    //@GetMapping
    //public List<entidadpelicula> obtenerTodasLasPeliculas() {
      //  return peliService.obtenerTodasLasPeliculas();
    //}

    @GetMapping("/{id}")
    public entidadpelicula obtenerPeliculaPorId(@PathVariable Long id) {
        return peliService.obtenerPeliculaPorId(id);
    }

    @PostMapping
    public entidadpelicula agregarPelicula(@RequestBody entidadpelicula pelicula) {
        return peliService.agregarPelicula(pelicula);
    }

    @DeleteMapping("/{id}")
    public void eliminarPelicula(@PathVariable Long id) {
        peliService.eliminarPelicula(id);
    }

}
