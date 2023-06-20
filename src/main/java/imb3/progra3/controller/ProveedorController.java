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

import imb3.progra3.entity.Proveedor;
import imb3.progra3.service.IProveedorService;

@RestController
@RequestMapping("/api/v1")
public class ProveedorController {
	
	@Autowired
	IProveedorService service;
	
	@GetMapping("/proveedor")
	public List<Proveedor> buscarTodos(){
		return service.buscarTodos();
	}
	
	@GetMapping("/proveedor/{id}")
	public Proveedor buscarPorId(@PathVariable("id") Integer id){
		return service.buscarPorId(id);		
	}
	
	@PostMapping("/proveedor")
	public Proveedor crearProveedor(@RequestBody Proveedor proveedor) {
		service.crear(proveedor);
		return proveedor;		
	}
	
	@PutMapping("/proveedor")
	public Proveedor actualizarProveedor(@RequestBody Proveedor proveedor) {
		service.crear(proveedor);
		return proveedor;		
	}
	
	@DeleteMapping("/proveedor/{id}")
	public void eliminar(@PathVariable("id") Integer id){
		service.eliminar(id);		
	}
	
}