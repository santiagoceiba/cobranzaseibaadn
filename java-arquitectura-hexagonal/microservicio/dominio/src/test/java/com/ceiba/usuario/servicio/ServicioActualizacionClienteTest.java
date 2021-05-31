package com.ceiba.usuario.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioActualizacionCliente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.servicio.testdatabuilder.ClienteTestDataBuilder;

public class ServicioActualizacionClienteTest {

	
    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().conId(1L).build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.existe(Mockito.any())).thenReturn(true);
        ServicioActualizacionCliente servicioActualizacionCliente = new ServicioActualizacionCliente(repositorioCliente);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizacionCliente.ejecutar(cliente), ExcepcionDuplicidad.class,"El cliente ya existe en el sistema");
    }
}
