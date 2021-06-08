package com.ceiba.acuerdo.pago.puerto.repositorio;

import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;

import java.util.List;

public interface RepositorioAcuerdo {
	
	/**
	 * Permite crear un AcuerdoPago
	 * @param acuerdoPago
	 * @return el id generado
	 */
    Long crear(AcuerdoPago acuerdoPago);
    
    /**
	 * Permite actualizar un AcuerdoPago
	 * @param acuerdoPago
	 */
    void actualizar(AcuerdoPago acuerdoPago);

    List<AcuerdoPago> listarAcuerdosPago();

    
    /**
     * Permite validar si existe una AcuerdoPago con id
     * @param numeroReferencia
     * @return si existe o no
     */
    boolean existe(Long numeroReferencia );
    
    AcuerdoPago consultarAcuerdoPorId(Long idAcuerdoPago);

    AcuerdoPago consultarAcuerdoPorNumeroReferencia(Long numeroReferencia);
    
}
