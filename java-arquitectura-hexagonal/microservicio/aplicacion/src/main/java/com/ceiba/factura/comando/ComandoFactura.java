package com.ceiba.factura.comando;

import java.time.LocalDateTime;

import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;

public class ComandoFactura {

	private Long idFactura;
	private Double montoCuota;
	private LocalDateTime fechaCaducidad;
	private AcuerdoPago acuerdoPago;
	private Boolean estado;
	
	
	public ComandoFactura(Long idFactura, Double montoCuota, LocalDateTime fechaCaducidad, AcuerdoPago acuerdoPago, Boolean estado) {
		super();
		this.idFactura = idFactura;
		this.montoCuota = montoCuota;
		this.fechaCaducidad = fechaCaducidad;
		this.acuerdoPago = acuerdoPago;
		this.estado = estado;
	}

	

	public ComandoFactura() {
		super();
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


	public AcuerdoPago getAcuerdoPago() {
		return acuerdoPago;
	}


	public void setAcuerdoPago(AcuerdoPago acuerdoPago) {
		this.acuerdoPago = acuerdoPago;
	}


	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
}
