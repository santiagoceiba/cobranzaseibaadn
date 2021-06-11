import { Component, Input, OnInit } from '@angular/core';
import { DtoFactura } from '../../shared/model/dto/DtoFactura';

@Component({
  selector: 'app-facturas',
  templateUrl: './facturas.component.html',
  styleUrls: ['./facturas.component.css']
})
export class FacturasComponent implements OnInit {
  @Input () idAcuerdo: number;
  listaFacturas= new Array<DtoFactura>();
  constructor() { }

  ngOnInit(): void {
    this.obtenerListaFacturas();
  }

  obtenerListaFacturas() {
    throw new Error('Method not implemented.');
  }

}
