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
	    Long idFactura = resultSet.getLong("idfactura");
        Double montoCuota = resultSet.getDouble("montocuota");
        LocalDateTime fechaCaducidad =extraerLocalDateTime(resultSet, "fechacaducidad");
        AcuerdoPago acuerdoPago = (AcuerdoPago) resultSet.getObject("acuerdopago");
        Boolean estado = resultSet.getBoolean("estado");
        Factura factura = new Factura(idFactura,montoCuota,fechaCaducidad,acuerdoPago);
        factura.setEstado(estado);
        return factura;
	}

}
