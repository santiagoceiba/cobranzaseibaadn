package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.factura.servicio.ServicioCambiarEstadoPagoFactura;
import com.ceiba.usuario.servicio.testdatabuilder.FacturaTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCambiarEstadoPagoFacturaTest {

    @Test
    public void validarFacturaExistenciaPreviaTest () {
        // arrange
        Factura factura = new FacturaTestDataBuilder().conId(1L).build();
        RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
        Mockito.when(repositorioFactura.existe(Mockito.any())).thenReturn(false);
        ServicioCambiarEstadoPagoFactura servicioCambiarEstadoPagoFactura = new ServicioCambiarEstadoPagoFactura(repositorioFactura);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCambiarEstadoPagoFactura.ejecutar(factura),
                ExcepcionDuplicidad.class,"la factura no existe en el sistema");
    }
}
