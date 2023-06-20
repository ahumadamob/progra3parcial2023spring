package imb3.progra3.controller;
import java.util.*;
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

import imb3.progra3.entity.Proyecto;
import imb3.progra3.service.iProyectoService;

@RestController
@RequestMapping("/api/v1")
public class ProyectoController {

	@Autowired
	iProyectoService service;


	@GetMapping("/proyecto")
	public ResponseEntity<APIResponse<List<Proyecto>>>buscarTodos() {

		List<Proyecto> proyecto = service.buscarTodos();
		if(proyecto.isEmpty()) {
			APIResponse<List<Proyecto>> response = new APIResponse<List<Proyecto>> (200, null, service.buscarTodos());
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		else {
			APIResponse<List<Proyecto>> response = new APIResponse<List<Proyecto>> (200, null, proyecto);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}

	@GetMapping("/proyecto/{id}")
	public ResponseEntity<APIResponse<Proyecto>> buscarPorId(@PathVariable("id") Integer id){
		Proyecto proyecto = service.buscarPorId(id);
		if(proyecto == null) {
			List <String> messages = new ArrayList<>();
			messages.add("No se encontró el proyecto con el id: " + id.toString());
			messages.add("Revise nuevamente el parámetro.");
			APIResponse<Proyecto> response = new APIResponse<Proyecto>(HttpStatus.BAD_REQUEST.value(), messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		else {
			APIResponse<Proyecto> response = new APIResponse<Proyecto>(HttpStatus.OK.value(), null, proyecto);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}

	@PostMapping("/proyecto")
	public ResponseEntity<APIResponse<Proyecto>> crearProyecto(@RequestBody Proyecto proyecto) {

		if(proyecto.getId() != null) {
			Proyecto buscaProyecto = service.buscarPorId(proyecto.getId());

			if(buscaProyecto!=null) {
				List <String> messages = new ArrayList<>();
				messages.add("Ya existe un proyecto con el id: " + proyecto.getId().toString());
				messages.add("Para actualizar utilice el verbo PUT");
				APIResponse<Proyecto> response = new APIResponse<Proyecto>(HttpStatus.BAD_REQUEST.value(), messages, null);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
		}

		service.guardar(proyecto);
		APIResponse<Proyecto> response = new APIResponse<Proyecto>(HttpStatus.CREATED.value(), null, proyecto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);

	}

	@PutMapping("/proyecto")
	public ResponseEntity<APIResponse<Proyecto>> actualizarProyecto(@RequestBody Proyecto proyecto) {

		boolean isError;
		String idStr;

		if(proyecto.getId() != null) {
			Proyecto buscaProyecto = service.buscarPorId(proyecto.getId());
			idStr = proyecto.getId().toString();

			if(buscaProyecto!=null) {
				isError = false;
			}
			else {
				isError = true;
			}
		}
		else{
			isError = true;
			idStr = "No definido";
		}

		if(isError) {

			List <String> messages = new ArrayList<>();
			messages.add("No existe un proyecto con el id: " + idStr);
			messages.add("Para crear una nueva categoria, utilice el verbo POST");
			APIResponse<Proyecto> response = new APIResponse<Proyecto>(HttpStatus.BAD_REQUEST.value(), messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

		}

		else {
			service.guardar(proyecto);
			APIResponse<Proyecto> response = new APIResponse<Proyecto>(HttpStatus.OK.value(), null, proyecto);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}

	@DeleteMapping("/proyecto/{id}")
	public ResponseEntity<APIResponse<Proyecto>> eliminar(@PathVariable("id") Integer id){
		Proyecto buscaProyecto = service.buscarPorId(id);

		if(buscaProyecto == null) {
			List <String> messages = new ArrayList<>();
			messages.add("No existe un proyecto con el id: " + id.toString());
			APIResponse<Proyecto> response = new APIResponse<Proyecto>(HttpStatus.OK.value(), null, buscaProyecto);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

		}

		else {
			service.eliminar(id);
			List <String> messages = new ArrayList<>();
			messages.add("El proyecto con id " + id.toString() + " ha sido eliminado con éxito");
			APIResponse<Proyecto> response = new APIResponse<Proyecto>(HttpStatus.OK.value(), messages, buscaProyecto);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

}
