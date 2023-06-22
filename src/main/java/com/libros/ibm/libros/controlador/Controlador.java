package com.libros.ibm.libros.controlador;
import com.libros.ibm.libros.entidades.*;
import com.libros.ibm.libros.servicio.*;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api/v1")
public class Controlador {
	@Autowired
	InterfazLibro libros;

    
	@GetMapping("libros")
	public List<Libro> BuscarTodos() {

		return libros.obtenerTodas();
	}
	

	
	

	@PostMapping("/libros")
	public Libro crear(@RequestBody Libro libro) {
	    libros.guardarLibro(libro);
		return libro;

	}

	@PutMapping("/libros")
	public Libro modificar(@RequestBody Libro libro) {
		libros.guardarLibro(libro);
		return libro;

	}

	@DeleteMapping("/libros/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		libros.eliminarLibro(id);

	}
	@GetMapping("/libros/{id}")
	public Libro buscarPorId(@PathVariable("id") Integer id) {
	  return libros.buscar(id);
	}
}
