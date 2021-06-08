package com.ceiba.factura.comando.fabrica;

import com.ceiba.acuerdo.pago.modelo.entidad.AcuerdoPago;
import com.ceiba.acuerdo.pago.puerto.repositorio.RepositorioAcuerdo;
import com.ceiba.factura.comando.ComandoFactura;
import com.ceiba.factura.modelo.entidad.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FabricaFactura {

	@Autowired
	private RepositorioAcuerdo repositorioAcuerdo;
	
    public Factura crear(ComandoFactura comandoFactura) {
    	
    	AcuerdoPago acuerdoPago = repositorioAcuerdo.consultarAcuerdoPorId(comandoFactura.getAcuerdoPago());
        return new Factura(
        		comandoFactura.getIdFactura(),
        		comandoFactura.getMontoCuota(),
        		comandoFactura.getFechaCaducidad(),
        		acuerdoPago
        );
    }
    
    
}
