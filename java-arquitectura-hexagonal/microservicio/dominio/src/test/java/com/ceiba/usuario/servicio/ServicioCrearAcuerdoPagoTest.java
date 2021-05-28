package com.ceiba.usuario.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.AcuerdoPago;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioAcuerdo;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.AcuerdoPagoTestDataBuilder;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;

public class ServicioCrearAcuerdoPagoTest {

    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
        AcuerdoPago acuerdoPago = new AcuerdoPagoTestDataBuilder().build();
        RepositorioAcuerdo repositorioAcuerdo = Mockito.mock(RepositorioAcuerdo.class);
        Mockito.when(repositorioAcuerdo.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearAcuerdoPago servicioCrearAcuerdo = new ServicioCrearAcuerdoPago(repositorioAcuerdo);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearAcuerdo.ejecutar(acuerdoPago), ExcepcionDuplicidad.class,"El acuerdo ya existe en el sistema");
    }
}
