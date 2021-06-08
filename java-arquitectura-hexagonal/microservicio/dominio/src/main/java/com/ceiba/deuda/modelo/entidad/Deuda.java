package com.ceiba.deuda.modelo.entidad;

import com.ceiba.cliente.modelo.entidad.Cliente;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

public class Deuda implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SE_DEBE_INGRESAR_MONTO = "Se debe ingresar el monto de la cuota del cliente";
	private static final String SE_DEBE_INGRESAR_FECHA_DEUDA = "Se debe ingresar la fecha en la que el cliente inicio la deuda";
	private static final String SE_DEBE_INGRESAR_NOMBRE_ENTIDAD_DEUDA = "Se debe ingresar el  nombre de la entidad a la que se debe la mora";
	private static final String SE_DEBE_INGRESAR_CONCEPTO_CUOTA = "Se debe ingresar el concepto por el cual se debe la mora";
	private static Integer DIAS_ANIO = 365;
	private static Double PORCENTAJE_AUMENTO = 1.01;
	private Long idDeuda;
	private Double monto;
	private LocalDateTime fechaInicialDeudaCliente;
	private String nombreEntidadDeuda;
	private String conceptoDeuda;
	private Cliente idCliente;

	public Deuda(Double monto, LocalDateTime fechaInicialDeudaCliente, String nombreEntidadDeuda, String conceptoDeuda,
			Cliente idCliente, Long idDeuda) {
		validarObligatorio(fechaInicialDeudaCliente, SE_DEBE_INGRESAR_FECHA_DEUDA);
		validarObligatorio(nombreEntidadDeuda, SE_DEBE_INGRESAR_NOMBRE_ENTIDAD_DEUDA);
		validarObligatorio(conceptoDeuda, SE_DEBE_INGRESAR_CONCEPTO_CUOTA);
		validarObligatorio(monto, SE_DEBE_INGRESAR_MONTO);

		this.monto = monto;
		this.fechaInicialDeudaCliente = fechaInicialDeudaCliente;
		this.nombreEntidadDeuda = nombreEntidadDeuda;
		this.conceptoDeuda = conceptoDeuda;
		this.idCliente = idCliente;
		this.idDeuda = idDeuda;
		validarAumentoPorAntiguedadDeuda();
	}

	public Long getIdDeuda() {
		return idDeuda;
	}

	public Double getMonto() {
		return monto;
	}

	public LocalDateTime getFechaInicialDeudaCliente() {
		return fechaInicialDeudaCliente;
	}

	public String getNombreEntidadDeuda() {
		return nombreEntidadDeuda;
	}

	public String getConceptoDeuda() {
		return conceptoDeuda;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	private void validarAumentoPorAntiguedadDeuda() {
		Long diferenciaDias = encontrarDiferenciaFechas(this.fechaInicialDeudaCliente, LocalDateTime.now());

		if (diferenciaDias > DIAS_ANIO) {
			this.setMonto(this.monto * (PORCENTAJE_AUMENTO));
		}

	}

	private Long encontrarDiferenciaFechas(LocalDateTime fechaInicialDeuda, LocalDateTime fechaActual) {

		long diferenciaMiliSegundos = Duration.between(fechaInicialDeuda, fechaActual).toMillis();
		long diferenciaHoras = TimeUnit.MILLISECONDS.toHours(diferenciaMiliSegundos);
		return diferenciaHoras / 24;

	}
	
}
