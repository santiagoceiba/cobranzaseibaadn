package com.ceiba.deuda.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class DtoDeuda {

    private Long idDeuda;
    private Double monto;
    private LocalDateTime fechaInicialDeudaCliente;
    private String nombreEntidadDeuda;
    private String conceptoDeuda;
    private Long idCliente;

}
