package com.ceiba.factura.puerto.repositorio;

import com.ceiba.factura.modelo.entidad.Factura;

import java.time.LocalDateTime;
import java.util.List;

public interface RepositorioFactura {
	


    List<Factura> obtenerListaFacturas(Long idAcuerdoPago);

    void actualizar(Factura factura);

    void crearFactura(Long idAcuerdoPago,LocalDateTime fechaCaducidad, Double montoCuota);

    Boolean existe(Long idFactura);
    
}
