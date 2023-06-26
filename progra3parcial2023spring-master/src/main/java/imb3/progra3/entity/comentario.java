package imb3.progra3.entity;

import javax.xml.crypto.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class comentario {
	
	
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private Integer id;
	private String contenido;
	private String autor;
	private Data fecha;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Data getFecha() {
		return fecha;
	}
	public void setFecha(Data fecha) {
		this.fecha = fecha;
	}
	
	
	
}
