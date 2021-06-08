package com.ceiba.factura.modelo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DtoFactura {

	private Long idFactura;
	private Double montoCuota;
	private LocalDateTime fechaCaducidad;
	private Long acuerdoPago;
	private Boolean estado;
	
	
	public DtoFactura(Long idFactura, Double montoCuota, LocalDateTime fechaCaducidad, Long acuerdoPago, Boolean estado) {
		this.idFactura = idFactura;
		this.montoCuota = montoCuota;
		this.fechaCaducidad = fechaCaducidad;
		this.acuerdoPago = acuerdoPago;
		this.estado = estado;
	}

	

	public DtoFactura() {
	}
}
