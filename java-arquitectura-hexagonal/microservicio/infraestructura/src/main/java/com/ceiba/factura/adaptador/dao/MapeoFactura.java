package com.ceiba.factura.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.ceiba.acuerdo.pago.puerto.repositorio.RepositorioAcuerdo;
import org.springframework.jdbc.core.RowMapper;

import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoFactura implements RowMapper<Factura>, MapperResult{

    private final RepositorioAcuerdo repositorioAcuerdo;

    public MapeoFactura(RepositorioAcuerdo repositorioAcuerdo) {
        this.repositorioAcuerdo = repositorioAcuerdo;
    }

    @Override
	public Factura mapRow(ResultSet resultSet, int rowNum) throws SQLException {
	    Long idFactura = resultSet.getLong("idFactura");
        Double montoCuota = resultSet.getDouble("montocuota");
        LocalDateTime fechaCaducidad =extraerLocalDateTime(resultSet, "fechacaducidad");
        Long idAcuerdoPago = resultSet.getLong("acuerdopago");
        AcuerdoPago acuerdoPago = this.repositorioAcuerdo.consultarAcuerdoPorId(idAcuerdoPago);
        Boolean estado = resultSet.getBoolean("estado");
        Factura factura = new Factura(idFactura,montoCuota,fechaCaducidad,acuerdoPago);
        return factura;
	}

}
