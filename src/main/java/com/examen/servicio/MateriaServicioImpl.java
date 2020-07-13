package com.examen.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.entidad.Materia;
import com.examen.repositorio.MateriaRepositorio;

@Service
public class MateriaServicioImpl implements MateriaServicio {

	
	@Autowired
	private MateriaRepositorio materiaRepositorio;
	
	@Override
	public List<Materia> listaMateria() {
		
		return materiaRepositorio.findAll();
	}

}
