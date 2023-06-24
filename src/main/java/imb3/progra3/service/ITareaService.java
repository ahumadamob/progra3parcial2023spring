package imb3.progra3.service;

import java.util.List;

import imb3.progra3.entity.Tarea;


public interface ITareaService {

public List<Tarea> buscarTodos() throws Exception;
	
	public Tarea buscarPorId (Long id)throws Exception;
	
	public Tarea guardar (Tarea tarea)throws Exception;
	
	public Tarea modificar (Long id, Tarea tarea) throws Exception;
	
	public boolean borrar (Long id) throws Exception;
}
