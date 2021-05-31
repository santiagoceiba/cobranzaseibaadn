package com.ceiba.cliente.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.acuerdo.pago.modelo.dto.DtoAcuerdoPago;
import com.ceiba.acuerdopago.utilidades.enumeracion.EstadoAcuerdoEnum;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.deuda.modelo.entidad.Deuda;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoAcuerdoPago implements RowMapper<DtoAcuerdoPago>, MapperResult {

	@Override
	public DtoAcuerdoPago mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long idAcuerdoPago = rs.getLong("idAcuerdoPago");
		LocalDateTime fechaAcuerdo = extraerLocalDateTime(rs, "fecha_acuerdo");
		Double montoCuota = rs.getDouble("monto_cuota");
		Cliente cliente = (Cliente) rs.getObject("idCliente");
		Deuda deuda = (Deuda) rs.getObject("idDeuda");
		EstadoAcuerdoEnum estado = (EstadoAcuerdoEnum) (rs.getObject("estado"));
		Integer cantidadCuotas = rs.getInt("cantidad_cuotas");
		Long numeroReferencia = rs.getLong("numero_referencia");

		return new DtoAcuerdoPago(idAcuerdoPago, fechaAcuerdo, montoCuota, cliente, deuda, estado, cantidadCuotas,
				numeroReferencia);
	}

}
