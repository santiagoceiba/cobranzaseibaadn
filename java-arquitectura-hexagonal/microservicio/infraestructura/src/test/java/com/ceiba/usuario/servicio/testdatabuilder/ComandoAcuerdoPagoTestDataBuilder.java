package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.acuerdo.pago.comando.ComandoAcuerdoPago;
import com.ceiba.acuerdopago.utilidades.enumeracion.EstadoAcuerdo;

import java.time.LocalDateTime;

public class ComandoAcuerdoPagoTestDataBuilder {
	
	private Long idAcuerdoPago;
	private LocalDateTime fechaAcuerdo;
	private Double montoCuota;
	private Long idCliente;
	private Long idDeuda;
	private EstadoAcuerdo estado;
	private Integer cantidadCuotas;
	private Long numeroReferencia;
	
	public ComandoAcuerdoPagoTestDataBuilder() {
		
	
		montoCuota = 100.0;
		fechaAcuerdo = LocalDateTime.now();
		idCliente = 1L;
		idDeuda = 1L;
		estado = EstadoAcuerdo.ACTIVO;
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
