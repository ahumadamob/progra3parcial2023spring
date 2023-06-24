package imb3.progra3.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb3.progra3.entity.Evento;
import imb3.progra3.repository.EventoRepository;
import imb3.progra3.service.IEventoService;


@Service
public class EventoService implements IEventoService {
	
	
	@Autowired
	EventoRepository repository;
	
	
	@Override
	public List<Evento> buscarTodos() {
		return repository.findAll();
	}

	@Override
	public Evento buscarPorId(Integer id) {
		Optional<Evento> optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	@Override
	public void crear(Evento evento) {
		repository.save(evento);

	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);

	}

}
