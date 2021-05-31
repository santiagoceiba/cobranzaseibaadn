package com.ceiba.factura.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.factura.modelo.dto.DtoFactura;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoFactura implements RowMapper<DtoFactura>, MapperResult{

	@Override
	public DtoFactura mapRow(ResultSet resultSet, int rowNum) throws SQLException {
	    Long idFactura = resultSet.getLong("idFactura");
        Double montoCuota = resultSet.getDouble("monto_cuota");
        LocalDateTime fechaCaducidad =extraerLocalDateTime(resultSet, "fecha_caducidad");
        Long acuerdoPago = resultSet.getLong("acuerdo_pago");
        Boolean estado = resultSet.getBoolean("estado");
 

        return new DtoFactura(idFactura,montoCuota,fechaCaducidad,acuerdoPago, estado);
	}

}
