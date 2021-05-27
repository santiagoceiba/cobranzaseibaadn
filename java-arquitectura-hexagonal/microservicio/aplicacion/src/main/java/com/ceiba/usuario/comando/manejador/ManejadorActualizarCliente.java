package com.ceiba.usuario.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.comando.ComandoCliente;
import com.ceiba.usuario.comando.fabrica.FabricaCliente;
import com.ceiba.usuario.modelo.entidad.Cliente;
import com.ceiba.usuario.servicio.ServicioActualizacionCliente;

@Component
public class ManejadorActualizarCliente implements ManejadorComando<ComandoCliente> {
	
    private final FabricaCliente fabricaCliente;
    private final ServicioActualizacionCliente servicioCliente;

    public ManejadorActualizarCliente(FabricaCliente fabricaCliente, ServicioActualizacionCliente servicioCliente) {
        this.fabricaCliente = fabricaCliente;
        this.servicioCliente = servicioCliente;
    }

    public void ejecutar(ComandoCliente comandoCliente) {
        Cliente cliente = this.fabricaCliente.crear(comandoCliente);
        this.servicioCliente.ejecutar(cliente);
    }
	
}
