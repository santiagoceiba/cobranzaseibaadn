package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;
import com.ceiba.acuerdopago.utilidades.enumeracion.EstadoAcuerdo;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.deuda.modelo.entidad.Deuda;
import com.ceiba.factura.modelo.entidad.Factura;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AcuerdoPagoTestDataBuilder {
	
	private Long idAcuerdoPago;
	private LocalDateTime fechaAcuerdo;
	private Double montoCuota;
	private Cliente idCliente;
	private Deuda idDeuda;
	private EstadoAcuerdo estado;
	private Integer cantidadCuotas;
	private Long numeroReferencia;
	private List<Factura> listaFacturas;
	
	public AcuerdoPagoTestDataBuilder() {
		
		Cliente idCliente = new Cliente(1L, "santiago","1234");
		Deuda idDeuda = new Deuda(10.0, LocalDateTime.now(), "tigo", "plan de datos", idCliente, 1L);
		idAcuerdoPago = 1L;
		fechaAcuerdo = LocalDateTime.now();
		montoCuota = 100.0;
		this.idCliente = idCliente;
		this.idDeuda = idDeuda;
		estado = EstadoAcuerdo.ACTIVO;
		cantidadCuotas = 2;
		numeroReferencia = 12345L;
  
	}
	
    public AcuerdoPagoTestDataBuilder conId(Long idAcuerdoPago) {
        this.idAcuerdoPago = idAcuerdoPago;
        return this;
    }

    public AcuerdoPagoTestDataBuilder conListaFacturas(List<Factura> listaFacturas) {
		this.listaFacturas = new ArrayList<Factura>(listaFacturas);
		return this;
	}
	public  AcuerdoPago buildConFactura() {
		AcuerdoPago acuerdoPago = new AcuerdoPago(idAcuerdoPago, fechaAcuerdo, montoCuota, idCliente, idDeuda, estado, cantidadCuotas, numeroReferencia);
		acuerdoPago.agregarListaFacturas(this.listaFacturas);
		return acuerdoPago;

	}
    public AcuerdoPago build() {
        return new AcuerdoPago(idAcuerdoPago, fechaAcuerdo, montoCuota, idCliente, idDeuda, estado, cantidadCuotas, numeroReferencia);
    }
}
