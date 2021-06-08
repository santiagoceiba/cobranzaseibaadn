package com.ceiba.cliente.modelo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DtoCliente {

    private Long idCliente;
    private String nombre;
    private String cedula;

    public DtoCliente(Long idCliente, String nombre, String cedula) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.cedula = cedula;
    }
}
