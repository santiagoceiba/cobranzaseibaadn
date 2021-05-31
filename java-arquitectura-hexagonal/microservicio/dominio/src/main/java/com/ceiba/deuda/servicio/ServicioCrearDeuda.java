package com.ceiba.deuda.servicio;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import com.ceiba.deuda.modelo.entidad.Deuda;
import com.ceiba.deuda.puerto.repositorio.RepositorioDeuda;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearDeuda {

	private static final String LA_DEUDA_YA_EXISTE_EN_EL_SISTEMA = "La deuda ya existe en el sistema";

	private final RepositorioDeuda repositorioDeuda;

	public ServicioCrearDeuda(RepositorioDeuda repositorioDeuda) {
		this.repositorioDeuda = repositorioDeuda;
	}

	public Long ejecutar(Deuda deuda) {
		validarExistenciaPrevia(deuda);
		validarAumentoPorAntiguedadDeuda(deuda);
		return this.repositorioDeuda.crear(deuda);
	}

	/**
	 * Método que permite hacer el incremento del monto de deuda siempre que la mora
	 * sea mayor a un año
	 * 
	 * @param deuda
	 */
	private void validarAumentoPorAntiguedadDeuda(Deuda deuda) {
		Long diferenciaDias = encontrarDiferenciaFechas(deuda.getFechaInicialDeudaCliente(), LocalDateTime.now());

		if (diferenciaDias > 365) {
			deuda.setMonto(deuda.getMonto() * (1.01));
		}

	}

	/**
	 * método que permite encontrar la diferecia entre dos fechas
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

	/**
	 * método que permite validar si un usario existe antes de agregarlo
	 * 
	 * @param deuda
	 */
	private void validarExistenciaPrevia(Deuda deuda) {
		boolean existe = this.repositorioDeuda.existe(deuda.getIdDeuda());
		if (existe) {
			throw new ExcepcionDuplicidad(LA_DEUDA_YA_EXISTE_EN_EL_SISTEMA);
		}
	}
}
