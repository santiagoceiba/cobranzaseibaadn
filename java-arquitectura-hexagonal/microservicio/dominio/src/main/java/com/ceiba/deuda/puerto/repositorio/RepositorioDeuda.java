package com.ceiba.deuda.puerto.repositorio;

import com.ceiba.deuda.modelo.entidad.Deuda;

public interface RepositorioDeuda {

	/**
	 * Permite crear un deuda
	 * 
	 * @param deuda
	 * @return el id generado
	 */
	Long crear(Deuda deuda);

	/**
	 * Permite validar si existe una deuda con id
	 * 
	 * @param iddeuda
	 * @return si existe o no
	 */
	boolean existe(Long idDeuda);

	/**
	 * Método que permite consultar un cliente a partir de su id
	 * 
	 * @param idCliente id del cliente a consultar
	 * @return el cliente requerido
	 */
	Deuda consultarDeuda(Long idDeuda);

	/**
	 * Permite actualizar un cliente
	 * 
	 * @param cliente
	 */
	void actualizar(Deuda deuda);
}
