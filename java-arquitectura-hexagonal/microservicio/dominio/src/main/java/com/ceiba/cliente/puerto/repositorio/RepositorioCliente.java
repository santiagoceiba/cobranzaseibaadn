package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;

public interface RepositorioCliente {
	
	/**
	 * Permite crear un cliente
	 * @param cliente
	 * @return el id generado
	 */
    Long crear(Cliente cliente);
    
    /**
	 * Permite actualizar un cliente
	 * @param cliente
	 */
    void actualizar(Cliente cliente);
    
    /**
     * Permite eliminar un cliente
     * @param id
     */
    void eliminar(Long idCliente);
    
    /**
     * Permite validar si existe un cliente con un nombre
     * @param nombre
     * @return si existe o no
     */
    boolean existe(String cedula);
    
    /**
     * Método que permite consultar un cliente a partir de su id
     * @param idCliente id del cliente a consultar
     * @return el cliente requerido
     */
    Cliente consultarCliente(Long idCliente);
    
}
