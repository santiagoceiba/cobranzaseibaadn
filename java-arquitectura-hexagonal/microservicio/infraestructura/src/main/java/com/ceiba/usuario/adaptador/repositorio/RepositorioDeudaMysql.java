package com.ceiba.usuario.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Deuda;
import com.ceiba.usuario.puerto.repositorio.RepositorioDeuda;

@Repository
public class RepositorioDeudaMysql implements RepositorioDeuda {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@SqlStatement(namespace = "deuda", value = "crear")
	private static String sqlCrear;

	@SqlStatement(namespace = "deuda", value = "existe")
	private static String sqlExiste;

	public RepositorioDeudaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(Deuda deuda) {
		// TODO Auto-generated method stub
		return this.customNamedParameterJdbcTemplate.crear(deuda, sqlCrear);
	}

	@Override
	public boolean existe(Long idDeuda) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("idDeuda", idDeuda);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,
				paramSource, Boolean.class);
	}
}
