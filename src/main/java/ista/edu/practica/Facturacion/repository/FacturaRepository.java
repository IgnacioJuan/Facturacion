/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ista.edu.practica.Facturacion.repository;

import ista.edu.practica.Facturacion.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author 59398
 */
public interface FacturaRepository extends JpaRepository<Factura, Integer>{
    @Query(value = "Select * from factura f where f.id_factura = :id_factura", nativeQuery = true)
    public Factura buscarFactura(String id_factura);
}
