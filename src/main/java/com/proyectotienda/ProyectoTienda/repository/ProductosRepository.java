package com.proyectotienda.ProyectoTienda.repository;


import com.proyectotienda.ProyectoTienda.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Long> {
}
