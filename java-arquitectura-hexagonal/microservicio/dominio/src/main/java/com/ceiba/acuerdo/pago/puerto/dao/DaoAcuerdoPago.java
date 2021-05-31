package com.ceiba.acuerdo.pago.puerto.dao;

import java.util.List;

import com.ceiba.acuerdo.pago.modelo.dto.DtoAcuerdoPago;

public interface DaoAcuerdoPago {
	
	
	/**
     * Permite listar los acuerdos
     * @return los usuarios
     */
    List<DtoAcuerdoPago> listar();
    

}
