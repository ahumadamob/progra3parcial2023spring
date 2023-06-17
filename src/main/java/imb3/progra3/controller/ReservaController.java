package imb3.progra3.controller;

import imb3.progra3.entity.Reserva;
import imb3.progra3.service.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ReservaController {

    @Autowired
    IReservaService service;

    @GetMapping ("/reserva")
    public List<Reserva> buscarTodos(){
        return service.buscarTodas();
    }

    @GetMapping("/reserva/{id}")
    public Reserva buscarPorId(@PathVariable("id") Integer id){
        return service.buscarPorId(id);
    }

    @PostMapping("/reserva")
    public Reserva crearReserva(@RequestBody Reserva reserva) {
        service.guardar(reserva);
        return reserva;
    }

    @PutMapping("/reserva")
    public Reserva actualizarReserva(@RequestBody Reserva reserva) {
        service.guardar(reserva);
        return reserva;
    }

    @DeleteMapping("/reserva/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        service.eliminar(id);
    }

}
