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
	public Optional<Estudiante> buscarPorId(Integer idEstudiante) {
		
		return repo.findById(idEstudiante);
		
	}
	
	@Override
	public Estudiante crearEstudiante(Estudiante request) {
		repo.save(request);
		return request;
	}

	@Override
	public Estudiante actualizarEstudiante(Estudiante request) {
		repo.save(request);
		return request;
	}
	
	//CREATE

	@Override
	public String eliminarPorId(Integer idEstudiante) {
		Optional<Estudiante> id = repo.findById(idEstudiante);
		if (id.isPresent()) {
		repo.deleteById(idEstudiante);
		} else {
			return null; //Agregar mensaje de error
		}
		return null;
		
		
	}

	@Override
	public Optional<Estudiante> eliminarPorTodos() {
		
		repo.deleteAll();
		return null;
	}

	
	

}
