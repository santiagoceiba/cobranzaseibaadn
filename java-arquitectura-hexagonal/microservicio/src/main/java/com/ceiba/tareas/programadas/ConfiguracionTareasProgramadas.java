package com.ceiba.tareas.programadas;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

//import com.ceiba.usuario.comando.manejador.ManejadorActualizarAcuerdo;


@Configuration
@EnableScheduling
public class ConfiguracionTareasProgramadas {


//	private final ManejadorActualizarAcuerdo manejadorActualizarAcuerdo;
//
//	public ConfiguracionTareasProgramadas(ManejadorActualizarAcuerdo manejadorActualizarAcuerdo) {
//		this.manejadorActualizarAcuerdo = manejadorActualizarAcuerdo;
//	}
//
//	@Scheduled(cron = "0 0 8 * * *", zone = "America/Bogota")
//	public void generarCobrosJuridicos() {
//		manejadorActualizarAcuerdo.ejecutarTareaJuridicos();
//	}

}
