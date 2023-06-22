package com.libros.ibm.libros.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.libros.ibm.libros.entidades.Libro;

@Service
@Primary
public class LibroMysql implements InterfazLibro{
    @Autowired
	repositorio repo;
	@Override
	public List<Libro> obtenerTodas() {
	  return repo.findAll();
	}
	@Override
	public void guardarLibro(Libro libro) {
		repo.save(libro);
		
	}
	@Override
	public void eliminarLibro(Integer id) {
		repo.deleteById(id);
	}
	@Override
	public Libro buscar(Integer id) {
		Optional<Libro> opt=repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return new Libro();
		}
		
		
	}
	

}
