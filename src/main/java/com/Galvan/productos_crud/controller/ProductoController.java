package com.Galvan.productos_crud.controller;

import org.springframework.ui.Model;
import com.Galvan.productos_crud.model.Producto;
import com.Galvan.productos_crud.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/productos")

public class ProductoController {

    private final ProductoService productService;
    // Inyeccion
    public ProductoController(ProductoService productService){
        this.productService = productService;
    }

    // GET /productos
    @GetMapping
    public String obtenerProductos(Model model){
        List<Producto> res = productService.obtenerTodos();
        model.addAttribute("productos", res);
        return "productos/lista";
    }
    // GET /productos/nuevo MOSTRARA FORMULARIO PARA CREAR
    @GetMapping("/nuevo")
    public String showForm(Model model){
        model.addAttribute("producto", new Producto());
        return "productos/formulario";
    }
    // POST /productos/guardar
    @PostMapping("/guardar")
    public String procesarForm(@ModelAttribute("producto") Producto producto){
        // Ya viene cargado el modelo, hay que llamar al service
        productService.guardar(producto);

        return "redirect:/productos";
    }

    // GET /productos/editar{id} @PathVariable es para obtener data de la url
    @GetMapping("/editar/{id}")
    public String showFormEdit(@PathVariable Long id, Model model){
        Producto productoExist = productService.obtenerPorID(id).orElseThrow();
        model.addAttribute("producto", productoExist);
        return "productos/formulario";
    }
    // GET /productos/eliminar/{id}
    @GetMapping("eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") Long id){
        //Service
        productService.eliminar(id);
        return "redirect:/productos";
    }

}
