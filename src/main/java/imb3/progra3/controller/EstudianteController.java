package imb3.progra3.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Object> buscarPorId(@PathVariable Integer idEstudiante){
		Optional<Estudiante> estudiante = servicio.buscarPorId(idEstudiante);
		if (estudiante.isPresent()) {
	        return ResponseEntity.ok(estudiante.get());
	    } else {
	        String mensajeError = "No se encontró un estudiante con el ID proporcionado";
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
	    }
	}

	@PostMapping("/estudiantes/crear")
	public Estudiante crearEstudiante(@RequestBody Estudiante request){
		return servicio.crearEstudiante(request);
		
	}

	
	@PutMapping("/estudiantes/actualizar")
	public ResponseEntity<Object> actualizar(@RequestBody Estudiante request) {
	    Optional<Estudiante> estudianteExistente = servicio.buscarPorId(request.getId());
	    if (estudianteExistente.isPresent()) {
	        Estudiante estudianteActualizado = servicio.actualizarEstudiante(request);
	        return ResponseEntity.ok(estudianteActualizado);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró un estudiante con el ID proporcionado");
	    }
	}

	@DeleteMapping("/estudiantes/eliminar/{idEstudiante}")
	public ResponseEntity<Object> eliminarPorId(@PathVariable Integer idEstudiante){
		Optional<Estudiante> estudiante = servicio.buscarPorId(idEstudiante);
		if (estudiante.isPresent()){
			servicio.eliminarPorId(idEstudiante);
			return ResponseEntity.status(HttpStatus.OK).body("Estudiante eliminado");
		} else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró un estudiante con el ID proporcionado");
			
		} 
		
		
	}
	
	@DeleteMapping("/estudiantes/eliminar/todos")
	public Optional<Estudiante> eliminarTodos(){
		return servicio.eliminarTodos();
		
	}
	
}
