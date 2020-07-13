package com.examen.entidad;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "examen_has_pregunta")
public class ExamenHasPregunta {
	
	@EmbeddedId
	private ExamenHasPreguntaPK examenHasPreguntaPk;

	@ManyToOne
	@JoinColumn(name = "idexamen", nullable = false)
	private Examen examen;

	@ManyToOne
	@JoinColumn(name = "idpregunta", nullable = false)
	private Pregunta pregunta;

	public ExamenHasPreguntaPK getExamenHasPreguntaPk() {
		return examenHasPreguntaPk;
	}

	public void setExamenHasPreguntaPk(ExamenHasPreguntaPK examenHasPreguntaPk) {
		this.examenHasPreguntaPk = examenHasPreguntaPk;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
	
	
}
