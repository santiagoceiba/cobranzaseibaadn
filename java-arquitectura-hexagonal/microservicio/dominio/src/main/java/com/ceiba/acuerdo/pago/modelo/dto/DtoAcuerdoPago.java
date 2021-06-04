package com.ceiba.acuerdo.pago.modelo.dto;

import java.time.LocalDateTime;

import com.ceiba.acuerdopago.utilidades.enumeracion.EstadoAcuerdo;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.deuda.modelo.entidad.Deuda;

public class DtoAcuerdoPago {
	
	private Long idAcuerdoPago;
	private LocalDateTime fechaAcuerdo;
	private Double montoCuota;
	private Cliente cliente;
	private Deuda deuda;
	private EstadoAcuerdo estado;
	private Integer cantidadCuotas;
	private Long numeroReferencia;
	
	
	
	public DtoAcuerdoPago(Long idAcuerdoPago, LocalDateTime fechaAcuerdo, Double montoCuota, Cliente cliente, Deuda deuda,
			EstadoAcuerdo estado, Integer cantidadCuotas, Long numeroReferencia) {
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Deuda getDeuda() {
		return deuda;
	}
	public void setDeuda(Deuda deuda) {
		this.deuda = deuda;
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
