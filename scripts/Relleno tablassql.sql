--tabla ciudades
INSERT INTO ciudades VALUES (
    1,
    'Madrid',
    'Comunidad de Madrid'
);

INSERT INTO ciudades VALUES (
    2,
    'Riaza',
    'Castilla y leon'
);

INSERT INTO ciudades VALUES (
    3,
    'Buitrago',
    'Comunidad de Madrid'
);

INSERT INTO ciudades VALUES (
    4,
    'Ayllon',
    'Castilla y Leon'
);
--tabla parques


INSERT INTO parques VALUES (
    4,
    'Plaza',
    250,
    2
);

INSERT INTO parques VALUES (
    5,
    'Castillo',
    750,
    3
);

INSERT INTO parques VALUES (
    6,
    'Rio',
    1200,
    3
);

INSERT INTO parques VALUES (
    7,
    'Rivera',
    1500,
    4
);

INSERT INTO parques VALUES (
    8,
    'plaza',
    600,
    4
);
--actuaciones
insert into actuaciones values(
1,
'Poda',
3,
1);
insert into actuaciones values(
2,
'Poda',
1,
2);
insert into actuaciones values(
3,
'Poda',
4,
3);
insert into actuaciones values(
4,
'Poda',
1,
4);
insert into actuaciones values(
5,
'Poda',
2,
5);
insert into actuaciones values(
6,
'Poda',
3,
6);
insert into actuaciones values(
7,
'Poda',
4,
7);
insert into actuaciones values(
8,
'Poda',
2,
8);

--siguiente actividad
insert into actuaciones values(
9,
'control plagas',
4,
1);
insert into actuaciones values(
10,
'control plagas',
2,
2);
insert into actuaciones values(
11,
'control plagas',
1,
3);
insert into actuaciones values(
12,
'control plagas',
5,
4);
insert into actuaciones values(
13,
'control plagas',
3,
5);
insert into actuaciones values(
14,
'control plagas',
6,
6);
insert into actuaciones values(
15,
'control plagas',
5,
7);
insert into actuaciones values(
16,
'control plagas',
3,
8);

commit;
--relleno cuadrillas
insert into cuadrillas values(
1,
'Castilla');
insert into cuadrillas values(
2,
'Madrid');
commit;
--relleno jardineros
insert into jardineros values(
1,
'Juan',
1,
1);
insert into jardineros values(
2,
'Angela',
1,
1);
insert into jardineros values(
3,
'Pedro',
1,
1);
insert into jardineros values(
4,
'Pepe',
2,
4);
insert into jardineros values(
5,
'Carlos',
2,
4);
insert into jardineros values(
6,
'Vanesa',
2,
4);
commit;