package com.ceiba.usuario.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.deuda.modelo.entidad.Deuda;
import com.ceiba.deuda.puerto.repositorio.RepositorioDeuda;
import com.ceiba.deuda.servicio.ServicioActualizacionDeuda;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.servicio.testdatabuilder.DeudaTestDataBuilder;

public class ServicioActualizacionDeudaTest {

    @Test
    public void validarDeudaExistenciaPreviaTest() {
        // arrange
        Deuda deuda = new DeudaTestDataBuilder().conId(1L).build();
        RepositorioDeuda repositorioDeuda = Mockito.mock(RepositorioDeuda.class);
        Mockito.when(repositorioDeuda.existe(Mockito.anyLong())).thenReturn(false);
        ServicioActualizacionDeuda servicioActualizacionDeuda = new ServicioActualizacionDeuda(repositorioDeuda);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizacionDeuda.ejecutar(deuda), ExcepcionDuplicidad.class,"El cliente no se puede actualizar porque no existe en el sistema");
    }
}
