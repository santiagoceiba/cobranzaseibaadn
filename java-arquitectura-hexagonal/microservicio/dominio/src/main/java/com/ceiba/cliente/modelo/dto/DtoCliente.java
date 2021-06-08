package com.ceiba.cliente.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class DtoCliente {

    private Long idCliente;
    private String nombre;
    private String cedula;

}
