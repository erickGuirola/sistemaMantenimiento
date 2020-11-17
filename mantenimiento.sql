-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler  version: 0.9.1
-- PostgreSQL version: 10.0
-- Project Site: pgmodeler.io
-- Model Author: ---


-- Database creation must be done outside a multicommand file.
-- These commands were put in this file only as a convenience.
-- -- object: new_database | type: DATABASE --
-- -- DROP DATABASE IF EXISTS new_database;
-- CREATE DATABASE new_database;
-- -- ddl-end --
-- 

-- object: public.tipo_mantenimiento | type: TABLE --
-- DROP TABLE IF EXISTS public.tipo_mantenimiento CASCADE;
CREATE TABLE public.tipo_mantenimiento(
	id_tipo_mantenimiento serial NOT NULL,
	mantenimiento varchar(50) NOT NULL,
	observaciones varchar(200),
	CONSTRAINT tipo_mantenimiento_pk PRIMARY KEY (id_tipo_mantenimiento)

);
-- ddl-end --
COMMENT ON TABLE public.tipo_mantenimiento IS 'Contendra los tipos de mantenimiento , preventivo o correctivo ';
-- ddl-end --
ALTER TABLE public.tipo_mantenimiento OWNER TO postgres;
-- ddl-end --

-- object: public.proveedores | type: TABLE --
-- DROP TABLE IF EXISTS public.proveedores CASCADE;
CREATE TABLE public.proveedores(
	id_proveedor serial NOT NULL,
	proveedor varchar(50) NOT NULL,
	telefono char(8),
	direccion varchar(100),
	observaciones varchar(200),
	CONSTRAINT proveedores_pk PRIMARY KEY (id_proveedor)

);
-- ddl-end --
COMMENT ON TABLE public.proveedores IS 'contiene los proveedores con los cuales adquirimos los materiales e insumos ';
-- ddl-end --
ALTER TABLE public.proveedores OWNER TO postgres;
-- ddl-end --

-- object: public.recurso_humano | type: TABLE --
-- DROP TABLE IF EXISTS public.recurso_humano CASCADE;
CREATE TABLE public.recurso_humano(
	id_recurso_humano serial NOT NULL,
	nombre varchar(50) NOT NULL,
	apellido varchar(50) NOT NULL,
	telefono char(8),
	observaciones varchar(200),
	CONSTRAINT recurso_humano_pk PRIMARY KEY (id_recurso_humano)

);
-- ddl-end --
COMMENT ON TABLE public.recurso_humano IS 'Contiene el Recurso humano que realizará la orden de trabajo , tomando en cuenta que solo podra estar una persona realizando una orden especifica ';
-- ddl-end --
ALTER TABLE public.recurso_humano OWNER TO postgres;
-- ddl-end --

-- object: public.tipo_programacion | type: TABLE --
-- DROP TABLE IF EXISTS public.tipo_programacion CASCADE;
CREATE TABLE public.tipo_programacion(
	id_tipo_programacion serial NOT NULL,
	programacion varchar(50) NOT NULL,
	observaciones varchar(200),
	CONSTRAINT tipo_programacion_pk PRIMARY KEY (id_tipo_programacion)

);
-- ddl-end --
COMMENT ON TABLE public.tipo_programacion IS 'contendra los tipos de programacion, ya sea anual o mensual';
-- ddl-end --
ALTER TABLE public.tipo_programacion OWNER TO postgres;
-- ddl-end --

-- object: public.materiales_insumos | type: TABLE --
-- DROP TABLE IF EXISTS public.materiales_insumos CASCADE;
CREATE TABLE public.materiales_insumos(
	id_material_insumo serial NOT NULL,
	material_insumo varchar(50) NOT NULL,
	existencia integer NOT NULL,
	stock_maximo integer NOT NULL,
	stock_minimo integer NOT NULL,
	observaciones varchar(200),
	CONSTRAINT materiales_insumos_pk PRIMARY KEY (id_material_insumo)

);
-- ddl-end --
COMMENT ON TABLE public.materiales_insumos IS 'contiene los materiales e insumos necesarios para dar mantenimientos , los cuales pueden ser desde lo mas minimo como un disco duro a una pc completa ';
-- ddl-end --
ALTER TABLE public.materiales_insumos OWNER TO postgres;
-- ddl-end --

