package com.ceiba.factura.adaptador.repositorio;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.factura.adaptador.dao.MapeoFactura;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Repository
public class RepositorioFacturaMysql implements RepositorioFactura {

	@SqlStatement(namespace = "factura", value = "listarFacturaPorAcuerdo")
	private static String sqlListar;

	@SqlStatement(namespace = "factura", value = "crear")
	private static String sqlCrear;

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	public RepositorioFacturaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public List<Factura> obtenerListaFacturas(Long idAcuerdoPago) {
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,
				new MapeoFactura());
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

}
