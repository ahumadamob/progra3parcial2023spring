package imb3.progra3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="calificacion")
public class Calificacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer valor;
	@NotBlank(message = "El nombre no puede estar vacío")
	@Size(max = 40, message = "El nombre del autor no debe superar los 40 caracteres") 
	private String autor;
	private String fecha;


	public Calificacion() {
	}

	public Calificacion(Long id, Integer valor, String autor, String fecha) {
		this.id = id;
		this.valor = valor;
		this.autor = autor;
		this.fecha = fecha;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Integer getValor() {
		return valor;
	}


	public void setValor(Integer valor) {
		this.valor = valor;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
