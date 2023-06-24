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

import imb3.progra3.entity.Producto;
import imb3.progra3.service.IProductoService;

@RestController
@RequestMapping("/api/v1")
public class ProductoController {
	
	@Autowired
	IProductoService service;
	
	@GetMapping("/producto")
	public List<Producto> buscarTodos(){
		return service.buscarTodos();
	}
	
	@GetMapping("/producto/{id}")
	public Producto buscarPorId(@PathVariable("id") Integer id){
		return service.buscarPorId(id);		
	}
	
	@PostMapping("/producto")
	public Producto crearProducto(@RequestBody Producto producto) {
		service.guardar(producto);
		return producto;		
	}
	
	@PutMapping("/producto")
	public Producto actualizarProducto(@RequestBody Producto producto) {
		service.guardar(producto);
		return producto;		
	}
	
	@DeleteMapping("/producto/{id}")
	public void eliminar(@PathVariable("id") Integer id){
		service.eliminar(id);		
	}	

}
