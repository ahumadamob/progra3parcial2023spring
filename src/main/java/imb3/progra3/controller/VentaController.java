package imb3.progra3.controller;

import java.util.*;
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
import imb3.progra3.entity.Venta;
import imb3.progra3.service.IVentaService;

@RestController
@RequestMapping("/api/v1")
public class VentaController {
	
	@Autowired
	IVentaService service;


	@GetMapping("/ventas")
	public ResponseEntity<APIResponse<List<Venta>>>buscarTodos() {

		List<Venta> venta = service.buscarTodos();
		if(venta.isEmpty()) {
			APIResponse<List<Venta>> response = new APIResponse<List<Venta>> (200, null, service.buscarTodos());
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		else {
			APIResponse<List<Venta>> response = new APIResponse<List<Venta>> (200, null, venta);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}

	@PostMapping("/ventas")
	public ResponseEntity<APIResponse<Venta>> crearVenta(@RequestBody Venta venta) {

		if(venta.getId() != null) {
			Venta buscaVenta = service.buscarPorId(venta.getId());

			if(buscaVenta!=null) {
				List <String> messages = new ArrayList<>();
				messages.add("Ya existe una venta con el id: " + venta.getId().toString());
				messages.add("Para actualizar utilice el verbo PUT");
				APIResponse<Venta> response = new APIResponse<Venta>(HttpStatus.BAD_REQUEST.value(), messages, null);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
		}

		service.guardar(venta);
		APIResponse<Venta> response = new APIResponse<Venta>(HttpStatus.CREATED.value(), null, venta);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);

	}

	@PutMapping("/ventas")
	public ResponseEntity<APIResponse<Venta>> actualizarVenta(@RequestBody Venta venta) {

		boolean isError;
		String idStr;

		if(venta.getId() != null) {
			Venta buscaVenta = service.buscarPorId(venta.getId());
			idStr = venta.getId().toString();

			if(buscaVenta!=null) {
				isError = false;
			}
			else {
				isError = true;
			}
		}
		else{
			isError = true;
			idStr = "No definido";
		}

		if(isError) {

			List <String> messages = new ArrayList<>();
			messages.add("No existe una venta con el id: " + idStr);
			messages.add("Para crear una nueva venta, utilice el verbo POST");
			APIResponse<Venta> response = new APIResponse<Venta>(HttpStatus.BAD_REQUEST.value(), messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

		}

		else {
			service.guardar(venta);
			APIResponse<Venta> response = new APIResponse<Venta>(HttpStatus.OK.value(), null, venta);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}


	@GetMapping("/ventas/{id}")
	public ResponseEntity<APIResponse<Venta>> buscarPorId(@PathVariable("id") Integer id){
		Venta venta = service.buscarPorId(id);
		if(venta == null) {
			List <String> messages = new ArrayList<>();
			messages.add("No se encontró la venta con el id: " + id.toString());
			messages.add("Revise nuevamente el parámetro.");
			APIResponse<Venta> response = new APIResponse<Venta>(HttpStatus.BAD_REQUEST.value(), messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		else {
			APIResponse<Venta> response = new APIResponse<Venta>(HttpStatus.OK.value(), null, venta);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}

	@DeleteMapping("/ventas/{id}")
	public ResponseEntity<APIResponse<Venta>> eliminar(@PathVariable("id") Integer id){
		Venta buscaVenta = service.buscarPorId(id);

		if(buscaVenta == null) {
			List <String> messages = new ArrayList<>();
			messages.add("No existe una venta con el id: " + id.toString());
			APIResponse<Venta> response = new APIResponse<Venta>(HttpStatus.OK.value(), null, buscaVenta);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

		}

		else {
			service.eliminar(id);
			List <String> messages = new ArrayList<>();
			messages.add("La venta con id " + id.toString() + " ha sido eliminada con éxito");
			APIResponse<Venta> response = new APIResponse<Venta>(HttpStatus.OK.value(), messages, buscaVenta);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

}


