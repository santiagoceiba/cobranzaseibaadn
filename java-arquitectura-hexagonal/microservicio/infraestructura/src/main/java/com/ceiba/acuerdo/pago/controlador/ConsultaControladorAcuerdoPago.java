package com.ceiba.acuerdo.pago.controlador;

import com.ceiba.acuerdo.pago.consulta.ManejadorListaAcuerdosPagos;
import com.ceiba.acuerdo.pago.modelo.dto.DtoAcuerdoPago;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/acuerdos")
@CrossOrigin(origins = "http://localhost:4200")
@Api(tags={"Controlador consultas sobre los acuerdos de pago generados"})
public class ConsultaControladorAcuerdoPago {
	
	
	private final ManejadorListaAcuerdosPagos manejadorListaAcuerdosPagos;

    public ConsultaControladorAcuerdoPago( ManejadorListaAcuerdosPagos manejadorListaAcuerdosPagos) {
        this.manejadorListaAcuerdosPagos = manejadorListaAcuerdosPagos;
    }

    @GetMapping("/listar")
    @ApiOperation("Listar acuerdos")
    public List<DtoAcuerdoPago> listar() {
        return this.manejadorListaAcuerdosPagos.ejecutar();
    }

}
