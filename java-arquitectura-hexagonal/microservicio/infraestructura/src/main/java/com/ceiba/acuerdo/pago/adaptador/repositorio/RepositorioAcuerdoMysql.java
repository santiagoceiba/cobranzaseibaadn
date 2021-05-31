package com.ceiba.acuerdo.pago.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;
import com.ceiba.acuerdo.pago.puerto.repositorio.RepositorioAcuerdo;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Repository
public class RepositorioAcuerdoMysql implements RepositorioAcuerdo {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@SqlStatement(namespace = "acuerdo", value = "crear")
	private static String sqlCrear;

	@SqlStatement(namespace = "acuerdo", value = "existe")
	private static String sqlExiste;



	public RepositorioAcuerdoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(AcuerdoPago AcuerdoPago) {
		// TODO Auto-generated method stub
		return this.customNamedParameterJdbcTemplate.crear(AcuerdoPago, sqlCrear);
	}

	@Override
	public void actualizar(AcuerdoPago AcuerdoPago) {
		// TODO Auto-generated method stub

	}


	@Override
	public boolean existe(Long idAcuerdoPago) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("idAcuerdoPago", idAcuerdoPago);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,
				paramSource, Boolean.class);
	}


	@Override
	public void eliminar(Long idAcuerdoPago) {
		// TODO Auto-generated method stub

	}
}
