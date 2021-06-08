package com.ceiba.acuerdo.pago.consulta;

import com.ceiba.acuerdo.pago.modelo.dto.DtoAcuerdoPago;
import com.ceiba.acuerdo.pago.puerto.dao.DaoAcuerdoPago;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ManejadorListaAcuerdosPagos {
	
	
	 private final DaoAcuerdoPago daoAcuerdoPago;

	    public ManejadorListaAcuerdosPagos(DaoAcuerdoPago daoAcuerdoPago){
	        this.daoAcuerdoPago = daoAcuerdoPago;
	    }

	    public List<DtoAcuerdoPago> ejecutar(){ return this.daoAcuerdoPago.listar(); }
}
