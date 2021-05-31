package com.ceiba.usuario.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.usuario.comando.ComandoFactura;

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
