package com.ceiba.factura.mapeo;

import com.ceiba.deuda.modelo.dto.DtoDeuda;
import com.ceiba.factura.modelo.dto.DtoFactura;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoDtoFactura implements RowMapper<DtoFactura>, MapperResult {
    @Override
    public DtoFactura mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long idFactura = rs.getLong("idFactura");
        Double montocuota = rs.getDouble("montocuota");
        LocalDateTime fechaCaducidad = extraerLocalDateTime(rs, "fechacaducidad");
        Long acuerdoPago = rs.getLong("acuerdopago");
        Boolean estado = rs.getBoolean("estado");

        return new DtoFactura(idFactura, montocuota, fechaCaducidad, acuerdoPago, estado);
    }
}
