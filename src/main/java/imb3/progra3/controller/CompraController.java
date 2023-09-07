package imb3.progra3.controller;


import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imb3.progra3.entity.Compra;
import imb3.progra3.service.ICompraService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestController
@RequestMapping("/api/v1/compra")
public class CompraController {
	
	@Autowired 
	ICompraService compraService;
	
	//buscarTodos
	@GetMapping
	public ResponseEntity<APIResponse<List<Compra>>> buscarTodos(){
		
		APIResponse<List<Compra>> response = new APIResponse<List<Compra>> (200, null, compraService.buscaTodos()) ;
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//buscarPorId
	@GetMapping("/{id}")
	public ResponseEntity<APIResponse<Compra>> buscarPorId(@PathVariable("id") Integer id){
		Compra compra = compraService.buscarPorId(id);
		if(this.existe(id)) {
			APIResponse<Compra> response = new APIResponse <Compra>(HttpStatus.OK.value(),null,compra);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}else {
			List <String> messages = new ArrayList<>();
		    messages.add("No se encontró la Compra con id =" + id.toString());
		    messages.add("Revise nuevamente el parametro");
		    APIResponse<Compra> response = new APIResponse <Compra>(HttpStatus.BAD_REQUEST.value(),messages,compra);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
	
	//CrearCompra
	@PostMapping
	public ResponseEntity<APIResponse<Compra>> crearCompra(@RequestBody Compra compra) {
		if(this.existe(compra.getId())) {
			List <String> messages = new ArrayList<>();
			messages.add("Ya existe una categoria con id = " +  compra.getId().toString());
			messages.add("Para actualizar debe utilizar el verbo PUT");
			APIResponse<Compra> response = new APIResponse <Compra>(HttpStatus.BAD_REQUEST.value(),messages,compra);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}else {
			compraService.crearCompra(compra);
			APIResponse<Compra> response = new APIResponse <Compra>(HttpStatus.CREATED.value(),null,compra);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}		
	}
	
	//actualizarCompra
	@PutMapping
	public ResponseEntity<APIResponse<Compra>> actualizarCompra(@RequestBody Compra compra) {
		if(this.existe(compra.getId())){
			compraService.crearCompra(compra);
			APIResponse<Compra> response = new APIResponse <Compra>(HttpStatus.OK.value(),null,compra);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}else {
			List <String> messages = new ArrayList<>();
			 messages.add("No existe una categoria con id especificado");
			 messages.add("Para actualizar una nueva debe utiliza verbo POST");
			 APIResponse<Compra> response = new APIResponse <Compra>(HttpStatus.BAD_REQUEST.value(),messages,compra);
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);	
		}
	}
	
	//borrarCompra
	@DeleteMapping("/compra/{id}")
	public ResponseEntity<APIResponse<Compra>> eliminarCompra(@PathVariable("id") Integer id){
		if(this.existe(id)) {
			compraService.eliminarCompra(id);
			List <String> messages = new ArrayList<>();
			messages.add("La compra seleccionada ha sido eliminada");
			APIResponse<Compra> response = new APIResponse <Compra>(HttpStatus.OK.value(),messages,null);
			return ResponseEntity.status(HttpStatus.OK).body(response);	
			
		}else {
			List <String> messages = new ArrayList<>();
		    messages.add("No se encontró la Compra con id =" + id.toString());
		    APIResponse<Compra> response = new APIResponse <Compra>(HttpStatus.BAD_REQUEST.value(),null,null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
	}
	
	
	private boolean existe(Integer id) {
		if (id == null) {
			return false;
		}else {
		    Compra compra = compraService.buscarPorId(id);
		    if(compra == null) {
		    	return false;
		    }else {
		    	return true;
		    }
		}	
	}
	
    @ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<APIResponse<?>>handleConstrainViolationException(ConstraintViolationException ex){
    	List <String> errors = new ArrayList<>();
    	for (ConstraintViolation<?> violation : ex.getConstraintViolations()){
    		errors.add(violation.getMessage());
    	}
    	APIResponse<Compra> response = new APIResponse <Compra>(HttpStatus.BAD_REQUEST.value(),errors,null);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		
    
    }
}
