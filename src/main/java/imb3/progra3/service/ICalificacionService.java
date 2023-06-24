package imb3.progra3.service;

import java.util.List;

import imb3.progra3.entity.Calificacion;


public interface ICalificacionService {
	List<Calificacion> buscarTodos();
	Calificacion buscarPorId(Long id);
	void guardar(Calificacion calificacion);
	void eliminar(Long id);
	
}