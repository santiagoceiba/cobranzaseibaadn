package com.ceiba.acuerdo.pago.comando.manejador;


import org.springframework.stereotype.Component;

import com.ceiba.acuerdo.pago.comando.ComandoAcuerdoPago;

import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;
import com.ceiba.acuerdo.pago.puerto.dao.DaoAcuerdoPago;
import com.ceiba.acuerdo.pago.servicio.ServicioActualizarAcuerdoPago;
import com.ceiba.acuerdo.pago.servicio.ServicioGenerarCobroJuridico;
import com.ceiba.acuerdo.pagocomando.fabrica.FabricaAcuerdoPago;
import com.ceiba.manejador.ManejadorComando;

@Component
public class ManejadorActualizarAcuerdo implements ManejadorComando<ComandoAcuerdoPago>{

	private final FabricaAcuerdoPago fabricaAcuerdoPago;

	private final ServicioActualizarAcuerdoPago servicioActualizarAcuerdoPago;
	private final ServicioGenerarCobroJuridico servicioGenerarCobroJuridico;
	private final DaoAcuerdoPago daoAcuerdoPago;
	
	public ManejadorActualizarAcuerdo(FabricaAcuerdoPago fabricaAcuerdoPago,
			ServicioActualizarAcuerdoPago servicioActualizarAcuerdoPago,
			 DaoAcuerdoPago daoAcuerdoPago,
			 ServicioGenerarCobroJuridico servicioGenerarCobroJuridico) {

		this.fabricaAcuerdoPago = fabricaAcuerdoPago;
		this.servicioActualizarAcuerdoPago = servicioActualizarAcuerdoPago;
		this.daoAcuerdoPago = daoAcuerdoPago;
		this.servicioGenerarCobroJuridico = servicioGenerarCobroJuridico;
	}
	
	  public void ejecutar(ComandoAcuerdoPago comandoAcuerdoPago) {
	        AcuerdoPago acuerdoPago = this.fabricaAcuerdoPago.crear(comandoAcuerdoPago);
	        this.servicioActualizarAcuerdoPago.ejecutar(acuerdoPago);
	    }
}
