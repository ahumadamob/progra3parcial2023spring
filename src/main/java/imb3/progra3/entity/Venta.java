package imb3.progra3.entity;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Venta {
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Integer id;
	 private Date fecha;
	 private Boolean cliente_asociado;
	 private String lista_productos_vendidos;
	 private Double total;
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Boolean getCliente_asociado() {
		return cliente_asociado;
	}
	public void setCliente_asociado(Boolean cliente_asociado) {
		this.cliente_asociado = cliente_asociado;
	}
	public String getLista_productos_vendidos() {
		return lista_productos_vendidos;
	}
	public void setLista_productos_vendidos(String lista_productos_vendidos) {
		this.lista_productos_vendidos = lista_productos_vendidos;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
}