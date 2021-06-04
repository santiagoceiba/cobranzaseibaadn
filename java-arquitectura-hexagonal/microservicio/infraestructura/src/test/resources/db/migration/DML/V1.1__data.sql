insert into cliente(nombre,cedula) values('santiago','11111');
insert into deuda (monto, fecha_inicial_deuda_cliente, nombre_entidad_deuda, concepto_deuda, id_cliente) values (10, '2021-05-05 08:12:13', 'tigo', 'plan de datos', 1);
insert into acuerdo_pago (fecha_acuerdo, monto_cuota, idCliente, idDeuda, estado, cantidad_cuotas, numero_referencia) values ('2021-05-05 08:12:13', 30, 1, 1, 'ACTIVO', 3, 1234 );
insert into factura (montocuota, fechacaducidad,acuerdopago, estado ) values (10, '2021-06-06 08:12:13', 1, 0);