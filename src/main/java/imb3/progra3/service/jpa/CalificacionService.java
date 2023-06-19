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
	public ArrayList<Calificacion> buscarTodos() throws Exception {
		try {
			List<Calificacion> entities = calificacionRepo.findAll();
			return (ArrayList<Calificacion>) entities;
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	public Calificacion buscarPorId(Long id) throws Exception {
		try {
			Optional<Calificacion> entityOptional = calificacionRepo.findById(id);
			return entityOptional.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	public Calificacion guardar(Calificacion entity) throws Exception {
		try {
			entity = calificacionRepo.save(entity);
			return entity;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	public boolean eliminar(Long id) throws Exception {
		try {
			if(calificacionRepo.existsById(id)) {
				calificacionRepo.deleteById(id);
				return true;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	
}