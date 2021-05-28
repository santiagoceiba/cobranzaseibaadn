package com.ceiba.usuario.puerto.dao;

import java.util.List;

import com.ceiba.usuario.modelo.dto.DtoAcuerdoPago;

public interface DaoAcuerdoPago {
	
	
	/**
     * Permite listar los acuerdos
     * @return los usuarios
     */
    List<DtoAcuerdoPago> listar();
    

}
