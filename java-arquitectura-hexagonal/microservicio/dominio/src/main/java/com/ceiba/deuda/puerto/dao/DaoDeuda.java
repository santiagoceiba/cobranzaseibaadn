package com.ceiba.deuda.puerto.dao;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.deuda.modelo.dto.DtoDeuda;

import java.util.List;

public interface DaoDeuda {

    List<DtoDeuda> listar();
}
