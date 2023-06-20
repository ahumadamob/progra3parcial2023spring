package imb3.progra3.service;

import java.util.List;

import imb3.progra3.entity.Evento;

public interface IEventoService {
	
	List<Evento> buscarTodos();
	Evento buscarPorId(Integer id);
	void crear(Evento evento);
	void eliminar(Integer id);
	

}
