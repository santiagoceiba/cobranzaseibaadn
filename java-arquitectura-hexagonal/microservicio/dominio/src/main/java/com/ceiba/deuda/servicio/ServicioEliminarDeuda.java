package com.ceiba.deuda.servicio;

import com.ceiba.deuda.puerto.repositorio.RepositorioDeuda;

public class ServicioEliminarDeuda {

	private final RepositorioDeuda repositorioDeuda;

	public ServicioEliminarDeuda(RepositorioDeuda repositorioDeuda) {
		this.repositorioDeuda = repositorioDeuda;
	}

	public void ejecutar(Long id) {
		//this.repositorioDeuda.eliminar(id);
	}
}
