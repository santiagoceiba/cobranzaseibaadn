package com.ceiba.factura.modelo.entidad;

import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

public class Factura implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SE_DEBE_INGRESAR_MONTO_CUOTA = "Se debe ingresar el monto de la cuota";
	private static final int NUMERO_DIAS_CADUCIDAD = 5;

	private Long idFactura;
	private Double montoCuota;
	private LocalDateTime fechaCaducidad;
	private AcuerdoPago acuerdoPago;
	private Boolean estado;

	public Factura(Long idFactura, Double montoCuota, LocalDateTime fechaCaducidad, AcuerdoPago acuerdoPago) {
		validarObligatorio(montoCuota, SE_DEBE_INGRESAR_MONTO_CUOTA);

		this.idFactura = idFactura;
		this.montoCuota = montoCuota;
		this.fechaCaducidad = fechaCaducidad;
		this.acuerdoPago = acuerdoPago;
		this.estado = false;
	}

	public Long getIdFactura() {
		return idFactura;
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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	private Long encontrarDiferenciaFechas(LocalDateTime fechaInicialDeuda, LocalDateTime fechaActual) {

		long diferenciaMiliSegundos = Duration.between(fechaInicialDeuda, fechaActual).toMillis();
		long diferenciaHoras = TimeUnit.MILLISECONDS.toHours(diferenciaMiliSegundos);
		return diferenciaHoras / 24;

	}

	/**
	 * método que permite definir si una factura se encuentra vencida por un número
	 * > a 5
	 */
	public Boolean esFacturaAlDia() {
		LocalDateTime fechaActual = LocalDateTime.now();
		Long diferenciaDiasFechas = encontrarDiferenciaFechas(this.fechaCaducidad, fechaActual);
		if (diferenciaDiasFechas > NUMERO_DIAS_CADUCIDAD && this.estado == Boolean.FALSE) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
}
