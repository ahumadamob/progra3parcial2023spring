package imb3.progra3.service;

import java.util.List;
import java.util.Optional;

import imb3.progra3.entity.Estudiante;

public interface IEstudianteService {

	List<Estudiante> buscarTodos();

	Optional<Estudiante> buscarPorId(Integer idEstudiante);
	
	Estudiante crearEstudiante(Estudiante request);
	
	Estudiante actualizarEstudiante(Estudiante request);

	String eliminarPorId(Integer idEstudiante);

	Optional<Estudiante> eliminarPorTodos();

	





}
