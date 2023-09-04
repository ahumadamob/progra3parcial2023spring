package imb3.progra3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String direccionCalle;
	private Integer direccionNum;
	private String contacto;
	
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
	
	public String getDireccionCalle() {
		return direccionCalle;
	}
	public void setDireccionCalle(String direccionCalle) {
		this.direccionCalle = direccionCalle;
	}
	
	public Integer getDireccionNum() {
		return direccionNum;
	}
	public void setDireccionNum(Integer direccionNum) {
		this.direccionNum = direccionNum;
	}
	
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

} 