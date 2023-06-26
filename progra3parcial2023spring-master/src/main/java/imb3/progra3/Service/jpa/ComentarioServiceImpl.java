package imb3.progra3.Service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb3.progra3.Repository.ComentarioRepository;
import imb3.progra3.Service.iComentarioService;
import imb3.progra3.entity.comentario;

@Service
public class ComentarioServiceImpl implements iComentarioService {

	@Autowired
	ComentarioRepository repo; 

	@Override
	public List<comentario> buscarTodos() {

		return repo.findAll();
	}

	@Override
	public comentario buscarPorId(Integer id) {
		Optional<comentario> optional = repo.findById(id);

		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}

	}	
	
	@Override
	public void guardar(comentario comentario) {

		repo.save(comentario);
	}

	@Override
	public void eliminar(Integer id) {

		repo.deleteById(id);

	}
}
