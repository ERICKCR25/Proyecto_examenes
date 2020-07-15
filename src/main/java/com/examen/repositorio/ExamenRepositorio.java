package com.examen.repositorio;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



import com.examen.entidad.*;

public interface ExamenRepositorio extends JpaRepository<Examen, Integer>{
	
	@Query("Select ex from Examen ex where ex.estado = 'Activo' ")
	public abstract List<Examen> listaExamenesActivos();
	
		
}
