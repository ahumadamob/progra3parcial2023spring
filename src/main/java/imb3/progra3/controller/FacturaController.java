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
//  2da version
//	public ResponseEntity<List<Factura>> buscarTodos() {
//		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
//	}
//  3er version
	public ResponseEntity<APIResponse<List<Factura>>> buscarTodos() {
		APIResponse<List<Factura>> response = new APIResponse<List<Factura>>(200, null, service.findAll());
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	
	@GetMapping("/{id}")
//	public Factura buscarPorId(@PathVariable("id") Integer id) {
//		return service.findById(id);	
//	}
//  2da version
//	public ResponseEntity<Factura> buscarPorId(@PathVariable("id") Integer id) {	
//		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));	
//	}
//  3er version
	public ResponseEntity<APIResponse<Factura>> buscarPorId(@PathVariable("id") Integer id) {
		Factura data = service.findById(id);
		List<String> messages = new ArrayList<String>();
		if (data == null) {
			messages.add("NO HAY FACTURAS con ese numero");
			APIResponse<Factura> response = new APIResponse<Factura>(400, messages, data);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);	
		} else {
			messages = null;
			APIResponse<Factura> response = new APIResponse<Factura>(200, messages, data);
			return ResponseEntity.status(HttpStatus.OK).body(response);	
		}
	}
	
	
	
	@PostMapping("")
//	public Factura crearFactura(@RequestBody Factura f) {
//		service.save(f);
//		return f;
//	}
//  2da version
//	public ResponseEntity<Factura> crearFactura(@RequestBody Factura f) {
//		return ResponseEntity.status(HttpStatus.OK).body(service.save(f));
//	}
//  3er version
	public ResponseEntity<APIResponse<Factura>> crearFactura(@RequestBody Factura f) {	
		if (f.getNroFactura() != null) {
			List<String> messages = new ArrayList<String>();
			messages.add("para CREAR una FACTURA no debe ingresar nroFactura");
			messages.add("para ACTUALIZAR una FACTURA debe usar una solicitud PUT");
			APIResponse<Factura> response = new APIResponse<Factura>(400, messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);			
		} else {
			Factura data = service.save(f);
			APIResponse<Factura> response = new APIResponse<Factura>(201, null, data);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
	}
	
	
	
	@PutMapping("/{id}")
//	public Factura actualizarFactura(@PathVariable("id") Integer id, @RequestBody Factura f) {
//		service.save(f);
//		return f;
//	}
//  2da version
//	public ResponseEntity<Factura> actualizarFactura(@PathVariable("id") Integer id, @RequestBody Factura f) {
//		return ResponseEntity.status(HttpStatus.OK).body(service.save(f));
//	}
// 3er version
	public ResponseEntity<APIResponse<Factura>> actualizarFactura(@PathVariable("id") Integer id, @RequestBody Factura f) {
		List<String> messages = new ArrayList<String>();
		if (f.getNroFactura() != null) {
			Factura fbuscada = service.findById(f.getNroFactura());
			if (fbuscada == null) {
				messages.add("NO HAY FACTURAS con ese numero");
				APIResponse<Factura> response = new APIResponse<Factura>(400, messages, null);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);	
			} else {
				Factura data = service.save(f);
				APIResponse<Factura> response = new APIResponse<Factura>(202, null, data);
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
			}
		} else {			
			messages.add("debe INGRESAR un nroFactura");
			APIResponse<Factura> response = new APIResponse<Factura>(400, messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
			
	}
	
	
	
	@DeleteMapping("/{id}")
//	public Factura eliminar(@PathVariable("id") Integer id) {
//		Factura f = service.deleteById(id);
//		return f;
//	}
//  2da version
//	public ResponseEntity<Factura> eliminar(@PathVariable("id") Integer id) {
//		return ResponseEntity.status(HttpStatus.OK).body(service.deleteById(id));
//	}
//	public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
//		return ResponseEntity.status(HttpStatus.OK).body(service.deleteById(id));
//	}
//  3er version
	public ResponseEntity<APIResponse<Factura>> eliminar(@PathVariable("id") Integer id) {
		Factura data = service.findById(id);
		List<String> messages = new ArrayList<String>();
		if (data == null) {
			messages.add("NO HAY FACTURAS con ese numero");
			APIResponse<Factura> response = new APIResponse<Factura>(400, messages, data);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);	
		} else {
			messages.add(service.deleteById(id));
			APIResponse<Factura> response = new APIResponse<Factura>(200, messages, data);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}
	
	
	
	
	
	
}
