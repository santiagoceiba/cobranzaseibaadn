package com.ceiba.deuda.controlador;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.deuda.comando.ComandoDeuda;
import com.ceiba.deuda.comando.manejador.ManejadorCrearDeuda;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/deudas")
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
