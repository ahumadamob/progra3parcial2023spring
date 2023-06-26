package imb3.progra3.Service;

import java.util.List;


import imb3.progra3.entity.comentario;

public interface iComentarioService {
	
	List <comentario> buscarTodos();
	comentario buscarPorId(Integer id);
	void guardar(comentario comentario);
	void eliminar (Integer id);

}
