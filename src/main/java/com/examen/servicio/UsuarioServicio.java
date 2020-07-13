package com.examen.servicio;

import java.util.List;

import com.examen.entidad.Estudiante;
import com.examen.entidad.Opcion;
import com.examen.entidad.Rol;
import com.examen.entidad.Usuario;

public interface UsuarioServicio {

	
	public abstract Usuario login(Usuario bean);

	public abstract List<Opcion> traerEnlacesDeUsuario(int idUsuario);

	public abstract List<Rol> traerRolesDeUsuario(int idUsuario);
	
	
	public abstract Estudiante datosEstudiante(int idUsuario);
}
