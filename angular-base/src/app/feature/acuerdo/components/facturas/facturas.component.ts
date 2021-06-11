import { Component, Input, OnInit } from '@angular/core';
import { DtoFactura } from '../../shared/model/dto/DtoFactura';
import { FacturaService } from '../../shared/service/factura.service';

@Component({
  selector: 'app-facturas',
  templateUrl: './facturas.component.html',
  styleUrls: ['./facturas.component.css']
})
export class FacturasComponent implements OnInit {
  @Input () idAcuerdo: number;
  listaFacturas= new Array<DtoFactura>();
  constructor(private serviceFactura: FacturaService) { }

  ngOnInit(): void {
    this.obtenerListaFacturas();
  }

  obtenerListaFacturas() {
    this.serviceFactura.consultarFacturaPorAcuerdo(this.idAcuerdo).subscribe(data => {
      this.listaFacturas = data;
    })
  }
  pagar(factura: any) {
    let facturaDto: DtoFactura = this.armarFactura(factura);
    this.serviceFactura.actualizarPagoFactura(facturaDto);
  }
  
  armarFactura(factura:DtoFactura): DtoFactura {
    let facturaDto: DtoFactura = new DtoFactura();
    facturaDto.idFactura = factura.idFactura;
    facturaDto.acuerdoPago = factura.acuerdoPago;
    facturaDto.estado = factura.estado;
    facturaDto.fechaCaducidad = factura.fechaCaducidad;
    facturaDto.montoCuota = factura.montoCuota;
    return facturaDto;
  }

  ngOnChanges() {
    this.obtenerListaFacturas();
  }

}
