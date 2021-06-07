import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DeudaRoutingModule } from './deuda-routing.module';
import { CrearDeudaComponent } from './components/crear-deuda/crear-deuda.component';
import { DeudaComponent } from './components/deuda/deuda.component';
import { SharedModule } from '@shared/shared.module';


@NgModule({
  declarations: [
    DeudaComponent,
    CrearDeudaComponent
  ],
  imports: [
    CommonModule,
    DeudaRoutingModule,
    SharedModule
  ]
})
export class DeudaModule { }
