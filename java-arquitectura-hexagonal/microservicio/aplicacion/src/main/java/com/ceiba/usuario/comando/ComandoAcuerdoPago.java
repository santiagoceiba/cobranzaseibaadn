package com.ceiba.usuario.comando;

import java.time.LocalDate;

import com.ceiba.usuario.modelo.entidad.Cliente;
import com.ceiba.usuario.modelo.entidad.Deuda;



public class ComandoAcuerdoPago {
	
	
	private LocalDate fechaAcuerdo;
	private Double montoCuota;
	private Cliente cliente;
	private Deuda deuda;
	private Boolean estado;
	private Integer cantidadCuotas;
	
	
	public LocalDate getFechaAcuerdo() {
		return fechaAcuerdo;
	}
	public void setFechaAcuerdo(LocalDate fechaAcuerdo) {
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
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public Integer getCantidadCuotas() {
		return cantidadCuotas;
	}
	public void setCantidadCuotas(Integer cantidadCuotas) {
		this.cantidadCuotas = cantidadCuotas;
	}
	
	public ComandoAcuerdoPago(LocalDate fechaAcuerdo, Double montoCuota, Cliente cliente, Deuda deuda, Boolean estado,
			Integer cantidadCuotas) {
		super();
		this.fechaAcuerdo = fechaAcuerdo;
		this.montoCuota = montoCuota;
		this.cliente = cliente;
		this.deuda = deuda;
		this.estado = estado;
		this.cantidadCuotas = cantidadCuotas;
	}
	
	
}
