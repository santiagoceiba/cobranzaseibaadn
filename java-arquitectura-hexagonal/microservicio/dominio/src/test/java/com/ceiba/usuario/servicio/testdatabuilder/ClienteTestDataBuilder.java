package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Cliente;

public class ClienteTestDataBuilder {

	
	private Long idCliente;
	private String nombre;
	private String cedula;

    public ClienteTestDataBuilder() {
    	nombre = "1234";
    	cedula = "1234";
    }

    public ClienteTestDataBuilder conCedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public ClienteTestDataBuilder conId(Long idCliente) {
        this.idCliente = idCliente;
        return this;
    }

    public Cliente build() {
        return new Cliente(idCliente, nombre, cedula);
    }
}
