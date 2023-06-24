package imb3.progra3.service.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb3.progra3.entity.Calificacion;
import imb3.progra3.repository.CalificacionRepository;
import imb3.progra3.service.ICalificacionService;


@Service
public class CalificacionService implements ICalificacionService {
	@Autowired
	CalificacionRepository calificacionRepo;
	
	@Override
	public ArrayList<Calificacion> buscarTodos() {
		List<Calificacion> entities = calificacionRepo.findAll();
		return (ArrayList<Calificacion>) entities;
	}
	
	@Override
	public Calificacion buscarPorId(Long id) {
		Optional<Calificacion> entityOptional = calificacionRepo.findById(id);
		if(entityOptional.isPresent()) {
			return entityOptional.get();
		}else {
			return null;
		}	
	}
	
	@Override
	public void guardar(Calificacion entity) {
		entity = calificacionRepo.save(entity);
		
	}
	
	@Override
	public void eliminar(Long id) {
		calificacionRepo.deleteById(id);

	}

	
}