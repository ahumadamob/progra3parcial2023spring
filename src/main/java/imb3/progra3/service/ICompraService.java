package imb3.progra3.service;

import java.util.List;

import imb3.progra3.entity.Compra;

public interface ICompraService {
	List<Compra> buscaTodos();
	Compra buscarPorId(Integer id);
	void guardar(Compra compra);
	void eliminar(Integer id);
	void crear (Compra compra);
}
