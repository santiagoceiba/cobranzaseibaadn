package com.ceiba.factura.adaptador.controlador;

import com.ceiba.factura.comando.ComandoFactura;
import com.ceiba.factura.comando.manejador.ManejadorActualizarFactura;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/factura")
@Api(tags = { "Controlador comando cliente"})
public class ComandoControladorFactura {

    private final ManejadorActualizarFactura manejadorActualizarFactura;


    public ComandoControladorFactura(ManejadorActualizarFactura manejadorActualizarFactura) {
        this.manejadorActualizarFactura = manejadorActualizarFactura;
    }

    @PutMapping(value="/{idFactura}")
    @ApiOperation("Actualizar Factura")
    public void actualizar(@RequestBody ComandoFactura comandoFactura, @PathVariable Long idFactura) {
        comandoFactura.setIdFactura(idFactura);
        manejadorActualizarFactura.ejecutar(comandoFactura);
    }
}
