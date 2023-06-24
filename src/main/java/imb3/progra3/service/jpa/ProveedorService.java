package imb3.progra3.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb3.progra3.entity.Proveedor;
import imb3.progra3.repository.ProveedorRepository;
import imb3.progra3.service.IProveedorService;

@Service
public class ProveedorService implements IProveedorService {

	@Autowired
	ProveedorRepository repository;
	
	@Override
	public List<Proveedor> buscarTodos() {
		return repository.findAll();
	}

	@Override
	public Proveedor buscarPorId(Integer id) {
		Optional<Proveedor> optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	@Override
	public void crear(Proveedor proveedor) {
		repository.save(proveedor);
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
	}

}