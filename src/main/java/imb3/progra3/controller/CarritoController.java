package imb3.progra3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import imb3.progra3.service.CarritoDeCompraService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="api/v1/carritos")
public class CarritoController {
	
	@Autowired
	protected CarritoDeCompraService carritoDeCompraService;

	@GetMapping("")
	public List<CarritoDeCompras> obtenercarrito (){
		return carritoDeCompraService.findAll();
	}
	@GetMapping("/{id}")
	public CarritoDeCompras obtenerporid(@PathVariable Long id) {
		return carritoDeCompraService.findById(id);
	}
	@PostMapping("")
	public CarritoDeCompras guardar(@RequestBody CarritoDeCompras carrito) {
		return carritoDeCompraService.save(carrito);
	}
	@PutMapping("/{id}")
	public CarritoDeCompras modificar(@PathVariable Long id,@RequestBody CarritoDeCompras carrito) {
		return carritoDeCompraService.update(id, carrito);
	}
	@DeleteMapping("/{id}")
	public boolean borrar(@PathVariable Long id) throws Exception {
		return carritoDeCompraService.delete(id);
	}
}
