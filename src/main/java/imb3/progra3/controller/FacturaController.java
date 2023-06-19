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

import imb3.progra3.entity.Factura;
import imb3.progra3.service.iFacturaService;

@RestController
@RequestMapping("/api/v1")
public class FacturaController {
	
	
	@Autowired
	iFacturaService service; 

	@GetMapping("/factura")
	public List<Factura> buscarTodos() {
		return service.buscarTodos();
	}
	
	@GetMapping("/factura/{id}")
	public Factura buscarPorId(@PathVariable("id") Integer id) {
		return service.buscarPorId(id);	
	}
	
	@PostMapping("/factura")
	public Factura crearFactura(@RequestBody Factura f) {
		service.guardar(f);
		return f;
	}
	
	@PutMapping("/factura/{id}")
	public Factura actualizarFactura(@PathVariable("id") Integer id, @RequestBody Factura f) {
		service.guardar(f);
		return f;
	}
	
	@DeleteMapping("/factura/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		service.eliminar(id);
	}
	
	
}
