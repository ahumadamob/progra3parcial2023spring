package imb3.progra3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb3.progra3.entity.CarritoDeCompras;
import imb3.progra3.repository.CarritoRepository;
import jakarta.transaction.Transactional;

@Service
public class CarritoDeCompraServiceImpl implements carritoService {
	
	@Autowired
	private CarritoRepository carritoRepository;

	@Override
	@Transactional
	public List<CarritoDeCompras> buscartodo() throws Exception {
		try {
			List<CarritoDeCompras>carrito=carritoRepository.findAll();
			return carrito;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public CarritoDeCompras buscarPorId(Long id) throws Exception {
		try {
			Optional<CarritoDeCompras>carritoOpc=carritoRepository.findById(id);
			return carritoOpc.get();
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public CarritoDeCompras guardar(CarritoDeCompras carrito) throws Exception {
		try {
			carrito=carritoRepository.save(carrito);
			return carrito;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public CarritoDeCompras modificar(Long id, CarritoDeCompras carrito) throws Exception {
		Optional<CarritoDeCompras>carritoOpc=carritoRepository.findById(id);
		CarritoDeCompras carritoMod=carritoOpc.get();
		carritoMod=carritoRepository.save(carrito);
		return carritoMod;
	}

	@Override
	@Transactional
	public boolean borrar(Long id) throws Exception {
		try {
			if(carritoRepository.existsById(id)) {
				carritoRepository.deleteById(id);
				return true;
			}else {
                throw new Exception();
			}
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}



}
