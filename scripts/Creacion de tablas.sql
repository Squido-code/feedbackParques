--Creando tablas base de datos
--tabla ciudades
CREATE TABLE ciudades (
    id_ciudad  NUMBER,
    nombre     VARCHAR2(20),
    ccaa       VARCHAR2(20),
    CONSTRAINT pk_id_ciudad PRIMARY KEY ( id_ciudad )
);
--tabla parques

CREATE TABLE parques (
    id_parque  NUMBER,
    nombre     VARCHAR2(20),
    extension  NUMBER,
    id_ciudad  NUMBER,
    CONSTRAINT fk_id_ciudad FOREIGN KEY ( id_ciudad )
        REFERENCES ciudades ( id_ciudad )
);
--se me olvido la primary key

ALTER TABLE parques ADD CONSTRAINT pk_id_parque PRIMARY KEY ( id_parque );
--tabla actuaciones

alter table parques drop CONSTRAINT pk_id_parque;

CREATE TABLE actuaciones (
    id_evento  NUMBER,
    nombre     VARCHAR2(20),
    duracion   NUMBER,
    id_parque  NUMBER,
    CONSTRAINT pk_id_evento PRIMARY KEY ( id_evento ),
    CONSTRAINT fk_id_parque FOREIGN KEY ( id_parque )
        REFERENCES parques ( id_parque )
);
alter table actuaciones add CONSTRAINT fk_id_parque FOREIGN KEY ( id_parque )
        REFERENCES parques ( id_parque ) on DELETE cascade;--tengo que actualizar la foreign key
        commit;
--tabla cuadrillas por que une jardineros y ejecuciones

CREATE TABLE cuadrillas (
    id_cuadrilla  NUMBER,
    nombre        VARCHAR2(20),
    CONSTRAINT pk_id_cuadrilla PRIMARY KEY ( id_cuadrilla )
);
--tabla ejecucion

CREATE TABLE ejecucion (
    id_ejecucion  NUMBER,
    id_evento     NUMBER,
    id_cuadrilla  NUMBER,
    CONSTRAINT pk_id_ejecucion PRIMARY KEY ( id_ejecucion ),
    CONSTRAINT fk_id_evento FOREIGN KEY ( id_evento )
        REFERENCES actuaciones ( id_evento ),
    CONSTRAINT fk_id_cuadrilla FOREIGN KEY ( id_cuadrilla )
        REFERENCES cuadrillas ( id_cuadrilla )
);
--tabla jardineros
create table jardineros (
id_jardinero number,
nombre varchar2(20),
id_cuadrilla number,
id_jefe number,
constraint pk_id_jardinero primary key (id_jardinero),
constraint fk_id_jefe foreign key (id_jefe)REFERENCES jardineros(id_jardinero));
--se me olvido la foreign key de cuadrillas
alter table jardineros add constraint fk_id_cuadrilla_jardinero foreign key (id_cuadrilla) references cuadrillas(id_cuadrilla);
commit;