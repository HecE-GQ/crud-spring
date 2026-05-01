package com.Galvan.productos_crud.service;
import com.Galvan.productos_crud.model.Producto;
import com.Galvan.productos_crud.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }
    // Logica de negocio
    public List<Producto> obtenerTodos(){
            return productoRepository.findAll();
    }
    public Optional<Producto> obtenerPorID(Long id){
        return productoRepository.findById(id);
    }

    public Producto guardar(Producto producto){
        return productoRepository.save(producto);
    }

    public void eliminar(Long id){
        productoRepository.deleteById(id);
    }
}
