package com.examen.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.examen.servicio.*;
import com.examen.entidad.*;


@Controller
public class ExamenController {

	
	@Autowired
	private ExamenServicio eservicio;
	@Autowired
	private MateriaServicio materiaservicio;
	@Autowired
	private PreguntaServicio preguntaServicio;
	
	@Autowired
	private TipoPreguntaServicio tipoPreguntaServicio;
	//@Autowired
	//private RespuestaServicio respuestaServicio;
	
	
	
	@RequestMapping("/verExamen")
	public String verPagina(Model m) {
		
		m.addAttribute("Examenes", eservicio.listaExamenesActivos());
		return "crudExamen";
	}
	
	@ResponseBody
	@RequestMapping("/cargaMateria")
	public List<Materia> cargaMateria() {		
		return materiaservicio.listaMateria();
	}
	
	@ResponseBody
	@RequestMapping("/cargaTipoPregunta")
	public List<TipoPregunta> cargaTipoPregunta() {		
		return tipoPreguntaServicio.listaTodo();
	}
//	
//	@ResponseBody
//	@RequestMapping("/cargaPreguntas")
//	public List<Pregunta> cargaPreguntas(int id) {	
//		return preguntaServicio.listaPorExamen(id);
//	}
//	
//	
//	
	@RequestMapping("/agregaPreguntas")
	public String verExamen(@RequestParam Map<String,String> params,Model m) {
		int id=Integer.parseInt(params.get("id_agrega"));		
		List<Examen> lista=eservicio.listaExamenesActivos();	
		List<Pregunta> preg=preguntaServicio.listaPorExamen(id);
		for(Examen e : lista) {
			if(e.getIdexamen()==id) {
				m.addAttribute("idex",e.getIdexamen());
				m.addAttribute("Examen",e.getNombre());
				m.addAttribute("descripcion",e.getDescripcion());
				m.addAttribute("idExamen",e.getIdexamen());
				m.addAttribute("porAprobacion",e.getPorAprobacion());
				m.addAttribute("valorTotal",e.getValorTotal());
			}
		}
		m.addAttribute("preguntas",preg);
		m.addAttribute("cantPreguntas",preguntaServicio.cantidadPreguntasPorExamen(id));
		return "crudTotal";
	}
	
	@RequestMapping("/agregaPreguntasEnEx")
	public String registraPreguntas(Model m,Pregunta obj,@RequestParam Map<String,String> params) {
		int id=Integer.parseInt(params.get("id_ex"));			
		preguntaServicio.agregaPregunta(obj);
		preguntaServicio.agregaPreguntaEnExamen(obj, id);
		List<Examen> lista=eservicio.listaExamenesActivos();	
		List<Pregunta> preg=preguntaServicio.listaPorExamen(id);
		for(Examen e : lista) {
			if(e.getIdexamen()==1) {
				m.addAttribute("idex",e.getIdexamen());
				m.addAttribute("Examen",e.getNombre());
				m.addAttribute("descripcion",e.getDescripcion());
				m.addAttribute("idExamen",e.getIdexamen());
				m.addAttribute("porAprobacion",e.getPorAprobacion());
				m.addAttribute("valorTotal",e.getValorTotal());
			}
		}
		m.addAttribute("preguntas",preg);
		m.addAttribute("cantPreguntas",preguntaServicio.cantidadPreguntasPorExamen(id));
		return "crudTotal";
	}
//	
	@RequestMapping("/eliminaPregunta")
	public String eliminaPregunta(@RequestParam Map<String,String> params, Model m) {			
		preguntaServicio.eliminaPregunta(Integer.parseInt(params.get("elimina_pregunta")));	
		int id=Integer.parseInt(params.get("id_ex"));	
		List<Examen> lista=eservicio.listaExamenesActivos();	
		List<Pregunta> preg=preguntaServicio.listaPorExamen(id);
		for(Examen e : lista) {
			if(e.getIdexamen()==id) {
				m.addAttribute("Examen",e.getNombre());
				m.addAttribute("descripcion",e.getDescripcion());
				m.addAttribute("idExamen",e.getIdexamen());
				m.addAttribute("porAprobacion",e.getPorAprobacion());
				m.addAttribute("valorTotal",e.getValorTotal());
			}
		}
		m.addAttribute("preguntas",preg);
		return "crudTotal";
	}
//	@RequestMapping("/actualizaPregunta")
//	public String actualizaPregunta( @RequestParam Map<String,String> params,Model m,Pregunta obj) {			
//		preguntaServicio.insertaActualizaPregunta(obj);	
//		int id=Integer.parseInt(params.get("idex"));		
//		List<Examen> lista=eservicio.listaExamen(id);	
//		List<Pregunta> preg=preguntaServicio.listaPorExamen(id);
//		
//		for(Examen e : lista) {
//			if(e.getIdexamen()==id) {
//				m.addAttribute("Examen",e.getNombre());
//				m.addAttribute("descripcion",e.getDescripcion());
//				m.addAttribute("idExamen",e.getIdexamen());
//				m.addAttribute("porAprobacion",e.getPorAprobacion());
//				m.addAttribute("valorTotal",e.getValorTotal());
//			}
//		}
//		m.addAttribute("preguntas",preg);
//		m.addAttribute("cantPreguntas",preguntaServicio.cantidadPreguntasPorExamen(id));
//		return "crudTotal";	
//	}
//	
	@RequestMapping("/registraExamen")
	public String agregaExamen( Model m,Examen obj) {			
		eservicio.registraExamen(obj);	
		List<Examen> list = eservicio.listaExamenesActivos();
		m.addAttribute("examenes", list);
		return "crudExamen";
	}
//	
//	@RequestMapping("/actualizaExamen")
//	public String actualizaExamen( Model m,Examen obj) {			
//		eservicio.actualizaExamen(obj);	
//		List<Examen> list = eservicio.listaExamenN("");
//		m.addAttribute("examenes", list);
//		return "crudExamen";	
//	}	
//	
//	
//	@RequestMapping("/eliminaExamen")
//	public String eliminaExamen(@RequestParam Map<String,String> params, Model m) {			
//		eservicio.eliminaExamen(Integer.parseInt(params.get("id")));	
//		List<Examen> list = eservicio.listaExamenN("");
//		m.addAttribute("examenes", list);
//		return "crudExamen";
//	}
//	
//	
//	
//	@RequestMapping("/listaExamenId")
//	public String listaExamenId(@RequestParam Map<String,String> params, Model m) {
//		List<Examen> list = eservicio.listaExamen(Integer.parseInt(params.get("filtro")));
//		m.addAttribute("examenes", list);
//		return "crudExamen";
//	}
//	
	@RequestMapping("/listaExamen")
	public String listaExamen( Model m) {
		List<Examen> list = eservicio.listaExamenesActivos();
		m.addAttribute("examenes", list);
		return "crudExamen";
	}
//	
//		
//	@RequestMapping("/listaExamenN")
//	public String listaExamenN(@RequestParam Map<String,String> params, Model m) {
//		List<Examen> list = eservicio.listaExamenN((params.get("filtro")));
//		m.addAttribute("examenes", list);
//		return "crudExamen";
//	}
//	
	
}
