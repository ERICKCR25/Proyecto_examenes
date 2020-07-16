package com.examen.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.entidad.Estudiante;

public interface EstudianteRepositorio extends JpaRepository<Estudiante, Integer>{

}
