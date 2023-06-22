package imb3.progra3.controller;


import java.util.List;
import java.util.ArrayList;

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

import imb3.progra3.entity.Compra;
import imb3.progra3.service.ICompraService;

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
		if (compra ==null) {
		    List <String> messages = new ArrayList<>();
		    messages.add("No se encontró la Compra con id =" + id.toString());
		    APIResponse<Compra> response = new APIResponse <Compra>(400,messages,compra);
			return ResponseEntity.status(HttpStatus.OK).body(response);
			
		}else {
			APIResponse<Compra> response = new APIResponse <Compra>(200,null,compra);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}
	
	//CrearCompra
	@PostMapping
	public Compra crearCompra(@RequestBody Compra compra) {
		compraService.guardar(compra);
		return compra;
	}
	
	//actualizarCompra
	@PutMapping
	public Compra actualizarCompra(@RequestBody Compra compra) {
		compraService.guardar(compra);
		return compra;
	}
	
	//borrarCompra
	@DeleteMapping("/compra/{id}")
	public void eliminarCompra(@PathVariable("id") Integer id){
		compraService.eliminar(id);	
	}
	
	
	

}
