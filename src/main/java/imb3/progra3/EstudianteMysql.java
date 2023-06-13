package imb3.progra3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import imb3.progra3.entity.Estudiante;
import imb3.progra3.repository.EstudianteRepository;
import imb3.progra3.service.IEstudianteService;

@Service
@Primary
public class EstudianteMysql implements IEstudianteService{

	@Autowired
	EstudianteRepository repo;
	
	@Override
	public List<Estudiante> buscarTodos() {
		
		return repo.findAll();
	}
	

}
