import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BorrarDeudaComponent } from './components/borrar-deuda/borrar-deuda.component';
import { CrearDeudaComponent } from './components/crear-deuda/crear-deuda.component';
import { DeudaComponent } from './components/deuda/deuda.component';
import { ListarDeudaComponent } from './components/listar-deuda/listar-deuda.component';



const routes: Routes = [
  {
    path: '',
    component: DeudaComponent,
    children: [
      {
        path: '',
        component: CrearDeudaComponent
        },
      {
        path: 'crear',
        component: CrearDeudaComponent
      },
      {
        path: 'listar',
        component: ListarDeudaComponent
      },
      {
        path: 'borrar',
        component: BorrarDeudaComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DeudaRoutingModule { }
