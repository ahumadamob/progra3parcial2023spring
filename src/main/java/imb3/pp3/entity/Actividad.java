package imb3.pp3.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Actividad {

	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private Integer maxPuntos;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getMaxPuntos() {
		return maxPuntos;
	}
	public void setDescripcion(Integer maxPuntos) {
		this.maxPuntos = maxPuntos;
	}

}
