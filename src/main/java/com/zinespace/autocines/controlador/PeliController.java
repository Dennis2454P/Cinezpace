package com.zinespace.autocines.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zinespace.autocines.modelo.entidadpelicula;
import com.zinespace.autocines.servicio.PeliService;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/peliculas")
public class PeliController {
	
	@Autowired
    private PeliService peliService;

    @GetMapping("/mostrar/{id}")
    public String mostrarPelicula(@PathVariable Long id, Model model) {
        entidadpelicula pelicula = peliService.buscarPorId(id);
        if (pelicula != null) {
        	model.addAttribute("pelicula", pelicula);
        }
        return "pelicula";
    }
    
    @PostMapping("/comprar/{id}")
    public String comprarPelicula(@PathVariable Long id) {
        // cod para compra
        return "redirect:/peliculas/mostrar/" + id;
    }

    @GetMapping("/crear")
    public String mostrarFormularioCreacion(Model model) {
        // cod para creacion películas
        return "formulario_creacion";
    }

    @PostMapping("/crear")
    public String crearPelicula(@ModelAttribute entidadpelicula entidadPelicula) {
        peliService.guardarPelicula(entidadPelicula);
        return "redirect:/peliculas/mostrar/" + entidadPelicula.getId();
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPelicula(@PathVariable Long id) {
        peliService.eliminarPelicula(id);
        return "redirect:/peliculas";
    }
	
}
