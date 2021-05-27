package com.ceiba.usuario.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.ComandoDeuda;
import com.ceiba.usuario.modelo.entidad.Deuda;

@Component
public class FabricaDeuda {

	public Deuda crear(ComandoDeuda comandoDeuda) {
		return new Deuda(comandoDeuda.getMonto(), comandoDeuda.getFechaInicialDeudaCliente(),
				comandoDeuda.getNombreEntidadDeuda(), comandoDeuda.getConceptoDeuda(), comandoDeuda.getIdCliente(),
				comandoDeuda.getIdDeuda()

		);
	}

}
