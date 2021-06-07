package com.ceiba.cliente.controlador;

import com.ceiba.cliente.comando.manejador.ManejadorListaClientes;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200")
@Api(tags={"Controlador consultas sobre los clientes"})
public class ConsultaControladorCliente {

    private final ManejadorListaClientes manejadorListaClientes;

    public ConsultaControladorCliente( ManejadorListaClientes manejadorListaClientes) {
        this.manejadorListaClientes = manejadorListaClientes;
    }

    @GetMapping("/listar")
    @ApiOperation("Listar acuerdos")
    public List<DtoCliente> listar() {
        return this.manejadorListaClientes.ejecutar();
    }
}
