package com.examen.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.entidad.Pregunta;
import com.examen.repositorio.PreguntaRepositorio;


@Service
public class PreguntaServicioImpl implements PreguntaServicio {

	@Autowired
	private PreguntaRepositorio preguntaRepositorio;
	
	
	@Override
	public List<Pregunta> listaPorExamen(int idExamen) {
		
		return preguntaRepositorio.listaPreguntasPorExamen(idExamen);
	}

}
