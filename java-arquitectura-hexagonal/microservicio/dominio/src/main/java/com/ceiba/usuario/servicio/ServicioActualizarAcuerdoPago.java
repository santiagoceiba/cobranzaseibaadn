package com.ceiba.usuario.servicio;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.ceiba.acuerdopago.utilidades.enumeracion.EstadoAcuerdoEnum;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.dto.DtoFactura;
import com.ceiba.usuario.modelo.entidad.AcuerdoPago;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.dao.DaoFactura;
import com.ceiba.usuario.puerto.repositorio.RepositorioAcuerdo;

public class ServicioActualizarAcuerdoPago {

	private final RepositorioAcuerdo repositorioAcuerdo;
	private final DaoFactura daoFactura;
	private static final int NUMERO_DIAS_CADUCIDAD = 5;
	private static final String EL_ACUERDO_YA_EXISTE_EN_EL_SISTEMA = "El acuerdo ya existe en el sistema";

	public ServicioActualizarAcuerdoPago(RepositorioAcuerdo repositorioAcuerdo, DaoFactura daoFactura) {
		this.repositorioAcuerdo = repositorioAcuerdo;
		this.daoFactura = daoFactura;
	}

	public void ejecutar(AcuerdoPago acuerdoPago) {
		validarExistenciaPrevia(acuerdoPago);
		this.repositorioAcuerdo.actualizar(acuerdoPago);
	}

	public void ejecutarTareaJuridicos(AcuerdoPago acuerdoPago) {
		if (acuerdoPago.getEstado().equals("A")) {
			List<DtoFactura> listaFacturas = this.daoFactura.listarFacturaPorAcuerdo(acuerdoPago.getIdAcuerdoPago());
			if (obtenerNumeroAcuerdosVencidos(listaFacturas) > 2) {
				acuerdoPago.setEstado("CJ");
				this.repositorioAcuerdo.actualizar(acuerdoPago);
			}
		}
	}

	/**
	 * Método que me permite conocer la cantidad de facturas que un acuerdo tiene
	 * vencidas
	 * 
	 * @param listaFacturas
	 * @return
	 */
	private int obtenerNumeroAcuerdosVencidos(List<DtoFactura> listaFacturas) {
		int contarFacturasVencidas = 0;
		for (DtoFactura dtoFactura : listaFacturas) {
			LocalDateTime fechaActual = LocalDateTime.now();
			Long diferenciaDiasFechas = encontrarDiferenciaFechas(fechaActual, dtoFactura.getFechaCaducidad());
			if (diferenciaDiasFechas > NUMERO_DIAS_CADUCIDAD && dtoFactura.getEstado() == Boolean.FALSE) {
				contarFacturasVencidas++;
			}
		}

		return contarFacturasVencidas;
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
	

    private void validarExistenciaPrevia(AcuerdoPago acuerdoPago) {
        boolean existe = this.repositorioAcuerdo.existe(acuerdoPago.getIdAcuerdoPago());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_ACUERDO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

}
