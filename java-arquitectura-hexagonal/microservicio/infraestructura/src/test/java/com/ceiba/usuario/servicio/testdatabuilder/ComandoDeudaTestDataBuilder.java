package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.deuda.comando.ComandoDeuda;

import java.time.LocalDateTime;

public class ComandoDeudaTestDataBuilder {

	private Long idDeuda;
	private Double monto;
	private LocalDateTime fechaInicialDeudaCliente;
	private String nombreEntidadDeuda;
	private String conceptoDeuda;
	private Long idCliente;
	
	public ComandoDeudaTestDataBuilder() {
		
		monto = 100.0;
		fechaInicialDeudaCliente = LocalDateTime.now();
		nombreEntidadDeuda = "tigo";
		conceptoDeuda = "pd";
		idCliente = 1L;
	}
	
    public ComandoDeudaTestDataBuilder conIdDeuda(Long idDeuda) {
        this.idDeuda = idDeuda;
        return this;
    }
    
    public ComandoDeuda build() {
        return new ComandoDeuda(idDeuda, monto, fechaInicialDeudaCliente, nombreEntidadDeuda, conceptoDeuda, idCliente);
    }

	
	
}
