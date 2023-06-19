package imb3.progra3.controller;

import java.util.ArrayList;
import java.util.List;
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
		Estudiante estudiante = servicio.buscarPorId(idEstudiante);
		if (estudiante == null) {
			String mensajeError = "No se encontró un estudiante con el ID proporcionado";
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
	    } else {
	    	return ResponseEntity.ok(estudiante);
	    }
	}

	@PostMapping("/estudiantes")
	public Estudiante crearEstudiante(@RequestBody Estudiante request){
		return servicio.crearEstudiante(request);
		
	}

	
	@PutMapping("/estudiantes")
	public ResponseEntity<Object> actualizar(@RequestBody Estudiante request) {
	    Estudiante estudianteExistente = servicio.buscarPorId(request.getId());
	    if (estudianteExistente == null) {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró un estudiante con el ID proporcionado");
	    } else {
	    	Estudiante estudianteActualizado = servicio.actualizarEstudiante(request);
	        return ResponseEntity.ok(estudianteActualizado);
	        
	    }
	}

	@DeleteMapping("/estudiantes/{idEstudiante}")
	public ResponseEntity<Object> eliminarPorId(@PathVariable Integer idEstudiante){
		Estudiante estudiante = servicio.buscarPorId(idEstudiante);
		if (estudiante == null){
			String mensajeError = "No se encontró un estudiante con el ID proporcionado";
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
			
		} else {
			servicio.eliminarPorId(idEstudiante);
			return ResponseEntity.status(HttpStatus.OK).body("Estudiante eliminado");
			
		} 
		
		
	}
	
	@DeleteMapping("/estudiantes/all")
	public ResponseEntity<String> eliminarTodos(){
		servicio.eliminarTodos();
		String mensaje = "Tabla de estudiante vaciada con éxito.";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
		
	}
	
}
