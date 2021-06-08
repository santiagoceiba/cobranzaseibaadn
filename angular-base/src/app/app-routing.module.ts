import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';



const routes: Routes = [
  { path: '', redirectTo: '/cliente', pathMatch: 'full' },
  { path: 'cliente', loadChildren: () => import('@producto/producto.module').then(mod => mod.ProductoModule) },
  { path: 'deuda', loadChildren: () => import('./feature/deuda/deuda.module').then(m => m.DeudaModule) },
  { path: 'acuerdos', loadChildren: () => import('./feature/acuerdo/acuerdo.module').then(m => m.AcuerdoModule) }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
