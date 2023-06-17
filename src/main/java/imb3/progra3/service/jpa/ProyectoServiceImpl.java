package imb3.progra3.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb3.progra3.entity.Proyecto;
import imb3.progra3.repository.ProyectoRepository;
import imb3.progra3.service.iProyectoService;

@Service
public class ProyectoServiceImpl implements iProyectoService {

	@Autowired
	ProyectoRepository repo; 
	
	@Override
	public List<Proyecto> buscarTodos() {
		
		return repo.findAll();
	}

	@Override
	public Proyecto buscarPorId(Integer id) {
		Optional<Proyecto> optional = repo.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
		
	}	
	@Override
	public void guardar(Proyecto proyecto) {
		
		repo.save(proyecto);
	}

	@Override
	public void eliminar(Integer id) {
		
		repo.deleteById(id);

	}

}
