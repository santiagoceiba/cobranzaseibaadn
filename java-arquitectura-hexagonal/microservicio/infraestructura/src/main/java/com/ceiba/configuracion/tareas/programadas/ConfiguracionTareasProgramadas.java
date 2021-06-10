package com.ceiba.configuracion.tareas.programadas;

import com.ceiba.acuerdo.pago.comando.manejador.ManejadorGenerarCobroJuridico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


@Configuration
public class ConfiguracionTareasProgramadas {

	@Autowired
	private ManejadorGenerarCobroJuridico manejadorGenerarCobroJuridico;
	@PostConstruct
	public void startScheduleTask(){
		Timer timer = new Timer();
		// Tarea que toma alrededor de 2s
		TimerTask task1 = new TimerTask() {
			@Override
			public void run() {
				// Obtenga la hora de inicio esperada de la tarea para esta ejecución
				manejadorGenerarCobroJuridico.ejecutarTareaJuridicos();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
				}
			}
		};
		LocalDateTime localDateTime1 = LocalDateTime.now().plusSeconds(-11);
		Date date = Date.from(localDateTime1.atZone(ZoneId.systemDefault()).toInstant());
		// Establece la hora de inicio programada en 11s
		timer.schedule(task1, date, 5000);
	}

}
