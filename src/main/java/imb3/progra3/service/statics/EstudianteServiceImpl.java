package imb3.progra3.service.statics;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import imb3.progra3.entity.Estudiante;
import imb3.progra3.repository.EstudianteRepository;
import imb3.progra3.service.IEstudianteService;

@Service
@Primary
public class EstudianteServiceImpl implements IEstudianteService{

	@Autowired
	EstudianteRepository repo;
	
	
	// GET ALL
	@Override
	public List<Estudiante> buscarTodos() {
		
		return repo.findAll();
	}
	
	//GET BY ID
	@Override
	public Estudiante buscarPorId(Integer idEstudiante) {
		Optional<Estudiante> optional = repo.findById(idEstudiante);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
		
	}
	
	//CREATE
	@Override
	public Estudiante crearEstudiante(Estudiante request) {
		repo.save(request);
		return request;
	}

	
	//PUT
	@Override
	public Estudiante actualizarEstudiante(Estudiante request) {
		repo.save(request);
		return request;
	}
	
	
	//DELETE
	@Override
	public Estudiante eliminarPorId(Integer idEstudiante) {
		repo.deleteById(idEstudiante);
		return null;
		
		
	}

	@Override
	public Estudiante eliminarTodos() {
		
		repo.deleteAll();
		return null;
	}

	
	

}
