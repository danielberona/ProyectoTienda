package com.proyectotienda.ProyectoTienda.model;

//definir la entidad

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Productos {

    // variables
    @Id
    private long id;

    private String Nombre;

    private String precio;


    // getters y setters

    public Long getId()
    { return id; }

    public void setId(Long id)
    { this.id = id; }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }




}

