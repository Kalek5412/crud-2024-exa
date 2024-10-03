package com.crud_producto.controller;

import com.crud_producto.model.Producto;
import com.crud_producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/listar")
    public List<Producto> listar(){
        return productoService.listProducto();
    }

    @PostMapping("/save")
    public ResponseEntity<?> crear(@RequestBody Producto producto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.guardar(producto));
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id,@RequestBody Producto producto){

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productoService.modificar(id,producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        productoService.eliminar(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
