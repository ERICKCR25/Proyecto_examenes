package com.examen.servicio;

import java.util.List;

import com.examen.entidad.*;
public interface ExamenServicio {

	public abstract List<Examen> listaTodos();
	public abstract Examen registraExamen(Examen obj);	
	public abstract void eliminaExamen(int id);	
	public abstract List<Examen> listaExamenesActivos();
	
	
}
