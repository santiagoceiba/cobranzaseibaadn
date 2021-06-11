package com.ceiba.factura.comando.manejador;

import com.ceiba.deuda.modelo.dto.DtoDeuda;
import com.ceiba.factura.modelo.dto.DtoFactura;
import com.ceiba.factura.puerto.dao.DaoFactura;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListaFacturasAcuerdo {
    private final DaoFactura daoFactura;

    public ManejadorListaFacturasAcuerdo(DaoFactura daoFactura) {
        this.daoFactura = daoFactura;
    }

    public List<DtoFactura> ejecutar(Long idFactura){ return this.daoFactura.listarFacturaPorAcuerdo(idFactura); }
}
