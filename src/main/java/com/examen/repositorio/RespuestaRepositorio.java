package com.examen.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.examen.entidad.Respuesta;

public interface RespuestaRepositorio extends JpaRepository<Respuesta, Integer>{

	
	@Query("select r from Respuesta r where  r.pregunta.idPregunta = :var_pregunta ")
	public List<Respuesta> listaRespuesta( @Param("var_pregunta")  int idPregunta);

	
}
