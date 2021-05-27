package com.ceiba.usuario.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.ComandoAcuerdoPago;
import com.ceiba.usuario.modelo.entidad.AcuerdoPago;

@Component
public class FabricaAcuerdoPago {

	public AcuerdoPago crear(ComandoAcuerdoPago comandoAcuerdoPago) {
		return new AcuerdoPago(comandoAcuerdoPago.getFechaAcuerdo(), comandoAcuerdoPago.getMontoCuota(),
				comandoAcuerdoPago.getCliente(), comandoAcuerdoPago.getDeuda(), comandoAcuerdoPago.getEstado(),
				comandoAcuerdoPago.getCantidadCuotas());
	}
}
