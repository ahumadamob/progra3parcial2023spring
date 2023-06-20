package imb3.progra3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb3.progra3.entity.CarritoDeCompras;
import imb3.progra3.repository.CarritoRepository;

@Service
public class CarritoDeCompraServiceImpl implements carritoService {
	
	@Autowired
	private CarritoRepository carritoRepository;

	@Override
	public List<CarritoDeCompras> buscartodo() {

			List<CarritoDeCompras>carrito=carritoRepository.findAll();
			return carrito;
	}

	@Override
	public CarritoDeCompras buscarPorId(Long id) {

			Optional<CarritoDeCompras>carritoOpc=carritoRepository.findById(id);
			return carritoOpc.get();
	}

	@Override
	public CarritoDeCompras guardar(CarritoDeCompras carrito) {
			carrito=carritoRepository.save(carrito);
			return carrito;
	}

	@Override
	public CarritoDeCompras modificar(Long id, CarritoDeCompras carrito) {
		Optional<CarritoDeCompras>carritoOpc=carritoRepository.findById(id);
		CarritoDeCompras carritoMod=carritoOpc.get();
		carritoMod=carritoRepository.save(carrito);
		return carritoMod;
	}

	@Override
	public boolean borrar(Long id) {
			carritoRepository.deleteById(id);
		return true;
	}



}
