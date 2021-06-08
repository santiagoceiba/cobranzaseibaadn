package com.ceiba.acuerdo.pago.modelo.dto;

import com.ceiba.acuerdopago.utilidades.enumeracion.EstadoAcuerdo;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.deuda.modelo.entidad.Deuda;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class DtoAcuerdoPago {
	
	private Long idAcuerdoPago;
	private LocalDateTime fechaAcuerdo;
	private Double montoCuota;
	private Cliente cliente;
	private Deuda deuda;
	private EstadoAcuerdo estado;
	private Integer cantidadCuotas;
	private Long numeroReferencia;

}
