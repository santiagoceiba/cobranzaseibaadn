package com.ceiba.usuario.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoCliente;
import com.ceiba.usuario.comando.fabrica.FabricaCliente;
import com.ceiba.usuario.modelo.entidad.Cliente;
import com.ceiba.usuario.servicio.ServicioCrearCliente;

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
