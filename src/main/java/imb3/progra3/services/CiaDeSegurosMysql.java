package imb3.progra3.services;

import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import imb3.progra3.entity.CiaDeSeguros;
import imb3.progra3.repository.CiaDeSegurosRepository;

@Service
@Primary
public class CiaDeSegurosMysql implements ICiaDeSegurosService{

	@Autowired
	CiaDeSegurosRepository repo;
	
	@Override
	public List<CiaDeSeguros> buscarTodos(){
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
    public CiaDeSeguros buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		Optional<CiaDeSeguros> companiaOptional = repo.findById(id);
        if (companiaOptional.isPresent()) {
            return companiaOptional.get();
        } else {
            throw new NoSuchElementException("CiaDeSeguros no encontrada con ID: " + id);
        }
    }

	@Override
	public void crear(CiaDeSeguros compania) {
		// TODO Auto-generated method stub
		repo.save(compania);
	}

	@Override
	public CiaDeSeguros modificar(CiaDeSeguros ciaModificada) {
	    Integer id = ciaModificada.getId();
	    Optional<CiaDeSeguros> ciaOptional = repo.findById(id);
	    if (ciaOptional.isPresent()) {
	        CiaDeSeguros ciaExistente = ciaOptional.get();
	        ciaExistente.setNombre(ciaModificada.getNombre());
	        ciaExistente.setDireccion(ciaModificada.getDireccion());
	        ciaExistente.setNumTelefono(ciaModificada.getNumTelefono());
	        ciaExistente.setTipoSeguro(ciaModificada.getTipoSeguro());
	        ciaExistente.setEstadoSeguro(ciaModificada.getEstadoSeguro());
	        return repo.save(ciaExistente);
	    } else {
	        throw new NoSuchElementException("CiaDeSeguros no encontrada con ID: " + id);
	    }
	}

	
	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
	
}
