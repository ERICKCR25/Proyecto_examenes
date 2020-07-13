package com.examen.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.examen.entidad.Pregunta;

public interface PreguntaRepositorio extends JpaRepository<Pregunta, Integer>{

	
	@Query("Select p from Pregunta p, ExamenHasPregunta ep where "
			+ " ep.pregunta.idPregunta = p.idPregunta and "
			+ " ep.examen.idexamen = :var_idExamen")
	public abstract List<Pregunta> listaPreguntasPorExamen(@Param("var_idExamen") int idExamen);
	
	
	
}
