package com.ceiba.deuda.modelo.dto;

import java.time.LocalDateTime;

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

    public Long getIdDeuda() {
        return idDeuda;
    }

    public void setIdDeuda(Long idDeuda) {
        this.idDeuda = idDeuda;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaInicialDeudaCliente() {
        return fechaInicialDeudaCliente;
    }

    public void setFechaInicialDeudaCliente(LocalDateTime fechaInicialDeudaCliente) {
        this.fechaInicialDeudaCliente = fechaInicialDeudaCliente;
    }

    public String getNombreEntidadDeuda() {
        return nombreEntidadDeuda;
    }

    public void setNombreEntidadDeuda(String nombreEntidadDeuda) {
        this.nombreEntidadDeuda = nombreEntidadDeuda;
    }

    public String getConceptoDeuda() {
        return conceptoDeuda;
    }

    public void setConceptoDeuda(String conceptoDeuda) {
        this.conceptoDeuda = conceptoDeuda;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}
