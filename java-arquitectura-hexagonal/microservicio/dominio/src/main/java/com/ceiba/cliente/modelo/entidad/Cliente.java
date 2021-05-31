package com.ceiba.cliente.modelo.entidad;


import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

public class Cliente {

	private static final String SE_DEBE_INGRESAR_LA_CEDULA = "Se debe ingresar la cedula del cliente";
	private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_CLIENTE = "Se debe ingresar el nombre de cliente";

	private Long idCliente;
	private String nombre;
	private String cedula;


	public Cliente(Long idCliente, String nombre, String cedula) {
		validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_CLIENTE);
		validarObligatorio(cedula, SE_DEBE_INGRESAR_LA_CEDULA);
	
		
		this.cedula = cedula;
		this.nombre = nombre;

		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}


}
