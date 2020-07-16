package com.examen.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.entidad.Examen;
import com.examen.repositorio.ExamenRepositorio;

@Service
public class ExamenServicioImpl implements ExamenServicio {
	
	@Autowired
	private ExamenRepositorio examenRepositorio;

	@Override
	public List<Examen> listaTodos() {
		return examenRepositorio.findAll();
	}

	@Override
	public Examen registraExamen(Examen obj) {
		return examenRepositorio.save(obj);
	}

	@Override
	public void eliminaExamen(int id) {	
		examenRepositorio.deleteById(id);
	}

	@Override
	public List<Examen> listaExamenesActivos() {
		
		return examenRepositorio.listaExamenesActivos();
	}

	
	@Override
	public int actualiza(String nombre,String descripcion,String claves,int numPreguntas,int valorAprobatorio
			,int porAprobacion,int valorTotal, int duracion, String estado, int idExamen) {	
		return examenRepositorio.actualiza(nombre, descripcion,claves, numPreguntas, valorAprobatorio, porAprobacion, valorTotal, duracion, estado, idExamen);
	}
	

	
	
	
	
	
	
	
	
	
	
	

}
