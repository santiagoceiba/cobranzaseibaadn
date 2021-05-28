package com.ceiba.usuario.puerto.dao;

import java.util.List;

import com.ceiba.usuario.modelo.dto.DtoFactura;

public interface DaoFactura {

	
	List<DtoFactura> listarFacturaPorAcuerdo(Long idAcuerdoPago);
}
