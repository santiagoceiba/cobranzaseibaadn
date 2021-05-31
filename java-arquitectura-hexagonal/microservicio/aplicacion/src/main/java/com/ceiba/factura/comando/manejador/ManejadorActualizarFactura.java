package com.ceiba.factura.comando.manejador;

import com.ceiba.factura.comando.fabrica.FabricaFactura;
import com.ceiba.factura.servicio.ServicioActualizarFactura;

public class ManejadorActualizarFactura {

	private final FabricaFactura fabricaFactura;
	private final ServicioActualizarFactura servicioActualizarFactura;
	
	
	public ManejadorActualizarFactura(FabricaFactura fabricaFactura,
			ServicioActualizarFactura servicioActualizarFactura) {
		this.fabricaFactura = fabricaFactura;
		this.servicioActualizarFactura = servicioActualizarFactura;
	}
	
}
