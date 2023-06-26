package imb3.progra3.Controller;



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

import imb3.progra3.entity.comentario;
import imb3.progra3.Service.iComentarioService;

@RestController
@RequestMapping("/api/v1")
public class ComentarioController {

	@Autowired
	iComentarioService service;


	@GetMapping("/comentario")
	public ResponseEntity<ApiResponse<List<comentario>>>buscarTodos() {

		List<comentario> comentario = service.buscarTodos();
		if(comentario.isEmpty()) {
			ApiResponse<List<comentario>> response = new ApiResponse<List<comentario>> (200, null, service.buscarTodos());
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		else {
			ApiResponse<List<comentario>> response = new ApiResponse<List<comentario>> (200, null, comentario);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}

	@GetMapping("/comentario/{id}")
	public ResponseEntity<ApiResponse<comentario>> buscarPorId(@PathVariable("id") Integer id){
		comentario comentario = service.buscarPorId(id);
		if(comentario == null) {
			List <String> messages = new ArrayList<>();
			messages.add("No se encontró el comentario con el id: " + id.toString());
			messages.add("Revise nuevamente el parámetro.");
			ApiResponse<comentario> response = new ApiResponse<comentario>(HttpStatus.BAD_REQUEST.value(), messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		else {
			ApiResponse<comentario> response = new ApiResponse<comentario>(HttpStatus.OK.value(), null, comentario);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}

	@PostMapping("/comentario")
	public ResponseEntity<ApiResponse<comentario>> crearcomentario(@RequestBody comentario comentario) {

		if(comentario.getId() != null) {
			comentario buscacomentario = service.buscarPorId(comentario.getId());

			if(buscacomentario!=null) {
				List <String> messages = new ArrayList<>();
				messages.add("Ya existe un comentariocon el id: " + comentario.getId().toString());
				messages.add("Para actualizar utilice el verbo PUT");
				ApiResponse<comentario> response = new ApiResponse<comentario>(HttpStatus.BAD_REQUEST.value(), messages, null);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
		}

		service.guardar(comentario);
		ApiResponse<comentario> response = new ApiResponse<comentario>(HttpStatus.CREATED.value(), null, comentario);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);

	}

	@PutMapping("/comentario")
	public ResponseEntity<ApiResponse<comentario>> actualizarcomentario(@RequestBody comentario comentario) {

		boolean isError;
		String idStr;

		if(comentario.getId() != null) {
			comentario buscacomentario = service.buscarPorId(comentario.getId());
			idStr = comentario.getId().toString();

			if(buscacomentario!=null) {
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
			messages.add("No existe un comentario con el id: " + idStr);
			messages.add("Para crear una nueva categoria, utilice el verbo POST");
			ApiResponse<comentario> response = new ApiResponse<comentario>(HttpStatus.BAD_REQUEST.value(), messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

		}

		else {
			service.guardar(comentario);
			ApiResponse<comentario> response = new ApiResponse<comentario>(HttpStatus.OK.value(), null, comentario);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}

	@DeleteMapping("/comentario/{id}")
	public ResponseEntity<ApiResponse<comentario>> eliminar(@PathVariable("id") Integer id){
		comentario buscaComentario = service.buscarPorId(id);

		if(buscaComentario == null) {
			List <String> messages = new ArrayList<>();
			messages.add("No existe un comentario con el id: " + id.toString());
			ApiResponse<comentario> response = new ApiResponse<comentario>(HttpStatus.OK.value(), null, buscaComentario);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

		}

		else {
			service.eliminar(id);
			List <String> messages = new ArrayList<>();
			messages.add("El comentario con id " + id.toString() + " ha sido eliminado con éxito");
			ApiResponse<comentario> response = new ApiResponse<comentario>(HttpStatus.OK.value(), messages, buscaComentario);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

}