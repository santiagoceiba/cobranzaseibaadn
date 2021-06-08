package com.ceiba.deuda.comando.manejador;

import com.ceiba.deuda.modelo.dto.DtoDeuda;
import com.ceiba.deuda.puerto.dao.DaoDeuda;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListaDeudasCliente {

    private final DaoDeuda daoDeuda;

    public ManejadorListaDeudasCliente(DaoDeuda daoDeuda){
        this.daoDeuda = daoDeuda;
    }

    public List<DtoDeuda> ejecutar(Long idCliente){ return this.daoDeuda.listarPorIdCliente(idCliente); }
}
