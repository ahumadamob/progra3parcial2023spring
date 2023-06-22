package com.libros.ibm.libros;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libros.ibm.libros.entidades.Libro;

public interface repositorio extends JpaRepository<Libro,Integer>{
	
	
}