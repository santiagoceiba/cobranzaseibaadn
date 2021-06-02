package com.ceiba.usuario.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;
import com.ceiba.factura.modelo.entidad.Factura;

public class FacturaTestDataBuilder {

	private Long idFactura;
	private Double montoCuota;
	private LocalDateTime fechaCaducidad;
	private AcuerdoPago acuerdoPago;
	private Boolean estado;
	
    public FacturaTestDataBuilder() {
    	
    	AcuerdoPago acuerdoPago = new AcuerdoPagoTestDataBuilder().build() ;
    	montoCuota = 10.0;
    	fechaCaducidad = LocalDateTime.now();
    	estado = false;
    	this.acuerdoPago = acuerdoPago;

    }



    public FacturaTestDataBuilder conId(Long idFactura) {
        this.idFactura = idFactura;
        return this;
    }

    public Factura build() {
        return new Factura(idFactura, montoCuota, fechaCaducidad, acuerdoPago, estado);
    }
}
