package imb3.progra3.service;

import java.util.List;

import imb3.progra3.entity.CarritoDeCompras;

public interface carritoService {
	List<CarritoDeCompras> buscartodo()throws Exception;;
	CarritoDeCompras buscarPorId(Long id)throws Exception;;
	CarritoDeCompras guardar(CarritoDeCompras carrito)throws Exception;;
	CarritoDeCompras modificar(Long id, CarritoDeCompras carrito)throws Exception;;
	boolean borrar(Long id) throws Exception;
}
