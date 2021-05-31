package com.ceiba.factura.puerto.repositorio;

import java.util.List;

import com.ceiba.factura.modelo.entidad.Factura;

public interface RepositorioFactura {
	

    
    /**
     * Permite consultar una lista de FACTURAS
     */
    List<Factura> obtenerListaFacturas(Long idAcuerdoPago);
    
    
}
