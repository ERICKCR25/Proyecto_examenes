package com.examen.entidad;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pregunta")
public class Pregunta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPregunta")
	private int idPregunta;
	
	@Column(name = "numero")
	private int nPregunta;
	
	@Column(name = "enunciado")
	private String enunciado;
	
	@JoinColumn(name = "idMateria")
	@ManyToOne
	private Materia materia;
	
	@JoinColumn(name = "idtipoPregunta")
	@ManyToOne
	private TipoPregunta tipoPregunta;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pregunta")
	private List<Respuesta> respuestas;

	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}
	

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public TipoPregunta getTipoPregunta() {
		return tipoPregunta;
	}

	public void setTipoPregunta(TipoPregunta tipoPregunta) {
		this.tipoPregunta = tipoPregunta;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	public int getnPregunta() {
		return nPregunta;
	}

	public void setnPregunta(int nPregunta) {
		this.nPregunta = nPregunta;
	}
	
	

	

}
