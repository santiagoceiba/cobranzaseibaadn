package com.ceiba.acuerdo.pago.adaptador.repositorio;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.acuerdo.pago.mapeo.MapeoAcuerdoPago;
import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;
import com.ceiba.acuerdo.pago.puerto.repositorio.RepositorioAcuerdo;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Repository
public class RepositorioAcuerdoMysql implements RepositorioAcuerdo {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
	
	@Autowired
	private  RepositorioFactura repositorioFactura;

	@SqlStatement(namespace = "acuerdo", value = "crear")
	private static String sqlCrear;

	@SqlStatement(namespace = "acuerdo", value = "existe")
	private static String sqlExiste;

    @SqlStatement(namespace="cliente", value ="consultar")
    private static String sqlConsulta;


	public RepositorioAcuerdoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(AcuerdoPago acuerdoPago) {
		// TODO Auto-generated method stub
		
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("idCliente", acuerdoPago.getCliente().getIdCliente());
		paramSource.addValue("idDeuda", acuerdoPago.getDeuda().getIdDeuda());
		paramSource.addValue("fechaAcuerdo", acuerdoPago.getFechaAcuerdo());
		paramSource.addValue("montoCuota", acuerdoPago.getMontoCuota());
		paramSource.addValue("estado", acuerdoPago.getEstado().name());
		paramSource.addValue("cantidadCuotas", acuerdoPago.getCantidadCuotas());
		paramSource.addValue("numeroReferencia", acuerdoPago.getNumeroReferencia());
		crearFacturas(acuerdoPago);
		return this.customNamedParameterJdbcTemplate.crear(acuerdoPago, paramSource,  sqlCrear);
		
	}

	@Override
	public void actualizar(AcuerdoPago AcuerdoPago) {
		// TODO Auto-generated method stub

	}


	@Override
	public boolean existe(Long numeroReferencia) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("numeroReferencia", numeroReferencia);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,
				paramSource, Boolean.class);
	}


	@Override
	public void eliminar(Long idAcuerdoPago) {
		// TODO Auto-generated method stub

	}

	@Override
	public AcuerdoPago consultarAcuerdoPorId(Long idAcuerdoPago) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("idAcuerdoPago", idAcuerdoPago);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlConsulta,
				paramSource, new MapeoAcuerdoPago());
	}
	
	
	/**
	 * Método que permite crear las facturas para el acuerdo de apgo
	 * @param acuerdo valores para la creación de la factura
	 * @param fechaActual fecha del sistema en el momento en el que se crea la factura
	 */
	private void crearFacturas(AcuerdoPago acuerdo) {
		// Se crea la lista de facturas para el acuerdo de pago
		Integer numeroFacturas = acuerdo.getCantidadCuotas();
		LocalDateTime fechaCaducidad;
		for (int i = 0; i <  numeroFacturas; i++) {
			fechaCaducidad = acuerdo.getFechaAcuerdo().plusMonths(i);
			this.repositorioFactura.crearFactura(acuerdo.getIdAcuerdoPago(), fechaCaducidad,acuerdo.getMontoCuota());
		}

	}
}
