package com.ceiba.acuerdo.pago.mapeo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;
import com.ceiba.acuerdopago.utilidades.enumeracion.EstadoAcuerdo;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.deuda.modelo.entidad.Deuda;
import com.ceiba.deuda.puerto.repositorio.RepositorioDeuda;
import com.ceiba.infraestructura.jdbc.MapperResult;


public class MapeoAcuerdoPago implements RowMapper<AcuerdoPago>, MapperResult {
	
	

	private final RepositorioCliente repositorioCliente;

	private final RepositorioDeuda repositorioDeuda;

	public MapeoAcuerdoPago(RepositorioCliente repositorioCliente, RepositorioDeuda repositorioDeuda) {
		this.repositorioCliente = repositorioCliente;
		this.repositorioDeuda = repositorioDeuda;
	}

	@Override
	public AcuerdoPago mapRow(ResultSet resultSet, int rowNum) throws SQLException {
	    Long idAcuerdoPago = resultSet.getLong("idAcuerdoPago");
        Long numeroReferencia = resultSet.getLong("numero_referencia");
        String estado = resultSet.getString("estado");
        Integer cantidadCuotas = resultSet.getInt("cantidad_cuotas");
        Double  montoCuota = resultSet.getDouble("monto_cuota");
        LocalDateTime fechaAcuerdo = extraerLocalDateTime(resultSet, "fecha_acuerdo");
        Long idCliente = resultSet.getLong("idCliente");
        Long idDeuda = resultSet.getLong("idDeuda");
        Cliente cliente = obtenerCliente(idCliente);
        Deuda deuda = obtenerDeuda(idDeuda);
        EstadoAcuerdo estadoAcuerdo = EstadoAcuerdo.valueOf(estado); 
       
        return new  AcuerdoPago(idAcuerdoPago, fechaAcuerdo, montoCuota, cliente, deuda, estadoAcuerdo, cantidadCuotas, numeroReferencia);
	}
	
	
	/**
	 * Método que permite consultar una deuda a partir de su id
	 * 
	 * @param idDeuda id de la deuda a consultar
	 * @return la deuda requerido
	 */
	private Deuda obtenerDeuda(Long idDeuda) {
		return this.repositorioDeuda.consultarDeuda(idDeuda);
	}
	

	/**
	 * método que retorna un cliente a partir de su id
	 * @param idCliente id del cliente a retornar
	 * @return Cliente que requiere la fabrica
	 */
	private Cliente obtenerCliente(Long idCliente) {
		return 	this.repositorioCliente.consultarCliente(idCliente);
	}
}

