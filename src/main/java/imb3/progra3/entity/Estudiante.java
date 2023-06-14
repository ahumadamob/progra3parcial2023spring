package imb3.progra3.entity;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import imb3.progra3.service.IEstudianteService;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Service
@Entity
public class Estudiante implements IEstudianteService{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String apellido;
	private Integer edad;
	private String curso;
	private String direccion;
	
	
	@Override
	public List<Estudiante> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Optional<Estudiante> buscarPorId(Integer idEstudiante) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estudiante crearEstudiante(Estudiante request) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Estudiante actualizarEstudiante(Estudiante request) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Optional<Estudiante> eliminarPorId(Integer idEstudiante) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Optional<Estudiante> eliminarPorTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	

	

	

	

	






	
	

}
