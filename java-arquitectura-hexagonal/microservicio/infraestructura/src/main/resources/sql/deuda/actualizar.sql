update deuda
set monto = :monto,
	fecha_inicial_deuda_cliente = :fechaInicialDeudaCliente
	nombre_entidad_deuda = :nombreEntidadDeuda
	concepto_deuda = :conceptoDeuda
	id_cliente = :idCliente
where idDeuda = :idDeuda