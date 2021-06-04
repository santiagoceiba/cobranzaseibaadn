package com.ceiba.usuario.controlador;


import com.ceiba.ApplicationMock;

import com.ceiba.acuerdo.pago.controlador.ComandoControladorAcuerdoPago;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorAcuerdoPago.class)
@AutoConfigureMockMvc(addFilters = false)
public class ConsultaControladorAcuerdoPagoTest {


    @Autowired
    private MockMvc mocMvc;

    @Test
    public void listar() throws Exception{
        mocMvc.perform(get("/acuerdos/listar")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].numeroReferencia", is(1234)));
    }
}
