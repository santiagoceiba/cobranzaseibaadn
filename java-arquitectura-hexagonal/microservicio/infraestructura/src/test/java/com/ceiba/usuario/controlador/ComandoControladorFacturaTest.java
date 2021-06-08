package com.ceiba.usuario.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.factura.adaptador.controlador.ComandoControladorFactura;
import com.ceiba.factura.comando.ComandoFactura;
import com.ceiba.usuario.servicio.testdatabuilder.ComandoFacturaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorFactura.class)
@AutoConfigureMockMvc(addFilters = false)
public class ComandoControladorFacturaTest {


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;
    @Test
    public void actualizar() throws Exception{
        // arrange
        Long id = 1L;
        ComandoFactura factura = new ComandoFacturaTestDataBuilder().build();

        // act - assert
        mocMvc.perform(put("/factura/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(factura)))
                .andExpect(status().isOk());
    }

}
