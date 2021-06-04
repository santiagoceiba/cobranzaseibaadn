package com.ceiba.configuracion;

import com.ceiba.factura.servicio.ServicioActualizarFactura;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.acuerdo.pago.puerto.repositorio.RepositorioAcuerdo;
import com.ceiba.acuerdo.pago.servicio.ServicioActualizarAcuerdoPago;
import com.ceiba.acuerdo.pago.servicio.ServicioCrearAcuerdoPago;
import com.ceiba.acuerdo.pago.servicio.ServicioGenerarCobroJuridico;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioActualizacionCliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.cliente.servicio.ServicioEliminarCliente;
import com.ceiba.deuda.puerto.repositorio.RepositorioDeuda;
import com.ceiba.deuda.servicio.ServicioCrearDeuda;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;


@Configuration
public class BeanServicio {


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
	public ServicioActualizarAcuerdoPago servicioActualizarAcuerdoPago(RepositorioAcuerdo repositorioAcuerdo) {
		return new ServicioActualizarAcuerdoPago(repositorioAcuerdo);
	}

	@Bean
	ServicioCrearDeuda servicioCrearDeuda(RepositorioDeuda repositorioDeuda) {
		return new ServicioCrearDeuda(repositorioDeuda);
	}
	@Bean
	ServicioActualizarFactura servicioActualizarFactura(RepositorioFactura repositorioFactura){
		return new ServicioActualizarFactura(repositorioFactura);
	}
	@Bean
	ServicioGenerarCobroJuridico servicioGenerarCobroJuridico(RepositorioAcuerdo reposotiroioAcuerdo,
			RepositorioFactura repositorioFactura) {
		return new ServicioGenerarCobroJuridico(reposotiroioAcuerdo, repositorioFactura);
	}
}
