package com.ceiba.cliente.adaptador.mapeo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.deuda.puerto.repositorio.RepositorioDeuda;
import org.springframework.jdbc.core.RowMapper;

import com.ceiba.acuerdo.pago.modelo.dto.DtoAcuerdoPago;
import com.ceiba.acuerdopago.utilidades.enumeracion.EstadoAcuerdo;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.deuda.modelo.entidad.Deuda;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoAcuerdoPago implements RowMapper<DtoAcuerdoPago>, MapperResult {

	private final RepositorioCliente repositorioCliente;

	private final RepositorioDeuda repositorioDeuda;

	public MapeoAcuerdoPago(RepositorioCliente repositorioCliente, RepositorioDeuda repositorioDeuda) {
		this.repositorioCliente = repositorioCliente;
		this.repositorioDeuda = repositorioDeuda;
	}

	@Override
	public DtoAcuerdoPago mapRow(ResultSet rs, int rowNum) throws SQLException {



		Long idAcuerdoPago = rs.getLong("idAcuerdoPago");
		LocalDateTime fechaAcuerdo = extraerLocalDateTime(rs, "fecha_acuerdo");
		Double montoCuota = rs.getDouble("monto_cuota");
		Long idCliente = rs.getLong("idCliente");
		Long idDeuda = rs.getLong("idDeuda");
		EstadoAcuerdo estado = (EstadoAcuerdo.valueOf(rs.getString("estado")));
		Integer cantidadCuotas = rs.getInt("cantidad_cuotas");
		Long numeroReferencia = rs.getLong("numero_referencia");
		Cliente cliente = obtenerCliente(idCliente);
		Deuda deuda = obtenerDeuda(idDeuda);
		return new DtoAcuerdoPago(idAcuerdoPago, fechaAcuerdo, montoCuota, cliente, deuda, estado, cantidadCuotas,
				numeroReferencia);
	}


	private Deuda obtenerDeuda(Long idDeuda) {
		return this.repositorioDeuda.consultarDeuda(idDeuda);
	}



	private Cliente obtenerCliente(Long idCliente) {
		return 	this.repositorioCliente.consultarCliente(idCliente);
	}

}
