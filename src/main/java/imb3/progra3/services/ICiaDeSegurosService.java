package imb3.progra3.services;
import java.util.List;

import imb3.progra3.entity.CiaDeSeguros;

public interface ICiaDeSegurosService {

	List <CiaDeSeguros> buscarTodos();
	CiaDeSeguros buscarPorId(Integer id);
	CiaDeSeguros crear(CiaDeSeguros compania);
	String eliminar (Integer id);
	CiaDeSeguros modificar(CiaDeSeguros comapania);
	
}
