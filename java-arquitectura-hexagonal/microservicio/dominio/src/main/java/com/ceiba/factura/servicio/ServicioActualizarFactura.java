package com.ceiba.factura.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioActualizarFactura {

    private static final String LA_FACTURA_YA_EXISTE_EN_EL_SISTEMA = "la factura ya existe en el sistema";
//
//    private final RepositorioFactura repositorioFactura;
//
//    public ServicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
//        this.repositorioUsuario = repositorioUsuario;
//    }
//
//    public void ejecutar(Usuario usuario) {
//        validarExistenciaPrevia(usuario);
//        this.repositorioUsuario.actualizar(usuario);
//    }
//
//    private void validarExistenciaPrevia(Usuario usuario) {
//        boolean existe = this.repositorioUsuario.existeExcluyendoId(usuario.getId(),usuario.getNombre());
//        if(existe) {
//            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
//        }
//    }
}
