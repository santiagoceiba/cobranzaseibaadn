package com.ceiba.acuerdo.pago.comando;

import java.time.LocalDateTime;

import com.ceiba.acuerdopago.utilidades.enumeracion.EstadoAcuerdoEnum;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.deuda.modelo.entidad.Deuda;



public class ComandoAcuerdoPago {
	
	private Long idAcuerdoPago;
	private LocalDateTime fechaAcuerdo;
	private Double montoCuota;
	private Cliente idCliente;
	private Deuda idDeuda;
	private EstadoAcuerdoEnum estado;
	private Integer cantidadCuotas;
	private Long numeroReferencia;
	

	public ComandoAcuerdoPago(Long idAcuerdoPago, LocalDateTime fechaAcuerdo, Double montoCuota, Cliente idCliente,
			Deuda idDeuda, EstadoAcuerdoEnum estado, Integer cantidadCuotas, Long numeroReferencia) {

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
	public Cliente getIdCliente() {
		return idCliente;
	}
	public void setCliente(Cliente cliente) {
		this.idCliente = cliente;
	}
	public Deuda getIdDeuda() {
		return idDeuda;
	}
	public void setDeuda(Deuda deuda) {
		this.idDeuda = deuda;
	}
	public EstadoAcuerdoEnum getEstado() {
		return estado;
	}
	public void setEstado(EstadoAcuerdoEnum estado) {
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
