package com.ceiba.factura.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;

public class ServicioCambiarEstadoPagoFactura {

    private static final String LA_FACTURA_NO_EXISTE_EN_EL_SISTEMA = "la factura no existe en el sistema";


    private final RepositorioFactura repositorioFactura;

    public ServicioCambiarEstadoPagoFactura(RepositorioFactura repositorioFactura) {
        this.repositorioFactura = repositorioFactura;
    }

    public void ejecutar(Factura factura) {
        validarExistenciaPrevia(factura);
        this.repositorioFactura.actualizar(factura);
    }

    private void validarExistenciaPrevia(Factura factura) {
        boolean existe = this.repositorioFactura.existe(factura.getIdFactura());
        if(!existe) {
            throw new ExcepcionDuplicidad(LA_FACTURA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

}
