package com.ceiba.usuario.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.puerto.dao.DaoUsuario;

@Component
public class ManejadorListaAcuerdosPagos {
	
	
	 private final DaoUsuario daoUsuario;

	    public ManejadorListaAcuerdosPagos(DaoUsuario daoUsuario){
	        this.daoUsuario = daoUsuario;
	    }

	    public List<DtoUsuario> ejecutar(){ return this.daoUsuario.listar(); }
}
