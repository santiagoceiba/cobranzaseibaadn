package com.ceiba.usuario.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.usuario.modelo.dto.DtoAcuerdoPago;
import com.ceiba.usuario.modelo.entidad.AcuerdoPago;

@Component
public class FabricaAcuerdoPagoDto {

	public AcuerdoPago crear(DtoAcuerdoPago dtoAcuerdoPago) {
		return new AcuerdoPago(dtoAcuerdoPago.getIdAcuerdoPago(), dtoAcuerdoPago.getFechaAcuerdo(), dtoAcuerdoPago.getMontoCuota(),
				dtoAcuerdoPago.getCliente(), dtoAcuerdoPago.getDeuda(), dtoAcuerdoPago.getEstado(),
				dtoAcuerdoPago.getCantidadCuotas(), dtoAcuerdoPago.getNumeroReferencia());
	}
}
