package com.ceiba.usuario.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.AcuerdoPago;
import com.ceiba.usuario.puerto.dao.DaoFactura;
import com.ceiba.usuario.puerto.repositorio.RepositorioAcuerdo;
import com.ceiba.usuario.servicio.testdatabuilder.AcuerdoPagoTestDataBuilder;

public class ServicioActualizarAcuerdoPagoTest {

	
    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
        AcuerdoPago acuerdoPago = new AcuerdoPagoTestDataBuilder().conId(1L).build();
        RepositorioAcuerdo repositorioAcuerdo = Mockito.mock(RepositorioAcuerdo.class);
        DaoFactura daoFactura = Mockito.mock(DaoFactura.class);
        Mockito.when(repositorioAcuerdo.existe(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarAcuerdoPago servicioActualizarAcuerdoPago = new ServicioActualizarAcuerdoPago(repositorioAcuerdo, daoFactura);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarAcuerdoPago.ejecutar(acuerdoPago), ExcepcionDuplicidad.class,"El acuerdo ya existe en el sistema");
    }
}
