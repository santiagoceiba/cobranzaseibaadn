package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Deuda;
import com.ceiba.usuario.puerto.repositorio.RepositorioDeuda;

public class ServicioActualizacionDeuda {
	
	
    private static final String EL_CLIENTE_YA_EXISTE_EN_EL_SISTEMA = "El cliente ya existe en el sistema";
    
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
    	if(existe) {
    		throw new ExcepcionDuplicidad(EL_CLIENTE_YA_EXISTE_EN_EL_SISTEMA);
    	}
	}
}
