package com.ceiba.acuerdo.pago.comando.manejador;

import com.ceiba.acuerdo.pago.servicio.ServicioGenerarCobroJuridico;
import org.springframework.stereotype.Component;

@Component
public class ManejadorGenerarCobroJuridico {

    private final ServicioGenerarCobroJuridico servicioGenerarCobroJuridico;

    public ManejadorGenerarCobroJuridico(ServicioGenerarCobroJuridico servicioGenerarCobroJuridico) {
        this.servicioGenerarCobroJuridico = servicioGenerarCobroJuridico;
    }

    public void ejecutarTareaJuridicos() {
        System.out.println("------------------------------------>ejecutar cobros");
        this.servicioGenerarCobroJuridico.ejecutarTareaJuridicos();
    }
}
