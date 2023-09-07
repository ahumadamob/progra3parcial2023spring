package imb3.progra3.service;

import java.util.List;

import imb3.progra3.entity.Compra;

public interface ICompraService {
	List<Compra> buscaTodos();
	Compra buscarPorId(Integer id);
	void guardarCompra(Compra compra);
	void eliminarCompra(Integer id);
	void crearCompra (Compra compra);
}
