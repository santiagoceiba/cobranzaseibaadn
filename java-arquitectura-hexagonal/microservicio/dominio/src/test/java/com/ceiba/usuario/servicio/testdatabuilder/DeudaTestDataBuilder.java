package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.deuda.modelo.entidad.Deuda;

import java.time.LocalDateTime;

public class DeudaTestDataBuilder {

	private Long idDeuda;
	private Double monto;
	private LocalDateTime fechaInicialDeudaCliente;
	private String nombreEntidadDeuda;
	private String conceptoDeuda;
	private Cliente idCliente;

    public DeudaTestDataBuilder() {
    	
    	Cliente cliente = new Cliente(1L, "santiago", "pruebas unitarias") ;
    	monto = 10.0;
    	fechaInicialDeudaCliente = LocalDateTime.now();
    	nombreEntidadDeuda = "Tigo";
    	conceptoDeuda = "Plan de datos";
    	idCliente = cliente;
    }



    public DeudaTestDataBuilder conId(Long idCliente) {
        this.idDeuda = idCliente;
        return this;
    }

    public DeudaTestDataBuilder conFecha(LocalDateTime fechaInicialDeudaCliente){
    	this.fechaInicialDeudaCliente = fechaInicialDeudaCliente;
    	return this;
	}
	public DeudaTestDataBuilder conMonto(Double monto) {
    	this.monto = monto;
    	return this;
	}

    public Deuda build() {
        return new Deuda(monto, fechaInicialDeudaCliente, nombreEntidadDeuda, conceptoDeuda, idCliente, idDeuda);
    }
}
