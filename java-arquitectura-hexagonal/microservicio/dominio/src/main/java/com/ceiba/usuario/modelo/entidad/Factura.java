package com.ceiba.usuario.modelo.entidad;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Factura {
	
	private Long idFactura;
	private Double montoCuota;
	private LocalDateTime fechaCaducidad;
	private Long acuerdoPago;
	private Boolean estado;
	
	
	public Factura(Long idFactura, Double montoCuota, LocalDateTime fechaCaducidad, Long acuerdoPago, Boolean estado) {
		super();
		this.idFactura = idFactura;
		this.montoCuota = montoCuota;
		this.fechaCaducidad = fechaCaducidad;
		this.acuerdoPago = acuerdoPago;
		this.estado = estado;
	}


	public Long getIdFactura() {
		return idFactura;
	}


	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}


	public Double getMontoCuota() {
		return montoCuota;
	}


	public void setMontoCuota(Double montoCuota) {
		this.montoCuota = montoCuota;
	}


	public LocalDateTime getFechaCaducidad() {
		return fechaCaducidad;
	}


	public void setFechaCaducidad(LocalDateTime fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}


	public Long getAcuerdoPago() {
		return acuerdoPago;
	}


	public void setAcuerdoPago(Long acuerdoPago) {
		this.acuerdoPago = acuerdoPago;
	}


	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
	
}
