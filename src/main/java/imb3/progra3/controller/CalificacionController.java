package imb3.progra3.controller;

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

import imb3.progra3.entity.Calificacion;
import imb3.progra3.service.ICalificacionService;



@RestController
@RequestMapping(path = "api/v1/calificaciones")
public class CalificacionController {
	private ICalificacionService calificacionService;
	
	public CalificacionController(ICalificacionService calificacionService) {
		this.calificacionService = calificacionService;
	}
	
	@GetMapping("")
	public ResponseEntity<?> buscarTodos(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(calificacionService.buscarTodos());
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(calificacionService.buscarPorId(id));
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. No se ha encontrado el ID.\"}");
		}
	}
	
	@PostMapping("")
	public ResponseEntity<?> crear(@RequestBody Calificacion entity){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(calificacionService.guardar(entity));
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se ha podido crear la entidad.\"}");
		}
	}
	
	@PutMapping("")
	public ResponseEntity<?> modificar(@RequestBody Calificacion entity){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(calificacionService.guardar(entity));
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se ha podido modificar la entidad.\"}");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(calificacionService.eliminar(id));
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se ha podido borrar la entidad.\"}");
		}
	}
	   
}

