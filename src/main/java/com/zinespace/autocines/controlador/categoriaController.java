package com.zinespace.autocines.controlador;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zinespace.autocines.modelo.categoria;
import com.zinespace.autocines.servicio.categoriaServicio;

@RestController
@RequestMapping("/categoria")
public class categoriaController {
	
	@Autowired
	private categoriaServicio categoriaservicio;
	
	@GetMapping
	public ArrayList<categoria> getCategorias(){
		return this.categoriaservicio.getCategoria();
	}
	@GetMapping(path = "/{id}")
	public Optional<categoria> getCategoriaById(@PathVariable("id") Long id){
		return this.categoriaservicio.getByid(id);
	}
}
