package imb3.progra3.controller;

import imb3.progra3.entity.Reserva;
import imb3.progra3.service.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ReservaController {

    @Autowired
    IReservaService service;

    @GetMapping ("/reserva")
    public ResponseEntity<ApiResponse<List<Reserva>>> buscarTodos(){
        List<Reserva> reserva = service.buscarTodas();
        if(reserva.isEmpty()) {
            ApiResponse<List<Reserva>> response = new ApiResponse<List<Reserva>> (200, null, service.buscarTodas());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        else {
            ApiResponse<List<Reserva>> response = new ApiResponse<List<Reserva>> (200, null, reserva);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @GetMapping("/reserva/{id}")
    public  ResponseEntity<ApiResponse<Reserva>> buscarPorId(@PathVariable("id") Integer id){
        Reserva reserva = service.buscarPorId(id);
        if(reserva == null) {
            List <String> messages = new ArrayList<>();
            messages.add("No se encontró el reserva con el id: " + id.toString());
            messages.add("Revise nuevamente el parámetro.");
            ApiResponse<Reserva> response = new ApiResponse<Reserva>(HttpStatus.BAD_REQUEST.value(), messages, null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        else {
            ApiResponse<Reserva> response = new ApiResponse<Reserva>(HttpStatus.OK.value(), null, reserva);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @PostMapping("/reserva")

    public ResponseEntity<ApiResponse<Reserva>> crearReserva(@RequestBody Reserva reserva) {

        if(reserva.getId() != null) {
            Reserva buscaReserva = service.buscarPorId(reserva.getId());

            if(buscaReserva!=null) {
                List <String> messages = new ArrayList<>();
                messages.add("Ya existe un reserva con el id: " + reserva.getId().toString());
                messages.add("Para actualizar utilice el verbo PUT");
                ApiResponse<Reserva> response = new ApiResponse<Reserva>(HttpStatus.BAD_REQUEST.value(), messages, null);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        }

        service.guardar(reserva);
        ApiResponse<Reserva> response = new ApiResponse<Reserva>(HttpStatus.CREATED.value(), null, reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @PutMapping("/reserva")
    public ResponseEntity<ApiResponse<Reserva>> actualizarReserva(@RequestBody Reserva reserva) {

        boolean isError;
        String idStr;

        if(reserva.getId() != null) {
            Reserva buscaReserva = service.buscarPorId(reserva.getId());
            idStr = reserva.getId().toString();

            if(buscaReserva!=null) {
                isError = false;
            }
            else {
                isError = true;
            }
        }
        else{
            isError = true;
            idStr = "No definido";
        }

        if(isError) {

            List <String> messages = new ArrayList<>();
            messages.add("No existe un reserva con el id: " + idStr);
            messages.add("Para crear una nueva categoria, utilice el verbo POST");
            ApiResponse<Reserva> response = new ApiResponse<Reserva>(HttpStatus.BAD_REQUEST.value(), messages, null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

        }

        else {
            service.guardar(reserva);
            ApiResponse<Reserva> response = new ApiResponse<Reserva>(HttpStatus.OK.value(), null, reserva);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @DeleteMapping("/reserva/{id}")
    public ResponseEntity<ApiResponse<Reserva>> eliminar(@PathVariable("id") Integer id) {
        Reserva buscaReserva = service.buscarPorId(id);

        if (buscaReserva == null) {
            List<String> messages = new ArrayList<>();
            messages.add("No existe un reserva con el id: " + id.toString());
            ApiResponse<Reserva> response = new ApiResponse<Reserva>(HttpStatus.OK.value(), null, buscaReserva);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

        } else {
            service.eliminar(id);
            List<String> messages = new ArrayList<>();
            messages.add("El reserva con id " + id.toString() + " ha sido eliminado con éxito");
            ApiResponse<Reserva> response = new ApiResponse<Reserva>(HttpStatus.OK.value(), messages, buscaReserva);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
