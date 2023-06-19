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
		CiaDeSeguros companiaPorId = service.buscarPorId(id);
		if(this.existe(id)) {
			APIResponse<CiaDeSeguros> response = new APIResponse<CiaDeSeguros>(HttpStatus.OK.value(), null, companiaPorId);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		else {
			List<String> messages = new ArrayList<>();
			messages.add("No encontrada Compañía con ID: "+ id.toString());
			APIResponse<CiaDeSeguros> response = new APIResponse<CiaDeSeguros>(HttpStatus.BAD_REQUEST.value(), messages, companiaPorId);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
	
	@PostMapping("/CiaDeSeguros") //imprimir
	public ResponseEntity<APIResponse<CiaDeSeguros>> crearCiaDeSeguros(@RequestBody CiaDeSeguros compania) { //inyecta un objeto nuevo a la clase
		if(this.existe(compania.getId())) {
			List<String> messages = new ArrayList<>();
			messages.add("Ya existe una Compañía con ID: "+ compania.getId());
			messages.add("Si desea actualizar, use el verbo PUT.");
			APIResponse<CiaDeSeguros> response = new APIResponse<CiaDeSeguros>(HttpStatus.BAD_REQUEST.value(), messages, compania);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		else {
			service.crear(compania);
			APIResponse<CiaDeSeguros> response = new APIResponse<CiaDeSeguros>(HttpStatus.CREATED.value(), null, compania);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
	}
	
	@PutMapping("/CiaDeSeguros") //reemplazar
	public ResponseEntity<APIResponse<CiaDeSeguros>> modificarCiaDeSeguros(@RequestBody CiaDeSeguros compania) {
	    if(this.existe(compania.getId())) {
	    	service.modificar(compania);
	    	APIResponse<CiaDeSeguros> response = new APIResponse<CiaDeSeguros>(HttpStatus.OK.value(), null, compania);
			return ResponseEntity.status(HttpStatus.OK).body(response);
	    }
	    else {
	    	List<String> messages = new ArrayList<>();
			messages.add("No existe una Compañía con ID: "+ compania.getId());
			messages.add("Si desea crear una, use el verbo POST.");
			APIResponse<CiaDeSeguros> response = new APIResponse<CiaDeSeguros>(HttpStatus.BAD_REQUEST.value(), messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	    }
	}
	
	@DeleteMapping("/CiaDeSeguros/{id}") //eliminar
	public ResponseEntity<APIResponse<CiaDeSeguros>> eliminar(@PathVariable("id") Integer id){
		CiaDeSeguros companiaPorId = service.buscarPorId(id);
		if(companiaPorId == null) {
			List<String> messages = new ArrayList<>();
			messages.add("No existe una Compañía con ID: "+ id.toString());
			APIResponse<CiaDeSeguros> response = new APIResponse<CiaDeSeguros>(HttpStatus.BAD_REQUEST.value(), messages, null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		else {
			service.eliminar(id);
			List<String> messages = new ArrayList<>();
			messages.add("Ya no existe una Compañía con ID: "+ id.toString()+". Fue exitosamente eliminada.");
			APIResponse<CiaDeSeguros> response = new APIResponse<CiaDeSeguros>(HttpStatus.OK.value(), messages, null);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}
	
	public boolean existe(Integer id) {
	    if (id == null) {
	        return false;
	    }
	    CiaDeSeguros idCompania = service.buscarPorId(id);
	    return idCompania != null;	
	}

	
}
