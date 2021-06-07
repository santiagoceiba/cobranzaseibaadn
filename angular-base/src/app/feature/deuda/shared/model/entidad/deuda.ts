import { Cliente } from "@producto/shared/model/cliente";

export class Deuda {
    idDeuda: number;
	monto: number;
	fechaInicialDeudaCliente: string;
	nombreEntidadDeuda: string;
	conceptoDeuda: string;
	cliente: Cliente;
}