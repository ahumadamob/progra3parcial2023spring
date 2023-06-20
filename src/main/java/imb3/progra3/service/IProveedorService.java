package imb3.progra3.service;

import java.util.List;

import imb3.progra3.entity.Proveedor;

public interface IProveedorService {
	
	List<Proveedor> buscarTodos();
	Proveedor buscarPorId(Integer id);
	void crear(Proveedor proveedor);
	void eliminar(Integer id);

}