package com.ceiba.acuerdo.pago.consulta;

import java.util.List;

import com.ceiba.acuerdo.pago.puerto.dao.DaoAcuerdoPago;
import org.springframework.stereotype.Component;

import com.ceiba.acuerdo.pago.modelo.dto.DtoAcuerdoPago;


@Component
public class ManejadorListaAcuerdosPagos {
	
	
	 private final DaoAcuerdoPago daoAcuerdoPago;

	    public ManejadorListaAcuerdosPagos(DaoAcuerdoPago daoAcuerdoPago){
	        this.daoAcuerdoPago = daoAcuerdoPago;
	    }

	    public List<DtoAcuerdoPago> ejecutar(){ return this.daoAcuerdoPago.listar(); }
}
