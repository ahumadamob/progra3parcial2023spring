package imb3.progra3.service;

import java.util.List;

import imb3.progra3.entity.Noticia;

public interface INoticiaService {
	List<Noticia> buscarTodos();
	Noticia buscarPorId(Integer id);
	void guardar(Noticia noticia);
	void eliminar(Integer id);
}
