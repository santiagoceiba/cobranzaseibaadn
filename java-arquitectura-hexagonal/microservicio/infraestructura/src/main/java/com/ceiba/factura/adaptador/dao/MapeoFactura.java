package com.ceiba.factura.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoFactura implements RowMapper<Factura>, MapperResult{

	@Override
	public Factura mapRow(ResultSet resultSet, int rowNum) throws SQLException {
	    Long idFactura = resultSet.getLong("idFactura");
        Double montoCuota = resultSet.getDouble("monto_cuota");
        LocalDateTime fechaCaducidad =extraerLocalDateTime(resultSet, "fecha_caducidad");
        AcuerdoPago acuerdoPago = (AcuerdoPago) resultSet.getObject("acuerdo_pago");
        Boolean estado = resultSet.getBoolean("estado");
 
        return new Factura(idFactura,montoCuota,fechaCaducidad,acuerdoPago, estado);
	}

}
