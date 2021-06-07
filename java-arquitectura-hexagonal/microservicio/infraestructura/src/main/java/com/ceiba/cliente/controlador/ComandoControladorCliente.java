package com.ceiba.cliente.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.comando.manejador.ManejadorActualizarCliente;
import com.ceiba.cliente.comando.manejador.ManejadorCrearCliente;
import com.ceiba.cliente.comando.manejador.ManejadorEliminarCliente;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200")
@Api(tags = { "Controlador comando cliente"})
public class ComandoControladorCliente {
	
	private final ManejadorActualizarCliente manejadorActualizarCliente;
	private final ManejadorCrearCliente manejadorCrearCliente;
	private final ManejadorEliminarCliente manejadorEliminarCliente;
	
	@Autowired
	public ComandoControladorCliente(ManejadorActualizarCliente manejadorActualizarCliente,
			ManejadorCrearCliente manejadorCrearCliente, ManejadorEliminarCliente manejadorEliminarCliente) {
		this.manejadorActualizarCliente = manejadorActualizarCliente;
		this.manejadorCrearCliente = manejadorCrearCliente;
		this.manejadorEliminarCliente = manejadorEliminarCliente;
	}
	
    @PostMapping(value="/crear")
    @ApiOperation("Crear Cliente")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCliente comandoCliente) {
        return manejadorCrearCliente.ejecutar(comandoCliente);
    }
    
    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Cliente")
	public void eliminar(@PathVariable Long id) {
    	manejadorEliminarCliente.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Cliente")
	public void actualizar(@RequestBody ComandoCliente comandoCliente,@PathVariable Long id) {
		comandoCliente.setIdCliente(id);
		manejadorActualizarCliente.ejecutar(comandoCliente);
	}

}
