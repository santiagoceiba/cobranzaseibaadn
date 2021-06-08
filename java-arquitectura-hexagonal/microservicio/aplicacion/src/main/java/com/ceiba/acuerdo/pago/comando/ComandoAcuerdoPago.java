package com.ceiba.acuerdo.pago.comando;

import com.ceiba.acuerdopago.utilidades.enumeracion.EstadoAcuerdo;

import java.time.LocalDateTime;



public class ComandoAcuerdoPago {
	
	private Long idAcuerdoPago;
	private LocalDateTime fechaAcuerdo;
	private Double montoCuota;
	private Long idCliente;
	private Long idDeuda;
	private EstadoAcuerdo estado;
	private Integer cantidadCuotas;
	private Long numeroReferencia;
	

	public ComandoAcuerdoPago(Long idAcuerdoPago, LocalDateTime fechaAcuerdo, Double montoCuota, Long idCliente,
			Long idDeuda, EstadoAcuerdo estado, Integer cantidadCuotas, Long numeroReferencia) {

		this.idAcuerdoPago = idAcuerdoPago;
		this.fechaAcuerdo = fechaAcuerdo;
		this.montoCuota = montoCuota;
		this.idCliente = idCliente;
		this.idDeuda = idDeuda;
		this.estado = estado;
		this.cantidadCuotas = cantidadCuotas;
		this.numeroReferencia = numeroReferencia;
	}
	
	
	
	public ComandoAcuerdoPago() {
	}



	public Long getIdAcuerdoPago() {
		return idAcuerdoPago;
	}
	public void setIdAcuerdoPago(Long idAcuerdoPago) {
		this.idAcuerdoPago = idAcuerdoPago;
	}
	
	public LocalDateTime getFechaAcuerdo() {
		return fechaAcuerdo;
	}
	public void setFechaAcuerdo(LocalDateTime fechaAcuerdo) {
		this.fechaAcuerdo = fechaAcuerdo;
	}
	public Double getMontoCuota() {
		return montoCuota;
	}
	public void setMontoCuota(Double montoCuota) {
		this.montoCuota = montoCuota;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setCliente(Long cliente) {
		this.idCliente = cliente;
	}
	public Long getIdDeuda() {
		return idDeuda;
	}
	public void setDeuda(Long deuda) {
		this.idDeuda = deuda;
	}
	public EstadoAcuerdo getEstado() {
		return estado;
	}
	public void setEstado(EstadoAcuerdo estado) {
		this.estado = estado;
	}
	public Integer getCantidadCuotas() {
		return cantidadCuotas;
	}
	public void setCantidadCuotas(Integer cantidadCuotas) {
		this.cantidadCuotas = cantidadCuotas;
	}
	public Long getNumeroReferencia() {
		return numeroReferencia;
	}
	public void setNumeroReferencia(Long numeroReferencia) {
		this.numeroReferencia = numeroReferencia;
	}
	

}
