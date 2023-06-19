package imb3.progra3.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb3.progra3.entity.Factura;
import imb3.progra3.repository.FacturaRepository;
import imb3.progra3.service.iFacturaService;

@Service
public class FacturaServiceImpl implements iFacturaService {

	@Autowired
	FacturaRepository repo;
	
	@Override
	public List<Factura> buscarTodos() {
		return repo.findAll();
	}

	@Override
	public Factura buscarPorId(int nroFactura) {
		Optional<Factura> optional = repo.findById(nroFactura);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	@Override
	public void guardar(Factura f) {
		repo.save(f);
		
	}

	@Override
	public void eliminar(int nro) {
		repo.deleteById(nro);
		
	}

}
