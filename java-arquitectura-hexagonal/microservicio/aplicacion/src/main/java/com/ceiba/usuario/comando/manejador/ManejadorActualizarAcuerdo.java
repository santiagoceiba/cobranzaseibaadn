package com.ceiba.usuario.comando.manejador;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.comando.ComandoAcuerdoPago;
import com.ceiba.usuario.comando.fabrica.FabricaAcuerdoPago;
import com.ceiba.usuario.comando.fabrica.FabricaAcuerdoPagoDto;
import com.ceiba.usuario.modelo.dto.DtoAcuerdoPago;
import com.ceiba.usuario.modelo.entidad.AcuerdoPago;
import com.ceiba.usuario.puerto.dao.DaoAcuerdoPago;
import com.ceiba.usuario.servicio.ServicioActualizarAcuerdoPago;

@Component
public class ManejadorActualizarAcuerdo implements ManejadorComando<ComandoAcuerdoPago>{

	private final FabricaAcuerdoPago fabricaAcuerdoPago;
	private final FabricaAcuerdoPagoDto fabricaAcuerdoPagoDto;
	private final ServicioActualizarAcuerdoPago servicioActualizarAcuerdoPago;
	private final DaoAcuerdoPago daoAcuerdoPago;
	
	public ManejadorActualizarAcuerdo(FabricaAcuerdoPago fabricaAcuerdoPago,
			ServicioActualizarAcuerdoPago servicioActualizarAcuerdoPago,
			 DaoAcuerdoPago daoAcuerdoPago,
			 FabricaAcuerdoPagoDto fabricaAcuerdoPagoDto) {

		this.fabricaAcuerdoPago = fabricaAcuerdoPago;
		this.servicioActualizarAcuerdoPago = servicioActualizarAcuerdoPago;
		this.daoAcuerdoPago = daoAcuerdoPago;
		this.fabricaAcuerdoPagoDto = fabricaAcuerdoPagoDto;
	}
	
	  public void ejecutar(ComandoAcuerdoPago comandoAcuerdoPago) {
	        AcuerdoPago acuerdoPago = this.fabricaAcuerdoPago.crear(comandoAcuerdoPago);
	        this.servicioActualizarAcuerdoPago.ejecutar(acuerdoPago);
	    }
	  
	  public void ejecutarTareaJuridicos() {
		  List<DtoAcuerdoPago> listaAcuerdosPago = this.daoAcuerdoPago.listar();
		  for (DtoAcuerdoPago dtoAcuerdoPago : listaAcuerdosPago) {
			  AcuerdoPago acuerdoPago = this.fabricaAcuerdoPagoDto.crear(dtoAcuerdoPago);
			  this.servicioActualizarAcuerdoPago.ejecutarTareaJuridicos(acuerdoPago);
		}
		  
	  }
	
}
