package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Deuda;

public interface RepositorioDeuda {
	
	
	/**
	 * Permite crear un deuda
	 * @param deuda
	 * @return el id generado
	 */
    Long crear(Deuda deuda);
    
    /**
	 * Permite actualizar un deuda
	 * @param deuda
	 */
    void actualizar(Deuda deuda);
    
    /**
     * Permite eliminar un deuda
     * @param iddeuda
     */
    void eliminar(Long idDeuda);
    
    /**
     * Permite validar si existe una deuda con id
     * @param iddeuda
     * @return si existe o no
     */
    boolean existe(Long idDeuda );
}
