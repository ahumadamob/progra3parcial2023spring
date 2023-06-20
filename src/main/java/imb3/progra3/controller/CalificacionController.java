package imb3.progra3.controller;

import java.util.ArrayList;
import java.util.List;

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
	public ResponseEntity<APIResponse<List<Calificacion>>> buscarTodos() {		
		APIResponse<List<Calificacion>> response = new APIResponse<List<Calificacion>>(200, null, calificacionService.buscarTodos());
		return ResponseEntity.status(HttpStatus.OK).body(response);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<APIResponse<Calificacion>> buscarPorId(@PathVariable("id") Long id) {
		if(this.existe(id)) {
			Calificacion calificacion = calificacionService.buscarPorId(id);
			APIResponse<Calificacion> response = new APIResponse<Calificacion>(HttpStatus.OK.value(), null, calificacion);
			return ResponseEntity.status(HttpStatus.OK).body(response);	
		}else {
			List<String> messages = new ArrayList<>();
			messages.add("No se encontró la Calificacion con id = " + id.toString());
			messages.add("Revise nuevamente el parámetro");
			APIResponse<Calificacion> response = new APIResponse<Calificacion>(HttpStatus.BAD_REQUEST.value(), messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);			
		}
	}
	
	@PostMapping("")
	public ResponseEntity<APIResponse<Calificacion>> crear(@RequestBody Calificacion calificacion) {
		if(this.existe(calificacion.getId())) {
			List<String> messages = new ArrayList<>();
			messages.add("Ya existe una calificacion con el ID = " + calificacion.getId().toString());
			messages.add("Para actualizar utilice el verbo PUT");
			APIResponse<Calificacion> response = new APIResponse<Calificacion>(HttpStatus.BAD_REQUEST.value(), messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}else {
			calificacionService.guardar(calificacion);
			APIResponse<Calificacion> response = new APIResponse<Calificacion>(HttpStatus.CREATED.value(), null, calificacion);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);			
		}			
	}
	
	@PutMapping("")
	public ResponseEntity<APIResponse<Calificacion>> modificar(@RequestBody Calificacion calificacion) {
		if(this.existe(calificacion.getId())) {
			calificacionService.guardar(calificacion);
			APIResponse<Calificacion> response = new APIResponse<Calificacion>(HttpStatus.OK.value(), null, calificacion);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}else {
			List<String> messages = new ArrayList<>();
			messages.add("No existe una calificacion con el ID especificado");
			messages.add("Para crear una nueva utilice el verbo POST");
			APIResponse<Calificacion> response = new APIResponse<Calificacion>(HttpStatus.BAD_REQUEST.value(), messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<APIResponse<Calificacion>> eliminar(@PathVariable("id") Long id) {
		if(this.existe(id)) {
			calificacionService.eliminar(id);
			List<String> messages = new ArrayList<>();
			messages.add("La Calificacion que figura en el cuerpo ha sido eliminada") ;			
			APIResponse<Calificacion> response = new APIResponse<Calificacion>(HttpStatus.OK.value(), messages, null);
			return ResponseEntity.status(HttpStatus.OK).body(response);	
		}else {
			List<String> messages = new ArrayList<>();
			messages.add("No existe una calificacion con el ID = " + id.toString());
			APIResponse<Calificacion> response = new APIResponse<Calificacion>(HttpStatus.BAD_REQUEST.value(), messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);			
		}
		
	}
	
	private boolean existe(Long id) {
		if(id == null) {
			return false;
		}else{
			Calificacion calificacion = calificacionService.buscarPorId(id);
			if(calificacion == null) {
				return false;				
			}else {
				return true;
			}
		}
	}
	   
}

