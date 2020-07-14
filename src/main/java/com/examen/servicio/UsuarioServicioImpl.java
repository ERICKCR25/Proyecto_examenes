package com.examen.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.entidad.Opcion;
import com.examen.entidad.Rol;
import com.examen.entidad.Usuario;
import com.examen.entidad.Estudiante;
import com.examen.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{
	@Autowired
	private UsuarioRepositorio repositorio;
	
	@Override
	public Usuario login(Usuario bean) {
		return repositorio.login(bean);
	}

	@Override
	public List<Opcion> traerEnlacesDeUsuario(int idUsuario) {
		return repositorio.traerEnlacesDeUsuario(idUsuario);
	}

	@Override
	public List<Rol> traerRolesDeUsuario(int idUsuario) {
		return repositorio.traerRolesDeUsuario(idUsuario);
	}
	
	@Override
	public Estudiante datosEstudiante(int idUsuario) {
		return repositorio.datoEstudiante(idUsuario);
	}

}
