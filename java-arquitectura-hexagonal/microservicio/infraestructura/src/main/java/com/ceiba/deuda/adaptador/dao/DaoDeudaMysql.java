package com.ceiba.deuda.adaptador.dao;

import com.ceiba.cliente.adaptador.mapeo.MapeoCliente;
import com.ceiba.deuda.adaptador.mapeo.MapeoDeuda;
import com.ceiba.deuda.modelo.dto.DtoDeuda;
import com.ceiba.deuda.puerto.dao.DaoDeuda;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoDeudaMysql implements DaoDeuda {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "deuda", value = "listar")
    private static String sqlListar;

    @SqlStatement (namespace = "deuda", value = "listarPorIdCliente")
    private static String sqlListarPorIdCliente;

    public DaoDeudaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoDeuda> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoDeuda());

    }

    @Override
    public List<DtoDeuda> listarPorIdCliente(Long idCliente) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idCliente", idCliente);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorIdCliente,paramSource, new MapeoDeuda());
    }
}
