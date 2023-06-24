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

import imb3.progra3.entity.Evento;
import imb3.progra3.service.IEventoService;

@RestController
@RequestMapping("/api/v1")
public class EventoController {
	
	@Autowired
	IEventoService service;
	
	@GetMapping("/Evento")
	public List <Evento> buscarTodos(){
		return service.buscarTodos();
		
	}
	
	@GetMapping("/Evento/{id}")
	public ResponseEntity<ApIResponse<Evento>> buscarPorId(@PathVariable("id")Integer id){
		Evento evento = service.buscarPorId(id);
		if(this.existe(id)) {
			ApIResponse<Evento> response = new ApIResponse <Evento>(HttpStatus.OK.value(),null,evento);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}else {
			List<String> mensajes = new ArrayList();
			mensajes.add("No existe");
			mensajes.add("Vuelva a consultar, por favor");
			ApIResponse<Evento> response = new ApIResponse <Evento>(HttpStatus.BAD_REQUEST.value(),mensajes,null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			
		}
		
	}
	
	@PostMapping("/Evento")
	public Evento crearEvento (@RequestBody Evento evento){
		service.crear(evento);
		return evento;
		
	}
	
	@PutMapping("/Evento")
	public Evento actualizarEvento (@RequestBody Evento evento){
		service.crear(evento);
		return evento;
		
	}

	@DeleteMapping("/Evento/{id}")
	public void eliminar (@PathVariable("id")Integer id){
		service.eliminar(id);
		
		
	}
	
	
	private boolean existe(Integer id) {
		if (id == null) {
			return false;
		}else {
		    Evento evento = service.buscarPorId(id);
		    if(evento == null) {
		    	return false;
		    }else {
		    	return true;
		    }
		}	
	}

}
