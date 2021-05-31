package com.ceiba.usuario.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;
import com.ceiba.acuerdopago.utilidades.enumeracion.EstadoAcuerdoEnum;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.deuda.modelo.entidad.Deuda;

public class AcuerdoPagoTestDataBuilder {
	
	private Long idAcuerdoPago;
	private LocalDateTime fechaAcuerdo;
	private Double montoCuota;
	private Cliente idCliente;
	private Deuda idDeuda;
	private EstadoAcuerdoEnum estado;
	private Integer cantidadCuotas;
	private Long numeroReferencia;
	
	public AcuerdoPagoTestDataBuilder() {
		
		Cliente idCliente = new Cliente(1L, "santiago","1234");
		Deuda idDeuda = new Deuda(10.0, LocalDateTime.now(), "tigo", "plan de datos", idCliente, 1L);
		fechaAcuerdo = LocalDateTime.now();
		montoCuota = 100.0;
		this.idCliente = idCliente;
		this.idDeuda = idDeuda;
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
