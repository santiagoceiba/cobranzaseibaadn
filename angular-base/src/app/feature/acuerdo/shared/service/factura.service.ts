import { HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpService } from '@core/services/http.service';
import { DtoFactura } from '../model/dto/DtoFactura';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FacturaService {

  constructor(protected http: HttpService) {}

  public consultarFacturaPorAcuerdo(idAcuerdoPago: number) {
    const params = new HttpParams().append('idAcuerdoPago', idAcuerdoPago.toString());
    return this.http.doGetParameters<DtoFactura[]>(`${environment.endpoint}/facturas/listarPorId`, params);
  }

  public actualizarPagoFactura(dtoFactura: DtoFactura) {
    let idFactura = dtoFactura.idFactura;
    //const params = new HttpParams().append('idFactura', idFactura.toString());
    return this.http.doPut<DtoFactura>(`${environment.endpoint}/factura/${idFactura}`, dtoFactura);

  }
}
