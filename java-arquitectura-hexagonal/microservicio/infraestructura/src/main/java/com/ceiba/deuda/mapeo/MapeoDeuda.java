package com.ceiba.deuda.mapeo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ceiba.acuerdo.pago.puerto.repositorio.RepositorioAcuerdo;
import com.ceiba.cliente.adaptador.repositorio.RepositorioClienteMysql;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.deuda.modelo.entidad.Deuda;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.stereotype.Component;

@Component
public class MapeoDeuda implements RowMapper<Deuda>, MapperResult {


	private final  RepositorioCliente repositorioCliente;

	public MapeoDeuda(RepositorioCliente repositorioCliente) {
		this.repositorioCliente = repositorioCliente;
	}

	@Override
	public Deuda mapRow(ResultSet resultSet, int rowNum) throws SQLException {
	    Long idDeuda = resultSet.getLong("idDeuda");
	    Double monto = resultSet.getDouble("monto");
	    LocalDateTime fechaInicial = extraerLocalDateTime(resultSet, "fecha_inicial_deuda_cliente");
        String nombreEntidad = resultSet.getString("nombre_entidad_deuda");
        String conceptoDeuda = resultSet.getString("concepto_deuda");
        Long idCliente = resultSet.getLong("id_cliente");
        Cliente cliente = this.repositorioCliente.consultarCliente(idCliente);
        
       
        return new Deuda(monto, fechaInicial, nombreEntidad, conceptoDeuda, cliente, idDeuda);
	}


}
