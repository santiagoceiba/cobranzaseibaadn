select idDeuda,monto,fecha_inicial_deuda_cliente,nombre_entidad_deuda,concepto_deuda,id_cliente
from deuda
where id_cliente = :idCliente