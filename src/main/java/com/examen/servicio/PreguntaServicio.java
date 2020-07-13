package com.examen.servicio;

import java.util.List;

import com.examen.entidad.Pregunta;

public interface PreguntaServicio {

	
	public abstract List<Pregunta> listaPorExamen(int idExamen);
}
