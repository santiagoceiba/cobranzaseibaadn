package com.ceiba.factura.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class DtoFactura {

	private Long idFactura;
	private Double montoCuota;
	private LocalDateTime fechaCaducidad;
	private Long acuerdoPago;
	private Boolean estado;
}
