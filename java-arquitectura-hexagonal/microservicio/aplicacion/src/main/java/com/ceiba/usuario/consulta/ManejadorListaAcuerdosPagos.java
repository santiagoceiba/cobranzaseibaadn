package com.ceiba.usuario.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.usuario.modelo.dto.DtoAcuerdoPago;
import com.ceiba.usuario.puerto.dao.DaoAcuerdoPago;

@Component
public class ManejadorListaAcuerdosPagos {
	
	
	 private final DaoAcuerdoPago daoAcuerdoPago;

	    public ManejadorListaAcuerdosPagos(DaoAcuerdoPago daoAcuerdoPago){
	        this.daoAcuerdoPago = daoAcuerdoPago;
	    }

	    public List<DtoAcuerdoPago> ejecutar(){ return this.daoAcuerdoPago.listar(); }
}
