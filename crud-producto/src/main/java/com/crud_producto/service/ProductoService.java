package com.crud_producto.service;

import com.crud_producto.model.Producto;
import com.crud_producto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listProducto(){
        return productoRepository.findAll();
    }

    public Optional<Producto> buscarPorId(Long id) {
        return productoRepository.findById(id);
    }


    public Producto guardar(Producto producto) {;
        producto.setFecha_creacion(LocalDate.now());
        return productoRepository.save(producto);
    }


    public Optional<Producto> modificar(Long id, Producto producto) {
        Producto productoEdit = productoRepository.findById(id).orElse(null);
        if (productoEdit == null) {
            return Optional.empty();
        }
        productoEdit.setNombre(producto.getNombre());
        productoEdit.setDescripcion(producto.getDescripcion());
        productoEdit.setPrecio(producto.getPrecio());
        productoEdit.setCantidad_stock(producto.getCantidad_stock());
        productoEdit.setFecha_actualizacion(LocalDate.now());
        return Optional.of(productoRepository.save(productoEdit));
    }

    public void eliminar(Long id) {
        productoRepository.deleteById(id);

    }

}
