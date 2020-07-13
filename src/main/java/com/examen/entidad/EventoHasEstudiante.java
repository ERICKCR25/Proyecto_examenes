package com.examen.entidad;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "evento_has_estudiante")
public class EventoHasEstudiante {

	
	@EmbeddedId
	private EventoHasEstudiantePK eventoHasEstudiantePk;
	
	@ManyToOne
	@JoinColumn(name = "idevento", nullable = false)
	private Evento evento;
	
	@ManyToOne
	@JoinColumn(name = "idestudiante", nullable = false)
	private Estudiante estudiante;
	
	

	

	public EventoHasEstudiantePK getEventoHasEstudiantePk() {
		return eventoHasEstudiantePk;
	}

	public void setEventoHasEstudiantePk(EventoHasEstudiantePK eventoHasEstudiantePk) {
		this.eventoHasEstudiantePk = eventoHasEstudiantePk;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	
}
