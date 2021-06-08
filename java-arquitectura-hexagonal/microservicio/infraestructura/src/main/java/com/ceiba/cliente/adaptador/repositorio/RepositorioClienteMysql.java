package com.ceiba.cliente.adaptador.repositorio;

import com.ceiba.cliente.mapeo.MapeoCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioClienteMysql implements RepositorioCliente {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@SqlStatement(namespace = "cliente", value = "crear")
	private static String sqlCrear;

	@SqlStatement(namespace = "cliente", value = "actualizar")
	private static String sqlActualizar;


	@SqlStatement(namespace = "cliente", value = "existe")
	private static String sqlExiste;

	@SqlStatement(namespace = "cliente", value = "consultar")
	private static String sqlConsulta;

	public RepositorioClienteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(Cliente cliente) {
		return this.customNamedParameterJdbcTemplate.crear(cliente, sqlCrear);
	}


	@Override
	public void actualizar(Cliente cliente) {
		this.customNamedParameterJdbcTemplate.actualizar(cliente, sqlActualizar);
	}

	@Override
	public boolean existe(String cedula) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("cedula", cedula);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,
				paramSource, Boolean.class);
	}

	@Override
	public Cliente consultarCliente(Long idCliente) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("idCliente", idCliente);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlConsulta,
				paramSource, new MapeoCliente());
	}

}
