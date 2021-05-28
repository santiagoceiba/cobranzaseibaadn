package com.ceiba.usuario.adaptador.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.dto.DtoAcuerdoPago;
import com.ceiba.usuario.puerto.dao.DaoAcuerdoPago;

@Component
public class DaoClienteMysql implements DaoAcuerdoPago {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@SqlStatement(namespace = "acuerdo", value = "listar")
	private static String sqlListar;

	public DaoClienteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public List<DtoAcuerdoPago> listar() {
		// TODO Auto-generated method stub
	  return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoAcuerdoPago());
	}


	
	

}
