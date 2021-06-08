package com.ceiba.acuerdo.pago.adaptador.repositorio;

import com.ceiba.acuerdo.pago.mapeo.MapeoAcuerdoPago;
import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;
import com.ceiba.acuerdo.pago.puerto.repositorio.RepositorioAcuerdo;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.deuda.puerto.repositorio.RepositorioDeuda;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class RepositorioAcuerdoMysql implements RepositorioAcuerdo {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@Autowired
	private RepositorioCliente repositorioCliente;

	@Autowired
	private RepositorioDeuda repositorioDeuda;

	@Autowired
	private  RepositorioFactura repositorioFactura;

	@SqlStatement(namespace = "acuerdo", value = "crear")
	private static String sqlCrear;

	@SqlStatement(namespace = "acuerdo", value = "existe")
	private static String sqlExiste;

    @SqlStatement(namespace="acuerdo", value ="consultar")
    private static String sqlConsulta;

	@SqlStatement(namespace="acuerdo", value ="consultarReferencia")
	private static String sqlConsultaNumeroReferencia;

	@SqlStatement(namespace="acuerdo", value ="listar")
	private static String sqlListar;

	@SqlStatement(namespace="acuerdo", value ="actualizar")
	private static String sqlActualizar;



	private static String REFERENCIA = "numeroReferencia";

	public RepositorioAcuerdoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(AcuerdoPago acuerdoPago) {
		
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("idCliente", acuerdoPago.getCliente().getIdCliente());
		paramSource.addValue("idDeuda", acuerdoPago.getDeuda().getIdDeuda());
		paramSource.addValue("fechaAcuerdo", acuerdoPago.getFechaAcuerdo());
		paramSource.addValue("montoCuota", acuerdoPago.getMontoCuota());
		paramSource.addValue("estado", acuerdoPago.getEstado().name());
		paramSource.addValue("cantidadCuotas", acuerdoPago.getCantidadCuotas());
		paramSource.addValue(REFERENCIA, acuerdoPago.getNumeroReferencia());
		Long resultadoConsulta = this.customNamedParameterJdbcTemplate.crear(acuerdoPago, paramSource,  sqlCrear);
		AcuerdoPago acuerdoPagoConId = consultarAcuerdoPorNumeroReferencia(acuerdoPago.getNumeroReferencia());
		crearFacturas(acuerdoPagoConId);
		return resultadoConsulta;
		
	}

	@Override
	public void actualizar(AcuerdoPago acuerdoPago) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("idAcuerdoPago", acuerdoPago.getIdAcuerdoPago());
		paramSource.addValue("estado", acuerdoPago.getEstado().name());
		this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizar, paramSource);
	}

	@Override
	public List<AcuerdoPago> listarAcuerdosPago() {
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,
				new MapeoAcuerdoPago(this.repositorioCliente, this.repositorioDeuda));
	}


	@Override
	public boolean existe(Long numeroReferencia) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue(REFERENCIA, numeroReferencia);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,
				paramSource, Boolean.class);
	}


	@Override
	public AcuerdoPago consultarAcuerdoPorId(Long idAcuerdoPago) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("idAcuerdoPago", idAcuerdoPago);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlConsulta,
				paramSource, new MapeoAcuerdoPago(this.repositorioCliente, this.repositorioDeuda));
	}

	@Override
	public AcuerdoPago consultarAcuerdoPorNumeroReferencia(Long numeroReferencia) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue(REFERENCIA, numeroReferencia);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlConsultaNumeroReferencia,
				paramSource, new MapeoAcuerdoPago(this.repositorioCliente, this.repositorioDeuda));
	}
	

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
