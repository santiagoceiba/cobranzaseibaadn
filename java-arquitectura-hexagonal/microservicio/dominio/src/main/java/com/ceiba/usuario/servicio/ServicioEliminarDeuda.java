package com.ceiba.usuario.servicio;

import com.ceiba.usuario.puerto.repositorio.RepositorioDeuda;

public class ServicioEliminarDeuda {

	private final RepositorioDeuda repositorioDeuda;

	public ServicioEliminarDeuda(RepositorioDeuda repositorioDeuda) {
		this.repositorioDeuda = repositorioDeuda;
	}

	public void ejecutar(Long id) {
		this.repositorioDeuda.eliminar(id);
	}
}
