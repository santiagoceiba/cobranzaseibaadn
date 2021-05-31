package com.ceiba.usuario.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.usuario.comando.ComandoCliente;

@Component
public class FabricaCliente {
	
	
    public Cliente crear(ComandoCliente comandoCliente) {
        return new Cliente(
        		comandoCliente.getIdCliente(),
        		comandoCliente.getNombre(), 
        		comandoCliente.getCedula()
        );
    }
}
