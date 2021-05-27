package com.ceiba.usuario.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.ceiba.acuerdopago.utilidades.enumeracion.EstadoAcuerdoEnum;



public class AcuerdoPago {

	private static final String SE_DEBE_INGRESAR_LA_FECHA_ACUERDO = "Se debe ingresar la fecha de acuerdo del pago";
	private static final String SE_DEBE_INGRESAR_CUOTA = "Se debe ingresar el valor del monto de la cuota";
	private static final String SE_DEBE_INGRESAR_NOMERO_CUOTAS = "Se debe ingresar el número de cuotas acordadas";
	private static final String SE_DEBE_INGRESAR_NOMERO_REFERENCIA = "Se debe ingresar el número de referencia de pago";

	private Long idAcuerdoPago;
	private LocalDateTime fechaAcuerdo;
	private Double montoCuota;
	private Long cliente;
	private Long deuda;
	private EstadoAcuerdoEnum estado;
	private Integer cantidadCuotas;
	private Long numeroReferencia;

	public AcuerdoPago(Long idAcuerdoPago, LocalDateTime fechaAcuerdo, Double cuota, Long cliente, Long deuda, EstadoAcuerdoEnum estado,
			Integer cantidadCuotas, Long numeroReferencia) {
		
		validarObligatorio(fechaAcuerdo, SE_DEBE_INGRESAR_LA_FECHA_ACUERDO);
		validarObligatorio(montoCuota, SE_DEBE_INGRESAR_CUOTA);
		validarObligatorio(cantidadCuotas, SE_DEBE_INGRESAR_NOMERO_CUOTAS);
		validarObligatorio(numeroReferencia, SE_DEBE_INGRESAR_NOMERO_REFERENCIA);
		
		this.idAcuerdoPago = idAcuerdoPago;
		this.fechaAcuerdo = fechaAcuerdo;
		this.montoCuota = cuota;
		this.cliente = cliente;
		this.deuda = deuda;
		this.estado = estado;
		this.cantidadCuotas = cantidadCuotas;
		this.numeroReferencia = numeroReferencia;
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

	public LocalDateTime getFechaAcuerdo() {
		return fechaAcuerdo;
	}

	public void setFechaAcuerdo(LocalDateTime fechaAcuerdo) {
		this.fechaAcuerdo = fechaAcuerdo;
	}
	
	
	public Long getNumeroReferencia() {
		return numeroReferencia;
	}

	public void setNumeroReferencia(Long numeroReferencia) {
		this.numeroReferencia = numeroReferencia;
	}

	public Double getCuota() {
		return montoCuota;
	}

	public void setCuota(Double montoCuota) {
		this.montoCuota = montoCuota;
	}

	
	public Long getIdAcuerdoPago() {
		return idAcuerdoPago;
	}

	public void setIdAcuerdoPago(Long idAcuerdoPago) {
		this.idAcuerdoPago = idAcuerdoPago;
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

	public EstadoAcuerdoEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoAcuerdoEnum estado) {
		this.estado = estado;
	}

}
