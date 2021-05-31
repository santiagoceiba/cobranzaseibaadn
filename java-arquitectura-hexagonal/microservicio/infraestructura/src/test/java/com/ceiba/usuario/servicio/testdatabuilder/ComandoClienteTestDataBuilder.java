package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.cliente.comando.ComandoCliente;

public class ComandoClienteTestDataBuilder {

	
	private Long idCliente;
	private String nombre;
	private String cedula;

    public ComandoClienteTestDataBuilder() {
    	nombre = "1234";
    	cedula = "1234";
    }

    public ComandoClienteTestDataBuilder conCedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public ComandoClienteTestDataBuilder conId(Long idCliente) {
        this.idCliente = idCliente;
        return this;
    }

    public ComandoCliente build() {
        return new ComandoCliente(idCliente, nombre, cedula);
    }
}
