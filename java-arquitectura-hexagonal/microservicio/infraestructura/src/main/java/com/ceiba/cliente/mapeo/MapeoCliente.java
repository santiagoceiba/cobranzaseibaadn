package com.ceiba.cliente.mapeo;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoCliente implements RowMapper<Cliente>, MapperResult{

	@Override
	public Cliente mapRow(ResultSet resultSet, int rowNum) throws SQLException {
	    Long idCliente = resultSet.getLong("idCliente");
        String nombre = resultSet.getString("nombre");
        String cedula = resultSet.getString("cedula");
 
        return new  Cliente(idCliente, nombre, cedula);
	}

}
