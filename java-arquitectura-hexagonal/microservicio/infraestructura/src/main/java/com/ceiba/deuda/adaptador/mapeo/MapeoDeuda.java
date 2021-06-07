package com.ceiba.deuda.adaptador.mapeo;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.deuda.modelo.dto.DtoDeuda;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoDeuda implements RowMapper<DtoDeuda>, MapperResult {
    @Override
    public DtoDeuda mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long idDeuda = rs.getLong("idDeuda");
        String nombreEntidad = rs.getString("nombre_entidad_deuda");
        String conceptoDeuda = rs.getString("concepto_deuda");
        LocalDateTime fechaDeuda = extraerLocalDateTime(rs, "fecha_inicial_deuda_cliente");
        Double montoDeuda = rs.getDouble("monto");
        Long idCliente = rs.getLong("id_cliente");

        return new DtoDeuda(idDeuda, montoDeuda, fechaDeuda, nombreEntidad, conceptoDeuda, idCliente);
    }
}
