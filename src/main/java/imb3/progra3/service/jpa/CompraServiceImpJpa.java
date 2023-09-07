package imb3.progra3.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import imb3.progra3.entity.Compra;
import imb3.progra3.repository.CompraRepository;
import imb3.progra3.service.ICompraService;

@Service
@Primary
public class CompraServiceImpJpa implements ICompraService {
	
	@Autowired
	CompraRepository repository;

	@Override
	public List<Compra> buscaTodos() {
		return repository.findAll();
	}

	@Override
	public Compra buscarPorId(Integer id) {
	    Optional<Compra> optional = repository.findById(id);
	    if (optional.isPresent()) {
	        return optional.get();
	    } else {
	        return null;
	    }
	}	

	@Override
	public void guardarCompra(Compra compra) {
		repository.save(compra);
	}

	@Override
	public void eliminarCompra(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public void crearCompra(Compra compra) {
		repository.save(compra);
		
	}
	

	

	

}
