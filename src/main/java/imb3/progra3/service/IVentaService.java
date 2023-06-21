package imb3.progra3.service;

import java.util.List;
import imb3.progra3.entity.Venta;

public interface IVentaService {
	
	List <Venta> buscarTodos();
	Venta buscarPorId(Integer id);
	void guardar(Venta venta);
	void eliminar (Integer id);
	

}
