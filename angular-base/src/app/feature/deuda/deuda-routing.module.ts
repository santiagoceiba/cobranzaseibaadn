import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CrearDeudaComponent } from './components/crear-deuda/crear-deuda.component';



const routes: Routes = [
  {
    path: '',
    component: CrearDeudaComponent,
    children: [
      {
        path: 'crear',
        component: CrearDeudaComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DeudaRoutingModule { }
