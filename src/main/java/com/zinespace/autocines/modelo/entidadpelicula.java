package com.zinespace.autocines.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class entidadpelicula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(name = "titulo") // Anota el campo "titulo"
    private String titulo;

    @Column(name = "duracion") // Anota el nuevo campo "duracion"
    private String Duracion;

    @Column(name = "fecha") // Anota el campo "fecha"
    private String Fecha;

    @Column(name = "sinopsis") // Anota el campo "sinopsis"
    private String sinopsis;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	//private Categoria categoria;
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDuracion() {
		return Duracion;
	}
	public void setDuracion(String duracion) {
		Duracion = duracion;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

}
