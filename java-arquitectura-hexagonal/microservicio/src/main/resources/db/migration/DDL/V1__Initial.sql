create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table cliente (
 idCliente int(11) not null auto_increment,
 nombre varchar(100) not null,
 cedula varchar(45) not null,
 primary key (idCliente)
);

create table acuerdo_pago (idAcuerdoPago int (11) not null auto_increment,
fecha_acuerdo date not null,
monto_cuota int(100) not null,
idCliente int(11) not null,
idDeuda int(11) not null,
estado enum('ACTIVO','INACTIVO','COBRO_JURIDICO'),
cantidad_cuotas int (11) not null,
numero_referencia int (11) not null, 
primary key (idAcuerdoPago)
);

create table deuda (idDeuda int (11) not null auto_increment,
monto decimal(60) not null,
fecha_inicial_deuda_cliente date,
nombre_entidad_deuda varchar(11),
concepto_deuda varchar (11),
id_cliente int(11) not null,
primary key (idDeuda)
);