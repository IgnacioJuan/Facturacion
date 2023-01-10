/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ista.edu.practica.Facturacion.controller;

import ista.edu.practica.Facturacion.model.Detalle_Factura;
import ista.edu.practica.Facturacion.service.DetalleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/detalle")
public class DetalleController {

    @Autowired
    DetalleService detalleService;

    @GetMapping("/listar")
    public ResponseEntity< List<Detalle_Factura>> obtenerLista() {
        return new ResponseEntity<>(detalleService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Detalle_Factura> crear(@RequestBody Detalle_Factura c) {
        return new ResponseEntity<>(detalleService.save(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Detalle_Factura> eliminar(@PathVariable Integer id) {
        detalleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Detalle_Factura> actualizarUsuario(@PathVariable Integer id, @RequestBody Detalle_Factura c) {
        Detalle_Factura detalle_Factura = detalleService.findById(id);
        if (detalle_Factura == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                detalle_Factura.setCantidad(c.getCantidad());
                detalle_Factura.setProducto(c.getProducto());

                return new ResponseEntity<>(detalleService.save(detalle_Factura), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

    }
}
