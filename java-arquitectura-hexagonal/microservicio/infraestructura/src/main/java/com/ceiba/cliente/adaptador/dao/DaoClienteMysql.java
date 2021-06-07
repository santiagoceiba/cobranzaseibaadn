package com.ceiba.cliente.adaptador.dao;

import java.util.List;

import com.ceiba.cliente.adaptador.mapeo.MapeoAcuerdoPago;
import com.ceiba.cliente.adaptador.mapeo.MapeoCliente;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.deuda.puerto.repositorio.RepositorioDeuda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.acuerdo.pago.modelo.dto.DtoAcuerdoPago;
import com.ceiba.acuerdo.pago.puerto.dao.DaoAcuerdoPago;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Component
public class DaoClienteMysql implements DaoCliente {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;


	@SqlStatement(namespace = "cliente", value = "listar")
	private static String sqlListar;

	public DaoClienteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public List<DtoCliente> listar() {
	  return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoCliente());
	}


	
	

}
