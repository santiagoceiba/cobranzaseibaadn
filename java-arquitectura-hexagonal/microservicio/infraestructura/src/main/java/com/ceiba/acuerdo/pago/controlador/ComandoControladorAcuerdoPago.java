package com.ceiba.acuerdo.pago.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.acuerdo.pago.comando.ComandoAcuerdoPago;
import com.ceiba.acuerdo.pago.comando.manejador.ManejadorCrearAcuerdoPago;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acuerdosPagos")
@CrossOrigin(origins = "http://localhost:4200")
@Api(tags = { "Controlador comando para la inserción de los acuerdos de pagos"})
public class ComandoControladorAcuerdoPago {
	
	private final ManejadorCrearAcuerdoPago manejadorListaAcuerdosPagos;

	public ComandoControladorAcuerdoPago(ManejadorCrearAcuerdoPago manejadorListaAcuerdosPagos) {
		this.manejadorListaAcuerdosPagos = manejadorListaAcuerdosPagos;
	}
	
	@PostMapping(value="/crear")
    @ApiOperation("Crear acuerdo")
	public ComandoRespuesta<Long> crear(@RequestBody ComandoAcuerdoPago comandoAcuerdo) {

	       return manejadorListaAcuerdosPagos.ejecutar(comandoAcuerdo);
	    }
}
//investigar proxy reverse angular