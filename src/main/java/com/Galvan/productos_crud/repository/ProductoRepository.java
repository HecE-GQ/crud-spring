package com.Galvan.productos_crud.repository;

import com.Galvan.productos_crud.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository <Producto, Long>{

}
