package com.ceiba.usuario.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoAcuerdoPago;

public class MapeoAcuerdoPago implements RowMapper<DtoAcuerdoPago>, MapperResult {

	@Override
	public DtoAcuerdoPago mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long idAcuerdoPago = rs.getLong("idAcuerdoPago");
		LocalDateTime fechaAcuerdo = extraerLocalDateTime(rs, "fecha_acuerdo");
		Double montoCuota = rs.getDouble("monto_cuota");
		Long cliente = rs.getLong("idCliente");
		Long deuda = rs.getLong("idDeuda");
		String estado = (rs.getString("estado"));
		Integer cantidadCuotas = rs.getInt("cantidad_cuotas");
		Long numeroReferencia = rs.getLong("numero_referencia");

		return new DtoAcuerdoPago(idAcuerdoPago, fechaAcuerdo, montoCuota, cliente, deuda, estado, cantidadCuotas,
				numeroReferencia);
	}

}
