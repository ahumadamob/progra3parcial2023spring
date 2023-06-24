package imb3.progra3.service;

import imb3.progra3.entity.Reserva;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IReservaService {
    List  <Reserva> buscarTodas();
    Reserva buscarPorId(Integer id);
    void guardar(Reserva reserva);
    void eliminar(Integer id);

}
