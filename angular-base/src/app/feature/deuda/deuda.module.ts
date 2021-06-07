import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DeudaRoutingModule } from './deuda-routing.module';
import { CrearDeudaComponent } from './components/crear-deuda/crear-deuda.component';
import { DeudaComponent } from './components/deuda/deuda.component';
import { SharedModule } from '@shared/shared.module';
import { ListarDeudaComponent } from './components/listar-deuda/listar-deuda.component';
import { BorrarDeudaComponent } from './components/borrar-deuda/borrar-deuda.component';


@NgModule({
  declarations: [
    DeudaComponent,
    CrearDeudaComponent,
    ListarDeudaComponent,
    BorrarDeudaComponent
  ],
  imports: [
    CommonModule,
    DeudaRoutingModule,
    SharedModule
  ]
})
export class DeudaModule { }
