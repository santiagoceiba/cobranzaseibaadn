package com.ceiba.factura.adaptador.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.factura.modelo.dto.DtoFactura;
import com.ceiba.factura.puerto.dao.DaoFactura;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Component
public class DaoFacturaMysql implements DaoFactura{

	
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="factura", value="listarFacturaPorAcuerdo")
    private static String sqlListar;

    public DaoFacturaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoFactura> listarFacturaPorAcuerdo(Long idAcuerdoPago) {
      return null; // return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoFactura());
    }
}
