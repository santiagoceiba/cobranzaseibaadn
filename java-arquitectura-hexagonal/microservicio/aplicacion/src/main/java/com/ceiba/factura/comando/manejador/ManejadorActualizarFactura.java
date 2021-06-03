package com.ceiba.factura.comando.manejador;
import com.ceiba.factura.comando.ComandoFactura;
import com.ceiba.factura.comando.fabrica.FabricaFactura;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.servicio.ServicioActualizarFactura;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarFactura {

	private final FabricaFactura fabricaFactura;
	private final ServicioActualizarFactura servicioActualizarFactura;
	
	
	public ManejadorActualizarFactura(FabricaFactura fabricaFactura,
			ServicioActualizarFactura servicioActualizarFactura) {
		this.fabricaFactura = fabricaFactura;
		this.servicioActualizarFactura = servicioActualizarFactura;
	}

	public void ejecutar(ComandoFactura comandoFactura) {
		Factura factura = this.fabricaFactura.crear(comandoFactura);
		this.servicioActualizarFactura.ejecutar(factura);
	}
}
