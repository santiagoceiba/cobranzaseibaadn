package com.ceiba.deuda.comando.fabrica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.deuda.comando.ComandoDeuda;
import com.ceiba.deuda.modelo.entidad.Deuda;

@Component
public class FabricaDeuda {
	
	
	@Autowired
	private RepositorioCliente repositorioCliente;
	
	public Deuda crear(ComandoDeuda comandoDeuda) {
		
		Cliente cliente = obtenerCliente(comandoDeuda.getIdCliente());
		return new Deuda(comandoDeuda.getMonto(), comandoDeuda.getFechaInicialDeudaCliente(),
				comandoDeuda.getNombreEntidadDeuda(), comandoDeuda.getConceptoDeuda(), cliente,
				comandoDeuda.getIdDeuda()

		);
	}
	
	
	/**
	 * método que retorna un cliente a partir de su id
	 * @param idCliente id del cliente a retornar
	 * @return Cliente que requiere la fabrica
	 */
	private Cliente obtenerCliente(Long idCliente) {
		return 	this.repositorioCliente.consultarCliente(idCliente);
	}

}
