package com.ceiba.cliente.puerto.dao;

import com.ceiba.acuerdo.pago.modelo.dto.DtoAcuerdoPago;
import com.ceiba.cliente.modelo.dto.DtoCliente;

import java.util.List;

public interface DaoCliente {

    List<DtoCliente> listar();
}
