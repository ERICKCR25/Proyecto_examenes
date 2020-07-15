package com.examen.controlador;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.examen.entidad.Pregunta;
import com.examen.entidad.Respuesta;
import com.examen.servicio.PreguntaServicio;
import com.examen.servicio.RespuestaServicio;
@Controller
public class RegistraRespuestaController {

	
	@Autowired
	private PreguntaServicio preguntaServicio;
	
	@Autowired
	private RespuestaServicio respuestaServicio;
	
	@RequestMapping("/listaPregunta")
	@ResponseBody
	public List<Pregunta> listaPreguntas(){
		return preguntaServicio.listaTodos();
	}
	
	@RequestMapping("/registraRespuesta")
	public String registraRespuesta(Respuesta obj,HttpSession session){
		Respuesta aux = respuestaServicio.registraRespuesta(obj);
		if(aux == null) {
			session.setAttribute("MENSAJE", "Registro erróneo");
		}else {
			session.setAttribute("MENSAJE", "Registro exitoso");
		}
		return "redirect:crudRespuesta";
		
	}
	
}
