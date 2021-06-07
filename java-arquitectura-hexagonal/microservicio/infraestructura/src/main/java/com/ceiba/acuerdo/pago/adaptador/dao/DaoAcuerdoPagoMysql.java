package com.ceiba.acuerdo.pago.adaptador.dao;

import com.ceiba.acuerdo.pago.modelo.dto.DtoAcuerdoPago;
import com.ceiba.acuerdo.pago.puerto.dao.DaoAcuerdoPago;
import com.ceiba.cliente.adaptador.mapeo.MapeoAcuerdoPago;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.deuda.puerto.repositorio.RepositorioDeuda;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoAcuerdoPagoMysql implements DaoAcuerdoPago {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @Autowired
    private RepositorioCliente repositorioCliente;

    @Autowired
    private RepositorioDeuda repositorioDeuda;

    @SqlStatement(namespace = "acuerdo", value = "listar")
    private static String sqlListar;

    public DaoAcuerdoPagoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoAcuerdoPago> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoAcuerdoPago(this.repositorioCliente, this.repositorioDeuda));
    }



}
