package com.ceiba.usuario.modelo.dto;

import java.time.LocalDateTime;

import com.ceiba.acuerdopago.utilidades.enumeracion.EstadoAcuerdoEnum;

public class DtoAcuerdoPago {
	
	private Long idAcuerdoPago;
	private LocalDateTime fechaAcuerdo;
	private Double montoCuota;
	private Long cliente;
	private Long deuda;
	private String estado;
	private Integer cantidadCuotas;
	private Long numeroReferencia;
	
	
	
	public DtoAcuerdoPago(Long idAcuerdoPago, LocalDateTime fechaAcuerdo, Double montoCuota, Long cliente, Long deuda,
			String estado, Integer cantidadCuotas, Long numeroReferencia) {
		super();
		this.idAcuerdoPago = idAcuerdoPago;
		this.fechaAcuerdo = fechaAcuerdo;
		this.montoCuota = montoCuota;
		this.cliente = cliente;
		this.deuda = deuda;
		this.estado = estado;
		this.cantidadCuotas = cantidadCuotas;
		this.numeroReferencia = numeroReferencia;
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
	public Long getCliente() {
		return cliente;
	}
	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}
	public Long getDeuda() {
		return deuda;
	}
	public void setDeuda(Long deuda) {
		this.deuda = deuda;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
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
