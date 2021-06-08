package com.ceiba.acuerdo.pagocomando.fabrica;

import com.ceiba.acuerdo.pago.comando.ComandoAcuerdoPago;
import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.deuda.modelo.entidad.Deuda;
import com.ceiba.deuda.puerto.repositorio.RepositorioDeuda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FabricaAcuerdoPago {
	
	@Autowired
	private RepositorioCliente repositorioCliente;
	
	@Autowired
	private RepositorioDeuda repositorioDeuda;
	
	public AcuerdoPago crear(ComandoAcuerdoPago comandoAcuerdoPago) {
		
		Cliente cliente = obtenerCliente(comandoAcuerdoPago.getIdCliente());
		Deuda deuda = obtenerDeuda(comandoAcuerdoPago.getIdDeuda());
		return new AcuerdoPago(comandoAcuerdoPago.getIdAcuerdoPago(), comandoAcuerdoPago.getFechaAcuerdo(), comandoAcuerdoPago.getMontoCuota(),
				cliente, deuda, (comandoAcuerdoPago.getEstado()),
				comandoAcuerdoPago.getCantidadCuotas(), comandoAcuerdoPago.getNumeroReferencia());
	}
	
	
	/**
	 * Método que permite consultar una deuda a partir de su id
	 * 
	 * @param idDeuda id de la deuda a consultar
	 * @return la deuda requerido
	 */
	private Deuda obtenerDeuda(Long idDeuda) {
		return this.repositorioDeuda.consultarDeuda(idDeuda);
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
