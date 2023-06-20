package imb3.progra3.service;

import java.util.List;

import imb3.progra3.entity.CarritoDeCompras;

public interface carritoService {
	List<CarritoDeCompras> buscartodo();
	CarritoDeCompras buscarPorId(Long id);
	CarritoDeCompras guardar(CarritoDeCompras carrito);
	CarritoDeCompras modificar(Long id, CarritoDeCompras carrito);
	boolean borrar(Long id);
}
