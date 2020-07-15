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


	@Override
	public int cantidadPreguntasPorExamen(int idExamen) {
		int cantidad=0;
		List<Pregunta> lista=preguntaRepositorio.listaPreguntasPorExamen(idExamen);
		for(Pregunta p: lista) {
			cantidad++;
		}
		
		return cantidad;
	}


	@Override
	public Pregunta agregaPregunta(Pregunta obj) {
		return preguntaRepositorio.save(obj);
	}


	@Override
	public void agregaPreguntaEnExamen(Pregunta obj, int idExamen) {
		preguntaRepositorio.registraEnExamen(obj, idExamen);
	}


	@Override
	public void eliminaPregunta(int id) {
		preguntaRepositorio.deleteById(id);
		
	}

	
	@Override
	public List<Pregunta> listaTodos(){
		return preguntaRepositorio.findAll();
	}
	
	
	
	
}
