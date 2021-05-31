package com.ceiba.configuracion;

import com.ceiba.acuerdo.pago.puerto.repositorio.RepositorioAcuerdo;
import com.ceiba.acuerdo.pago.servicio.ServicioActualizarAcuerdoPago;
import com.ceiba.acuerdo.pago.servicio.ServicioCrearAcuerdoPago;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioActualizacionCliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.cliente.servicio.ServicioEliminarCliente;
import com.ceiba.deuda.puerto.repositorio.RepositorioDeuda;
import com.ceiba.deuda.servicio.ServicioCrearDeuda;
import com.ceiba.factura.puerto.dao.DaoFactura;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
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
    public ServicioActualizacionCliente servicioActualizacionCliente(RepositorioCliente repositorioCliente) {
        return new ServicioActualizacionCliente(repositorioCliente);
    }
	
    
    @Bean
    public ServicioCrearAcuerdoPago servicioCrearAcuerdoPago(RepositorioAcuerdo repositorioAcuerdo) {
        return new ServicioCrearAcuerdoPago(repositorioAcuerdo);
    }
    
    
    @Bean
    public ServicioActualizarAcuerdoPago servicioActualizarAcuerdoPago(RepositorioAcuerdo repositorioAcuerdo, DaoFactura daoFactura) {
        return new ServicioActualizarAcuerdoPago(repositorioAcuerdo, daoFactura);
    }

    @Bean ServicioCrearDeuda servicioCrearDeuda (RepositorioDeuda repositorioDeuda) {
    	return new ServicioCrearDeuda(repositorioDeuda);
    }
}
