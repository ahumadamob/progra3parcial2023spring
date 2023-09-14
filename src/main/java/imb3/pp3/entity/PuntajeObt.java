package imb3.pp3.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PuntajeObt {

	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private Integer id;
	private Integer dniProfesor;
	private Integer totalPuntos;
	private Date fecha;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDniProfesor() {
		return dniProfesor;
	}
	public void setDniProfesor(Integer dniProfesor) {
		this.dniProfesor = dniProfesor;
	}
	public Integer getTotalPuntos() {
		return totalPuntos;
	}
	public void setTotalPuntos(Integer totalPuntos) {
		this.totalPuntos = totalPuntos;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


}
