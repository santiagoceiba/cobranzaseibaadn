package com.ceiba.usuario.servicio.testdatabuilder;


import com.ceiba.factura.comando.ComandoFactura;

import java.time.LocalDateTime;

public class ComandoFacturaTestDataBuilder {

    private Long idFactura;
    private Double montoCuota;
    private LocalDateTime fechaCaducidad;
    private Long acuerdoPago;
    private Boolean estado;

    public ComandoFacturaTestDataBuilder() {
        montoCuota = 10.0;
        fechaCaducidad = LocalDateTime.now();
        acuerdoPago = 1L;
        estado = true;
    }

    public ComandoFacturaTestDataBuilder conId(Long idFactura) {
        this.idFactura = idFactura;
        return this;
    }

    public ComandoFactura build() {
        return new ComandoFactura(idFactura, montoCuota, fechaCaducidad, acuerdoPago, estado);
    }
}
