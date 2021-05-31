package com.ceiba.deuda.modelo.entidad;



import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDateTime;



public class Deuda {
	
	
	private static final String SE_DEBE_INGRESAR_MONTO = "Se debe ingresar el monto de la cuota del cliente";
	private static final String SE_DEBE_INGRESAR_FECHA_DEUDA = "Se debe ingresar la fecha en la que el cliente inicio la deuda";
	private static final String SE_DEBE_INGRESAR_NOMBRE_ENTIDAD_DEUDA = "Se debe ingresar el  nombre de la entidad a la que se debe la mora";
	private static final String SE_DEBE_INGRESAR_CONCEPTO_CUOTA = "Se debe ingresar el concepto por el cual se debe la mora";
	
	private Long idDeuda;
	private Double monto;
	private LocalDateTime fechaInicialDeudaCliente;
	private String nombreEntidadDeuda;
	private String conceptoDeuda;
	private Long idCliente;
	
	
	
	public Deuda(Double monto, LocalDateTime fechaInicialDeudaCliente, String nombreEntidadDeuda, String conceptoDeuda,
			Long idCliente, Long idDeuda) {
		
		validarObligatorio(fechaInicialDeudaCliente, SE_DEBE_INGRESAR_FECHA_DEUDA);
		validarObligatorio(nombreEntidadDeuda, SE_DEBE_INGRESAR_NOMBRE_ENTIDAD_DEUDA);
		validarObligatorio(conceptoDeuda, SE_DEBE_INGRESAR_CONCEPTO_CUOTA);
		validarObligatorio(monto, SE_DEBE_INGRESAR_MONTO);
		
		this.monto = monto;
		this.fechaInicialDeudaCliente = fechaInicialDeudaCliente;
		this.nombreEntidadDeuda = nombreEntidadDeuda;
		this.conceptoDeuda = conceptoDeuda;
		this.idCliente = idCliente;
		this.idDeuda = idDeuda;
	}
	
	
	
	public Long getIdDeuda() {
		return idDeuda;
	}



	public void setIdDeuda(Long idDeuda) {
		this.idDeuda = idDeuda;
	}



	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public LocalDateTime getFechaInicialDeudaCliente() {
		return fechaInicialDeudaCliente;
	}
	public void setFechaInicialDeudaCliente(LocalDateTime fechaInicialDeudaCliente) {
		this.fechaInicialDeudaCliente = fechaInicialDeudaCliente;
	}
	public String getNombreEntidadDeuda() {
		return nombreEntidadDeuda;
	}
	public void setNombreEntidadDeuda(String nombreEntidadDeuda) {
		this.nombreEntidadDeuda = nombreEntidadDeuda;
	}
	public String getConceptoDeuda() {
		return conceptoDeuda;
	}
	public void setConceptoDeuda(String conceptoDeuda) {
		this.conceptoDeuda = conceptoDeuda;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	
	
	
}
