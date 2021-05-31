package com.ceiba.usuario.comando.manejador;

import com.ceiba.factura.servicio.ServicioActualizarFactura;
import com.ceiba.usuario.comando.fabrica.FabricaFactura;

public class ManejadorActualizarFactura {

	private final FabricaFactura fabricaFactura;
	private final ServicioActualizarFactura servicioActualizarFactura;
	
	
	public ManejadorActualizarFactura(FabricaFactura fabricaFactura,
			ServicioActualizarFactura servicioActualizarFactura) {
		this.fabricaFactura = fabricaFactura;
		this.servicioActualizarFactura = servicioActualizarFactura;
	}
	
}
