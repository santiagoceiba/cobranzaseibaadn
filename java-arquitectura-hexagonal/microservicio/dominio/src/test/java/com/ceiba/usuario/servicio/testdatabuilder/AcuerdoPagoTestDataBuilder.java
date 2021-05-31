package com.ceiba.usuario.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;

public class AcuerdoPagoTestDataBuilder {
	
	private Long idAcuerdoPago;
	private LocalDateTime fechaAcuerdo;
	private Double montoCuota;
	private Long idCliente;
	private Long idDeuda;
	private String estado;
	private Integer cantidadCuotas;
	private Long numeroReferencia;
	
	public AcuerdoPagoTestDataBuilder() {
		fechaAcuerdo = LocalDateTime.now();
		montoCuota = 100.0;
		idCliente = 1L;
		idDeuda = 1L;
		estado = "A";
		cantidadCuotas = 2;
		numeroReferencia = 12345L;
  
	}
	
    public AcuerdoPagoTestDataBuilder conId(Long idAcuerdoPago) {
        this.idAcuerdoPago = idAcuerdoPago;
        return this;
    }

    public AcuerdoPago build() {
        return new AcuerdoPago(idAcuerdoPago, fechaAcuerdo, montoCuota, idCliente, idDeuda, estado, cantidadCuotas, numeroReferencia);
    }
}
