import { Injectable } from '@angular/core';
import { HttpService } from '@core/services/http.service';
import { Producto } from '@producto/shared/model/producto';
import { Deuda } from '../model/deuda';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DeudaService {

  constructor(protected http: HttpService) {}

  public consultar() {
    return this.http.doGet<Deuda[]>(`${environment.endpoint}/clientes/listar`);
  }

  public guardar(deuda: Deuda) {
    return this.http.doPost<Deuda, number>(`${environment.endpoint}/deudas/crear`, deuda);
  }

  public eliminar(producto: Producto) {
    return this.http.doDelete<boolean>(`${environment.endpoint}/productos/${producto.id}`,
                                                 this.http.optsName('eliminar productos'));
  }
}
