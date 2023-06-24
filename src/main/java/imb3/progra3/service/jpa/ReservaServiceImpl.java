package imb3.progra3.service.jpa;

import imb3.progra3.entity.Reserva;
import imb3.progra3.repository.ReservaRepository;
import imb3.progra3.service.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReservaServiceImpl implements IReservaService {
    @Autowired
    ReservaRepository repository;

    @Override
    public List<Reserva> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public Reserva buscarPorId(Integer id) {
        Optional<Reserva> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    @Override
    public void guardar(Reserva reserva) {
        repository.save(reserva);

    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);

    }
}
