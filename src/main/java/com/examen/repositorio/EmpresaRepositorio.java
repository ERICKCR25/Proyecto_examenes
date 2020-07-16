package com.examen.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.entidad.Empresa;

public interface EmpresaRepositorio extends JpaRepository<Empresa, Integer>{

}
