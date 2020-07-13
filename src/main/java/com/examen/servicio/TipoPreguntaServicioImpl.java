package com.examen.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.entidad.TipoPregunta;
import com.examen.repositorio.TipoPreguntaRepositorio;


@Service
public class TipoPreguntaServicioImpl implements TipoPreguntaServicio {
	
	@Autowired
	private TipoPreguntaRepositorio tipoPreguntaRepositorio;

	@Override
	public List<TipoPregunta> listaTodo() {
		
		return tipoPreguntaRepositorio.findAll();
	}

}
