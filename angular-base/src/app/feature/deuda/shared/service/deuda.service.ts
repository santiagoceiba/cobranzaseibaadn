import { Injectable } from '@angular/core';
import { HttpService } from '@core/services/http.service';
import { Producto } from '@producto/shared/model/producto';
import { DtoDeuda } from '../model/dto/Dtodeuda';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DeudaService {

  constructor(protected http: HttpService) {}

  public consultar() {
    return this.http.doGet<DtoDeuda[]>(`${environment.endpoint}/deudas/listar`);
  }

  public guardar(deuda: DtoDeuda) {
    return this.http.doPost<DtoDeuda, number>(`${environment.endpoint}/deudas/crear`, deuda);
  }

  public eliminar(producto: Producto) {
    return this.http.doDelete<boolean>(`${environment.endpoint}/productos/${producto.id}`,
                                                 this.http.optsName('eliminar productos'));
  }
}
