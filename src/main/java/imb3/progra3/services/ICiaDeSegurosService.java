package imb3.progra3.services;
import java.util.List;

import imb3.progra3.entity.CiaDeSeguros;

public interface ICiaDeSegurosService {

	List <CiaDeSeguros> buscarTodos();
	CiaDeSeguros buscarPorId(Integer id);
	void crear(CiaDeSeguros compania);
	void eliminar (Integer id);
	CiaDeSeguros modificar(CiaDeSeguros comapania);
	
}
