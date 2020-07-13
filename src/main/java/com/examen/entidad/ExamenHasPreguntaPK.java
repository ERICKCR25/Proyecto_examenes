package com.examen.entidad;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ExamenHasPreguntaPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idExamen; 
	private int idPregunta;
	
	
	public int getIdExamen() {
		return idExamen;
	}
	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}
	public int getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}
	
	
	
}
