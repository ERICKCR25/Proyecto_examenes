package com.examen.entidad;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ExamenHasEstudiantePK implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private int idExamen;
	
	private int idEstudiante;

	public int getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}

	public int getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	
	
	
	

}
