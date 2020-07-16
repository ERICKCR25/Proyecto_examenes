package com.examen.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.examen.entidad.*;

public interface ExamenRepositorio extends JpaRepository<Examen, Integer> {

	@Query("Select ex from Examen ex where ex.estado = 'Activo' ")
	public abstract List<Examen> listaExamenesActivos();

	@Modifying
	@Query(value = "update  Examen e set e.nombre= :nombre ,e.descripcion= :descripcion,e.claves= :claves ,e.numPreguntas= :numPreguntas,e.valorAprobatorio= :valorAprobatorio"
			+ ",e.porAprobacion= :porAprobacion,e.valorTotal= :valorTotal,e.duracion= :duracion,e.estado= :estado where e.idExamen = :idExamen ", nativeQuery = true)
	@Transactional
	public int actualiza(@Param(value = "nombre") String nombre, @Param(value = "descripcion") String descripcion,
			@Param(value = "claves") String claves,
			@Param(value = "numPreguntas") int numPreguntas,
			@Param(value = "valorAprobatorio") int valorAprobatorio,
			@Param(value = "porAprobacion") int porAprobacion, @Param(value = "valorTotal") int valorTotal,
			@Param(value = "duracion") int duracion, @Param(value = "estado") String estado,
			@Param(value = "idExamen") int idExamen);

}
