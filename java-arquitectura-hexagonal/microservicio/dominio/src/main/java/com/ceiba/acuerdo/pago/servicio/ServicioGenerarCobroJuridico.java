package com.ceiba.acuerdo.pago.servicio;

import java.util.List;

import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;
import com.ceiba.acuerdo.pago.puerto.repositorio.RepositorioAcuerdo;
import com.ceiba.acuerdopago.utilidades.enumeracion.EstadoAcuerdo;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;

public class ServicioGenerarCobroJuridico {

	private final RepositorioAcuerdo repositorioAcuerdo;
	private final RepositorioFactura repositorioFactura;
	private static final String EL_ACUERDO_NO_TIENE_FACTURAS = "El acuerdo no contiene ninguna factura";
	
	public ServicioGenerarCobroJuridico(RepositorioAcuerdo repositorioAcuerdo, RepositorioFactura repositorioFactura) {
		this.repositorioAcuerdo = repositorioAcuerdo;
		this.repositorioFactura = repositorioFactura;
	}

	public void ejecutarTareaJuridicos() {
		List<AcuerdoPago> listaAcuerdosPago = this.repositorioAcuerdo.listarAcuerdosPago();
		for (AcuerdoPago acuerdoPago: listaAcuerdosPago) {
			List<Factura> listaFacturas = this.repositorioFactura.obtenerListaFacturas(acuerdoPago.getIdAcuerdoPago());
			acuerdoPago.agregarListaFacturas(listaFacturas);
			validarContenidoListas(listaFacturas);
			acuerdoPago.cambiarAEstadoJuridico();
			System.out.println("estado"+ acuerdoPago.getEstado());
			if(acuerdoPago.getEstado() == EstadoAcuerdo.COBRO_JURIDICO){
				this.repositorioAcuerdo.actualizar(acuerdoPago);
			}
		}
	}

	private void validarContenidoListas(List<Factura> listaFacturas) {
		if (listaFacturas.isEmpty()) {
			throw new ExcepcionSinDatos(EL_ACUERDO_NO_TIENE_FACTURAS);
		}

	}

}
