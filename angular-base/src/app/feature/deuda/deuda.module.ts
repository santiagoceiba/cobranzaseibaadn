import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DeudaRoutingModule } from './deuda-routing.module';
import { CrearDeudaComponent } from './components/crear-deuda/crear-deuda.component';
import { DeudaComponent } from './components/deuda/deuda.component';


@NgModule({
  declarations: [
    DeudaComponent,
    CrearDeudaComponent
  ],
  imports: [
    CommonModule,
    DeudaRoutingModule
  ]
})
export class DeudaModule { }
