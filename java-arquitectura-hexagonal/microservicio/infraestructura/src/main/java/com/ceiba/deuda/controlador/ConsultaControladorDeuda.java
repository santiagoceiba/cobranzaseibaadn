package com.ceiba.deuda.controlador;

import com.ceiba.deuda.comando.manejador.ManejadorListaDeudas;
import com.ceiba.deuda.comando.manejador.ManejadorListaDeudasCliente;
import com.ceiba.deuda.modelo.dto.DtoDeuda;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deudas")
@CrossOrigin(origins = "http://localhost:4200")
@Api(tags={"Controlador consultas sobre las deudas"})
public class ConsultaControladorDeuda {

    private final ManejadorListaDeudas manejadorListaDeudas;
    private final ManejadorListaDeudasCliente manejadorListaDeudasCliente;

    public ConsultaControladorDeuda( ManejadorListaDeudas manejadorListaDeudas , ManejadorListaDeudasCliente manejadorListaDeudasCliente) {
        this.manejadorListaDeudas = manejadorListaDeudas;
        this.manejadorListaDeudasCliente = manejadorListaDeudasCliente;
    }

    @GetMapping("/listar")
    @ApiOperation("Listar deudas")
    public List<DtoDeuda> listar() {
        return this.manejadorListaDeudas.ejecutar();
    }

    @GetMapping("/listarPorId")
    @CrossOrigin(origins = "http://localhost:4200")
    @ApiOperation("Listar deudas por id del cliente")
    public List<DtoDeuda> listarPorIdCliente(@RequestParam Long idCliente) {
        return this.manejadorListaDeudasCliente.ejecutar(idCliente);
    }
}
