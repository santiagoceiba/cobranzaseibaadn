package com.ceiba.factura.modelo;

import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.usuario.servicio.testdatabuilder.FacturaTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class FacturaTest {

    @Test
    public void esFacturaVencida(){
        Factura factura = new FacturaTestDataBuilder().build();
        Boolean resultadoFactura = factura.esFacturaAlDia();
        Assert.assertFalse(resultadoFactura);
    }

    @Test
    public void esFacturaVencidaCasoExito(){
        Factura factura = new FacturaTestDataBuilder().conFecha(LocalDateTime.now()).build();
        Boolean resultadoFactura = factura.esFacturaAlDia();
        Assert.assertTrue(resultadoFactura);
    }

    @Test
    public void validarCampoMontoCuota(){
        Factura factura = new FacturaTestDataBuilder().build();
        Double montoCuota = factura.getMontoCuota();
        Assert.assertNotNull(montoCuota);
    }
}
