package com.ceiba.factura.adaptador.controlador;



import com.ceiba.factura.comando.manejador.ManejadorListaFacturasAcuerdo;
import com.ceiba.factura.modelo.dto.DtoFactura;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
@CrossOrigin(origins = "http://localhost:4200")
@Api(tags={"Controlador consultas sobre los clientes"})
public class ConsultarControladorFactura {
    private final  ManejadorListaFacturasAcuerdo manejadorListaFacturasAcuerdo;

    public ConsultarControladorFactura(ManejadorListaFacturasAcuerdo manejadorListaFacturasAcuerdo) {
        this.manejadorListaFacturasAcuerdo = manejadorListaFacturasAcuerdo;
    }

    @GetMapping("/listarPorId")
    @CrossOrigin(origins = "http://localhost:4200")
    @ApiOperation("Listar facturas por id del acuerdo")
    public List<DtoFactura> listarPorIdAcuerdo(@RequestParam Long idAcuerdoPago) {
        return this.manejadorListaFacturasAcuerdo.ejecutar(idAcuerdoPago);
    }
}
