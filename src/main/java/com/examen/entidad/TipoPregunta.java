package com.examen.entidad;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tipopregunta")
public class TipoPregunta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtipoPregunta")
	private int idTipoPregunta;
	
	@Column(name = "nombre")
	private String nombre;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoPregunta")
	private List<Pregunta> preguntas;

	public int getIdTipoPregunta() {
		return idTipoPregunta;
	}

	public void setIdTipoPregunta(int idTipoPregunta) {
		this.idTipoPregunta = idTipoPregunta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	
	
	
}
