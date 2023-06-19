package imb3.progra3.service;

import java.util.List;

import imb3.progra3.entity.Factura;

public interface iFacturaService {
	
	public List<Factura> buscarTodos();
	
	public Factura buscarPorId(int nroFactura);
	
	public void guardar(Factura f);
	
	public void eliminar(int nro);
	

}
