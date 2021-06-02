package com.ceiba.usuario.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.servicio.testdatabuilder.ClienteTestDataBuilder;

public class ServicioCrearClienteTest {

	@Test
	public void validarClienteExistenciaPreviaTest() {
		// arrange
		Cliente cliente = new ClienteTestDataBuilder().build();
		RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
		Mockito.when(repositorioCliente.existe(Mockito.anyString())).thenReturn(true);
		ServicioCrearCliente serviciCrearCliente = new ServicioCrearCliente(repositorioCliente);
		// act - assert
		BasePrueba.assertThrows(() -> serviciCrearCliente.ejecutar(cliente), ExcepcionDuplicidad.class,
				"El cliente ya existe en el sistema");
	}
}
