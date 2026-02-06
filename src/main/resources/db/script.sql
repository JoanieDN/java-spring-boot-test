
create table cat_estatus_pedido(
                                   estatus_id INT primary key,
                                   description VARCHAR(50) not null UNIQUE
);

create table productos(
                          producto_id UUID primary KEY default gen_random_uuid(),
                          nombre varchar (100) not null,
                          precio DECIMAL(12, 2) not null,
                          stock INT not null
);

create table pedidos(
                        pedido_id UUID primary KEY default gen_random_uuid(),
                        estatus_id INT not null default 1,
                        nombre_cliente varchar(150) not null,
                        monto_total DECIMAL (12,2) not null default 0,
                        direccion_envio TEXT not null,
                        fecha_pedido TIMESTAMP default current_timestamp,
                        CONSTRAINT fk_estatus FOREIGN KEY (estatus_id) REFERENCES cat_estatus_pedido(estatus_id)
);


create table items_pedidos(
                              pedido_id UUID,
                              producto_id UUID,
                              cantidad INT not null,
                              precio DECIMAL (12,2) not null default 0,
                              PRIMARY KEY (pedido_id, producto_id),
                              CONSTRAINT fk_pedido foreign key(pedido_id) references pedidos(pedido_id),
                              CONSTRAINT fk_producto foreign key(producto_id) references productos(producto_id)
);