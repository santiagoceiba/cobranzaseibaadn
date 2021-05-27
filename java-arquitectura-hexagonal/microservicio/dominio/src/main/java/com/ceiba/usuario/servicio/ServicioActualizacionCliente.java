package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Cliente;
import com.ceiba.usuario.puerto.repositorio.RepositorioCliente;

public class ServicioActualizacionCliente {
	
	
    private static final String EL_CLIENTE_YA_EXISTE_EN_EL_SISTEMA = "El cliente ya existe en el sistema";
    
	private final RepositorioCliente repositorioCliente;

    public ServicioActualizacionCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public void ejecutar(Cliente cliente) {
    	validarExistenciaPrevia(cliente);
        this.repositorioCliente.actualizar(cliente);
    }

	private void validarExistenciaPrevia(Cliente cliente) {
		boolean existe = this.repositorioCliente.existe(cliente.getNombre());
    	if(existe) {
    		throw new ExcepcionDuplicidad(EL_CLIENTE_YA_EXISTE_EN_EL_SISTEMA);
    	}
	}
}