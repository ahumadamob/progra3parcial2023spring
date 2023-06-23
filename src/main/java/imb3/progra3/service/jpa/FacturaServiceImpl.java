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
	public List<Factura> findAll() {
		return repo.findAll();
	}

	@Override
	public Factura findById(int nroFactura) {
		Optional<Factura> optional = repo.findById(nroFactura);
		if (optional.isPresent()) {
			return optional.get();
		} else {
//			Factura f = new Factura();
//			f.setNroFactura(nroFactura);
//			f.setClienteAsociado("NO EXISTE esa factura");
//			return f;
            return null;			
		}
	}

	@Override
	public Factura save(Factura f) {
		repo.save(f);
		return f;
		
	}

	@Override
//	public void deleteById(int nroFactura) {
//		repo.deleteById(nroFactura);
//	public Factura deleteById(int nroFactura) {
//		Optional<Factura> optional = repo.findById(nroFactura);
//		if (optional.isPresent()) {
//			repo.deleteById(nroFactura);
//			Factura f = new Factura();
//			f.setNroFactura(nroFactura);
//			f.setClienteAsociado("factura ELIMINADA");
//			return f;		
//		} else {
//			Factura f = new Factura();
//			f.setNroFactura(nroFactura);
//			f.setClienteAsociado("NO EXISTE esa factura");
//            return f;			
//		}
	
	public String deleteById(int nroFactura) {
		Optional<Factura> optional = repo.findById(nroFactura);
		if (optional.isPresent()) {
			repo.deleteById(nroFactura);
			return "factura ELIMINADA";
		} else {
			return "NO EXISTE esa factura";
		}
		
	}

}
