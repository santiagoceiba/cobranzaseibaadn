package com.ceiba.configuracion;

import com.ceiba.usuario.puerto.dao.DaoFactura;
import com.ceiba.usuario.puerto.repositorio.RepositorioAcuerdo;
import com.ceiba.usuario.puerto.repositorio.RepositorioCliente;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizacionClienteTest;
import com.ceiba.usuario.servicio.ServicioActualizarAcuerdoPago;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearAcuerdoPago;
import com.ceiba.usuario.servicio.ServicioCrearCliente;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarCliente;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }
	
    
    @Bean
    public ServicioCrearCliente servicioCrearCliente(RepositorioCliente repositorioCliente) {
        return new ServicioCrearCliente(repositorioCliente);
    }

    @Bean
    public ServicioEliminarCliente servicioEliminarCliente(RepositorioCliente repositorioCliente) {
        return new ServicioEliminarCliente(repositorioCliente);
    }

    @Bean
    public ServicioActualizacionClienteTest servicioActualizacionCliente(RepositorioCliente repositorioCliente) {
        return new ServicioActualizacionClienteTest(repositorioCliente);
    }
	
    
    @Bean
    public ServicioCrearAcuerdoPago servicioCrearAcuerdoPago(RepositorioAcuerdo repositorioAcuerdo) {
        return new ServicioCrearAcuerdoPago(repositorioAcuerdo);
    }
    
    
    @Bean
    public ServicioActualizarAcuerdoPago servicioActualizarAcuerdoPago(RepositorioAcuerdo repositorioAcuerdo, DaoFactura daoFactura) {
        return new ServicioActualizarAcuerdoPago(repositorioAcuerdo, daoFactura);
    }

}