-- object: public.orden_compra | type: TABLE --
-- DROP TABLE IF EXISTS public.orden_compra CASCADE;
CREATE TABLE public.orden_compra(
	id_orden_compra serial NOT NULL,
	id_proveedor serial NOT NULL,
	id_material_insumo serial NOT NULL,
	cantidad integer NOT NULL,
	observaciones varchar(200),
	CONSTRAINT orden_compra_pk PRIMARY KEY (id_orden_compra,id_proveedor,id_material_insumo)

);
-- ddl-end --
COMMENT ON TABLE public.orden_compra IS 'Esta tabla contendra las ordenes de compras , generadas cuando se llegue al stock minimo de los materiales o insumos ';
-- ddl-end --
ALTER TABLE public.orden_compra OWNER TO postgres;
-- ddl-end --

-- object: public.proveedores_por_insumo | type: TABLE --
-- DROP TABLE IF EXISTS public.proveedores_por_insumo CASCADE;
CREATE TABLE public.proveedores_por_insumo(
	id_material_insumo serial NOT NULL,
	id_proveedor serial NOT NULL,
	observaciones varchar(200),
	CONSTRAINT proveedores_por_insumo_pk PRIMARY KEY (id_material_insumo,id_proveedor)

);
-- ddl-end --
COMMENT ON TABLE public.proveedores_por_insumo IS 'Dado que un insumo no solo puedo comprarselo a un solo proveedor sino  a varios , surge esta tabla para asinar un insumo a varios proveedores ';
-- ddl-end --
ALTER TABLE public.proveedores_por_insumo OWNER TO postgres;
-- ddl-end --

-- object: public.equipo | type: TABLE --
-- DROP TABLE IF EXISTS public.equipo CASCADE;
CREATE TABLE public.equipo(
	id_equipo serial NOT NULL,
	equipo varchar(50) NOT NULL,
	cantidad integer NOT NULL,
	descripcion varchar(100) NOT NULL,
	observaciones varchar(200),
	CONSTRAINT equipo_pk PRIMARY KEY (id_equipo)

);
-- ddl-end --
COMMENT ON TABLE public.equipo IS 'contiene los equipos a los cuales se les aplica el mantenimiento:
ejemplo:
Computadoras 
Switch 
Routers , etc ';
-- ddl-end --
ALTER TABLE public.equipo OWNER TO postgres;
-- ddl-end --

-- object: public.partes | type: TABLE --
-- DROP TABLE IF EXISTS public.partes CASCADE;
CREATE TABLE public.partes(
	id_parte serial NOT NULL,
	parte varchar(50) NOT NULL,
	descripcion varchar(100),
	observaciones varchar(200),
	CONSTRAINT partes_pk PRIMARY KEY (id_parte)

);
-- ddl-end --
COMMENT ON TABLE public.partes IS 'contiene las diferentes partes de los equipos 
ejemplo 
Disco duro 
Memorias Ram 
Fuentes 
motherboard , etc';
-- ddl-end --
ALTER TABLE public.partes OWNER TO postgres;
-- ddl-end --

-- object: public.partes_por_equipo | type: TABLE --
-- DROP TABLE IF EXISTS public.partes_por_equipo CASCADE;
CREATE TABLE public.partes_por_equipo(
	id_equipo serial NOT NULL,
	id_parte serial NOT NULL,
	cantidad integer NOT NULL,
	observaciones varchar(200),
	CONSTRAINT partes_por_equipo_pk PRIMARY KEY (id_equipo,id_parte)

);
-- ddl-end --
COMMENT ON TABLE public.partes_por_equipo IS 'cada equipo puede estar compuesto por diversas partes , para diferenciarlas de cada equipo , se crea esta tabla ';
-- ddl-end --
ALTER TABLE public.partes_por_equipo OWNER TO postgres;
-- ddl-end --

