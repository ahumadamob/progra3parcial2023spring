package imb3.progra3.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tareas")
public class Tarea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="fechaInicio")
	private Date fechaDeInicio;
	
	@Column(name="fechaVto")
	private Date fechaDeVto;
	
	@Column(name="estado")
	private String estado;

	public Tarea() {
	}

	public Tarea(Long id, String descripcion, Date fechaDeInicio, Date fechaDeVto, String estado) {
		this.id = id;
		this.descripcion = descripcion;
		this.fechaDeInicio = fechaDeInicio;
		this.fechaDeVto = fechaDeVto;
		this.estado = estado;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the fechaDeInicio
	 */
	public Date getFechaDeInicio() {
		return fechaDeInicio;
	}

	/**
	 * @param fechaDeInicio the fechaDeInicio to set
	 */
	public void setFechaDeInicio(Date fechaDeInicio) {
		this.fechaDeInicio = fechaDeInicio;
	}

	/**
	 * @return the fechaDeVto
	 */
	public Date getFechaDeVto() {
		return fechaDeVto;
	}

	/**
	 * @param fechaDeVto the fechaDeVto to set
	 */
	public void setFechaDeVto(Date fechaDeVto) {
		this.fechaDeVto = fechaDeVto;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	

}
