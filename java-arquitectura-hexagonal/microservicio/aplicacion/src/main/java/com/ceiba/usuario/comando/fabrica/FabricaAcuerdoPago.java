package com.ceiba.usuario.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;
import com.ceiba.usuario.comando.ComandoAcuerdoPago;

@Component
public class FabricaAcuerdoPago {

	public AcuerdoPago crear(ComandoAcuerdoPago comandoAcuerdoPago) {
		return new AcuerdoPago(comandoAcuerdoPago.getIdAcuerdoPago(), comandoAcuerdoPago.getFechaAcuerdo(), comandoAcuerdoPago.getMontoCuota(),
				comandoAcuerdoPago.getCliente(), comandoAcuerdoPago.getDeuda(), (comandoAcuerdoPago.getEstado()),
				comandoAcuerdoPago.getCantidadCuotas(), comandoAcuerdoPago.getNumeroReferencia());
	}
}
