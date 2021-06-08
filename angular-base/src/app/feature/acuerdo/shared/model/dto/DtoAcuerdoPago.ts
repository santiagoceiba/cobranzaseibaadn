import { EstadoAcuerdo } from "../enumeraciones/estadoAcuerdo";

export class DtoAcuerdoPago {
    idAcuerdoPago: number;
    fechaAcuerdo;
    montoCuota: number;
    cliente: number;
    deuda: number;
    estado: EstadoAcuerdo;
    cantidadCuotas: number;
    numeroReferencia: number;

}