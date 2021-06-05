package com.ceiba.factura.adaptador.repositorio;

import java.time.LocalDateTime;
import java.util.List;

import com.ceiba.acuerdo.pago.puerto.repositorio.RepositorioAcuerdo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.factura.adaptador.dao.MapeoFactura;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Repository
public class RepositorioFacturaMysql implements RepositorioFactura {

	@Autowired
	@Lazy
	private RepositorioAcuerdo repositorioAcuerdo;

	@SqlStatement(namespace = "factura", value = "listarFacturaPorAcuerdo")
	private static String sqlListar;

	@SqlStatement(namespace = "factura", value = "crear")
	private static String sqlCrear;

	@SqlStatement(namespace = "factura", value = "actualizar")
	private static String sqlActualizar;

	@SqlStatement(namespace = "factura", value = "existe")
	private static String sqlExiste;

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	public RepositorioFacturaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public List<Factura> obtenerListaFacturas(Long idAcuerdoPago) {

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("idAcuerdoPago", idAcuerdoPago);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, paramSource,
				new MapeoFactura(this.repositorioAcuerdo));
	}

	@Override
	public void actualizar(Factura factura) {
		this.customNamedParameterJdbcTemplate.actualizar(factura, sqlActualizar);
	}

	@Override
	public void crearFactura(Long idAcuerdo, LocalDateTime fechaCaducidad, Double montoCuota) {

		int valorPorDefectoEstado = 0;
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("acuerdoPago", idAcuerdo);
		paramSource.addValue("fechaCaducidad", fechaCaducidad);
		paramSource.addValue("montoCuota", montoCuota);
		paramSource.addValue("estado", valorPorDefectoEstado);
		customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear);

	}

	@Override
	public Boolean existe(Long idFactura) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("idFactura", idFactura);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,
				paramSource, Boolean.class);
	}

}
