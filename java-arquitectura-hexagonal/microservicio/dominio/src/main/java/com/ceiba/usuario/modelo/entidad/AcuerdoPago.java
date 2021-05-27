package com.ceiba.usuario.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import java.time.LocalDate;



public class AcuerdoPago {

	private static final String SE_DEBE_INGRESAR_LA_FECHA_ACUERDO = "Se debe ingresar la fecha de acuerdo del pago";
	private static final String SE_DEBE_INGRESAR_CUOTA = "Se debe ingresar el valor del monto de la cuota";
	private static final String SE_DEBE_INGRESAR_NOMERO_CUOTAS = "Se debe ingresar el número de cuotas acordadas";

	
	private LocalDate fechaAcuerdo;
	private Double montoCuota;
	private Cliente cliente;
	private Deuda deuda;
	private Boolean estado;
	private Integer cantidadCuotas;

	public AcuerdoPago(LocalDate fechaAcuerdo, Double cuota, Cliente cliente, Deuda deuda, Boolean estado,
			Integer cantidadCuotas) {
		
		validarObligatorio(fechaAcuerdo, SE_DEBE_INGRESAR_LA_FECHA_ACUERDO);
		validarObligatorio(montoCuota, SE_DEBE_INGRESAR_CUOTA);
		validarObligatorio(cantidadCuotas, SE_DEBE_INGRESAR_NOMERO_CUOTAS);
		
		
		this.fechaAcuerdo = fechaAcuerdo;
		this.montoCuota = cuota;
		this.cliente = cliente;
		this.deuda = deuda;
		this.estado = estado;
		this.cantidadCuotas = cantidadCuotas;
	}

	public Double getMontoCuota() {
		return montoCuota;
	}

	public void setMontoCuota(Double montoCuota) {
		this.montoCuota = montoCuota;
	}

	public Integer getCantidadCuotas() {
		return cantidadCuotas;
	}

	public void setCantidadCuotas(Integer cantidadCuotas) {
		this.cantidadCuotas = cantidadCuotas;
	}

	public LocalDate getFechaAcuerdo() {
		return fechaAcuerdo;
	}

	public void setFechaAcuerdo(LocalDate fechaAcuerdo) {
		this.fechaAcuerdo = fechaAcuerdo;
	}

	public Double getCuota() {
		return montoCuota;
	}

	public void setCuota(Double montoCuota) {
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

}
