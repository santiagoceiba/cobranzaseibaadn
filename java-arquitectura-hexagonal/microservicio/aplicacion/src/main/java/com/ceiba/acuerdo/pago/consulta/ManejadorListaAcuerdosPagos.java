package com.ceiba.acuerdo.pago.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.acuerdo.pago.modelo.dto.DtoAcuerdoPago;
import com.ceiba.acuerdo.pago.puerto.dao.DaoAcuerdoPago;

@Component
public class ManejadorListaAcuerdosPagos {
	
	
	 private final DaoAcuerdoPago daoAcuerdoPago;

	    public ManejadorListaAcuerdosPagos(DaoAcuerdoPago daoAcuerdoPago){
	        this.daoAcuerdoPago = daoAcuerdoPago;
	    }

	    public List<DtoAcuerdoPago> ejecutar(){ return this.daoAcuerdoPago.listar(); }
}
