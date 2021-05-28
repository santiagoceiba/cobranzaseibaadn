package com.ceiba.usuario.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.usuario.comando.ComandoAcuerdoPago;

public class ComandoAcuerdoPagoTestDataBuilder {
	
	private Long idAcuerdoPago;
	private LocalDateTime fechaAcuerdo;
	private Double montoCuota;
	private Long idCliente;
	private Long idDeuda;
	private String estado;
	private Integer cantidadCuotas;
	private Long numeroReferencia;
	
	public ComandoAcuerdoPagoTestDataBuilder() {
		montoCuota = 100.0;
		fechaAcuerdo = LocalDateTime.now();
		System.out.println(fechaAcuerdo);
		idCliente = 1L;
		idDeuda = 1L;
		estado = "A";
		cantidadCuotas = 2;
		numeroReferencia = 12345L;
  
	}
	
    public ComandoAcuerdoPagoTestDataBuilder conId(Long idAcuerdoPago) {
        this.idAcuerdoPago = idAcuerdoPago;
        return this;
    }

    public ComandoAcuerdoPago build() {
        return new ComandoAcuerdoPago(idAcuerdoPago, fechaAcuerdo, montoCuota, idCliente, idDeuda, estado, cantidadCuotas, numeroReferencia);
    }
}
