package com.ceiba.deuda.modelo;

import com.ceiba.deuda.modelo.entidad.Deuda;
import com.ceiba.usuario.servicio.testdatabuilder.DeudaTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class DeudaTest {

    @Test
    public void validarAumentoMontoDeuda() {
        LocalDateTime fechaInicialDeuda = LocalDateTime.of(2019,05,05,00,01);
        Double montoInicial = 100.0;
        Deuda deuda = new DeudaTestDataBuilder().conMonto(montoInicial).conFecha(fechaInicialDeuda).build();
        Assert.assertTrue(montoInicial*1.01 == deuda.getMonto());
    }
    @Test
   public void validarFecha(){
        Deuda deuda = new DeudaTestDataBuilder().build();
        LocalDateTime fechaDeuda = deuda.getFechaInicialDeudaCliente();
        Assert.assertNotNull(fechaDeuda);
    }
    @Test
    public void validarNombre(){
        Deuda deuda = new DeudaTestDataBuilder().build();
        String nombreEntidadDeuda = deuda.getNombreEntidadDeuda();
        Assert.assertNotNull(nombreEntidadDeuda);
    }
    @Test
    public void validarConcepto(){
        Deuda deuda = new DeudaTestDataBuilder().build();
        String conceptoDeuda = deuda.getConceptoDeuda();
        Assert.assertNotNull(conceptoDeuda);
    }
    @Test
    public void validarMonto() {
        Deuda deuda = new DeudaTestDataBuilder().build();
        Double monto = deuda.getMonto();
        Assert.assertNotNull(monto);
    }


}
