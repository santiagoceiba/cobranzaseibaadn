package com.ceiba.acuerdo.pago.puerto.dao;

import com.ceiba.acuerdo.pago.modelo.dto.DtoAcuerdoPago;

import java.util.List;

public interface DaoAcuerdoPago {
	
	
	/**
     * Permite listar los acuerdos
     * @return los usuarios
     */
    List<DtoAcuerdoPago> listar();
    

}
