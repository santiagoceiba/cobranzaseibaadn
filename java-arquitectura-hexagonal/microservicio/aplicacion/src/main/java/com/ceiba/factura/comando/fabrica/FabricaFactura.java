package com.ceiba.factura.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.factura.comando.ComandoFactura;
import com.ceiba.factura.modelo.entidad.Factura;

@Component
public class FabricaFactura {

    public Factura crear(ComandoFactura comandoFactura) {
        return new Factura(
        		comandoFactura.getIdFactura(),
        		comandoFactura.getMontoCuota(),
        		comandoFactura.getFechaCaducidad(),
        		comandoFactura.getAcuerdoPago(),
        		comandoFactura.getEstado()
        );
    }
}
