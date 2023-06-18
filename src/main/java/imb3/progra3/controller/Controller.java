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

import imb3.progra3.entity.CiaDeSeguros;

@RestController
@RequestMapping("/api/v1")
public class Controller {
	@Autowired
	iCiaDeSegurosService service;
	
	
	@GetMapping("/CiaDeSeguros")
	public List <CiaDeSeguros> buscarTodos(){
		return service.buscarTodos();
	}
	
	@PostMapping("/CiaDeSeguros")
	public CiaDeSeguros crearCiaDeSeguros(@RequestBody CiaDeSeguros compania) {
		service.guardar(compania);
		return compania;
	}
	
	@PutMapping("/CiaDeSeguros")
	public CiaDeSeguros actualizarCiaDeSeguros(@RequestBody CiaDeSeguros compania) {
		service.guardar(compania);
		return compania;
	}
	
	
	@GetMapping("/CiaDeSeguros/{id}")
	public CiaDeSeguros buscarporId(@PathVariable("id") Integer id){
		return service.buscarPorId(id);
	}
	
	@DeleteMapping("/CiaDeSeguros/{id}")
	public void eliminar(@PathVariable("id") Integer id){
		service.eliminar(id);
	}
}
