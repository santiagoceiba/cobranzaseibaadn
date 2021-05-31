package com.ceiba.deuda.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.deuda.comando.ComandoDeuda;
import com.ceiba.deuda.modelo.entidad.Deuda;

@Component
public class FabricaDeuda {

	public Deuda crear(ComandoDeuda comandoDeuda) {
		return new Deuda(comandoDeuda.getMonto(), comandoDeuda.getFechaInicialDeudaCliente(),
				comandoDeuda.getNombreEntidadDeuda(), comandoDeuda.getConceptoDeuda(), comandoDeuda.getIdCliente(),
				comandoDeuda.getIdDeuda()

		);
	}

}
