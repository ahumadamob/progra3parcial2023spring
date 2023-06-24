package imb3.progra3.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb3.progra3.entity.Noticia;
import imb3.progra3.repository.NoticiaRepository;
import imb3.progra3.service.INoticiaService;

@Service
public class NoticiaServiceImpl implements INoticiaService {
	
	@Autowired
	NoticiaRepository repository;

	@Override
	public List<Noticia> buscarTodos() {
		return repository.findAll();
	}

	@Override
	public Noticia buscarPorId(Integer id) {
		Optional <Noticia>optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}

	@Override
	public void guardar(Noticia noticia) {
		repository.save(noticia);
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
	}

}
