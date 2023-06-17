package imb3.progra3.service;

import java.util.List;

import imb3.progra3.entity.Proyecto;

public interface iProyectoService {
	
	List <Proyecto> buscarTodos();
	Proyecto buscarPorId(Integer id);
	void guardar(Proyecto proyecto);
	void eliminar (Integer id);
}
