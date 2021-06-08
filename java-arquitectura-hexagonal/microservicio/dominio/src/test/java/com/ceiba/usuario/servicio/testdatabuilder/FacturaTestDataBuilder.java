package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;
import com.ceiba.factura.modelo.entidad.Factura;

import java.time.LocalDateTime;

public class FacturaTestDataBuilder {

    private Long idFactura;
    private Double montoCuota;
    private LocalDateTime fechaCaducidad;
    private AcuerdoPago acuerdoPago;
    private Boolean estado;

    public FacturaTestDataBuilder() {
        AcuerdoPago acuerdoPago = new AcuerdoPagoTestDataBuilder().build() ;
        montoCuota = 10.0;
        fechaCaducidad = LocalDateTime.of(2020,05,05, 00,01);
        this.acuerdoPago = acuerdoPago;
        estado = true;
    }

    public FacturaTestDataBuilder conId(Long idFactura) {
        this.idFactura = idFactura;
        return this;
    }

    public FacturaTestDataBuilder conEstado(Boolean estado) {
        this.estado = estado;
        return this;
    }

    public Factura build() {
        return new Factura(idFactura, montoCuota, fechaCaducidad, acuerdoPago);
    }
}
