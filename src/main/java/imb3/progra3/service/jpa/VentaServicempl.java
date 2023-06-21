package imb3.progra3.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb3.progra3.entity.Venta;
import imb3.progra3.repository.VentaRepository;
import imb3.progra3.service.IVentaService;

@Service
public class VentaServicempl implements IVentaService {

	@Autowired
	VentaRepository repo; 

	@Override
	public List<Venta> buscarTodos() {

		return repo.findAll();
	}

	@Override
	public Venta buscarPorId(Integer id) {
		Optional<Venta> optional = repo.findById(id);

		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}

	}	
	@Override
	public void guardar(Venta venta) {

		repo.save(venta);
	}

	@Override
	public void eliminar(Integer id) {

		repo.deleteById(id);

	}

}

