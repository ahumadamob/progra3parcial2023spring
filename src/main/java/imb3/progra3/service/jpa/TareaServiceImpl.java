package imb3.progra3.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb3.progra3.entity.Tarea;
import imb3.progra3.repository.TareaRepository;
import imb3.progra3.service.ITareaService;


@Service
public class TareaServiceImpl implements ITareaService {
	@Autowired
	TareaRepository tareaRepository;

	@Override
	public List<Tarea> buscarTodos() throws Exception {
		try {
			List<Tarea> tareas = tareaRepository.findAll();
			return tareas;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Tarea buscarPorId(Long id) throws Exception {
		
		try {
			Optional<Tarea> tareaOptional = tareaRepository.findById(id);
			return tareaOptional.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Tarea guardar(Tarea tarea) throws Exception {
		tareaRepository.save(tarea);
		try {
			tarea = tareaRepository.save(tarea);
			return tarea;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Tarea modificar(Long id, Tarea tarea) throws Exception {
		try {
			Optional<Tarea> tareaOptional = tareaRepository.findById(id);
			Tarea tareaMod = tareaOptional.get();
			tareaMod = tareaRepository.save(tarea);
			return tareaMod;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public boolean borrar(Long id) throws Exception {
		try {
			if(tareaRepository.existsById(id)) {
				tareaRepository.deleteById(id);
				return true;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
	}
	}

}
