package com.ceiba.cliente.modelo;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.usuario.servicio.testdatabuilder.ClienteTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {

    @Test
    public void validarNombre() {
        Cliente cliente = new ClienteTestDataBuilder().build();
        String nombre = cliente.getNombre();
        Assert.assertNotNull(nombre);
    }

    @Test
    public void validarCedula() {
        Cliente cliente = new ClienteTestDataBuilder().build();
        String cedula = cliente.getCedula();
        Assert.assertNotNull(cedula);
    }
}
