package com.ceiba.usuario.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.usuario.consulta.ManejadorListaAcuerdosPagos;
import com.ceiba.usuario.modelo.dto.DtoAcuerdoPago;
import com.ceiba.usuario.modelo.dto.DtoUsuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/acuerdos")
@Api(tags={"Controlador consultas sobre los acuerdos de pago generados"})
public class ConsultaControladorAcuerdoPago {
	
	
	private final ManejadorListaAcuerdosPagos manejadorListaAcuerdosPagos;

    public ConsultaControladorAcuerdoPago( ManejadorListaAcuerdosPagos manejadorListaAcuerdosPagos) {
        this.manejadorListaAcuerdosPagos = manejadorListaAcuerdosPagos;
    }

    @GetMapping("/listar")
    @ApiOperation("Listar Usuarios")
    public List<DtoAcuerdoPago> listar() {
        return this.manejadorListaAcuerdosPagos.ejecutar();
    }

}
