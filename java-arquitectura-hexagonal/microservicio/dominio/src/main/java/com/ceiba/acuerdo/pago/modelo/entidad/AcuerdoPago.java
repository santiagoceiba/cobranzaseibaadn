
package com.ceiba.acuerdo.pago.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.ceiba.acuerdopago.utilidades.enumeracion.EstadoAcuerdoEnum;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.deuda.modelo.entidad.Deuda;
import com.ceiba.factura.modelo.entidad.Factura;
import static com.ceiba.dominio.ValidadorArgumento.validarFecha;


public class AcuerdoPago implements Serializable{

	

	private static final long serialVersionUID = 1L;
	private static final int NUMERO_ATRASOS_CUOTAS_COBRO_JURIDICO = 2;
	private static final String SE_DEBE_INGRESAR_LA_FECHA_ACUERDO = "Se debe ingresar la fecha de acuerdo del pago";
	private static final String SE_DEBE_INGRESAR_CUOTA = "Se debe ingresar el valor del monto de la cuota";
	private static final String SE_DEBE_INGRESAR_NOMERO_CUOTAS = "Se debe ingresar el número de cuotas acordadas";
	private static final String SE_DEBE_INGRESAR_NOMERO_REFERENCIA = "Se debe ingresar el numero de referencia de pago";
	private static final String SE_DEBE_INGRESAR_UNA_FECHA_VALIDA = "La fecha ingresada es mayor a la fecha actual";
	
	
	private Long idAcuerdoPago;
	private LocalDateTime fechaAcuerdo;
	private Double montoCuota;
	private Cliente idCliente;
	private Deuda idDeuda;
	private EstadoAcuerdoEnum estado;
	private Integer cantidadCuotas;
	private Long numeroReferencia;
	private List<Factura> listaFacturas;

	public AcuerdoPago(Long idAcuerdoPago, LocalDateTime fechaAcuerdo, Double cuota, Cliente cliente, Deuda deuda, EstadoAcuerdoEnum estado,
			Integer cantidadCuotas, Long numeroReferencia) {
		validarFecha(fechaAcuerdo, SE_DEBE_INGRESAR_UNA_FECHA_VALIDA);
		validarObligatorio(fechaAcuerdo, SE_DEBE_INGRESAR_LA_FECHA_ACUERDO);
		validarObligatorio(cuota, SE_DEBE_INGRESAR_CUOTA);
		validarObligatorio(cantidadCuotas, SE_DEBE_INGRESAR_NOMERO_CUOTAS);
		validarObligatorio(numeroReferencia, SE_DEBE_INGRESAR_NOMERO_REFERENCIA);
		
		this.idAcuerdoPago = idAcuerdoPago;
		this.fechaAcuerdo = fechaAcuerdo;
		this.montoCuota = cuota;
		this.idCliente = cliente;
		this.idDeuda = deuda;
		this.estado = estado;
		this.cantidadCuotas = cantidadCuotas;
		this.numeroReferencia = numeroReferencia;
		//this.listaFacturas = crearFacturas();
	}
	
//	/**
//	 * Método que permite crear una factura a partir del acuerdo realizado con el cliente
//	 * @return una lista con las facturas creadas
//	 */
//	private List<Factura> crearFacturas() {
//		
//		LocalDateTime fechaActual = LocalDateTime.now();
//	for (int i = 1; i <= this.cantidadCuotas ; i++) {
//		LocalDateTime fechaCaducidad = (fechaActual.plusMonths(i));
//		crearFactura(this.getClass(), fechaCaducidad, this.montoCuota);
//	}
//		return null;
//	}
	
	/**
	 * método que permite definir si es necesario cambiar el estado de un acuerdo a Cobro jurídico
	 * @param listaFacturas
	 */
	public void cambiarAEstadoJuridico(List<Factura> listaFacturas) {
		if (this.estado.equals(EstadoAcuerdoEnum.ACTIVO)) {
			if (obtenerNumeroAcuerdosVencidos(listaFacturas) > NUMERO_ATRASOS_CUOTAS_COBRO_JURIDICO) {
				this.estado = EstadoAcuerdoEnum.COBRO_JURIDICO;
			}
		}
	}
	
	/**
	 * Método que me permite conocer la cantidad de facturas que un acuerdo tiene
	 * vencidas
	 * 
	 * @param listaFacturas
	 * @return
	 */
	private int obtenerNumeroAcuerdosVencidos(List<Factura> listaFacturas) {
		int contarFacturasVencidas = 0;
		for (Factura factura : listaFacturas) {
			if (factura.getEstado()) {
				contarFacturasVencidas ++;
			}
		}

		return contarFacturasVencidas;
	}


	public Double getMontoCuota() {
		return montoCuota;
	}

	public void setMontoCuota(Double montoCuota) {
		this.montoCuota = montoCuota;
	}

	public Integer getCantidadCuotas() {
		return cantidadCuotas;
	}

	public void setCantidadCuotas(Integer cantidadCuotas) {
		this.cantidadCuotas = cantidadCuotas;
	}
	public LocalDateTime getFechaAcuerdo() {
		return fechaAcuerdo;
	}

	public void setFechaAcuerdo(LocalDateTime fechaAcuerdo) {
		this.fechaAcuerdo = fechaAcuerdo;
	}
	
	
	public List<Factura> getListaFacturas() {
		return listaFacturas;
	}

	public void setListaFacturas(List<Factura> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}

	public Long getNumeroReferencia() {
		return numeroReferencia;
	}

	public Double getCuota() {
		return montoCuota;
	}

	public void setCuota(Double montoCuota) {
		this.montoCuota = montoCuota;
	}

	
	public Long getIdAcuerdoPago() {
		return idAcuerdoPago;
	}



	public Cliente getCliente() {
		return idCliente;
	}


	public Deuda getDeuda() {
		return idDeuda;
	}


	public EstadoAcuerdoEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoAcuerdoEnum estado) {
		this.estado = estado;
	}

	public AcuerdoPago() {
	}

	
}
