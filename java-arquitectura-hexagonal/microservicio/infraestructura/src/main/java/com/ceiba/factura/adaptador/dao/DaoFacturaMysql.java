package com.ceiba.factura.adaptador.dao;

import com.ceiba.deuda.adaptador.mapeo.MapeoDeuda;
import com.ceiba.factura.mapeo.MapeoDtoFactura;
import com.ceiba.factura.modelo.dto.DtoFactura;
import com.ceiba.factura.puerto.dao.DaoFactura;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoFacturaMysql implements DaoFactura{

	
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="factura", value="listarFacturaPorAcuerdo")
    private static String sqlListarPorAcuerdo;

    public DaoFacturaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoFactura> listarFacturaPorAcuerdo(Long idAcuerdoPago) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idAcuerdoPago", idAcuerdoPago);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorAcuerdo,
                paramSource, new MapeoDtoFactura());
    }
}
