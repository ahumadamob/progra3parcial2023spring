package imb3.progra3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imb3.progra3.entity.Estudiante;
import imb3.progra3.service.IEstudianteService;

@RestController
@RequestMapping("/api/v1")
public class EstudianteController {
	List<Estudiante> estudiantes = new ArrayList<Estudiante>();
	@Autowired
	IEstudianteService servicio;
	
	@GetMapping("/estudiantes")
	public List<Estudiante> buscarTodos(){
		
		return servicio.buscarTodos();
		
	}
	
	public List<Estudiante> buscarPorID(){
		return estudiantes;
		
	}
	
	public List<Estudiante> crear(){
		return estudiantes;
		
	}
	
	public List<Estudiante> eliminar(){
		return estudiantes;
		
	}
	
}