-- object: public.procedimiento | type: TABLE --
-- DROP TABLE IF EXISTS public.procedimiento CASCADE;
CREATE TABLE public.procedimiento(
	id_procedimiento serial NOT NULL,
	procedimiento varchar(50) NOT NULL,
	descripcion varchar(100),
	observaciones varchar(200),
	CONSTRAINT procedimiento_pk PRIMARY KEY (id_procedimiento)

);
-- ddl-end --
COMMENT ON TABLE public.procedimiento IS 'contiene los procedimientos generales aplicables a los equipos a dar mantenimiento: ejemplo :
Limpieza de Computadora
Cambio de UPS 
Realizar Cables de Red ';
-- ddl-end --
ALTER TABLE public.procedimiento OWNER TO postgres;
-- ddl-end --

-- object: public.procedimiento_por_equipo | type: TABLE --
-- DROP TABLE IF EXISTS public.procedimiento_por_equipo CASCADE;
CREATE TABLE public.procedimiento_por_equipo(
	id_procedimiento serial NOT NULL,
	id_equipo serial NOT NULL,
	id_material_insumo serial NOT NULL,
	descripcion varchar(100) NOT NULL,
	observaciones varchar(100),
	CONSTRAINT procedimiento_por_equipo_pk PRIMARY KEY (id_procedimiento,id_equipo,id_material_insumo)

);
-- ddl-end --
COMMENT ON TABLE public.procedimiento_por_equipo IS 'contiene los procedimiento especificos para dar mantenimiento a los equipos incluyendo el material y /o equipo que se usara para tal fin ';
-- ddl-end --
ALTER TABLE public.procedimiento_por_equipo OWNER TO postgres;
-- ddl-end --

-- object: public.orden_trabajo | type: TABLE --
-- DROP TABLE IF EXISTS public.orden_trabajo CASCADE;
CREATE TABLE public.orden_trabajo(
	id_orden_trabajo serial NOT NULL,
	id_recurso_humano serial NOT NULL,
	id_procedimiento serial NOT NULL,
	id_tipo_mantenimiento serial NOT NULL,
	id_estado serial NOT NULL,
	fecha_generacion date NOT NULL,
	observaciones varchar(200),
	CONSTRAINT orden_trabajo_pk PRIMARY KEY (id_orden_trabajo)

);
-- ddl-end --
COMMENT ON TABLE public.orden_trabajo IS 'contiene todas las odenes de trabajo , especificando el recurso humano procedimiento tipo de mantenimiento y fecha en que fue generada la orden de trabajo , ';
-- ddl-end --
ALTER TABLE public.orden_trabajo OWNER TO postgres;
-- ddl-end --

-- object: public.estado_orden_trabajo | type: TABLE --
-- DROP TABLE IF EXISTS public.estado_orden_trabajo CASCADE;
CREATE TABLE public.estado_orden_trabajo(
	id_estado serial NOT NULL,
	estado varchar(50) NOT NULL,
	observaciones varchar(200),
	CONSTRAINT estado_orden_trabajo_pk PRIMARY KEY (id_estado)

);
-- ddl-end --
COMMENT ON TABLE public.estado_orden_trabajo IS 'cada orden de trabajo contendra un estado especifico los cuales podrian ser:
Generada 
En proceso 
Fallida
Finalizada , etc ';
-- ddl-end --
ALTER TABLE public.estado_orden_trabajo OWNER TO postgres;
-- ddl-end --

-- object: public.programacion | type: TABLE --
-- DROP TABLE IF EXISTS public.programacion CASCADE;
CREATE TABLE public.programacion(
	id_programacion serial NOT NULL,
	id_tipo_programacion serial,
	id_orden_trabajo serial,
	fecha_realizacion date NOT NULL,
	observaciones varchar(200),
	CONSTRAINT programacion_pk PRIMARY KEY (id_programacion)

);
-- ddl-end --
COMMENT ON TABLE public.programacion IS 'Se almacenará la programacion de las ordenes de trabajo para mantenimiento preventivo ';
-- ddl-end --
ALTER TABLE public.programacion OWNER TO postgres;
-- ddl-end --

