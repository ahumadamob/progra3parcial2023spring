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

import imb3.progra3.entity.Proyecto;
import imb3.progra3.service.iProyectoService;

@RestController
@RequestMapping("/api/v1")
public class ProyectoController {
	
	@Autowired
	iProyectoService service;
	
	
	@GetMapping("/proyecto")
	public List <Proyecto> buscarTodos(){
		return service.buscarTodos();
	}
	
	@PostMapping("/proyecto")
	public Proyecto crearProyecto(@RequestBody Proyecto proyecto) {
		service.guardar(proyecto);
		return proyecto;
	}
	
	@PutMapping("/proyecto")
	public Proyecto actualizarProyecto(@RequestBody Proyecto proyecto) {
		service.guardar(proyecto);
		return proyecto;
	}
	
	
	@GetMapping("/proyecto/{id}")
	public Proyecto buscarporId(@PathVariable("id") Integer id){
		return service.buscarPorId(id);
	}
	
	@DeleteMapping("/proyecto/{id}")
	public void eliminar(@PathVariable("id") Integer id){
		service.eliminar(id);
	}
	
}
