/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ista.edu.practica.Facturacion.repository;

import ista.edu.practica.Facturacion.model.Detalle_Factura;
import ista.edu.practica.Facturacion.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author 59398
 */
public interface DetalleRepository extends JpaRepository<Detalle_Factura, Integer>{
    @Query(value = "Select * from detalle_factura d where d.numero_factura = :numero_factura", nativeQuery = true)
    public Detalle_Factura buscarDetalle_Factura(String numero_factura);
}
