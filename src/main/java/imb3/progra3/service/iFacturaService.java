package imb3.progra3.service;

import java.util.List;

import imb3.progra3.entity.Factura;

public interface iFacturaService {
	
	public List<Factura> findAll();
	
	public Factura findById(int nroFactura);
	
//	public void save(Factura f);
	public Factura save(Factura f);
	
//	public void deleteById(int nro);
	public Factura deleteById(int nro);
	

}
