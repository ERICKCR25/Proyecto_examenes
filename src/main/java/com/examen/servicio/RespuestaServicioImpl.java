package com.examen.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.entidad.Respuesta;
import com.examen.repositorio.RespuestaRepositorio;
@Service
public class RespuestaServicioImpl implements RespuestaServicio{

	
	@Autowired
	private RespuestaRepositorio repositorio;
	
	@Override
	public Respuesta registraRespuesta(Respuesta obj) {
		return repositorio.save(obj);
		
	}
	
	@Override
	public List<Respuesta> listaRespuesta( int idPregunta){
		
		return repositorio.listaRespuesta( idPregunta);
		
	}

	@Override
	public List<Respuesta> listaRespuestas() {
		
		return repositorio.findAll();
	}
	
}
