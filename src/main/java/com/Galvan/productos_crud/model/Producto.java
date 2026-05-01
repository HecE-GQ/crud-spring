package com.Galvan.productos_crud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
//Constructor
@NoArgsConstructor
@AllArgsConstructor
// La anotacion indica que hablaran directamente con mysql
@Entity
@Table(name="productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generacion automatica
    private Long id;

    //Campos de la BD
    @Column(name = "nombre", nullable = false, length=255) //Campos no nulos
    private String nombre;
    @Column(name="precio", nullable = false)
    private double precio;
    @Column(name = "stock", nullable = false)
    private int stock;
    @Column(name = "categoria", nullable = false)
    private String categoria;
}
