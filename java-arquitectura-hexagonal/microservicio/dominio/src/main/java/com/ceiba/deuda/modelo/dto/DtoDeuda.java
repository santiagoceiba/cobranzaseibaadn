package com.ceiba.deuda.modelo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DtoDeuda {

    private Long idDeuda;
    private Double monto;
    private LocalDateTime fechaInicialDeudaCliente;
    private String nombreEntidadDeuda;
    private String conceptoDeuda;
    private Long idCliente;

    public DtoDeuda(Long idDeuda, Double monto, LocalDateTime fechaInicialDeudaCliente, String nombreEntidadDeuda, String conceptoDeuda, Long idCliente) {
        this.idDeuda = idDeuda;
        this.monto = monto;
        this.fechaInicialDeudaCliente = fechaInicialDeudaCliente;
        this.nombreEntidadDeuda = nombreEntidadDeuda;
        this.conceptoDeuda = conceptoDeuda;
        this.idCliente = idCliente;
    }
}
