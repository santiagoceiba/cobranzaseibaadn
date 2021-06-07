package com.ceiba.deuda.controlador;

import com.ceiba.deuda.comando.manejador.ManejadorListaDeudas;
import com.ceiba.deuda.modelo.dto.DtoDeuda;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deudas")
@CrossOrigin(origins = "http://localhost:4200")
@Api(tags={"Controlador consultas sobre las deudas"})
public class ConsultaControladorDeuda {

    private final ManejadorListaDeudas manejadorListaDeudas;

    public ConsultaControladorDeuda( ManejadorListaDeudas manejadorListaDeudas) {
        this.manejadorListaDeudas = manejadorListaDeudas;
    }

    @GetMapping("/listar")
    @ApiOperation("Listar deudas")
    public List<DtoDeuda> listar() {
        return this.manejadorListaDeudas.ejecutar();
    }
}
