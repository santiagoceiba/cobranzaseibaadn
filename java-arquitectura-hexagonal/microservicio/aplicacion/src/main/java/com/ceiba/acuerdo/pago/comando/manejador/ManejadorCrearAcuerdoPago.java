package com.ceiba.acuerdo.pago.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.acuerdo.pago.comando.ComandoAcuerdoPago;
import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;
import com.ceiba.acuerdo.pago.servicio.ServicioCrearAcuerdoPago;
import com.ceiba.acuerdo.pagocomando.fabrica.FabricaAcuerdoPago;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearAcuerdoPago {
	
	private FabricaAcuerdoPago fabrica;
	private ServicioCrearAcuerdoPago servicioCrearAcuerdoPago;
	
	public ManejadorCrearAcuerdoPago(FabricaAcuerdoPago fabrica, ServicioCrearAcuerdoPago servicioCrearAcuerdoPago) {
		this.fabrica = fabrica;
		this.servicioCrearAcuerdoPago = servicioCrearAcuerdoPago;
	}
	
	  public ComandoRespuesta<Long> ejecutar(ComandoAcuerdoPago comandoAcuerdoPago) {
	        AcuerdoPago acuerdoPago = this.fabrica.crear(comandoAcuerdoPago);
	        return new ComandoRespuesta<>(this.servicioCrearAcuerdoPago.ejecutar(acuerdoPago));
	    }
}
