package imb3.progra3.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import imb3.progra3.entity.Estudiante;

@Service
public interface IEstudianteService {

	List<Estudiante> buscarTodos();

	Optional<Estudiante> buscarPorId(Integer idEstudiante);
	
	Estudiante crearEstudiante(Estudiante request);
	
	Estudiante actualizarEstudiante(Estudiante request);

	Optional<Estudiante> eliminarPorId(Integer idEstudiante);

	Optional<Estudiante> eliminarTodos();

	





}
