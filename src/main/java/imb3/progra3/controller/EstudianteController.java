package imb3.progra3.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/estudiantes/{idEstudiante}")
	public Optional<Estudiante> buscarPorId(@PathVariable Integer idEstudiante){
		return servicio.buscarPorId(idEstudiante);
		
	}

	@PostMapping("/estudiantes/crear")
	public Estudiante crearEstudiante(@RequestBody Estudiante request){
		return servicio.crearEstudiante(request);
		
	}
	
	@PutMapping("/estudiantes/actualizar")
	public Estudiante actualizar(@RequestBody Estudiante request) {
		return servicio.actualizarEstudiante(request);
		
		
	}

	@DeleteMapping("/estudiantes/eliminar/{idEstudiante}")
	public Optional<Estudiante> eliminarPorId(@PathVariable Integer idEstudiante){
		return servicio.eliminarPorId(idEstudiante);
		
	}
	
	@DeleteMapping("/estudiantes/eliminar/todos")
	public Optional<Estudiante> eliminarTodos(){
		return servicio.eliminarPorTodos();
		
	}
	
}
