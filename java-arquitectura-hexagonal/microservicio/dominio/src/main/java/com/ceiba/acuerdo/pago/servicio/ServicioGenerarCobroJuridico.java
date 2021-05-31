package com.ceiba.acuerdo.pago.servicio;

import java.util.List;

import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;
import com.ceiba.acuerdo.pago.puerto.repositorio.RepositorioAcuerdo;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;

public class ServicioGenerarCobroJuridico {



	private final RepositorioAcuerdo repositorioAcuerdo;
	private final RepositorioFactura repositorioFactura;

	public ServicioGenerarCobroJuridico(RepositorioAcuerdo repositorioAcuerdo, RepositorioFactura repositorioFactura) {
		super();
		this.repositorioAcuerdo = repositorioAcuerdo;
		this.repositorioFactura = repositorioFactura;
	}

	public void ejecutarTareaJuridicos(AcuerdoPago acuerdoPago) {

		List<Factura> listaFacturas = this.repositorioFactura.obtenerListaFacturas(acuerdoPago.getIdAcuerdoPago());
		acuerdoPago.cambiarAEstadoJuridico(listaFacturas);
		this.repositorioAcuerdo.actualizar(acuerdoPago);
	}

}
