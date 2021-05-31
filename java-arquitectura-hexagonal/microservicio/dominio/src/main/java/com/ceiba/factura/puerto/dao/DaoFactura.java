package com.ceiba.factura.puerto.dao;

import java.util.List;

import com.ceiba.factura.modelo.dto.DtoFactura;

public interface DaoFactura {

	
	List<DtoFactura> listarFacturaPorAcuerdo(Long idAcuerdoPago);
}
