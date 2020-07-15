package com.examen.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.examen.entidad.Respuesta;
import com.examen.servicio.RespuestaServicio;



@Controller
public class VerRespuestaController {
	@Autowired
	private RespuestaServicio respuestaServicio;

	@RequestMapping("/verRespuestas")
	@ResponseBody
	public List<Respuesta> verRespuesta(Respuesta obj) {
		return respuestaServicio.listaRespuesta( obj.getPregunta().getIdPregunta());
	}
}
