import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AcuerdoRoutingModule } from './acuerdo-routing.module';
import { AcuerdoComponent } from './acuerdo.component';
import { ListarAcuerdosComponent } from './components/listar-acuerdos/listar-acuerdos.component';
import { CrearAcuerdosPagosComponent } from './components/crear-acuerdos-pagos/crear-acuerdos-pagos.component';
import { CerrarAcuerdosPagosComponent } from './components/cerrar-acuerdos-pagos/cerrar-acuerdos-pagos.component';
import { SharedModule } from '@shared/shared.module';
import { FacturasComponent } from './components/facturas/facturas.component';


@NgModule({
  declarations: [
    AcuerdoComponent,
    ListarAcuerdosComponent,
    CrearAcuerdosPagosComponent,
    CerrarAcuerdosPagosComponent,
    FacturasComponent
  ],
  imports: [
    CommonModule,
    AcuerdoRoutingModule,
    SharedModule
  ]
})
export class AcuerdoModule { }
