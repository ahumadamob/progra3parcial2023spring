package imb3.progra3.controller;

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

import imb3.progra3.entity.Factura;
import imb3.progra3.service.iFacturaService;

@RestController
@RequestMapping("/api/v1/factura")
public class FacturaController {
	
	
	@Autowired
	iFacturaService service; 

	@GetMapping("")
//	public List<Factura> buscarTodos() {
//		return service.findAll();
//	}
	public ResponseEntity<List<Factura>> buscarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	
	@GetMapping("/{id}")
//	public Factura buscarPorId(@PathVariable("id") Integer id) {
//		return service.findById(id);	
//	}
	public ResponseEntity<Factura> buscarPorId(@PathVariable("id") Integer id) {	
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));	
	}
	
	
	@PostMapping("")
//	public Factura crearFactura(@RequestBody Factura f) {
//		service.save(f);
//		return f;
//	}
	public ResponseEntity<Factura> crearFactura(@RequestBody Factura f) {
		return ResponseEntity.status(HttpStatus.OK).body(service.save(f));
	}
	
	
	@PutMapping("/{id}")
//	public Factura actualizarFactura(@PathVariable("id") Integer id, @RequestBody Factura f) {
//		service.save(f);
//		return f;
//	}
	public ResponseEntity<Factura> actualizarFactura(@PathVariable("id") Integer id, @RequestBody Factura f) {
		return ResponseEntity.status(HttpStatus.OK).body(service.save(f));
	}
	
	
	@DeleteMapping("/{id}")
//	public Factura eliminar(@PathVariable("id") Integer id) {
//		Factura f = service.deleteById(id);
//		return f;
//	}
	public ResponseEntity<Factura> eliminar(@PathVariable("id") Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.deleteById(id));
	}
	
	
}
