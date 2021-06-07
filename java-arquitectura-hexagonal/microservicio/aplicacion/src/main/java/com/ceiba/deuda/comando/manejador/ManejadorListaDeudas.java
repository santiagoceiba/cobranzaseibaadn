package com.ceiba.deuda.comando.manejador;

import com.ceiba.cliente.modelo.dto.DtoCliente;

import com.ceiba.deuda.modelo.dto.DtoDeuda;
import com.ceiba.deuda.puerto.dao.DaoDeuda;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListaDeudas {

    private final DaoDeuda daoDeuda;

    public ManejadorListaDeudas(DaoDeuda daoDeuda){
        this.daoDeuda = daoDeuda;
    }

    public List<DtoDeuda> ejecutar(){ return this.daoDeuda.listar(); }
}
