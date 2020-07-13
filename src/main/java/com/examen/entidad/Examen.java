package com.examen.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "examen")
public class Examen {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idExamen")
	private int idexamen;
	
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "claves")
	private String claves;
	
	@Column(name = "numPreguntas")
	private int numPreguntas;
	
	@Column(name = "valorAprobatorio")
	private int valorAprobatorio;
	
	
	@Column(name = "porAprobacion")
	private int porAprobacion;
	
	@Column(name = "valorTotal")
	private int valorTotal;
	
	@Column(name = "duracion")
	private int duracion;
	
	@Column(name = "estado")
	private String estado;
	
	
	public int getIdexamen() {
		return idexamen;
	}
	public void setIdexamen(int idexamen) {
		this.idexamen = idexamen;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getClaves() {
		return claves;
	}
	public void setClaves(String claves) {
		this.claves = claves;
	}
	public int getNumPreguntas() {
		return numPreguntas;
	}
	public void setNumPreguntas(int numPreguntas) {
		this.numPreguntas = numPreguntas;
	}
	public int getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
	}
	public int getValorAprobatorio() {
		return valorAprobatorio;
	}
	public void setValorAprobatorio(int valorAprobatorio) {
		this.valorAprobatorio = valorAprobatorio;
	}
	public int getPorAprobacion() {
		return porAprobacion;
	}
	public void setPorAprobacion(int porAprobacion) {
		this.porAprobacion = porAprobacion;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
