package com.examen.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.entidad.Evento;

public interface EventoRepositorio extends JpaRepository<Evento, Integer>{

}
