package com.ceiba.deuda.adaptador.repositorio;


import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ceiba.deuda.mapeo.MapeoDeuda;
import com.ceiba.deuda.modelo.entidad.Deuda;
import com.ceiba.deuda.puerto.repositorio.RepositorioDeuda;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Repository
public class RepositorioDeudaMysql implements RepositorioDeuda {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
	
	@Autowired
	private RepositorioCliente repositorioCliente;

	@SqlStatement(namespace = "deuda", value = "crear")
	private static String sqlCrear;

	@SqlStatement(namespace = "deuda", value = "existe")
	private static String sqlExiste;
	
    
    @SqlStatement(namespace="deuda", value ="consultar")
    private static String sqlConsulta;
    
    @SqlStatement(namespace="deuda", value ="actualizar")
    private static String sqlActualizar;

	public RepositorioDeudaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(Deuda deuda) {
	
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		Long idCliente = deuda.getIdCliente().getIdCliente();
		paramSource.addValue("monto", deuda.getMonto());
		paramSource.addValue("fechaInicialDeudaCliente", deuda.getFechaInicialDeudaCliente());
		paramSource.addValue("nombreEntidadDeuda", deuda.getNombreEntidadDeuda());
		paramSource.addValue("conceptoDeuda", deuda.getConceptoDeuda());
		paramSource.addValue("idCliente", idCliente);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCrear, paramSource, keyHolder, new String[]{"id"});
		return keyHolder.getKey().longValue();
	}

	@Override
	public boolean existe(Long idDeuda) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("idDeuda", idDeuda);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,
				paramSource, Boolean.class);
	}

	@Override
	public Deuda consultarDeuda(Long idDeuda) {
		  MapSqlParameterSource paramSource = new MapSqlParameterSource();
	       paramSource.addValue("idDeuda", idDeuda);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlConsulta,paramSource,
				new MapeoDeuda(this.repositorioCliente));
	}

	@Override
	public void actualizar(Deuda deuda) {
		this.customNamedParameterJdbcTemplate.actualizar(deuda, sqlActualizar);
		
	}



}
