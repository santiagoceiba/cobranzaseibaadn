package com.ceiba.deuda.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.deuda.comando.ComandoDeuda;
import com.ceiba.deuda.comando.manejador.ManejadorCrearDeuda;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deudas")
@CrossOrigin(origins = "http://localhost:4200")
@Api(tags = { "Controlador comando usuario"})
public class ComandoControladorDeuda {

	private final ManejadorCrearDeuda manejadorCrearDeuda;

	public ComandoControladorDeuda(ManejadorCrearDeuda manejadorCrearDeuda) {
		this.manejadorCrearDeuda = manejadorCrearDeuda;
	}
	
	@PostMapping(value = "/crear")
	@ApiOperation("se crea la deuda")
	public ComandoRespuesta<Long> crear(@RequestBody ComandoDeuda comandoDeuda){
		return manejadorCrearDeuda.ejecutar(comandoDeuda);
	}
}
