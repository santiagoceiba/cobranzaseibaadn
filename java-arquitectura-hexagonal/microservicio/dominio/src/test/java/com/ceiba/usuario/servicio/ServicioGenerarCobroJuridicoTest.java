package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;
import com.ceiba.acuerdo.pago.puerto.repositorio.RepositorioAcuerdo;
import com.ceiba.acuerdo.pago.servicio.ServicioGenerarCobroJuridico;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.usuario.servicio.testdatabuilder.AcuerdoPagoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ServicioGenerarCobroJuridicoTest {
	
	
    @Test
    public void validarObtenerListaFacturas() {
        // arrange
        AcuerdoPago acuerdoPago = new AcuerdoPagoTestDataBuilder().build();
        RepositorioAcuerdo repositorioAcuerdo = Mockito.mock(RepositorioAcuerdo.class);
        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        Mockito.when(repositorioFactura.obtenerListaFacturas(Mockito.anyLong())).thenReturn(listaFacturasMock());
        Mockito.when(repositorioAcuerdo.listarAcuerdosPago()).thenReturn(listaAcuerdosMock());
        ServicioGenerarCobroJuridico servicioGenerarCobroJuridico = new ServicioGenerarCobroJuridico(repositorioAcuerdo, repositorioFactura);
        // act - assert
        BasePrueba.assertThrows(() -> servicioGenerarCobroJuridico.ejecutarTareaJuridicos(), ExcepcionSinDatos.class,"El acuerdo no contiene ninguna factura");
    }

    private List<AcuerdoPago> listaAcuerdosMock() {
        List<AcuerdoPago> listaAcuerdos = new ArrayList<>();
        AcuerdoPagoTestDataBuilder acuerdoPagoTestDataBuilder = new AcuerdoPagoTestDataBuilder();
        listaAcuerdos.add(acuerdoPagoTestDataBuilder.build());
        return listaAcuerdos;
    }

    private List<Factura> listaFacturasMock() {
		List<Factura> listaFacturas = new ArrayList<>();
		
		return listaFacturas;
	}
}
