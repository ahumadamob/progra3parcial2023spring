package imb3.progra3.service;

import java.util.List;

import imb3.progra3.entity.Producto;

public interface IProductoService {
	List<Producto> buscarTodos();
	Producto buscarPorId(Integer id);
	void guardar(Producto producto);
	void eliminar(Integer id);
}
