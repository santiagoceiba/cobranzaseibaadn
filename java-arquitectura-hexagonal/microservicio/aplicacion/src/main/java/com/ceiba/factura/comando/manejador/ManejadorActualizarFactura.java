package com.ceiba.factura.comando.manejador;
import com.ceiba.factura.comando.ComandoFactura;
import com.ceiba.factura.comando.fabrica.FabricaFactura;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.servicio.ServicioCambiarEstadoPagoFactura;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarFactura {

	private final FabricaFactura fabricaFactura;
	private final ServicioCambiarEstadoPagoFactura servicioCambiarEstadoPagoFactura;
	
	
	public ManejadorActualizarFactura(FabricaFactura fabricaFactura,
			ServicioCambiarEstadoPagoFactura servicioCambiarEstadoPagoFactura) {
		this.fabricaFactura = fabricaFactura;
		this.servicioCambiarEstadoPagoFactura = servicioCambiarEstadoPagoFactura;
	}

	public void ejecutar(ComandoFactura comandoFactura) {
		Factura factura = this.fabricaFactura.crear(comandoFactura);
		this.servicioCambiarEstadoPagoFactura.ejecutar(factura);
	}
}
