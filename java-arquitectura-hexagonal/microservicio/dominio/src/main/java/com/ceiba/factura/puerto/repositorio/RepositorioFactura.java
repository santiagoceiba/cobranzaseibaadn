package com.ceiba.factura.puerto.repositorio;

import java.time.LocalDateTime;
import java.util.List;

import com.ceiba.factura.modelo.entidad.Factura;

public interface RepositorioFactura {
	


    List<Factura> obtenerListaFacturas(Long idAcuerdoPago);

    void actualizar(Factura factura);

    void crearFactura(Long idAcuerdoPago,LocalDateTime fechaCaducidad, Double montoCuota);

    Boolean existe(Long idFactura);
    
}
