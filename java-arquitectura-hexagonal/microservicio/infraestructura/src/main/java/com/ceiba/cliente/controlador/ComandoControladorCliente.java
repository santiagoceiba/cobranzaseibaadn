package com.ceiba.cliente.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.comando.manejador.ManejadorActualizarCliente;
import com.ceiba.cliente.comando.manejador.ManejadorCrearCliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200")
@Api(tags = { "Controlador comando cliente"})
public class ComandoControladorCliente {
	
	private final ManejadorActualizarCliente manejadorActualizarCliente;
	private final ManejadorCrearCliente manejadorCrearCliente;

	
	@Autowired
	public ComandoControladorCliente(ManejadorActualizarCliente manejadorActualizarCliente,
			ManejadorCrearCliente manejadorCrearCliente) {
		this.manejadorActualizarCliente = manejadorActualizarCliente;
		this.manejadorCrearCliente = manejadorCrearCliente;
	}
	
    @PostMapping(value="/crear")
    @ApiOperation("Crear Cliente")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCliente comandoCliente) {
        return manejadorCrearCliente.ejecutar(comandoCliente);
    }


	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Cliente")
	public void actualizar(@RequestBody ComandoCliente comandoCliente,@PathVariable Long id) {
		comandoCliente.setIdCliente(id);
		manejadorActualizarCliente.ejecutar(comandoCliente);
	}

}
