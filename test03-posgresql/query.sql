create table if not exists productos
(
    producto int,
    nombre   varchar(100),
    precio   money
    );

create table if not exists cajeros
(
    cajero      int,
    nombreApels varchar(255)
    );

create table if not exists venta
(
    cajero   int,
    maquina  int,
    producto int
);

create table if not exists maquinas_registradoras
(
    maquina int,
    piso    int
);

-- ################# assign primary key #######################


alter table productos
    add primary key (producto);
alter table cajeros
    add primary key (cajero);
alter table maquinas_registradoras
    add primary key (maquina);


-- ################# assign foreign key #######################

alter table venta
    add constraint pk_venta_cajero
        foreign key (cajero)
            references cajeros (cajero);

alter table venta
    add constraint pk_venta_maquina
        foreign key (maquina)
            references maquinas_registradoras (maquina);

alter table venta
    add constraint pk_venta_producto
        foreign key (producto)
            references productos (producto);

-- ################# populate databases #######################

insert into productos(producto, nombre, precio)
values (1, 'leche', 39);
insert into productos(producto, nombre, precio)
values (2, 'pan', 7.50);
insert into productos(producto, nombre, precio)
values (3, 'huevo', 64.90);
insert into productos(producto, nombre, precio)
values (4, 'tortillas', 20);
insert into productos(producto, nombre, precio)
values (5, 'pollo', 36);

insert into cajeros(cajero, nombreApels)
values (1, 'shaila luna');
insert into cajeros(cajero, nombreApels)
values (2, 'samir ramos');
insert into cajeros(cajero, nombreApels)
values (3, 'veronica lopez');
insert into cajeros(cajero, nombreApels)
values (4, 'arturo gutierrez');
insert into cajeros(cajero, nombreApels)
values (5, 'antonio galindo');

insert into maquinas_registradoras(maquina, piso)
VALUES (1, 1);
insert into maquinas_registradoras(maquina, piso)
VALUES (2, 10);
insert into maquinas_registradoras(maquina, piso)
VALUES (3, 12);
insert into maquinas_registradoras(maquina, piso)
VALUES (4, 0);
insert into maquinas_registradoras(maquina, piso)
VALUES (5, 5);

insert into venta(cajero, maquina, producto)
VALUES (1, 1, 5);
insert into venta(cajero, maquina, producto)
VALUES (1, 2, 4);
insert into venta(cajero, maquina, producto)
VALUES (1, 3, 2);
insert into venta(cajero, maquina, producto)
VALUES (1, 4, 1);
insert into venta(cajero, maquina, producto)
VALUES (1, 5, 1);

insert into venta(cajero, maquina, producto)
VALUES (2, 1, 2);
insert into venta(cajero, maquina, producto)
VALUES (2, 2, 2);
insert into venta(cajero, maquina, producto)
VALUES (2, 3, 1);
insert into venta(cajero, maquina, producto)
VALUES (2, 4, 3);
insert into venta(cajero, maquina, producto)
VALUES (2, 5, 5);

insert into venta(cajero, maquina, producto)
VALUES (3, 1, 4);
insert into venta(cajero, maquina, producto)
VALUES (3, 2, 3);
insert into venta(cajero, maquina, producto)
VALUES (3, 3, 2);
insert into venta(cajero, maquina, producto)
VALUES (3, 4, 5);
insert into venta(cajero, maquina, producto)
VALUES (3, 5, 5);

insert into venta(cajero, maquina, producto)
VALUES (4, 1, 3);
insert into venta(cajero, maquina, producto)
VALUES (4, 2, 3);
insert into venta(cajero, maquina, producto)
VALUES (4, 3, 2);
insert into venta(cajero, maquina, producto)
VALUES (4, 4, 5);
insert into venta(cajero, maquina, producto)
VALUES (4, 5, 4);

insert into venta(cajero, maquina, producto)
VALUES (5, 1, 4);
insert into venta(cajero, maquina, producto)
VALUES (5, 2, 1);
insert into venta(cajero, maquina, producto)
VALUES (5, 3, 2);
insert into venta(cajero, maquina, producto)
VALUES (5, 4, 3);
insert into venta(cajero, maquina, producto)
VALUES (5, 5, 3);


-- ## 2. Mostrar el número de ventas de cada producto, ordenado de más a menos ventas.
select p.producto as id_producto, p.nombre, count(v.producto) as veces_vendido
from productos p
         left join venta v
                   on p.producto = v.producto
group by p.producto, p.nombre
order by count(v.producto) desc;

-- ## 3. Obtener un informe completo de ventas, indicando el nombre del cajero que realizo la venta, nombre y precios
-- de los productos vendidos, y el piso en el que se encuentra la maquina registradora donde se realizo la venta.

select distinct c.nombreApels as nombre_cajero, p.precio, p.nombre, m.piso
from productos p,
     cajeros c,
     venta v,
     maquinas_registradoras m
where v.cajero = c.cajero
  and v.producto = p.producto
  and v.maquina = m.maquina;

-- ## 4. Obtener las ventas totales realizadas en cada piso

select m.piso as numero_piso, sum(p.precio) as ventas_totales
from venta v,
     productos p,
     maquinas_registradoras m
where v.producto = p.producto
  and v.maquina = m.maquina
group by m.piso;

-- ### 5. Obtener el codigo y nombre de cada cajero junto con el importe total de sus ventas

select c.cajero as id_cajero, c.nombreApels as nombre_cajero, sum(p.precio) as ventas_totales
from productos p
         inner join (
    cajeros c left join venta v
        on v.cajero = c.cajero
    )
                    on v.producto = p.producto
group by c.cajero, c.nombreApels;

-- ### 6. Obtener el código y nombre de aquellos cajeros que hayan realizado ventas en pisos cuyas ventas totales
-- sean inferiores a los 5000 pesos.

select c.cajero as id_cajero, c.nombreApels as nombre_cajero
from cajeros c
where c.cajero in (
    select cajero
    from venta
    where maquina in (
        select c.cajero
        from maquinas_registradoras m
        where m.piso in (
            select m.piso
            from venta v,
                 productos p,
                 maquinas_registradoras m
            where v.producto = p.producto
              and v.maquina = m.maquina
            group by m.piso
            having sum(p.precio)::numeric::float < 5000
    )
    )
    );
