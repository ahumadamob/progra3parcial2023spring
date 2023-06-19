package imb3.progra3.service;

import java.util.List;

import imb3.progra3.entity.Calificacion;


public interface ICalificacionService {
	List<Calificacion> buscarTodos() throws Exception;
	Calificacion buscarPorId(Long id) throws Exception;
	Calificacion guardar(Calificacion calificacion) throws Exception;
	boolean eliminar(Long id) throws Exception;
	
}