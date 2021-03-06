package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;
import com.ceiba.acuerdo.pago.puerto.repositorio.RepositorioAcuerdo;
import com.ceiba.acuerdo.pago.servicio.ServicioCrearAcuerdoPago;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.servicio.testdatabuilder.AcuerdoPagoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearAcuerdoPagoTest {

    @Test
    public void validarAcuerdoExistenciaPreviaTest() {
        // arrange
        AcuerdoPago acuerdoPago = new AcuerdoPagoTestDataBuilder().build();
        RepositorioAcuerdo repositorioAcuerdo = Mockito.mock(RepositorioAcuerdo.class);
        Mockito.when(repositorioAcuerdo.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearAcuerdoPago servicioCrearAcuerdo = new ServicioCrearAcuerdoPago(repositorioAcuerdo);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearAcuerdo.ejecutar(acuerdoPago), ExcepcionDuplicidad.class,"El acuerdo ya existe en el sistema");
    }
}
