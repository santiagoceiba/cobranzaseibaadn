package com.ceiba.cliente.adaptador.mapeo;


import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoCliente implements RowMapper<DtoCliente>, MapperResult {
    @Override
    public DtoCliente mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long idCliente = rs.getLong("idCliente");
        String nombre = rs.getString("nombre");
        String cedula = rs.getString("cedula");

        return new DtoCliente(idCliente, nombre, cedula);
    }
}
