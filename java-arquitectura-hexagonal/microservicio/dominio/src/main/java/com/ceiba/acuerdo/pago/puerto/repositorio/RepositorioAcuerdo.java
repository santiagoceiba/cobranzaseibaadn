package com.ceiba.acuerdo.pago.puerto.repositorio;

import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;

public interface RepositorioAcuerdo {
	
	/**
	 * Permite crear un AcuerdoPago
	 * @param AcuerdoPago
	 * @return el id generado
	 */
    Long crear(AcuerdoPago AcuerdoPago);
    
    /**
	 * Permite actualizar un AcuerdoPago
	 * @param AcuerdoPago
	 */
    void actualizar(AcuerdoPago AcuerdoPago);
    
   
    /**
     * Permite eliminar un AcuerdoPago
     * @param idAcuerdoPago
     */
    void eliminar(Long idAcuerdoPago);
    
    /**
     * Permite validar si existe una AcuerdoPago con id
     * @param idAcuerdoPago
     * @return si existe o no
     */
    boolean existe(Long numeroReferencia );
    
    AcuerdoPago consultarAcuerdoPorId(Long idAcuerdoPago);

    AcuerdoPago consultarAcuerdoPorNumeroReferencia(Long numeroReferencia);
    
}
