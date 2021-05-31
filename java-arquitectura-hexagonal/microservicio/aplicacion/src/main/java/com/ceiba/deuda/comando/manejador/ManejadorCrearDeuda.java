package com.ceiba.deuda.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.deuda.comando.ComandoDeuda;
import com.ceiba.deuda.comando.fabrica.FabricaDeuda;
import com.ceiba.deuda.modelo.entidad.Deuda;
import com.ceiba.deuda.servicio.ServicioCrearDeuda;
import com.ceiba.manejador.ManejadorComandoRespuesta;

@Component
public class ManejadorCrearDeuda implements ManejadorComandoRespuesta<ComandoDeuda, ComandoRespuesta<Long>>{

	private final FabricaDeuda fabricaDeuda;
	private final ServicioCrearDeuda servicioCrearDeuda;
	
	
	public ManejadorCrearDeuda(FabricaDeuda fabricaDeuda, ServicioCrearDeuda servicioCrearDeuda) {
		this.fabricaDeuda = fabricaDeuda;
		this.servicioCrearDeuda = servicioCrearDeuda;
	}


	@Override
	public ComandoRespuesta<Long> ejecutar(ComandoDeuda comando) {
		Deuda deuda = this.fabricaDeuda.crear(comando);
		return  new ComandoRespuesta<>(this.servicioCrearDeuda.ejecutar(deuda));
	}

}
