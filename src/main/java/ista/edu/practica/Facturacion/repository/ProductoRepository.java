/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ista.edu.practica.Facturacion.repository;

import ista.edu.practica.Facturacion.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author 59398
 */
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    @Query(value = "Select * from producto p where p.id_producto = :id_producto", nativeQuery = true)
    public Producto buscarProducto(String id_producto);
}
