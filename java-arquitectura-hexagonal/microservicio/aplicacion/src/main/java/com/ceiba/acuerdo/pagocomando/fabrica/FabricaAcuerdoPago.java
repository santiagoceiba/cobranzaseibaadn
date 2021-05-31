package com.ceiba.acuerdo.pagocomando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.acuerdo.pago.comando.ComandoAcuerdoPago;
import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;

@Component
public class FabricaAcuerdoPago {

	public AcuerdoPago crear(ComandoAcuerdoPago comandoAcuerdoPago) {
		return new AcuerdoPago(comandoAcuerdoPago.getIdAcuerdoPago(), comandoAcuerdoPago.getFechaAcuerdo(), comandoAcuerdoPago.getMontoCuota(),
				comandoAcuerdoPago.getIdCliente(), comandoAcuerdoPago.getIdDeuda(), (comandoAcuerdoPago.getEstado()),
				comandoAcuerdoPago.getCantidadCuotas(), comandoAcuerdoPago.getNumeroReferencia());
	}
}
