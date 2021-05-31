package com.ceiba.deuda.modelo.entidad;



import static com.ceiba.dominio.ValidadorArgumento.validarFecha;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import com.ceiba.cliente.modelo.entidad.Cliente;



public class Deuda implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private static final String SE_DEBE_INGRESAR_MONTO = "Se debe ingresar el monto de la cuota del cliente";
	private static final String SE_DEBE_INGRESAR_FECHA_DEUDA = "Se debe ingresar la fecha en la que el cliente inicio la deuda";
	private static final String SE_DEBE_INGRESAR_NOMBRE_ENTIDAD_DEUDA = "Se debe ingresar el  nombre de la entidad a la que se debe la mora";
	private static final String SE_DEBE_INGRESAR_CONCEPTO_CUOTA = "Se debe ingresar el concepto por el cual se debe la mora";
	private static final String SE_DEBE_INGRESAR_UNA_FECHA_VALIDA = "La fecha ingresada es mayor a la fecha actual";

	private Long idDeuda;
	private Double monto;
	private LocalDateTime fechaInicialDeudaCliente;
	private String nombreEntidadDeuda;
	private String conceptoDeuda;
	private Cliente idCliente;
	
	
	
	public Deuda(Double monto, LocalDateTime fechaInicialDeudaCliente, String nombreEntidadDeuda, String conceptoDeuda,
			Cliente idCliente, Long idDeuda) {
		validarFecha(fechaInicialDeudaCliente, SE_DEBE_INGRESAR_UNA_FECHA_VALIDA);
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
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public LocalDateTime getFechaInicialDeudaCliente() {
		return fechaInicialDeudaCliente;
	}
	public void setFechaInicialDeudaCliente(LocalDateTime fechaInicialDeudaCliente) {
		this.fechaInicialDeudaCliente = fechaInicialDeudaCliente;
	}
	public String getNombreEntidadDeuda() {
		return nombreEntidadDeuda;
	}
	public void setNombreEntidadDeuda(String nombreEntidadDeuda) {
		this.nombreEntidadDeuda = nombreEntidadDeuda;
	}
	public String getConceptoDeuda() {
		return conceptoDeuda;
	}
	public void setConceptoDeuda(String conceptoDeuda) {
		this.conceptoDeuda = conceptoDeuda;
	}
	public Cliente getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * M�todo que permite hacer el incremento del monto de deuda siempre que la mora
	 * sea mayor a un a�o
	 * 
	 * @param deuda
	 */
	private void validarAumentoPorAntiguedadDeuda() {
		Long diferenciaDias = encontrarDiferenciaFechas(this.fechaInicialDeudaCliente, LocalDateTime.now());

		if (diferenciaDias > 365) {
			this.setMonto(this.monto * (1.01));
		}

	}

	/**
	 * m�todo que permite encontrar la diferecia entre dos fechas
	 * 
	 * @param fechaInicialDeuda
	 * @param fechaActual
	 */
	// TODO buscar mejos manera de encontrar la diferencia
	private Long encontrarDiferenciaFechas(LocalDateTime fechaInicialDeuda, LocalDateTime fechaActual) {

		long diferenciaMiliSegundos = Duration.between(fechaInicialDeuda, fechaActual).toMillis();
		long diferenciaHoras = TimeUnit.MILLISECONDS.toHours(diferenciaMiliSegundos);
		long diferenciaDias = diferenciaHoras / 24;
		return diferenciaDias;

	}

	public Deuda() {
	}
	
	
	
}
