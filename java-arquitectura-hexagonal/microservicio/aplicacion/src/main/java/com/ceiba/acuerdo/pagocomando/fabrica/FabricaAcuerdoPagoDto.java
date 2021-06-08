package com.ceiba.acuerdo.pagocomando.fabrica;

import com.ceiba.acuerdo.pago.modelo.dto.DtoAcuerdoPago;
import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;
import org.springframework.stereotype.Component;

@Component
public class FabricaAcuerdoPagoDto {

	public AcuerdoPago crear(DtoAcuerdoPago dtoAcuerdoPago) {
		return new AcuerdoPago(dtoAcuerdoPago.getIdAcuerdoPago(), dtoAcuerdoPago.getFechaAcuerdo(), dtoAcuerdoPago.getMontoCuota(),
				dtoAcuerdoPago.getCliente(), dtoAcuerdoPago.getDeuda(), dtoAcuerdoPago.getEstado(),
				dtoAcuerdoPago.getCantidadCuotas(), dtoAcuerdoPago.getNumeroReferencia());
	}
}
