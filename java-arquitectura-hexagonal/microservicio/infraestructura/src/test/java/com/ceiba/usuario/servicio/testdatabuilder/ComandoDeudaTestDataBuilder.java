package com.ceiba.usuario.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.deuda.comando.ComandoDeuda;

public class ComandoDeudaTestDataBuilder {

	private Long idDeuda;
	private Double monto;
	private LocalDateTime fechaInicialDeudaCliente;
	private String nombreEntidadDeuda;
	private String conceptoDeuda;
	private Cliente idCliente;
	
	public ComandoDeudaTestDataBuilder() {
		Cliente idCliente = new Cliente(1L, "santiago","1234");
		monto = 100.0;
		fechaInicialDeudaCliente = LocalDateTime.now();
		nombreEntidadDeuda = "tigo";
		conceptoDeuda = "pd";
		this.idCliente = idCliente;
	}
	
    public ComandoDeudaTestDataBuilder conIdDeuda(Long idDeuda) {
        this.idDeuda = idDeuda;
        return this;
    }
    
    public ComandoDeuda build() {
        return new ComandoDeuda(idDeuda, monto, fechaInicialDeudaCliente, nombreEntidadDeuda, conceptoDeuda, idCliente);
    }

	
	
}
