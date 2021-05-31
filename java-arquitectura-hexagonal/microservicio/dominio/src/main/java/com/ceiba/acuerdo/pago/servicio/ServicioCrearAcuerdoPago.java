package com.ceiba.acuerdo.pago.servicio;

import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;
import com.ceiba.acuerdo.pago.puerto.repositorio.RepositorioAcuerdo;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearAcuerdoPago {
	
	
	 private static final String EL_ACUERDO_YA_EXISTE_EN_EL_SISTEMA = "El acuerdo ya existe en el sistema";

	    private final RepositorioAcuerdo repositorioAcuerdo;

	    public ServicioCrearAcuerdoPago( RepositorioAcuerdo repositorioAcuerdo) {
	        this.repositorioAcuerdo = repositorioAcuerdo;
	    }

	    public Long ejecutar(AcuerdoPago acuerdo) {
	        validarExistenciaPrevia(acuerdo);
	        return this.repositorioAcuerdo.crear(acuerdo);
	    }

	    private void validarExistenciaPrevia(AcuerdoPago acuerdo) {
	        boolean existe = this.repositorioAcuerdo.existe(acuerdo.getIdAcuerdoPago());
	        if(existe) {
	            throw new ExcepcionDuplicidad(EL_ACUERDO_YA_EXISTE_EN_EL_SISTEMA);
	        }
	    }
}
