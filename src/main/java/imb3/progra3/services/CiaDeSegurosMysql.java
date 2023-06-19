package imb3.progra3.services;

import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import imb3.progra3.entity.CiaDeSeguros;
import imb3.progra3.repository.CiaDeSegurosRepository;

//indica clase de servicio
@Service
@Primary
public class CiaDeSegurosMysql implements ICiaDeSegurosService{

	//inyecta el repositorio
	@Autowired
	CiaDeSegurosRepository repo;
	
	//reemplaza el método de la superclase o interfaz en este caso
	@Override
	public List<CiaDeSeguros> buscarTodos(){
		return repo.findAll();
	}

	@Override
    public CiaDeSeguros buscarPorId(Integer id) {
		Optional<CiaDeSeguros> companiaOptional = repo.findById(id);
        if (companiaOptional.isPresent()) {
            return companiaOptional.get();
        }
        else {
            throw new NoSuchElementException("CiaDeSeguros no encontrada con ID: " + id);
        }
    }

	@Override
	public CiaDeSeguros crear(CiaDeSeguros compania) {
		return repo.save(compania);
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
	public String eliminar(Integer id) {
		boolean existeRegistro = repo.existsById(id);
	    if (existeRegistro) {
	        repo.deleteById(id);
	        return "Registro eliminado correctamente.";
	    } else {
	        return "Registro no encontrado.";
	    }	
	 }
	
}
