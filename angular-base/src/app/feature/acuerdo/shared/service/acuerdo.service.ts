import { Injectable } from '@angular/core';
import { HttpService } from '@core/services/http.service';
import { environment } from 'src/environments/environment';
import { AcuerdoPago } from '../model/acuerdo-pago';
import { DtoAcuerdoPago } from '../model/dto/DtoAcuerdoPago';


@Injectable({
  providedIn: 'root'
})
export class AcuerdoService {

  constructor(protected http: HttpService) {}

  public consultar() {
    return this.http.doGet<AcuerdoPago[]>(`${environment.endpoint}/acuerdos/listar`);
  }


  public guardar(acuerdoPago: DtoAcuerdoPago) {
    return this.http.doPost<DtoAcuerdoPago, number>(`${environment.endpoint}/acuerdosPagos/crear`, acuerdoPago);
  }

}
