package com.ceiba.usuario.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.acuerdo.pago.comando.ComandoAcuerdoPago;
import com.ceiba.acuerdopago.utilidades.enumeracion.EstadoAcuerdoEnum;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.deuda.modelo.entidad.Deuda;

public class ComandoAcuerdoPagoTestDataBuilder {
	
	private Long idAcuerdoPago;
	private LocalDateTime fechaAcuerdo;
	private Double montoCuota;
	private Cliente idCliente;
	private Deuda idDeuda;
	private EstadoAcuerdoEnum estado;
	private Integer cantidadCuotas;
	private Long numeroReferencia;
	
	public ComandoAcuerdoPagoTestDataBuilder() {
		
		Cliente idCliente = new Cliente(1L, "santiago","1234");
		Deuda idDeuda = new Deuda(10.0, LocalDateTime.now(), "tigo", "plan de datos", idCliente, 1L);
		montoCuota = 100.0;
		fechaAcuerdo = LocalDateTime.now();
		System.out.println(fechaAcuerdo);
		this.idCliente = idCliente;
		this.idDeuda = idDeuda;
		estado = EstadoAcuerdoEnum.ACTIVO;
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
