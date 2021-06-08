package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.deuda.modelo.entidad.Deuda;
import com.ceiba.deuda.puerto.repositorio.RepositorioDeuda;
import com.ceiba.deuda.servicio.ServicioCrearDeuda;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.servicio.testdatabuilder.DeudaTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearDeudaTest {

	@Test
	public void validarDeudaExistenciaPreviaTest() {
		// arrange
		Deuda deuda = new DeudaTestDataBuilder().build();
		RepositorioDeuda repositorioDeuda = Mockito.mock(RepositorioDeuda.class);
		Mockito.when(repositorioDeuda.existe(Mockito.anyLong())).thenReturn(true);
		ServicioCrearDeuda servicioCrearDeuda = new ServicioCrearDeuda(repositorioDeuda);
		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearDeuda.ejecutar(deuda), ExcepcionDuplicidad.class,
				"La deuda ya existe en el sistema");
	}

}
