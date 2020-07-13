package com.examen.entidad;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "examen_has_estudiante")
public class ExamenHasEstudiante {

	@EmbeddedId
	private ExamenHasEstudiantePK examenHasEstudiantePk;
	
	
	@ManyToOne
	@JoinColumn(name = "idexamen", nullable = false)
	private Examen examen;

	@ManyToOne
	@JoinColumn(name = "idestudiante", nullable = false)
	private Estudiante estudiante;
	
	@ManyToOne
	@JoinColumn(name = "idevento", nullable = false)
	private Evento evento;
	
	@Column(name = "nota")
	private double nota;

	

	

	public ExamenHasEstudiantePK getExamenHasEstudiantePk() {
		return examenHasEstudiantePk;
	}

	public void setExamenHasEstudiantePk(ExamenHasEstudiantePK examenHasEstudiantePk) {
		this.examenHasEstudiantePk = examenHasEstudiantePk;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
	
	
	
}
