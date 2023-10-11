package com.zinespace.autocines.servicio;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zinespace.autocines.modelo.categoria;
import com.zinespace.autocines.repositorio.categoriaRepositorio;

@Service
public class categoriaServicio {
	
	@Autowired
	private categoriaRepositorio categoriaRepositorio;
	
	public ArrayList<categoria> getCategoria(){
		return (ArrayList<categoria>) categoriaRepositorio.findAll();
	}
	
	public Optional<categoria> getByid(Long id){
		return categoriaRepositorio.findById(id);
	}
	
	
	
	
}
