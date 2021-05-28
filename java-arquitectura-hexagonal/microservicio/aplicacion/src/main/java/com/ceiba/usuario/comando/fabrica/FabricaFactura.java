package com.ceiba.usuario.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.ComandoFactura;
import com.ceiba.usuario.modelo.entidad.Factura;

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
