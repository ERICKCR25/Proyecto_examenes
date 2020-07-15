package com.examen.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.examen.entidad.*;

public interface PreguntaRepositorio extends JpaRepository<Pregunta, Integer>{

	
	@Query("Select p from Pregunta p, ExamenHasPregunta ep where "
			+ " ep.pregunta.idPregunta = p.idPregunta and "
			+ " ep.examen.idexamen = :var_idExamen")
	public abstract List<Pregunta> listaPreguntasPorExamen(@Param("var_idExamen") int idExamen);
	
	@Modifying
    @Query(value = "insert into examen_has_pregunta (idexamen,idpregunta) VALUES (:ex,:#{#preg.idPregunta})", nativeQuery = true)
    @Transactional
    public abstract void registraEnExamen(@Param(value = "preg") Pregunta bean,@Param(value = "ex") int ex);
	
//	@Query("insert ExamenHasPregunta ep (ep.idexamen, ep.idpregunta) values(:preg.idPregunta,:ex.idExamen)")
//	public abstract ExamenHasPregunta registraEnExamen(@Param(value = "preg") Pregunta bean,@Param(value = "ex") Examen ex);
	
	
	
	
}
