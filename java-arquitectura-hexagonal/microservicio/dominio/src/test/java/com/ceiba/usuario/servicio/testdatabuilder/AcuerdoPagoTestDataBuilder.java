package com.ceiba.usuario.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.acuerdopago.utilidades.enumeracion.EstadoAcuerdoEnum;
import com.ceiba.usuario.modelo.entidad.AcuerdoPago;

public class AcuerdoPagoTestDataBuilder {
	
	private Long idAcuerdoPago;
	private LocalDateTime fechaAcuerdo;
	private Double montoCuota;
	private Long idCliente;
	private Long idDeuda;
	private EstadoAcuerdoEnum estado;
	private Integer cantidadCuotas;
	private Long numeroReferencia;
	
	public AcuerdoPagoTestDataBuilder() {
		montoCuota = 100.0;
		idCliente = 1L;
		idDeuda = 1L;
		estado = EstadoAcuerdoEnum.ACTIVO;
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
