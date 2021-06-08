package com.ceiba.usuario.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.controlador.ComandoControladorCliente;
import com.ceiba.usuario.servicio.testdatabuilder.ComandoClienteTestDataBuilder;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorCliente.class)
@AutoConfigureMockMvc(addFilters = false)
public class ComandoControladorClienteTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoCliente cliente = new ComandoClienteTestDataBuilder().build();
        //inyectar repositorio - obtener el acuerdo 2 y validar que haya quedado con los datos correctos
        // La importancia de las pruebas están en los assert
        // act - assert
        mocMvc.perform(post("/clientes/crear")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }
    
    @Test
    public void actualizar() throws Exception{
        // arrange
        Long id = 2L;
        ComandoCliente cliente = new ComandoClienteTestDataBuilder().build();

        // act - assert
        mocMvc.perform(put("/clientes/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk());
    }
    
}
