package imb3.progra3.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imb3.progra3.entity.CiaDeSeguros;
import imb3.progra3.services.ICiaDeSegurosService;

//indica clase controladora y ruta de aplicación
@RestController
@RequestMapping("/api/v1")
public class Controller {
	//inyección de dependencias, funcionamiento automático de los objetos
	@Autowired
	ICiaDeSegurosService service;
	
	//verbos específicos del mapping
	@GetMapping("/CiaDeSeguros")
	public ResponseEntity<APIResponse<List<CiaDeSeguros>>>buscarTodos(){
		APIResponse<List<CiaDeSeguros>> response = new APIResponse<List<CiaDeSeguros>>(200, null, service.buscarTodos());	
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/CiaDeSeguros/{id}") //consultar
	public ResponseEntity<APIResponse<CiaDeSeguros>>buscarporId(@PathVariable("id") Integer id){ //filtrado por segmento específico
		
		CiaDeSeguros compania = service.buscarPorId(id);
		
		if(compania == null) {
			List<String> messages = new ArrayList<>();
			messages.add("No encontrada Compañía con ID: "+ id.toString());
			APIResponse<CiaDeSeguros> response = new APIResponse<CiaDeSeguros>(HttpStatus.BAD_REQUEST.value(), messages, compania);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		else {
			APIResponse<CiaDeSeguros> response = new APIResponse<CiaDeSeguros>(HttpStatus.OK.value(), null, compania);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}
	
	@PostMapping("/CiaDeSeguros") //imprimir
	public CiaDeSeguros crearCiaDeSeguros(@RequestBody CiaDeSeguros compania) { //inyecta un objeto nuevo a la clase
		service.crear(compania);
		return compania;
	}
	
	@PutMapping("/CiaDeSeguros") //reemplazar
	public CiaDeSeguros modificarCiaDeSeguros(@RequestBody CiaDeSeguros compania) {
	    return service.modificar(compania);
	}

	
	@DeleteMapping("/CiaDeSeguros/{id}") //eliminar
	public void eliminar(@PathVariable("id") Integer id){
		service.eliminar(id);
	}
}
