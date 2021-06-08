package com.ceiba.acuerdo.pago.modelo;

import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;
import com.ceiba.acuerdopago.utilidades.enumeracion.EstadoAcuerdo;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.usuario.servicio.testdatabuilder.AcuerdoPagoTestDataBuilder;
import com.ceiba.usuario.servicio.testdatabuilder.FacturaTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AcuerdoPagoTest {

    @Test
    public void cambiarAEstdoJuridico(){
        AcuerdoPago acuerdoPago =new  AcuerdoPagoTestDataBuilder().conListaFacturas(simularListaFacturas()).buildConFactura();
        acuerdoPago.cambiarAEstadoJuridico();
        Assert.assertTrue(acuerdoPago.getEstado() == EstadoAcuerdo.COBRO_JURIDICO);
    }

    @Test
    public void modificarCuotasAcuerdoPago(){
        AcuerdoPago acuerdoPago = new AcuerdoPagoTestDataBuilder().build();
        Double nuevoMontoCuota = 200.0;
        Integer cantidadCuotas = 4;
        acuerdoPago.modificarCuotasAcuerdoPago(nuevoMontoCuota, cantidadCuotas);
        Assert.assertTrue((acuerdoPago.getMontoCuota() == nuevoMontoCuota)&&(acuerdoPago.getCantidadCuotas() == cantidadCuotas));
    }

    @Test
    public void validarFecha() {
        AcuerdoPago acuerdoPago = new AcuerdoPagoTestDataBuilder().build();
        LocalDateTime fechaAcuerdo = acuerdoPago.getFechaAcuerdo();
        Assert.assertNotNull(fechaAcuerdo);
    }

    @Test
    public void validarCampoCuota() {
        AcuerdoPago acuerdoPago = new AcuerdoPagoTestDataBuilder().build();
        Double montoCuota = acuerdoPago.getMontoCuota();
        Assert.assertNotNull(montoCuota);
    }

    @Test
    public void validarCampoCantidadCuotas() {
        AcuerdoPago acuerdoPago = new AcuerdoPagoTestDataBuilder().build();
        Integer cantidadCuotas = acuerdoPago.getCantidadCuotas();
        Assert.assertNotNull(cantidadCuotas);
    }

    @Test
    public void validarCampoNumeroReferencia (){
        AcuerdoPago acuerdoPago = new AcuerdoPagoTestDataBuilder().build();
        Long numeroReferencia = acuerdoPago.getNumeroReferencia();
        Assert.assertNotNull(numeroReferencia);
    }
    private List<Factura> simularListaFacturas() {
        List<Factura> listaFacturas = new ArrayList<>();
        Factura factura1 = new FacturaTestDataBuilder().conEstado(false).build();
        Factura factura2 = new FacturaTestDataBuilder().conEstado(false).build();
        Factura factura3 = new FacturaTestDataBuilder().conEstado((false)).build();
        listaFacturas = Arrays.asList(factura1, factura2, factura3);
        return listaFacturas;
    }
}
