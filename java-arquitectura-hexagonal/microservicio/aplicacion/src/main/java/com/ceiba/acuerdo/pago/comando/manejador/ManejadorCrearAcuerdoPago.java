package com.ceiba.acuerdo.pago.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.acuerdo.pago.comando.ComandoAcuerdoPago;
import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;
import com.ceiba.acuerdo.pago.servicio.ServicioCrearAcuerdoPago;
import com.ceiba.acuerdo.pagocomando.fabrica.FabricaAcuerdoPago;

@Component
public class ManejadorCrearAcuerdoPago {
	
	private FabricaAcuerdoPago fabrica;
	private ServicioCrearAcuerdoPago servicioCrearAcuerdoPago;
	
	public ManejadorCrearAcuerdoPago(FabricaAcuerdoPago fabrica, ServicioCrearAcuerdoPago servicioCrearAcuerdoPago) {
		this.fabrica = fabrica;
		this.servicioCrearAcuerdoPago = servicioCrearAcuerdoPago;
	}
	
	  public ComandoRespuesta<Long> ejecutar(ComandoAcuerdoPago comandoAcuerdoPago) {
			System.out.print("comandoacuerdo334567"+comandoAcuerdoPago.getCantidadCuotas()+
					comandoAcuerdoPago.getEstado()+ comandoAcuerdoPago.getFechaAcuerdo()+ comandoAcuerdoPago.getIdCliente()+ comandoAcuerdoPago.getIdDeuda());
	        AcuerdoPago acuerdoPago = this.fabrica.crear(comandoAcuerdoPago);

	        return new ComandoRespuesta<>(this.servicioCrearAcuerdoPago.ejecutar(acuerdoPago));
	    }
}
