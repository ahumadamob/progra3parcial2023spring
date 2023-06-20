package imb3.progra3.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imb3.progra3.entity.CarritoDeCompras;
import imb3.progra3.service.CarritoDeCompraServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="api/v1/carritos")
public class CarritoControllerImpl  {
	
	@Autowired
	private CarritoDeCompraServiceImpl carritoDeCompraService;

	@GetMapping("")
	public ResponseEntity<ApiResponce<List<CarritoDeCompras>>> buscartodo() {
		ApiResponce<List<CarritoDeCompras>> response= new ApiResponce<List<CarritoDeCompras>>(0, null, carritoDeCompraService.buscartodo());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponce<CarritoDeCompras>> buscarPorId(@PathVariable("id") Long id) {
		if(this.existe(id)) {
			CarritoDeCompras carrito = carritoDeCompraService.buscarPorId(id);
			ApiResponce<CarritoDeCompras> response = new ApiResponce<CarritoDeCompras>(HttpStatus.OK.value(), null, carrito);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}else {
			List<String> messages = new ArrayList<>();
			messages.add("No se encontró el producto con id = " + id.toString());
			ApiResponce<CarritoDeCompras> response = new ApiResponce<CarritoDeCompras>(HttpStatus.BAD_REQUEST.value(), messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}	
	}

	@PostMapping("")
	public ResponseEntity<ApiResponce<CarritoDeCompras>> save(@RequestBody CarritoDeCompras carrito) {
		if(this.existe(carrito.getId())) {
			List<String> messages = new ArrayList<>();
			messages.add("Ya existe una calificacion con el ID = " + carrito.getId().toString());
			messages.add("Para actualizar utilice el verbo PUT");
			ApiResponce<CarritoDeCompras> response = new ApiResponce<CarritoDeCompras>(HttpStatus.BAD_REQUEST.value(), messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}else {
			carritoDeCompraService.guardar(carrito);
			ApiResponce<CarritoDeCompras> response = new ApiResponce<CarritoDeCompras>(HttpStatus.CREATED.value(), null, carrito);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);			
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<ApiResponce<CarritoDeCompras>> update(@PathVariable("id") Long id,@RequestBody CarritoDeCompras carrito) {
		if(this.existe(id)) {
			carritoDeCompraService.modificar(id, carrito);
			ApiResponce<CarritoDeCompras>response = new ApiResponce<CarritoDeCompras>(HttpStatus.OK.value(),null,carrito);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}else {
			List<String> messages = new ArrayList<>();
			messages.add("No se encontró el producto = " + id.toString());
			ApiResponce<CarritoDeCompras> response = new ApiResponce<CarritoDeCompras>(HttpStatus.BAD_REQUEST.value(), messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}	
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponce<CarritoDeCompras>> delete(@PathVariable("id") Long id) {
		if(this.existe(id)) {
			carritoDeCompraService.borrar(id);
			List<String> messages = new ArrayList<>();
			messages.add("El producto fue borrado");
			ApiResponce<CarritoDeCompras>response = new ApiResponce<CarritoDeCompras>(HttpStatus.OK.value(),messages,null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}else {
			List<String> messages = new ArrayList<>();
			messages.add("No existe el producto = " + id.toString());
			ApiResponce<CarritoDeCompras> response = new ApiResponce<CarritoDeCompras>(HttpStatus.BAD_REQUEST.value(), messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}	
	}
	private boolean existe(Long id) {
		if(id == null) {
			return false;
		}else{
			CarritoDeCompras carrito = carritoDeCompraService.buscarPorId(id);
			if(carrito == null) {
				return false;				
			}else {
				return true;
			}
		}

	
}
}
