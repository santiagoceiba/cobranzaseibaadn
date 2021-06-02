package com.ceiba.deuda.servicio;

import com.ceiba.deuda.modelo.entidad.Deuda;
import com.ceiba.deuda.puerto.repositorio.RepositorioDeuda;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizacionDeuda {
	
	
    private static final String EL_CLIENTE_NO_EXISTE_EN_EL_SISTEMA = "El cliente no se puede actualizar porque no existe en el sistema";
    
	private final RepositorioDeuda repositorioDeuda;

    public ServicioActualizacionDeuda(RepositorioDeuda repositorioDeuda) {
        this.repositorioDeuda = repositorioDeuda;
    }

    public void ejecutar(Deuda deuda) {
    	validarExistenciaPrevia(deuda);
        this.repositorioDeuda.actualizar(deuda);
    }

	private void validarExistenciaPrevia(Deuda deuda) {
		boolean existe = this.repositorioDeuda.existe(deuda.getIdDeuda());
    	if(!existe) {
    		throw new ExcepcionDuplicidad(EL_CLIENTE_NO_EXISTE_EN_EL_SISTEMA);
    	}
	}
}
