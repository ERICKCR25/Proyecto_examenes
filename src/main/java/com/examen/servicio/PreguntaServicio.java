package com.examen.servicio;

import java.util.List;

import com.examen.entidad.Pregunta;

public interface PreguntaServicio {

	
	public abstract List<Pregunta> listaPorExamen(int idExamen);
	
	public abstract int cantidadPreguntasPorExamen(int idExamen);
	
	public abstract Pregunta agregaPregunta(Pregunta obj);
	
	public abstract void agregaPreguntaEnExamen(Pregunta obj,int idExamen);
}
