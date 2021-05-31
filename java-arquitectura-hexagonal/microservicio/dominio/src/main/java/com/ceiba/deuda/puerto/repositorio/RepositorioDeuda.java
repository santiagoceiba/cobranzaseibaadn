package com.ceiba.deuda.puerto.repositorio;

import com.ceiba.deuda.modelo.entidad.Deuda;

public interface RepositorioDeuda {
	
	
	/**
	 * Permite crear un deuda
	 * @param deuda
	 * @return el id generado
	 */
    Long crear(Deuda deuda);
    
    
    /**
     * Permite validar si existe una deuda con id
     * @param iddeuda
     * @return si existe o no
     */
    boolean existe(Long idDeuda );
}
