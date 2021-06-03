Select idAcuerdoPago, fecha_acuerdo, monto_cuota, idCliente, idDeuda, estado, cantidad_cuotas, numero_referencia
from acuerdo_pago
where  numero_referencia = :numeroReferencia
order by estado desc limit 1