-- object: public.falla | type: TABLE --
-- DROP TABLE IF EXISTS public.falla CASCADE;
CREATE TABLE public.falla(
	id_falla serial NOT NULL,
	id_tipo_falla serial NOT NULL,
	descripcion varchar(100) NOT NULL,
	observaciones varchar(200),
	CONSTRAINT falla_pk PRIMARY KEY (id_falla)

);
-- ddl-end --
COMMENT ON TABLE public.falla IS 'contendra las fallas que se dan en los equipos , a los cuales se les aplica el mantenimiento ';
-- ddl-end --
ALTER TABLE public.falla OWNER TO postgres;
-- ddl-end --

-- object: public.tipo_falla | type: TABLE --
-- DROP TABLE IF EXISTS public.tipo_falla CASCADE;
CREATE TABLE public.tipo_falla(
	id_tipo_falla serial NOT NULL,
	nombre_tipo_falla varchar(50) NOT NULL,
	observaciones varchar(200),
	CONSTRAINT tipo_falla_pk PRIMARY KEY (id_tipo_falla)

);
-- ddl-end --
COMMENT ON TABLE public.tipo_falla IS 'Contiene los posibles  tipos de fallas que un equipo puede tener ';
-- ddl-end --
ALTER TABLE public.tipo_falla OWNER TO postgres;
-- ddl-end --

-- object: public.bitacora_de_fallas | type: TABLE --
-- DROP TABLE IF EXISTS public.bitacora_de_fallas CASCADE;
CREATE TABLE public.bitacora_de_fallas(
	id_equipo serial NOT NULL,
	id_falla serial NOT NULL,
	observaciones varchar(200),
	CONSTRAINT bitacora_de_fallas_pk PRIMARY KEY (id_equipo,id_falla)

);
-- ddl-end --
COMMENT ON TABLE public.bitacora_de_fallas IS 'Contiene un historial de las fallas que se han dado por equipo , conteniendo el id del equipo  en cuestion y el id de la falla ';
-- ddl-end --
ALTER TABLE public.bitacora_de_fallas OWNER TO postgres;
-- ddl-end --

