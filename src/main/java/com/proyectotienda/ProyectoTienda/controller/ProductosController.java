package com.proyectotienda.ProyectoTienda.controller;

import com.proyectotienda.ProyectoTienda.model.Productos;
import com.proyectotienda.ProyectoTienda.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/productos")
public class ProductosController {

    // inyeccion de dependencia
    @Autowired
    private ProductosRepository productosRepository;


    // manejador de la lista de cliente de los GET

    @GetMapping
    public String listarProductos(Model model){
        List<Productos> productos = productosRepository.findAll();
        model.addAttribute("productos", productos);
        return "productos";
    }

    // funcion usuario nuevo

    @GetMapping("/nuevo")
    public String mostrarformularioderegistro(Model model){
        model.addAttribute("productos",new Productos());
        return "registro_productos";
    }

    // funcion que maneja las solictudes POST /productos y crear un nuevo cliente

    @PostMapping
    public String crearProductos(@ModelAttribute("productos")Productos productos){
        productosRepository.save(productos);
        return "redirect:/productos";
    }

    // funcion mostrar lista productos de edicion
    @GetMapping ("/editar/{id}")
    public String mostrarFormularioDeEdiccion(@PathVariable long id, Model model){
        Productos productos = productosRepository.findById(id).orElseThrow(() -> new RuntimeException("producto no encontrado"));
        model.addAttribute("producto", productos);
        return "editar_productos";
    }


    @PostMapping("/{id}")
    public String actualizarproductos(@PathVariable long id, @ModelAttribute("productos") Productos productosactulizado){
        Productos productos = productosRepository.findById(id).orElseThrow(() -> new RuntimeException("producto no encontrado"));
        productos.setNombre(productosactulizado.getNombre());
        productos.setPrecio(productosactulizado.getPrecio());
        productosRepository.save(productos);
        return "redirect:/productos";
    }


    @GetMapping("/eliminar/id")
    public String borrarproductos(@PathVariable long id){
        productosRepository.deleteById(id);
        return "redirect:productos";
    }



}
