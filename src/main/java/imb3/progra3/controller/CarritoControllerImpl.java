package imb3.progra3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imb3.progra3.entity.CarritoDeCompras;
import imb3.progra3.service.CarritoDeCompraServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="api/v1/carritos")
public class CarritoControllerImpl implements CarritoController {
	
	@Autowired
	private CarritoDeCompraServiceImpl carritoDeCompraService;

	@Override
	@GetMapping("")
	public ResponseEntity<?> getAll() {
		try {
            return ResponseEntity.status(HttpStatus.OK).body(carritoDeCompraService.buscartodo());
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
        }
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(Long id) {
		try {
            return ResponseEntity.status(HttpStatus.OK).body(carritoDeCompraService.buscarPorId(id));
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
        }
	}

	@Override
	@PostMapping("")
	public ResponseEntity<?> save(CarritoDeCompras carrito) {
		try {
            return ResponseEntity.status(HttpStatus.OK).body(carritoDeCompraService.guardar(carrito));
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
        }
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<?> update(Long id, CarritoDeCompras carrito) {
		try {
            return ResponseEntity.status(HttpStatus.OK).body(carritoDeCompraService.modificar(id,carrito));
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
        }
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(Long id) {
		try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(carritoDeCompraService.borrar(id));
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
        }
	}

	
}
