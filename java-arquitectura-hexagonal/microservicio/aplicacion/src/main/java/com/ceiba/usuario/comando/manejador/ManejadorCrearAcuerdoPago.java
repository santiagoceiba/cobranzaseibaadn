package com.ceiba.usuario.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;
import com.ceiba.acuerdo.pago.servicio.ServicioCrearAcuerdoPago;
import com.ceiba.usuario.comando.ComandoAcuerdoPago;
import com.ceiba.usuario.comando.fabrica.FabricaAcuerdoPago;

@Component
public class ManejadorCrearAcuerdoPago {
	
	private FabricaAcuerdoPago fabrica;
	private ServicioCrearAcuerdoPago servicioCrearAcuerdoPago;
	
	public ManejadorCrearAcuerdoPago(FabricaAcuerdoPago fabrica, ServicioCrearAcuerdoPago servicioCrearAcuerdoPago) {
		super();
		this.fabrica = fabrica;
		this.servicioCrearAcuerdoPago = servicioCrearAcuerdoPago;
	}
	
	  public ComandoRespuesta<Long> ejecutar(ComandoAcuerdoPago comandoAcuerdoPago) {
	        AcuerdoPago acuerdoPago = this.fabrica.crear(comandoAcuerdoPago);
	        return new ComandoRespuesta<>(this.servicioCrearAcuerdoPago.ejecutar(acuerdoPago));
	    }
}
