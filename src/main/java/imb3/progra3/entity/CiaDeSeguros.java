package imb3.progra3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class CiaDeSeguros {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "El nombre no puede estar vacío.")
	@Size(max=50, message = "El nombre no puede tener más de 50 caracteres.")
	private String nombre;
	@NotBlank(message = "La dirección no puede estar vacía.")
	@Size(min = 3, max = 100, message = "Mínimo 3, máximo 100 caracteres.")
	private String direccion;
	private Integer numTelefono;
	private String tipoSeguro; //terceros, total, empresarial
	private boolean estadoSeguro; //0= baja, 1= alta
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getNumTelefono() {
		return numTelefono;
	}
	public void setNumTelefono(int numTelefono) {
		this.numTelefono = numTelefono;
	}
	public String getTipoSeguro() {
		return tipoSeguro;
	}
	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}
	public boolean getEstadoSeguro() {
		return estadoSeguro;
	}
	public void setEstadoSeguro(boolean estadoSeguro) {
		this.estadoSeguro = estadoSeguro;
	}
	
	
}
