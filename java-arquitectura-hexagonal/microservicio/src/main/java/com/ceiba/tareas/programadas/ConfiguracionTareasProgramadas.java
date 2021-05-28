package com.ceiba.tareas.programadas;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.ceiba.usuario.comando.manejador.ManejadorActualizarAcuerdo;
import com.ceiba.usuario.consulta.ManejadorListaAcuerdosPagos;
import com.ceiba.usuario.modelo.dto.DtoAcuerdoPago;

@Configuration
@EnableScheduling
public class ConfiguracionTareasProgramadas {

	// private final ManejadorListaAcuerdosPagos manejadorListaAcuerdosPagos;
	private final ManejadorActualizarAcuerdo manejadorActualizarAcuerdo;

//	
//	public ConfiguracionTareasProgramadas(ManejadorListaAcuerdosPagos manejadorListaAcuerdosPagos) {
//		this.manejadorListaAcuerdosPagos = manejadorListaAcuerdosPagos;
//	}
	public ConfiguracionTareasProgramadas(ManejadorActualizarAcuerdo manejadorActualizarAcuerdo) {
		this.manejadorActualizarAcuerdo = manejadorActualizarAcuerdo;
	}

	@Scheduled(cron = "0 0 8 * * *", zone = "America/Bogota")
	public void generarCobrosJuridicos() {
		manejadorActualizarAcuerdo.ejecutarTareaJuridicos();
	}

}
