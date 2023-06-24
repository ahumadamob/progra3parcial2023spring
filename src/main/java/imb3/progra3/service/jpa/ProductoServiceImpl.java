package imb3.progra3.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb3.progra3.entity.Producto;
import imb3.progra3.repository.ProductoRepository;
import imb3.progra3.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {	
	
	@Autowired
	ProductoRepository repository;

	@Override
	public List<Producto> buscarTodos() {		
		return repository.findAll();

	}

	@Override
	public Producto buscarPorId(Integer id) {
		Optional<Producto> optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}

	@Override
	public void guardar(Producto producto) {
		repository.save(producto);
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
	}

}
