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

import imb3.progra3.entity.Proveedor;
import imb3.progra3.service.IProveedorService;

@RestController
@RequestMapping("/api/v1")
public class ProveedorController {
	
	@Autowired
	IProveedorService service;
	
	@GetMapping("/proveedor")
	public ResponseEntity<APIResponse<List<Proveedor>>> buscarTodos(){
		APIResponse<List<Proveedor>> response = new APIResponse<List<Proveedor>> (200, null, service.buscarTodos());
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("/proveedor/{id}")
	public ResponseEntity<APIResponse<Proveedor>> buscarPorId(@PathVariable("id") Integer id) {
		Proveedor proveedor = service.buscarPorId(id);
		if(proveedor == null){
			List<String> messages = new ArrayList<>();
			messages.add("No se encontró el Proveedor con el número de id = " + id.toString());
			messages.add("Revise el parámetro");
			APIResponse<Proveedor> response = new APIResponse<Proveedor>(HttpStatus.BAD_REQUEST.value(), messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}else {
			APIResponse<Proveedor> response = new APIResponse<Proveedor>(HttpStatus.OK.value(),null,proveedor);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}
	
	@PostMapping("/proveedor")
	public ResponseEntity<APIResponse<Proveedor>> crearProveedor(@RequestBody Proveedor proveedor) {
		if(proveedor.getId() != null) {
			Proveedor buscaProveedor = service.buscarPorId(proveedor.getId());
			if (buscaProveedor != null) {
				List<String> messages = new ArrayList<>();
				messages.add("Ya existe un proveedor con el id = " + proveedor.getId().toString());
				messages.add("Para actualizar utilice el verbo PUT");
				APIResponse<Proveedor> response = new APIResponse<Proveedor>(HttpStatus.BAD_REQUEST.value(), messages, null);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
		}
		service.crear(proveedor);
		APIResponse<Proveedor> response = new APIResponse<Proveedor>(HttpStatus.CREATED.value(),null,proveedor);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}
	
	@PutMapping("/proveedor")
	public ResponseEntity<APIResponse<Proveedor>> actualizarProveedor(@RequestBody Proveedor proveedor) {
		boolean isError;
		String idStr;
		if(proveedor.getId() != null) {
			Proveedor buscaProveedor = service.buscarPorId(proveedor.getId());
			idStr = proveedor.getId().toString();
			if (buscaProveedor != null) {
				//Devolver un OK
				isError = false;
			}else {
				//Devolver un Error
				isError = true;
			}
			
		}else {
			idStr = "<No definido>";
			//Devolver un error
			isError = true;
		}
		
		if(isError) {
			//Devolvermos el error
			List<String> messages = new ArrayList<>();
			messages.add("No existe un proveedor para actualizar con el id = " + idStr);
			messages.add("Para crear un nuevo proveedor utilice el verbo POST");
			APIResponse<Proveedor> response = new APIResponse<Proveedor>(HttpStatus.BAD_REQUEST.value(), messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}else {
			//Devolvemos el OK
			service.crear(proveedor);
			APIResponse<Proveedor> response = new APIResponse<Proveedor>(HttpStatus.OK.value(),null,proveedor);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		
	}
	
	@DeleteMapping("/proveedor/{id}")
	public ResponseEntity<APIResponse<Proveedor>> eliminar(@PathVariable("id") Integer id) {
		Proveedor buscaProveedor = service.buscarPorId(id);
		if(buscaProveedor == null) {
			//Error
			List<String> messages = new ArrayList<>();
			messages.add("No existe un proveedor para eliminar con el id = " + id.toString());
			APIResponse<Proveedor> response = new APIResponse<Proveedor>(HttpStatus.BAD_REQUEST.value(),messages,null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}else {
			service.eliminar(id);
			List<String> messages = new ArrayList<>();
			messages.add("El proveedor que figura en el cuerpo ha sido eliminado");
			APIResponse<Proveedor> response = new APIResponse<Proveedor>(HttpStatus.OK.value(),messages,buscaProveedor);
			return ResponseEntity.status(HttpStatus.OK).body(response);
			//eliminar
		}
		
	}
	
}