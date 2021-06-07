package com.ceiba.cliente.modelo.dto;

public class DtoCliente {

    private Long idCliente;
    private String nombre;
    private String cedula;

    public DtoCliente(Long idCliente, String nombre, String cedula) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
