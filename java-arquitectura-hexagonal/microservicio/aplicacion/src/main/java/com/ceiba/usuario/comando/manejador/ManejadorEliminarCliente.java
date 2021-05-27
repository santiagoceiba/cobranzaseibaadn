package com.ceiba.usuario.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.servicio.ServicioEliminarCliente;

@Component
public class ManejadorEliminarCliente implements ManejadorComando<Long> {
	
	private final ServicioEliminarCliente servicioEliminarCliente;

    public ManejadorEliminarCliente(ServicioEliminarCliente servicioEliminarCliente) {
        this.servicioEliminarCliente = servicioEliminarCliente;
    }

    public void ejecutar(Long idCliente) {
        this.servicioEliminarCliente.ejecutar(idCliente);
    }
}
