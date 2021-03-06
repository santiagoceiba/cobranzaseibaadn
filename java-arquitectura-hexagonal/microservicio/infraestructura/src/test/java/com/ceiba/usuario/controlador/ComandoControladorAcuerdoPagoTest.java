package com.ceiba.usuario.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.acuerdo.pago.comando.ComandoAcuerdoPago;
import com.ceiba.acuerdo.pago.controlador.ComandoControladorAcuerdoPago;
import com.ceiba.usuario.servicio.testdatabuilder.ComandoAcuerdoPagoTestDataBuilder;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorAcuerdoPago.class)
@AutoConfigureMockMvc(addFilters = false)
public class ComandoControladorAcuerdoPagoTest {
	
	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;
	
    @Test
    public void crear() throws Exception{
        // arrange
        ComandoAcuerdoPago comandoAcuerdo = new ComandoAcuerdoPagoTestDataBuilder().conId(100L).build();
        
        // act - assert
        mocMvc.perform(post("/acuerdosPagos/crear")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoAcuerdo)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }
    

}
