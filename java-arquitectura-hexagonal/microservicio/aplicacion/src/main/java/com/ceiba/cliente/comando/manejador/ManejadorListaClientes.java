package com.ceiba.cliente.comando.manejador;


import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListaClientes {
    private final DaoCliente daoCliente;

    public ManejadorListaClientes(DaoCliente daoCliente){
        this.daoCliente = daoCliente;
    }

    public List<DtoCliente> ejecutar(){ return this.daoCliente.listar(); }
}
