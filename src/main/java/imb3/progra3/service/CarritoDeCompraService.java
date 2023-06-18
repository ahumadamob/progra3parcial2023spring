package imb3.progra3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb3.progra3.entity.CarritoDeCompras;
import imb3.progra3.repository.CarritoRepository;
import jakarta.transaction.Transactional;

@Service
public class CarritoDeCompraService  {
	
	@Autowired
	private CarritoRepository carritoRepository;
	

	@Transactional
	public List<CarritoDeCompras> findAll()  {
		List<CarritoDeCompras> entities= carritoRepository.findAll();
		return entities;
	}

	@Transactional
	public CarritoDeCompras findById(Long id)  {
		Optional<CarritoDeCompras> entityOptional= carritoRepository.findById(id);
		return entityOptional.get();
	}
	@Transactional
	public CarritoDeCompras save(CarritoDeCompras carrito)  {
		return carritoRepository.save(carrito);
	}
	@Transactional
	public CarritoDeCompras update(Long id, CarritoDeCompras entity)  {
		Optional<CarritoDeCompras> entityOptional= carritoRepository.findById(id);
		CarritoDeCompras carrito=entityOptional.get();
		carrito= carritoRepository.save(entity);
		return carrito;
	}
	@Transactional
	public boolean delete(long id) throws Exception {
		if(carritoRepository.existsById(id)) {
			carritoRepository.deleteById(id);
			return true;
		}else {
			throw new Exception();
		}
	}

}
