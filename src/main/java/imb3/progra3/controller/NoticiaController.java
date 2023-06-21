package imb3.progra3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Noticia>buscarTodos(){
		return service.buscarTodos();
	}
	
	@GetMapping("/noticia/{id}")
	public Noticia buscarPorId(@PathVariable("id") Integer id) {
		return service.buscarPorId(id);
	}
	
	@PostMapping("/noticia")
	public Noticia crearNoticia(@RequestBody Noticia noticia) {
		service.guardar(noticia);
		return noticia;
	}
	
	@PutMapping("/noticia")
	public Noticia actualizarNoticia(@RequestBody Noticia noticia) {
		service.guardar(noticia);
		return noticia;
	}
	
	@DeleteMapping("/noticia/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		service.eliminar(id);
	}

}
