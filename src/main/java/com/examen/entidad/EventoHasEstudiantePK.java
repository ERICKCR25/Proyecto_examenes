package com.examen.entidad;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EventoHasEstudiantePK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int idEvento;
	
	private int idEstudiante;

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public int getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	
	

}
