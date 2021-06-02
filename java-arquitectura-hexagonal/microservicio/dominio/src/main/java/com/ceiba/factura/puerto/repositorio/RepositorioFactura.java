package com.ceiba.factura.puerto.repositorio;

import java.time.LocalDateTime;
import java.util.List;

import com.ceiba.factura.modelo.entidad.Factura;

public interface RepositorioFactura {
	

    
    /**
     * Permite consultar una lista de FACTURAS
     */
    List<Factura> obtenerListaFacturas(Long idAcuerdoPago);
    
    /**
     * Crear Facturas
     * @param double1 
     */
    void crearFactura(Long idAcuerdoPago,LocalDateTime fechaCaducidad, Double montoCuota);
    
}
