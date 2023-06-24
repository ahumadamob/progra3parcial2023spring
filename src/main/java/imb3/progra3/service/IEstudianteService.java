package imb3.progra3.service;

import java.util.List;
import org.springframework.stereotype.Service;
import imb3.progra3.entity.Estudiante;

@Service
public interface IEstudianteService {

	List<Estudiante> buscarTodos();

	Estudiante buscarPorId(Integer idEstudiante);
	
	Estudiante crearEstudiante(Estudiante request);
	
	Estudiante actualizarEstudiante(Estudiante request);

	Estudiante eliminarPorId(Integer idEstudiante);

	Estudiante eliminarTodos();

	





}
