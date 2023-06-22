package com.libros.ibm.libros;

import java.util.List;
import java.util.Optional;

import com.libros.ibm.libros.entidades.Libro;

public interface InterfazLibro {
	public List<Libro> obtenerTodas();
	public void guardarLibro(Libro libro);
	public void eliminarLibro(Integer id);
	public Libro buscar(Integer id); 

}
