import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AcuerdoComponent } from './acuerdo.component';
import { CerrarAcuerdosPagosComponent } from './components/cerrar-acuerdos-pagos/cerrar-acuerdos-pagos.component';
import { CrearAcuerdosPagosComponent } from './components/crear-acuerdos-pagos/crear-acuerdos-pagos.component';
import { ListarAcuerdosComponent } from './components/listar-acuerdos/listar-acuerdos.component';

const routes: Routes = [
  {
    path: '', component: AcuerdoComponent,
    children: [
      {
        path: '',
        component: CrearAcuerdosPagosComponent
      },
      {
        path: 'crear',
        component: CrearAcuerdosPagosComponent
      },
      {
        path: 'cerrar',
        component: CerrarAcuerdosPagosComponent
      },
      {
        path: 'listar',
        component: ListarAcuerdosComponent
      }]
  }];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AcuerdoRoutingModule { }
