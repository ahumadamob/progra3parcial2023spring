package imb3.progra3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import imb3.progra3.entity.CarritoDeCompras;

@Repository
public interface CarritoRepository extends JpaRepository<CarritoDeCompras, Long> {

}
