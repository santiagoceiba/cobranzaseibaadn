import { Cliente } from "@producto/shared/model/cliente";
import { Deuda } from "src/app/feature/deuda/shared/model/entidad/deuda";
import { EstadoAcuerdo } from "./enumeraciones/estadoAcuerdo";

export class AcuerdoPago {
    idAcuerdoPago: number;
    fechaAcuerdo;
    montoCuota: number;
    cliente: Cliente;
    deuda: Deuda;
    estado: EstadoAcuerdo;
    cantidadCuotas: number;
    numeroReferencia: number;

}