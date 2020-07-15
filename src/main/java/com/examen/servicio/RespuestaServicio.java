package com.examen.servicio;

import java.util.List;

import com.examen.entidad.Respuesta;

public interface RespuestaServicio {

	public Respuesta registraRespuesta(Respuesta obj);
	public List<Respuesta> listaRespuesta( int idPregunta);
	
	
}
