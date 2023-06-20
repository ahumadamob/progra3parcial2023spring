package imb3.progra3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import imb3.progra3.entity.CarritoDeCompras;

public interface CarritoController {
    public ResponseEntity<?>getAll();
    public ResponseEntity<?>getOne(@PathVariable Long id);
    public ResponseEntity<?>save(@RequestBody CarritoDeCompras carrito);
    public ResponseEntity<?>update(@PathVariable Long id,@RequestBody CarritoDeCompras carrito);
    public ResponseEntity<?>delete(@PathVariable Long id);
}
