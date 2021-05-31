package com.ceiba.usuario.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoCliente;
import com.ceiba.usuario.comando.fabrica.FabricaCliente;

@Component
public class ManejadorCrearCliente implements ManejadorComandoRespuesta<ComandoCliente, ComandoRespuesta<Long>> {
	
    private final FabricaCliente fabricaCliente;
    private final ServicioCrearCliente servicioCliente;

    public ManejadorCrearCliente(FabricaCliente fabricaCliente, ServicioCrearCliente servicioCliente) {
        this.fabricaCliente = fabricaCliente;
        this.servicioCliente = servicioCliente;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoCliente comandoCliente) {
        Cliente cliente = this.fabricaCliente.crear(comandoCliente);
        return new ComandoRespuesta<>(this.servicioCliente.ejecutar(cliente));
    }

}
