package com.ceiba.deuda.servicio;

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
		return this.repositorioDeuda.crear(deuda);
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
