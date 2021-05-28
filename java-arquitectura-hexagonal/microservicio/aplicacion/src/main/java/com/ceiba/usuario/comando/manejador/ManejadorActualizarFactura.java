package com.ceiba.usuario.comando.manejador;

import com.ceiba.usuario.comando.fabrica.FabricaFactura;
import com.ceiba.usuario.servicio.ServicioActualizarFactura;

public class ManejadorActualizarFactura {

	private final FabricaFactura fabricaFactura;
	private final ServicioActualizarFactura servicioActualizarFactura;
	
	
	public ManejadorActualizarFactura(FabricaFactura fabricaFactura,
			ServicioActualizarFactura servicioActualizarFactura) {
		this.fabricaFactura = fabricaFactura;
		this.servicioActualizarFactura = servicioActualizarFactura;
	}
	
}
