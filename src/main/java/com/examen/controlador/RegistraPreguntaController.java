package com.examen.controlador;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.examen.entidad.Materia;
import com.examen.entidad.Pregunta;
import com.examen.entidad.TipoPregunta;
import com.examen.servicio.MateriaServicio;
import com.examen.servicio.PreguntaServicio;
import com.examen.servicio.TipoPreguntaServicio;

@Controller
public class RegistraPreguntaController {

	
	@Autowired
	private PreguntaServicio preguntaServicio;
	
	@Autowired
	private MateriaServicio materiaServicio;
	
	@Autowired
	private TipoPreguntaServicio tipoPreguntaServicio;
	
	@RequestMapping("/listaMateria")
	@ResponseBody
	public List<Materia> listaMateria(){
		return materiaServicio.listaMateria();
	}
	
	@RequestMapping("/listaTipoPregunta")
	@ResponseBody
	public List<TipoPregunta> listaTipoPregunta(){
		return tipoPreguntaServicio.listaTodo();
	}
	
	@RequestMapping("/registraPregunta")
	public String registraPregunta(Pregunta obj,HttpSession session){
		Pregunta aux = preguntaServicio.agregaPregunta(obj);
		if(aux == null) {
			session.setAttribute("MENSAJE", "Registro erróneo");
		}else {
			session.setAttribute("MENSAJE", "Registro exitoso");
		}
		return "redirect:crudPreguntas2";
		
	}
}
