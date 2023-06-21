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

import imb3.progra3.entity.Noticia;
import imb3.progra3.service.INoticiaService;

@RestController
@RequestMapping("/api/v1")
public class NoticiaController {
	
	@Autowired
	INoticiaService service;
	
	@GetMapping("/noticia")
	public ResponseEntity<APIResponse<List<Noticia>>>buscarTodos(){
		APIResponse<List<Noticia>> response = new APIResponse<List<Noticia>> (200, null, service.buscarTodos());
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("/noticia/{id}")
	public ResponseEntity<APIResponse<Noticia>> buscarPorId(@PathVariable("id") Integer id) {
		Noticia noticia = service.buscarPorId(id);
		if(noticia == null){
			List<String> messages = new ArrayList<>();
			messages.add("No se encontró la Noticia con id = " + id.toString());
			messages.add("Revise el parámetro");
			APIResponse<Noticia> response = new APIResponse<Noticia>(HttpStatus.BAD_REQUEST.value(), messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}else {
			APIResponse<Noticia> response = new APIResponse<Noticia>(HttpStatus.OK.value(),null,noticia);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}
	
	@PostMapping("/noticia")
	public ResponseEntity<APIResponse<Noticia>> crearNoticia(@RequestBody Noticia noticia) {
		if(noticia.getId() != null) {
			Noticia buscaNoticia = service.buscarPorId(noticia.getId());
			if (buscaNoticia != null) {
				List<String> messages = new ArrayList<>();
				messages.add("Ya existe una noticia con el ID = " + noticia.getId().toString());
				messages.add("Para actualizar utilice el verbo PUT");
				APIResponse<Noticia> response = new APIResponse<Noticia>(HttpStatus.BAD_REQUEST.value(), messages, null);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
		}
		service.guardar(noticia);
		APIResponse<Noticia> response = new APIResponse<Noticia>(HttpStatus.CREATED.value(),null,noticia);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}
	
	@PutMapping("/noticia")
	public ResponseEntity<APIResponse<Noticia>> actualizarNoticia(@RequestBody Noticia noticia) {
		boolean isError;
		String idStr;
		if(noticia.getId() != null) {
			Noticia buscaNoticia = service.buscarPorId(noticia.getId());
			idStr = noticia.getId().toString();
			if (buscaNoticia != null) {
				//Devolver un OK
				isError = false;
			}else {
				//Devolver un Error
				isError = true;
			}
			
		}else {
			idStr = "<No definido>";
			//Devolver un error
			isError = true;
		}
		
		if(isError) {
			//Devolvermos el error
			List<String> messages = new ArrayList<>();
			messages.add("No existe una noticia con el ID = " + idStr);
			messages.add("Para crear una nueva utilice el verbo POST");
			APIResponse<Noticia> response = new APIResponse<Noticia>(HttpStatus.BAD_REQUEST.value(), messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}else {
			//Devolvemos el OK
			service.guardar(noticia);
			APIResponse<Noticia> response = new APIResponse<Noticia>(HttpStatus.OK.value(),null,noticia);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		
	}
	
	@DeleteMapping("/noticia/{id}")
	public ResponseEntity<APIResponse<Noticia>> eliminar(@PathVariable("id") Integer id) {
		Noticia buscaNoticia = service.buscarPorId(id);
		if(buscaNoticia == null) {
			//Error
			List<String> messages = new ArrayList<>();
			messages.add("No existe una noticia con el ID = " + id.toString());
			APIResponse<Noticia> response = new APIResponse<Noticia>(HttpStatus.BAD_REQUEST.value(),messages,null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}else {
			service.eliminar(id);
			List<String> messages = new ArrayList<>();
			messages.add("La noticia que figura en el cuerpo ha sido eliminada");
			APIResponse<Noticia> response = new APIResponse<Noticia>(HttpStatus.OK.value(),messages,buscaNoticia);
			return ResponseEntity.status(HttpStatus.OK).body(response);
			//eliminar
		}
		
	}

}
