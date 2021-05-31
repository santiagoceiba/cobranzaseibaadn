package com.ceiba.acuerdo.pago.servicio;

import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;
import com.ceiba.acuerdo.pago.puerto.repositorio.RepositorioAcuerdo;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarAcuerdoPago {

	private final RepositorioAcuerdo repositorioAcuerdo;
	private static final String EL_ACUERDO_YA_EXISTE_EN_EL_SISTEMA = "El acuerdo ya existe en el sistema";

	public ServicioActualizarAcuerdoPago(RepositorioAcuerdo repositorioAcuerdo) {
		this.repositorioAcuerdo = repositorioAcuerdo;

	}

	public void ejecutar(AcuerdoPago acuerdoPago) {
		validarExistenciaPrevia(acuerdoPago);
		this.repositorioAcuerdo.actualizar(acuerdoPago);
	}

    private void validarExistenciaPrevia(AcuerdoPago acuerdoPago) {
        boolean existe = this.repositorioAcuerdo.existe(acuerdoPago.getIdAcuerdoPago());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_ACUERDO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

}