-- object: proveedor | type: CONSTRAINT --
-- ALTER TABLE public.orden_compra DROP CONSTRAINT IF EXISTS proveedor CASCADE;
ALTER TABLE public.orden_compra ADD CONSTRAINT proveedor FOREIGN KEY (id_proveedor)
REFERENCES public.proveedores (id_proveedor) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: material_insumo | type: CONSTRAINT --
-- ALTER TABLE public.orden_compra DROP CONSTRAINT IF EXISTS material_insumo CASCADE;
ALTER TABLE public.orden_compra ADD CONSTRAINT material_insumo FOREIGN KEY (id_material_insumo)
REFERENCES public.materiales_insumos (id_material_insumo) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: material_insumo | type: CONSTRAINT --
-- ALTER TABLE public.proveedores_por_insumo DROP CONSTRAINT IF EXISTS material_insumo CASCADE;
ALTER TABLE public.proveedores_por_insumo ADD CONSTRAINT material_insumo FOREIGN KEY (id_material_insumo)
REFERENCES public.materiales_insumos (id_material_insumo) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: proveedores | type: CONSTRAINT --
-- ALTER TABLE public.proveedores_por_insumo DROP CONSTRAINT IF EXISTS proveedores CASCADE;
ALTER TABLE public.proveedores_por_insumo ADD CONSTRAINT proveedores FOREIGN KEY (id_proveedor)
REFERENCES public.proveedores (id_proveedor) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: equipo | type: CONSTRAINT --
-- ALTER TABLE public.partes_por_equipo DROP CONSTRAINT IF EXISTS equipo CASCADE;
ALTER TABLE public.partes_por_equipo ADD CONSTRAINT equipo FOREIGN KEY (id_equipo)
REFERENCES public.equipo (id_equipo) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: partes | type: CONSTRAINT --
-- ALTER TABLE public.partes_por_equipo DROP CONSTRAINT IF EXISTS partes CASCADE;
ALTER TABLE public.partes_por_equipo ADD CONSTRAINT partes FOREIGN KEY (id_parte)
REFERENCES public.partes (id_parte) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: procedimiento | type: CONSTRAINT --
-- ALTER TABLE public.procedimiento_por_equipo DROP CONSTRAINT IF EXISTS procedimiento CASCADE;
ALTER TABLE public.procedimiento_por_equipo ADD CONSTRAINT procedimiento FOREIGN KEY (id_procedimiento)
REFERENCES public.procedimiento (id_procedimiento) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: equipo | type: CONSTRAINT --
-- ALTER TABLE public.procedimiento_por_equipo DROP CONSTRAINT IF EXISTS equipo CASCADE;
ALTER TABLE public.procedimiento_por_equipo ADD CONSTRAINT equipo FOREIGN KEY (id_equipo)
REFERENCES public.equipo (id_equipo) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: material_insumo | type: CONSTRAINT --
-- ALTER TABLE public.procedimiento_por_equipo DROP CONSTRAINT IF EXISTS material_insumo CASCADE;
ALTER TABLE public.procedimiento_por_equipo ADD CONSTRAINT material_insumo FOREIGN KEY (id_material_insumo)
REFERENCES public.materiales_insumos (id_material_insumo) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: tipo_mantenimiento | type: CONSTRAINT --
-- ALTER TABLE public.orden_trabajo DROP CONSTRAINT IF EXISTS tipo_mantenimiento CASCADE;
ALTER TABLE public.orden_trabajo ADD CONSTRAINT tipo_mantenimiento FOREIGN KEY (id_tipo_mantenimiento)
REFERENCES public.tipo_mantenimiento (id_tipo_mantenimiento) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: recurso_humano | type: CONSTRAINT --
-- ALTER TABLE public.orden_trabajo DROP CONSTRAINT IF EXISTS recurso_humano CASCADE;
ALTER TABLE public.orden_trabajo ADD CONSTRAINT recurso_humano FOREIGN KEY (id_recurso_humano)
REFERENCES public.recurso_humano (id_recurso_humano) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: estado_orden_trabajo | type: CONSTRAINT --
-- ALTER TABLE public.orden_trabajo DROP CONSTRAINT IF EXISTS estado_orden_trabajo CASCADE;
ALTER TABLE public.orden_trabajo ADD CONSTRAINT estado_orden_trabajo FOREIGN KEY (id_estado)
REFERENCES public.estado_orden_trabajo (id_estado) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: procedimiento | type: CONSTRAINT --
-- ALTER TABLE public.orden_trabajo DROP CONSTRAINT IF EXISTS procedimiento CASCADE;
ALTER TABLE public.orden_trabajo ADD CONSTRAINT procedimiento FOREIGN KEY (id_procedimiento)
REFERENCES public.procedimiento (id_procedimiento) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: tipo_programacion | type: CONSTRAINT --
-- ALTER TABLE public.programacion DROP CONSTRAINT IF EXISTS tipo_programacion CASCADE;
ALTER TABLE public.programacion ADD CONSTRAINT tipo_programacion FOREIGN KEY (id_tipo_programacion)
REFERENCES public.tipo_programacion (id_tipo_programacion) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: orden_trabajo | type: CONSTRAINT --
-- ALTER TABLE public.programacion DROP CONSTRAINT IF EXISTS orden_trabajo CASCADE;
ALTER TABLE public.programacion ADD CONSTRAINT orden_trabajo FOREIGN KEY (id_orden_trabajo)
REFERENCES public.orden_trabajo (id_orden_trabajo) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: tipo_falla | type: CONSTRAINT --
-- ALTER TABLE public.falla DROP CONSTRAINT IF EXISTS tipo_falla CASCADE;
ALTER TABLE public.falla ADD CONSTRAINT tipo_falla FOREIGN KEY (id_tipo_falla)
REFERENCES public.tipo_falla (id_tipo_falla) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: falla | type: CONSTRAINT --
-- ALTER TABLE public.bitacora_de_fallas DROP CONSTRAINT IF EXISTS falla CASCADE;
ALTER TABLE public.bitacora_de_fallas ADD CONSTRAINT falla FOREIGN KEY (id_falla)
REFERENCES public.falla (id_falla) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: equipo | type: CONSTRAINT --
-- ALTER TABLE public.bitacora_de_fallas DROP CONSTRAINT IF EXISTS equipo CASCADE;
ALTER TABLE public.bitacora_de_fallas ADD CONSTRAINT equipo FOREIGN KEY (id_equipo)
REFERENCES public.equipo (id_equipo) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --


