package com.ceiba.acuerdo.pago.modelo;

import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;
import com.ceiba.acuerdopago.utilidades.enumeracion.EstadoAcuerdo;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.usuario.servicio.testdatabuilder.AcuerdoPagoTestDataBuilder;
import com.ceiba.usuario.servicio.testdatabuilder.FacturaTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;

import org.mockito.Mockito;

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

    private List<Factura> simularListaFacturas() {
        List<Factura> listaFacturas = new ArrayList<>();
        Factura factura1 = new FacturaTestDataBuilder().conEstado(false).build();
        Factura factura2 = new FacturaTestDataBuilder().conEstado(false).build();
        Factura factura3 = new FacturaTestDataBuilder().conEstado((false)).build();
        listaFacturas = Arrays.asList(factura1, factura2, factura3);
        return listaFacturas;
    }
}
