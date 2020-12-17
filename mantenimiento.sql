--
-- PostgreSQL database dump
--

-- Dumped from database version 12.5 (Ubuntu 12.5-1.pgdg18.04+1)
-- Dumped by pg_dump version 12.5 (Ubuntu 12.5-1.pgdg18.04+1)

-- Started on 2020-12-01 11:14:57 CST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE mantenimiento;
--
-- TOC entry 3335 (class 1262 OID 16662)
-- Name: mantenimiento; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE mantenimiento WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';


ALTER DATABASE mantenimiento OWNER TO postgres;

\connect mantenimiento

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 251 (class 1259 OID 16842)
-- Name: bitacora_de_fallas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bitacora_de_fallas (
    id_equipo integer NOT NULL,
    id_falla integer NOT NULL,
    observaciones character varying(200)
);


ALTER TABLE public.bitacora_de_fallas OWNER TO postgres;

--
-- TOC entry 3336 (class 0 OID 0)
-- Dependencies: 251
-- Name: TABLE bitacora_de_fallas; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.bitacora_de_fallas IS 'Contiene un historial de las fallas que se han dado por equipo , conteniendo el id del equipo  en cuestion y el id de la falla ';


--
-- TOC entry 249 (class 1259 OID 16838)
-- Name: bitacora_de_fallas_id_equipo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.bitacora_de_fallas_id_equipo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.bitacora_de_fallas_id_equipo_seq OWNER TO postgres;

--
-- TOC entry 3337 (class 0 OID 0)
-- Dependencies: 249
-- Name: bitacora_de_fallas_id_equipo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.bitacora_de_fallas_id_equipo_seq OWNED BY public.bitacora_de_fallas.id_equipo;


--
-- TOC entry 250 (class 1259 OID 16840)
-- Name: bitacora_de_fallas_id_falla_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.bitacora_de_fallas_id_falla_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.bitacora_de_fallas_id_falla_seq OWNER TO postgres;

--
-- TOC entry 3338 (class 0 OID 0)
-- Dependencies: 250
-- Name: bitacora_de_fallas_id_falla_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.bitacora_de_fallas_id_falla_seq OWNED BY public.bitacora_de_fallas.id_falla;


--
-- TOC entry 220 (class 1259 OID 16730)
-- Name: equipo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.equipo (
    id_equipo integer NOT NULL,
    equipo character varying(50) NOT NULL,
    cantidad integer NOT NULL,
    descripcion character varying(100) NOT NULL,
    observaciones character varying(200)
);


ALTER TABLE public.equipo OWNER TO postgres;

--
-- TOC entry 3339 (class 0 OID 0)
-- Dependencies: 220
-- Name: TABLE equipo; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.equipo IS 'contiene los equipos a los cuales se les aplica el mantenimiento:
ejemplo:
Computadoras 
Switch 
Routers , etc ';


--
-- TOC entry 219 (class 1259 OID 16728)
-- Name: equipo_id_equipo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.equipo_id_equipo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.equipo_id_equipo_seq OWNER TO postgres;

--
-- TOC entry 3340 (class 0 OID 0)
-- Dependencies: 219
-- Name: equipo_id_equipo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.equipo_id_equipo_seq OWNED BY public.equipo.id_equipo;


--
-- TOC entry 239 (class 1259 OID 16799)
-- Name: estado_orden_trabajo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estado_orden_trabajo (
    id_estado integer NOT NULL,
    estado character varying(50) NOT NULL,
    observaciones character varying(200)
);


ALTER TABLE public.estado_orden_trabajo OWNER TO postgres;

--
-- TOC entry 3341 (class 0 OID 0)
-- Dependencies: 239
-- Name: TABLE estado_orden_trabajo; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.estado_orden_trabajo IS 'cada orden de trabajo contendra un estado especifico los cuales podrian ser:
Generada 
En proceso 
Fallida
Finalizada , etc ';


--
-- TOC entry 238 (class 1259 OID 16797)
-- Name: estado_orden_trabajo_id_estado_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.estado_orden_trabajo_id_estado_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.estado_orden_trabajo_id_estado_seq OWNER TO postgres;

--
-- TOC entry 3342 (class 0 OID 0)
-- Dependencies: 238
-- Name: estado_orden_trabajo_id_estado_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.estado_orden_trabajo_id_estado_seq OWNED BY public.estado_orden_trabajo.id_estado;


--
-- TOC entry 246 (class 1259 OID 16823)
-- Name: falla; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.falla (
    id_falla integer NOT NULL,
    id_tipo_falla integer NOT NULL,
    descripcion character varying(100) NOT NULL,
    observaciones character varying(200)
);


ALTER TABLE public.falla OWNER TO postgres;

--
-- TOC entry 3343 (class 0 OID 0)
-- Dependencies: 246
-- Name: TABLE falla; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.falla IS 'contendra las fallas que se dan en los equipos , a los cuales se les aplica el mantenimiento ';


--
-- TOC entry 244 (class 1259 OID 16819)
-- Name: falla_id_falla_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.falla_id_falla_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.falla_id_falla_seq OWNER TO postgres;

--
-- TOC entry 3344 (class 0 OID 0)
-- Dependencies: 244
-- Name: falla_id_falla_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.falla_id_falla_seq OWNED BY public.falla.id_falla;


--
-- TOC entry 245 (class 1259 OID 16821)
-- Name: falla_id_tipo_falla_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.falla_id_tipo_falla_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.falla_id_tipo_falla_seq OWNER TO postgres;

--
-- TOC entry 3345 (class 0 OID 0)
-- Dependencies: 245
-- Name: falla_id_tipo_falla_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.falla_id_tipo_falla_seq OWNED BY public.falla.id_tipo_falla;


--
-- TOC entry 211 (class 1259 OID 16697)
-- Name: materiales_insumos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.materiales_insumos (
    id_material_insumo integer NOT NULL,
    material_insumo character varying(50) NOT NULL,
    existencia integer NOT NULL,
    stock_maximo integer NOT NULL,
    stock_minimo integer NOT NULL,
    observaciones character varying(200)
);


ALTER TABLE public.materiales_insumos OWNER TO postgres;

--
-- TOC entry 3346 (class 0 OID 0)
-- Dependencies: 211
-- Name: TABLE materiales_insumos; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.materiales_insumos IS 'contiene los materiales e insumos necesarios para dar mantenimientos , los cuales pueden ser desde lo mas minimo como un disco duro a una pc completa ';


--
-- TOC entry 210 (class 1259 OID 16695)
-- Name: materiales_insumos_id_material_insumo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.materiales_insumos_id_material_insumo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.materiales_insumos_id_material_insumo_seq OWNER TO postgres;

--
-- TOC entry 3347 (class 0 OID 0)
-- Dependencies: 210
-- Name: materiales_insumos_id_material_insumo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.materiales_insumos_id_material_insumo_seq OWNED BY public.materiales_insumos.id_material_insumo;


--
-- TOC entry 215 (class 1259 OID 16709)
-- Name: orden_compra; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orden_compra (
    id_orden_compra integer NOT NULL,
    id_proveedor integer NOT NULL,
    id_material_insumo integer NOT NULL,
    cantidad integer NOT NULL,
    observaciones character varying(200)
);


ALTER TABLE public.orden_compra OWNER TO postgres;

--
-- TOC entry 3348 (class 0 OID 0)
-- Dependencies: 215
-- Name: TABLE orden_compra; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.orden_compra IS 'Esta tabla contendra las ordenes de compras , generadas cuando se llegue al stock minimo de los materiales o insumos ';


--
-- TOC entry 214 (class 1259 OID 16707)
-- Name: orden_compra_id_material_insumo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orden_compra_id_material_insumo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orden_compra_id_material_insumo_seq OWNER TO postgres;

--
-- TOC entry 3349 (class 0 OID 0)
-- Dependencies: 214
-- Name: orden_compra_id_material_insumo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orden_compra_id_material_insumo_seq OWNED BY public.orden_compra.id_material_insumo;


--
-- TOC entry 212 (class 1259 OID 16703)
-- Name: orden_compra_id_orden_compra_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orden_compra_id_orden_compra_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orden_compra_id_orden_compra_seq OWNER TO postgres;

--
-- TOC entry 3350 (class 0 OID 0)
-- Dependencies: 212
-- Name: orden_compra_id_orden_compra_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orden_compra_id_orden_compra_seq OWNED BY public.orden_compra.id_orden_compra;


--
-- TOC entry 213 (class 1259 OID 16705)
-- Name: orden_compra_id_proveedor_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orden_compra_id_proveedor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orden_compra_id_proveedor_seq OWNER TO postgres;

--
-- TOC entry 3351 (class 0 OID 0)
-- Dependencies: 213
-- Name: orden_compra_id_proveedor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orden_compra_id_proveedor_seq OWNED BY public.orden_compra.id_proveedor;


--
-- TOC entry 237 (class 1259 OID 16787)
-- Name: orden_trabajo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orden_trabajo (
    id_orden_trabajo integer NOT NULL,
    id_recurso_humano integer NOT NULL,
    id_procedimiento integer,
    id_tipo_mantenimiento integer NOT NULL,
    id_estado integer DEFAULT 1 NOT NULL,
    fecha_generacion timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    observaciones character varying(500),
    id_equipo integer NOT NULL,
    fecha_actualizacion timestamp without time zone
);


ALTER TABLE public.orden_trabajo OWNER TO postgres;

--
-- TOC entry 3352 (class 0 OID 0)
-- Dependencies: 237
-- Name: TABLE orden_trabajo; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.orden_trabajo IS 'contiene todas las odenes de trabajo , especificando el recurso humano procedimiento tipo de mantenimiento y fecha en que fue generada la orden de trabajo , ';


--
-- TOC entry 236 (class 1259 OID 16785)
-- Name: orden_trabajo_id_estado_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orden_trabajo_id_estado_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orden_trabajo_id_estado_seq OWNER TO postgres;

--
-- TOC entry 3353 (class 0 OID 0)
-- Dependencies: 236
-- Name: orden_trabajo_id_estado_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orden_trabajo_id_estado_seq OWNED BY public.orden_trabajo.id_estado;


--
-- TOC entry 232 (class 1259 OID 16777)
-- Name: orden_trabajo_id_orden_trabajo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orden_trabajo_id_orden_trabajo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orden_trabajo_id_orden_trabajo_seq OWNER TO postgres;

--
-- TOC entry 3354 (class 0 OID 0)
-- Dependencies: 232
-- Name: orden_trabajo_id_orden_trabajo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orden_trabajo_id_orden_trabajo_seq OWNED BY public.orden_trabajo.id_orden_trabajo;


--
-- TOC entry 234 (class 1259 OID 16781)
-- Name: orden_trabajo_id_procedimiento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orden_trabajo_id_procedimiento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orden_trabajo_id_procedimiento_seq OWNER TO postgres;

--
-- TOC entry 3355 (class 0 OID 0)
-- Dependencies: 234
-- Name: orden_trabajo_id_procedimiento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orden_trabajo_id_procedimiento_seq OWNED BY public.orden_trabajo.id_procedimiento;


--
-- TOC entry 233 (class 1259 OID 16779)
-- Name: orden_trabajo_id_recurso_humano_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orden_trabajo_id_recurso_humano_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orden_trabajo_id_recurso_humano_seq OWNER TO postgres;

--
-- TOC entry 3356 (class 0 OID 0)
-- Dependencies: 233
-- Name: orden_trabajo_id_recurso_humano_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orden_trabajo_id_recurso_humano_seq OWNED BY public.orden_trabajo.id_recurso_humano;


--
-- TOC entry 235 (class 1259 OID 16783)
-- Name: orden_trabajo_id_tipo_mantenimiento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orden_trabajo_id_tipo_mantenimiento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.orden_trabajo_id_tipo_mantenimiento_seq OWNER TO postgres;

--
-- TOC entry 3357 (class 0 OID 0)
-- Dependencies: 235
-- Name: orden_trabajo_id_tipo_mantenimiento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orden_trabajo_id_tipo_mantenimiento_seq OWNED BY public.orden_trabajo.id_tipo_mantenimiento;


--
-- TOC entry 222 (class 1259 OID 16738)
-- Name: partes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.partes (
    id_parte integer NOT NULL,
    parte character varying(50) NOT NULL,
    descripcion character varying(100),
    observaciones character varying(200)
);


ALTER TABLE public.partes OWNER TO postgres;

--
-- TOC entry 3358 (class 0 OID 0)
-- Dependencies: 222
-- Name: TABLE partes; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.partes IS 'contiene las diferentes partes de los equipos 
ejemplo 
Disco duro 
Memorias Ram 
Fuentes 
motherboard , etc';


--
-- TOC entry 221 (class 1259 OID 16736)
-- Name: partes_id_parte_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.partes_id_parte_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.partes_id_parte_seq OWNER TO postgres;

--
-- TOC entry 3359 (class 0 OID 0)
-- Dependencies: 221
-- Name: partes_id_parte_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.partes_id_parte_seq OWNED BY public.partes.id_parte;


--
-- TOC entry 225 (class 1259 OID 16748)
-- Name: partes_por_equipo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.partes_por_equipo (
    id_equipo integer NOT NULL,
    id_parte integer NOT NULL,
    cantidad integer NOT NULL,
    observaciones character varying(200)
);


ALTER TABLE public.partes_por_equipo OWNER TO postgres;

--
-- TOC entry 3360 (class 0 OID 0)
-- Dependencies: 225
-- Name: TABLE partes_por_equipo; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.partes_por_equipo IS 'cada equipo puede estar compuesto por diversas partes , para diferenciarlas de cada equipo , se crea esta tabla ';


--
-- TOC entry 223 (class 1259 OID 16744)
-- Name: partes_por_equipo_id_equipo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.partes_por_equipo_id_equipo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.partes_por_equipo_id_equipo_seq OWNER TO postgres;

--
-- TOC entry 3361 (class 0 OID 0)
-- Dependencies: 223
-- Name: partes_por_equipo_id_equipo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.partes_por_equipo_id_equipo_seq OWNED BY public.partes_por_equipo.id_equipo;


--
-- TOC entry 224 (class 1259 OID 16746)
-- Name: partes_por_equipo_id_parte_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.partes_por_equipo_id_parte_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.partes_por_equipo_id_parte_seq OWNER TO postgres;

--
-- TOC entry 3362 (class 0 OID 0)
-- Dependencies: 224
-- Name: partes_por_equipo_id_parte_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.partes_por_equipo_id_parte_seq OWNED BY public.partes_por_equipo.id_parte;


--
-- TOC entry 227 (class 1259 OID 16757)
-- Name: procedimiento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.procedimiento (
    id_procedimiento integer NOT NULL,
    procedimiento character varying(50) NOT NULL,
    descripcion character varying(100),
    observaciones character varying(200)
);


ALTER TABLE public.procedimiento OWNER TO postgres;

--
-- TOC entry 3363 (class 0 OID 0)
-- Dependencies: 227
-- Name: TABLE procedimiento; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.procedimiento IS 'contiene los procedimientos generales aplicables a los equipos a dar mantenimiento: ejemplo :
Limpieza de Computadora
Cambio de UPS 
Realizar Cables de Red ';


--
-- TOC entry 226 (class 1259 OID 16755)
-- Name: procedimiento_id_procedimiento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.procedimiento_id_procedimiento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.procedimiento_id_procedimiento_seq OWNER TO postgres;

--
-- TOC entry 3364 (class 0 OID 0)
-- Dependencies: 226
-- Name: procedimiento_id_procedimiento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.procedimiento_id_procedimiento_seq OWNED BY public.procedimiento.id_procedimiento;


--
-- TOC entry 231 (class 1259 OID 16769)
-- Name: procedimiento_por_equipo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.procedimiento_por_equipo (
    id_procedimiento integer NOT NULL,
    id_equipo integer NOT NULL,
    id_material_insumo integer NOT NULL,
    descripcion character varying(100) NOT NULL,
    observaciones character varying(100)
);


ALTER TABLE public.procedimiento_por_equipo OWNER TO postgres;

--
-- TOC entry 3365 (class 0 OID 0)
-- Dependencies: 231
-- Name: TABLE procedimiento_por_equipo; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.procedimiento_por_equipo IS 'contiene los procedimiento especificos para dar mantenimiento a los equipos incluyendo el material y /o equipo que se usara para tal fin ';


--
-- TOC entry 229 (class 1259 OID 16765)
-- Name: procedimiento_por_equipo_id_equipo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.procedimiento_por_equipo_id_equipo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.procedimiento_por_equipo_id_equipo_seq OWNER TO postgres;

--
-- TOC entry 3366 (class 0 OID 0)
-- Dependencies: 229
-- Name: procedimiento_por_equipo_id_equipo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.procedimiento_por_equipo_id_equipo_seq OWNED BY public.procedimiento_por_equipo.id_equipo;


--
-- TOC entry 230 (class 1259 OID 16767)
-- Name: procedimiento_por_equipo_id_material_insumo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.procedimiento_por_equipo_id_material_insumo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.procedimiento_por_equipo_id_material_insumo_seq OWNER TO postgres;

--
-- TOC entry 3367 (class 0 OID 0)
-- Dependencies: 230
-- Name: procedimiento_por_equipo_id_material_insumo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.procedimiento_por_equipo_id_material_insumo_seq OWNED BY public.procedimiento_por_equipo.id_material_insumo;


--
-- TOC entry 228 (class 1259 OID 16763)
-- Name: procedimiento_por_equipo_id_procedimiento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.procedimiento_por_equipo_id_procedimiento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.procedimiento_por_equipo_id_procedimiento_seq OWNER TO postgres;

--
-- TOC entry 3368 (class 0 OID 0)
-- Dependencies: 228
-- Name: procedimiento_por_equipo_id_procedimiento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.procedimiento_por_equipo_id_procedimiento_seq OWNED BY public.procedimiento_por_equipo.id_procedimiento;


--
-- TOC entry 243 (class 1259 OID 16811)
-- Name: programacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.programacion (
    id_programacion integer NOT NULL,
    id_tipo_programacion integer NOT NULL,
    id_orden_trabajo integer NOT NULL,
    fecha_realizacion date NOT NULL,
    observaciones character varying(200)
);


ALTER TABLE public.programacion OWNER TO postgres;

--
-- TOC entry 3369 (class 0 OID 0)
-- Dependencies: 243
-- Name: TABLE programacion; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.programacion IS 'Se almacenará la programacion de las ordenes de trabajo para mantenimiento preventivo ';


--
-- TOC entry 242 (class 1259 OID 16809)
-- Name: programacion_id_orden_trabajo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.programacion_id_orden_trabajo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.programacion_id_orden_trabajo_seq OWNER TO postgres;

--
-- TOC entry 3370 (class 0 OID 0)
-- Dependencies: 242
-- Name: programacion_id_orden_trabajo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.programacion_id_orden_trabajo_seq OWNED BY public.programacion.id_orden_trabajo;


--
-- TOC entry 240 (class 1259 OID 16805)
-- Name: programacion_id_programacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.programacion_id_programacion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.programacion_id_programacion_seq OWNER TO postgres;

--
-- TOC entry 3371 (class 0 OID 0)
-- Dependencies: 240
-- Name: programacion_id_programacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.programacion_id_programacion_seq OWNED BY public.programacion.id_programacion;


--
-- TOC entry 241 (class 1259 OID 16807)
-- Name: programacion_id_tipo_programacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.programacion_id_tipo_programacion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.programacion_id_tipo_programacion_seq OWNER TO postgres;

--
-- TOC entry 3372 (class 0 OID 0)
-- Dependencies: 241
-- Name: programacion_id_tipo_programacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.programacion_id_tipo_programacion_seq OWNED BY public.programacion.id_tipo_programacion;


--
-- TOC entry 205 (class 1259 OID 16673)
-- Name: proveedores; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.proveedores (
    id_proveedor integer NOT NULL,
    proveedor character varying(50) NOT NULL,
    telefono character(8),
    direccion character varying(100),
    observaciones character varying(200)
);


ALTER TABLE public.proveedores OWNER TO postgres;

--
-- TOC entry 3373 (class 0 OID 0)
-- Dependencies: 205
-- Name: TABLE proveedores; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.proveedores IS 'contiene los proveedores con los cuales adquirimos los materiales e insumos ';


--
-- TOC entry 204 (class 1259 OID 16671)
-- Name: proveedores_id_proveedor_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.proveedores_id_proveedor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.proveedores_id_proveedor_seq OWNER TO postgres;

--
-- TOC entry 3374 (class 0 OID 0)
-- Dependencies: 204
-- Name: proveedores_id_proveedor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.proveedores_id_proveedor_seq OWNED BY public.proveedores.id_proveedor;


--
-- TOC entry 218 (class 1259 OID 16721)
-- Name: proveedores_por_insumo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.proveedores_por_insumo (
    id_material_insumo integer NOT NULL,
    id_proveedor integer NOT NULL,
    observaciones character varying(200)
);


ALTER TABLE public.proveedores_por_insumo OWNER TO postgres;

--
-- TOC entry 3375 (class 0 OID 0)
-- Dependencies: 218
-- Name: TABLE proveedores_por_insumo; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.proveedores_por_insumo IS 'Dado que un insumo no solo puedo comprarselo a un solo proveedor sino  a varios , surge esta tabla para asinar un insumo a varios proveedores ';


--
-- TOC entry 216 (class 1259 OID 16717)
-- Name: proveedores_por_insumo_id_material_insumo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.proveedores_por_insumo_id_material_insumo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.proveedores_por_insumo_id_material_insumo_seq OWNER TO postgres;

--
-- TOC entry 3376 (class 0 OID 0)
-- Dependencies: 216
-- Name: proveedores_por_insumo_id_material_insumo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.proveedores_por_insumo_id_material_insumo_seq OWNED BY public.proveedores_por_insumo.id_material_insumo;


--
-- TOC entry 217 (class 1259 OID 16719)
-- Name: proveedores_por_insumo_id_proveedor_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.proveedores_por_insumo_id_proveedor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.proveedores_por_insumo_id_proveedor_seq OWNER TO postgres;

--
-- TOC entry 3377 (class 0 OID 0)
-- Dependencies: 217
-- Name: proveedores_por_insumo_id_proveedor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.proveedores_por_insumo_id_proveedor_seq OWNED BY public.proveedores_por_insumo.id_proveedor;


--
-- TOC entry 207 (class 1259 OID 16681)
-- Name: recurso_humano; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.recurso_humano (
    id_recurso_humano integer NOT NULL,
    nombre character varying(50) NOT NULL,
    apellido character varying(50) NOT NULL,
    telefono character(8),
    observaciones character varying(200)
);


ALTER TABLE public.recurso_humano OWNER TO postgres;

--
-- TOC entry 3378 (class 0 OID 0)
-- Dependencies: 207
-- Name: TABLE recurso_humano; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.recurso_humano IS 'Contiene el Recurso humano que realizará la orden de trabajo , tomando en cuenta que solo podra estar una persona realizando una orden especifica ';


--
-- TOC entry 206 (class 1259 OID 16679)
-- Name: recurso_humano_id_recurso_humano_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.recurso_humano_id_recurso_humano_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.recurso_humano_id_recurso_humano_seq OWNER TO postgres;

--
-- TOC entry 3379 (class 0 OID 0)
-- Dependencies: 206
-- Name: recurso_humano_id_recurso_humano_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.recurso_humano_id_recurso_humano_seq OWNED BY public.recurso_humano.id_recurso_humano;


--
-- TOC entry 248 (class 1259 OID 16832)
-- Name: tipo_falla; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_falla (
    id_tipo_falla integer NOT NULL,
    nombre_tipo_falla character varying(50) NOT NULL,
    observaciones character varying(200)
);


ALTER TABLE public.tipo_falla OWNER TO postgres;

--
-- TOC entry 3380 (class 0 OID 0)
-- Dependencies: 248
-- Name: TABLE tipo_falla; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.tipo_falla IS 'Contiene los posibles  tipos de fallas que un equipo puede tener ';


--
-- TOC entry 247 (class 1259 OID 16830)
-- Name: tipo_falla_id_tipo_falla_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_falla_id_tipo_falla_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_falla_id_tipo_falla_seq OWNER TO postgres;

--
-- TOC entry 3381 (class 0 OID 0)
-- Dependencies: 247
-- Name: tipo_falla_id_tipo_falla_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_falla_id_tipo_falla_seq OWNED BY public.tipo_falla.id_tipo_falla;


--
-- TOC entry 203 (class 1259 OID 16665)
-- Name: tipo_mantenimiento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_mantenimiento (
    id_tipo_mantenimiento integer NOT NULL,
    mantenimiento character varying(50) NOT NULL,
    observaciones character varying(200)
);


ALTER TABLE public.tipo_mantenimiento OWNER TO postgres;

--
-- TOC entry 3382 (class 0 OID 0)
-- Dependencies: 203
-- Name: TABLE tipo_mantenimiento; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.tipo_mantenimiento IS 'Contendra los tipos de mantenimiento , preventivo o correctivo ';


--
-- TOC entry 202 (class 1259 OID 16663)
-- Name: tipo_mantenimiento_id_tipo_mantenimiento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_mantenimiento_id_tipo_mantenimiento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_mantenimiento_id_tipo_mantenimiento_seq OWNER TO postgres;

--
-- TOC entry 3383 (class 0 OID 0)
-- Dependencies: 202
-- Name: tipo_mantenimiento_id_tipo_mantenimiento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_mantenimiento_id_tipo_mantenimiento_seq OWNED BY public.tipo_mantenimiento.id_tipo_mantenimiento;


--
-- TOC entry 209 (class 1259 OID 16689)
-- Name: tipo_programacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_programacion (
    id_tipo_programacion integer NOT NULL,
    programacion character varying(50) NOT NULL,
    observaciones character varying(200)
);


ALTER TABLE public.tipo_programacion OWNER TO postgres;

--
-- TOC entry 3384 (class 0 OID 0)
-- Dependencies: 209
-- Name: TABLE tipo_programacion; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.tipo_programacion IS 'contendra los tipos de programacion, ya sea anual o mensual';


--
-- TOC entry 208 (class 1259 OID 16687)
-- Name: tipo_programacion_id_tipo_programacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_programacion_id_tipo_programacion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_programacion_id_tipo_programacion_seq OWNER TO postgres;

--
-- TOC entry 3385 (class 0 OID 0)
-- Dependencies: 208
-- Name: tipo_programacion_id_tipo_programacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_programacion_id_tipo_programacion_seq OWNED BY public.tipo_programacion.id_tipo_programacion;


--
-- TOC entry 3097 (class 2604 OID 16845)
-- Name: bitacora_de_fallas id_equipo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bitacora_de_fallas ALTER COLUMN id_equipo SET DEFAULT nextval('public.bitacora_de_fallas_id_equipo_seq'::regclass);


--
-- TOC entry 3098 (class 2604 OID 16846)
-- Name: bitacora_de_fallas id_falla; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bitacora_de_fallas ALTER COLUMN id_falla SET DEFAULT nextval('public.bitacora_de_fallas_id_falla_seq'::regclass);


--
-- TOC entry 3076 (class 2604 OID 16733)
-- Name: equipo id_equipo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipo ALTER COLUMN id_equipo SET DEFAULT nextval('public.equipo_id_equipo_seq'::regclass);


--
-- TOC entry 3090 (class 2604 OID 16802)
-- Name: estado_orden_trabajo id_estado; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estado_orden_trabajo ALTER COLUMN id_estado SET DEFAULT nextval('public.estado_orden_trabajo_id_estado_seq'::regclass);


--
-- TOC entry 3094 (class 2604 OID 16826)
-- Name: falla id_falla; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.falla ALTER COLUMN id_falla SET DEFAULT nextval('public.falla_id_falla_seq'::regclass);


--
-- TOC entry 3095 (class 2604 OID 16827)
-- Name: falla id_tipo_falla; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.falla ALTER COLUMN id_tipo_falla SET DEFAULT nextval('public.falla_id_tipo_falla_seq'::regclass);


--
-- TOC entry 3070 (class 2604 OID 16700)
-- Name: materiales_insumos id_material_insumo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.materiales_insumos ALTER COLUMN id_material_insumo SET DEFAULT nextval('public.materiales_insumos_id_material_insumo_seq'::regclass);


--
-- TOC entry 3071 (class 2604 OID 16712)
-- Name: orden_compra id_orden_compra; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_compra ALTER COLUMN id_orden_compra SET DEFAULT nextval('public.orden_compra_id_orden_compra_seq'::regclass);


--
-- TOC entry 3072 (class 2604 OID 16713)
-- Name: orden_compra id_proveedor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_compra ALTER COLUMN id_proveedor SET DEFAULT nextval('public.orden_compra_id_proveedor_seq'::regclass);


--
-- TOC entry 3073 (class 2604 OID 16714)
-- Name: orden_compra id_material_insumo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_compra ALTER COLUMN id_material_insumo SET DEFAULT nextval('public.orden_compra_id_material_insumo_seq'::regclass);


--
-- TOC entry 3084 (class 2604 OID 16790)
-- Name: orden_trabajo id_orden_trabajo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_trabajo ALTER COLUMN id_orden_trabajo SET DEFAULT nextval('public.orden_trabajo_id_orden_trabajo_seq'::regclass);


--
-- TOC entry 3085 (class 2604 OID 16791)
-- Name: orden_trabajo id_recurso_humano; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_trabajo ALTER COLUMN id_recurso_humano SET DEFAULT nextval('public.orden_trabajo_id_recurso_humano_seq'::regclass);


--
-- TOC entry 3086 (class 2604 OID 16793)
-- Name: orden_trabajo id_tipo_mantenimiento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_trabajo ALTER COLUMN id_tipo_mantenimiento SET DEFAULT nextval('public.orden_trabajo_id_tipo_mantenimiento_seq'::regclass);


--
-- TOC entry 3088 (class 2604 OID 16951)
-- Name: orden_trabajo id_equipo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_trabajo ALTER COLUMN id_equipo SET DEFAULT nextval('public.orden_trabajo_id_orden_trabajo_seq'::regclass);


--
-- TOC entry 3077 (class 2604 OID 16741)
-- Name: partes id_parte; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.partes ALTER COLUMN id_parte SET DEFAULT nextval('public.partes_id_parte_seq'::regclass);


--
-- TOC entry 3078 (class 2604 OID 16751)
-- Name: partes_por_equipo id_equipo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.partes_por_equipo ALTER COLUMN id_equipo SET DEFAULT nextval('public.partes_por_equipo_id_equipo_seq'::regclass);


--
-- TOC entry 3079 (class 2604 OID 16752)
-- Name: partes_por_equipo id_parte; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.partes_por_equipo ALTER COLUMN id_parte SET DEFAULT nextval('public.partes_por_equipo_id_parte_seq'::regclass);


--
-- TOC entry 3080 (class 2604 OID 16760)
-- Name: procedimiento id_procedimiento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procedimiento ALTER COLUMN id_procedimiento SET DEFAULT nextval('public.procedimiento_id_procedimiento_seq'::regclass);


--
-- TOC entry 3081 (class 2604 OID 16772)
-- Name: procedimiento_por_equipo id_procedimiento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procedimiento_por_equipo ALTER COLUMN id_procedimiento SET DEFAULT nextval('public.procedimiento_por_equipo_id_procedimiento_seq'::regclass);


--
-- TOC entry 3082 (class 2604 OID 16773)
-- Name: procedimiento_por_equipo id_equipo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procedimiento_por_equipo ALTER COLUMN id_equipo SET DEFAULT nextval('public.procedimiento_por_equipo_id_equipo_seq'::regclass);


--
-- TOC entry 3083 (class 2604 OID 16774)
-- Name: procedimiento_por_equipo id_material_insumo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procedimiento_por_equipo ALTER COLUMN id_material_insumo SET DEFAULT nextval('public.procedimiento_por_equipo_id_material_insumo_seq'::regclass);


--
-- TOC entry 3091 (class 2604 OID 16814)
-- Name: programacion id_programacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.programacion ALTER COLUMN id_programacion SET DEFAULT nextval('public.programacion_id_programacion_seq'::regclass);


--
-- TOC entry 3092 (class 2604 OID 16815)
-- Name: programacion id_tipo_programacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.programacion ALTER COLUMN id_tipo_programacion SET DEFAULT nextval('public.programacion_id_tipo_programacion_seq'::regclass);


--
-- TOC entry 3093 (class 2604 OID 16816)
-- Name: programacion id_orden_trabajo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.programacion ALTER COLUMN id_orden_trabajo SET DEFAULT nextval('public.programacion_id_orden_trabajo_seq'::regclass);


--
-- TOC entry 3067 (class 2604 OID 16676)
-- Name: proveedores id_proveedor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.proveedores ALTER COLUMN id_proveedor SET DEFAULT nextval('public.proveedores_id_proveedor_seq'::regclass);


--
-- TOC entry 3074 (class 2604 OID 16724)
-- Name: proveedores_por_insumo id_material_insumo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.proveedores_por_insumo ALTER COLUMN id_material_insumo SET DEFAULT nextval('public.proveedores_por_insumo_id_material_insumo_seq'::regclass);


--
-- TOC entry 3075 (class 2604 OID 16725)
-- Name: proveedores_por_insumo id_proveedor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.proveedores_por_insumo ALTER COLUMN id_proveedor SET DEFAULT nextval('public.proveedores_por_insumo_id_proveedor_seq'::regclass);


--
-- TOC entry 3068 (class 2604 OID 16684)
-- Name: recurso_humano id_recurso_humano; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.recurso_humano ALTER COLUMN id_recurso_humano SET DEFAULT nextval('public.recurso_humano_id_recurso_humano_seq'::regclass);


--
-- TOC entry 3096 (class 2604 OID 16835)
-- Name: tipo_falla id_tipo_falla; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_falla ALTER COLUMN id_tipo_falla SET DEFAULT nextval('public.tipo_falla_id_tipo_falla_seq'::regclass);


--
-- TOC entry 3066 (class 2604 OID 16668)
-- Name: tipo_mantenimiento id_tipo_mantenimiento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_mantenimiento ALTER COLUMN id_tipo_mantenimiento SET DEFAULT nextval('public.tipo_mantenimiento_id_tipo_mantenimiento_seq'::regclass);


--
-- TOC entry 3069 (class 2604 OID 16692)
-- Name: tipo_programacion id_tipo_programacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_programacion ALTER COLUMN id_tipo_programacion SET DEFAULT nextval('public.tipo_programacion_id_tipo_programacion_seq'::regclass);


--
-- TOC entry 3329 (class 0 OID 16842)
-- Dependencies: 251
-- Data for Name: bitacora_de_fallas; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3298 (class 0 OID 16730)
-- Dependencies: 220
-- Data for Name: equipo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.equipo (id_equipo, equipo, cantidad, descripcion, observaciones) VALUES (12, 'Laptop', 5, 'Lenovo 330s', 'Destinadas a la gerencia.');


--
-- TOC entry 3317 (class 0 OID 16799)
-- Dependencies: 239
-- Data for Name: estado_orden_trabajo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.estado_orden_trabajo (id_estado, estado, observaciones) VALUES (1, 'Activa', 'Ordenes de trabajo sin completar');
INSERT INTO public.estado_orden_trabajo (id_estado, estado, observaciones) VALUES (2, 'Inactiva', 'Ordenes de trabajo completadas');


--
-- TOC entry 3324 (class 0 OID 16823)
-- Dependencies: 246
-- Data for Name: falla; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3289 (class 0 OID 16697)
-- Dependencies: 211
-- Data for Name: materiales_insumos; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3293 (class 0 OID 16709)
-- Dependencies: 215
-- Data for Name: orden_compra; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3315 (class 0 OID 16787)
-- Dependencies: 237
-- Data for Name: orden_trabajo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.orden_trabajo (id_orden_trabajo, id_recurso_humano, id_procedimiento, id_tipo_mantenimiento, id_estado, fecha_generacion, observaciones, id_equipo, fecha_actualizacion) VALUES (45, 5, 3, 1, 2, '2020-11-30 18:03:00', 'La laptop fue expuesta al polvo en condiciones extremas de trabajo. Reparado.', 12, '2020-11-30 18:03:26');


--
-- TOC entry 3300 (class 0 OID 16738)
-- Dependencies: 222
-- Data for Name: partes; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3303 (class 0 OID 16748)
-- Dependencies: 225
-- Data for Name: partes_por_equipo; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3305 (class 0 OID 16757)
-- Dependencies: 227
-- Data for Name: procedimiento; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.procedimiento (id_procedimiento, procedimiento, descripcion, observaciones) VALUES (3, 'Limpieza general', 'Se limpian todas las piezas internas del equipo, cuidadosamente.', 'Se puede aplicar a cualquier equipo.');
INSERT INTO public.procedimiento (id_procedimiento, procedimiento, descripcion, observaciones) VALUES (4, 'Procedimiento estandar', 'Inspeccion del equipo, revisar el estado en que fue entregada al taller de mantemiento.', 'Se aplica a cualquier equipo, sin excepciones.');


--
-- TOC entry 3309 (class 0 OID 16769)
-- Dependencies: 231
-- Data for Name: procedimiento_por_equipo; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3321 (class 0 OID 16811)
-- Dependencies: 243
-- Data for Name: programacion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3283 (class 0 OID 16673)
-- Dependencies: 205
-- Data for Name: proveedores; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.proveedores (id_proveedor, proveedor, telefono, direccion, observaciones) VALUES (7, 'Digital Solutions', '22251242', 'Chalchuapa, Santa Ana.', 'Venta de articulos para computadora.');


--
-- TOC entry 3296 (class 0 OID 16721)
-- Dependencies: 218
-- Data for Name: proveedores_por_insumo; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3285 (class 0 OID 16681)
-- Dependencies: 207
-- Data for Name: recurso_humano; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.recurso_humano (id_recurso_humano, nombre, apellido, telefono, observaciones) VALUES (5, 'Edenilson', 'Arana', '75968723', 'Tecnico en mantenimiento');


--
-- TOC entry 3326 (class 0 OID 16832)
-- Dependencies: 248
-- Data for Name: tipo_falla; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3281 (class 0 OID 16665)
-- Dependencies: 203
-- Data for Name: tipo_mantenimiento; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tipo_mantenimiento (id_tipo_mantenimiento, mantenimiento, observaciones) VALUES (1, 'Preventivo', 'Mantenimiento preventivo programado cada cierta cantidad de tiempo.');
INSERT INTO public.tipo_mantenimiento (id_tipo_mantenimiento, mantenimiento, observaciones) VALUES (2, 'Correctivo', 'Mantenimiento por fallas o mal funcionamiento.');


--
-- TOC entry 3287 (class 0 OID 16689)
-- Dependencies: 209
-- Data for Name: tipo_programacion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3386 (class 0 OID 0)
-- Dependencies: 249
-- Name: bitacora_de_fallas_id_equipo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.bitacora_de_fallas_id_equipo_seq', 1, false);


--
-- TOC entry 3387 (class 0 OID 0)
-- Dependencies: 250
-- Name: bitacora_de_fallas_id_falla_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.bitacora_de_fallas_id_falla_seq', 1, false);


--
-- TOC entry 3388 (class 0 OID 0)
-- Dependencies: 219
-- Name: equipo_id_equipo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.equipo_id_equipo_seq', 12, true);


--
-- TOC entry 3389 (class 0 OID 0)
-- Dependencies: 238
-- Name: estado_orden_trabajo_id_estado_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.estado_orden_trabajo_id_estado_seq', 2, true);


--
-- TOC entry 3390 (class 0 OID 0)
-- Dependencies: 244
-- Name: falla_id_falla_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.falla_id_falla_seq', 1, false);


--
-- TOC entry 3391 (class 0 OID 0)
-- Dependencies: 245
-- Name: falla_id_tipo_falla_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.falla_id_tipo_falla_seq', 1, false);


--
-- TOC entry 3392 (class 0 OID 0)
-- Dependencies: 210
-- Name: materiales_insumos_id_material_insumo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.materiales_insumos_id_material_insumo_seq', 1, false);


--
-- TOC entry 3393 (class 0 OID 0)
-- Dependencies: 214
-- Name: orden_compra_id_material_insumo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orden_compra_id_material_insumo_seq', 1, false);


--
-- TOC entry 3394 (class 0 OID 0)
-- Dependencies: 212
-- Name: orden_compra_id_orden_compra_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orden_compra_id_orden_compra_seq', 1, false);


--
-- TOC entry 3395 (class 0 OID 0)
-- Dependencies: 213
-- Name: orden_compra_id_proveedor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orden_compra_id_proveedor_seq', 1, false);


--
-- TOC entry 3396 (class 0 OID 0)
-- Dependencies: 236
-- Name: orden_trabajo_id_estado_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orden_trabajo_id_estado_seq', 1, false);


--
-- TOC entry 3397 (class 0 OID 0)
-- Dependencies: 232
-- Name: orden_trabajo_id_orden_trabajo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orden_trabajo_id_orden_trabajo_seq', 45, true);


--
-- TOC entry 3398 (class 0 OID 0)
-- Dependencies: 234
-- Name: orden_trabajo_id_procedimiento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orden_trabajo_id_procedimiento_seq', 1, true);


--
-- TOC entry 3399 (class 0 OID 0)
-- Dependencies: 233
-- Name: orden_trabajo_id_recurso_humano_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orden_trabajo_id_recurso_humano_seq', 1, false);


--
-- TOC entry 3400 (class 0 OID 0)
-- Dependencies: 235
-- Name: orden_trabajo_id_tipo_mantenimiento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orden_trabajo_id_tipo_mantenimiento_seq', 1, false);


--
-- TOC entry 3401 (class 0 OID 0)
-- Dependencies: 221
-- Name: partes_id_parte_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.partes_id_parte_seq', 1, false);


--
-- TOC entry 3402 (class 0 OID 0)
-- Dependencies: 223
-- Name: partes_por_equipo_id_equipo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.partes_por_equipo_id_equipo_seq', 1, false);


--
-- TOC entry 3403 (class 0 OID 0)
-- Dependencies: 224
-- Name: partes_por_equipo_id_parte_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.partes_por_equipo_id_parte_seq', 1, false);


--
-- TOC entry 3404 (class 0 OID 0)
-- Dependencies: 226
-- Name: procedimiento_id_procedimiento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.procedimiento_id_procedimiento_seq', 4, true);


--
-- TOC entry 3405 (class 0 OID 0)
-- Dependencies: 229
-- Name: procedimiento_por_equipo_id_equipo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.procedimiento_por_equipo_id_equipo_seq', 1, false);


--
-- TOC entry 3406 (class 0 OID 0)
-- Dependencies: 230
-- Name: procedimiento_por_equipo_id_material_insumo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.procedimiento_por_equipo_id_material_insumo_seq', 1, false);


--
-- TOC entry 3407 (class 0 OID 0)
-- Dependencies: 228
-- Name: procedimiento_por_equipo_id_procedimiento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.procedimiento_por_equipo_id_procedimiento_seq', 1, false);


--
-- TOC entry 3408 (class 0 OID 0)
-- Dependencies: 242
-- Name: programacion_id_orden_trabajo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.programacion_id_orden_trabajo_seq', 1, false);


--
-- TOC entry 3409 (class 0 OID 0)
-- Dependencies: 240
-- Name: programacion_id_programacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.programacion_id_programacion_seq', 1, false);


--
-- TOC entry 3410 (class 0 OID 0)
-- Dependencies: 241
-- Name: programacion_id_tipo_programacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.programacion_id_tipo_programacion_seq', 1, false);


--
-- TOC entry 3411 (class 0 OID 0)
-- Dependencies: 204
-- Name: proveedores_id_proveedor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.proveedores_id_proveedor_seq', 7, true);


--
-- TOC entry 3412 (class 0 OID 0)
-- Dependencies: 216
-- Name: proveedores_por_insumo_id_material_insumo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.proveedores_por_insumo_id_material_insumo_seq', 1, false);


--
-- TOC entry 3413 (class 0 OID 0)
-- Dependencies: 217
-- Name: proveedores_por_insumo_id_proveedor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.proveedores_por_insumo_id_proveedor_seq', 1, false);


--
-- TOC entry 3414 (class 0 OID 0)
-- Dependencies: 206
-- Name: recurso_humano_id_recurso_humano_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.recurso_humano_id_recurso_humano_seq', 5, true);


--
-- TOC entry 3415 (class 0 OID 0)
-- Dependencies: 247
-- Name: tipo_falla_id_tipo_falla_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_falla_id_tipo_falla_seq', 1, false);


--
-- TOC entry 3416 (class 0 OID 0)
-- Dependencies: 202
-- Name: tipo_mantenimiento_id_tipo_mantenimiento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_mantenimiento_id_tipo_mantenimiento_seq', 2, true);


--
-- TOC entry 3417 (class 0 OID 0)
-- Dependencies: 208
-- Name: tipo_programacion_id_tipo_programacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_programacion_id_tipo_programacion_seq', 1, false);


--
-- TOC entry 3134 (class 2606 OID 16848)
-- Name: bitacora_de_fallas bitacora_de_fallas_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bitacora_de_fallas
    ADD CONSTRAINT bitacora_de_fallas_pk PRIMARY KEY (id_equipo, id_falla);


--
-- TOC entry 3114 (class 2606 OID 16735)
-- Name: equipo equipo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipo
    ADD CONSTRAINT equipo_pk PRIMARY KEY (id_equipo);


--
-- TOC entry 3126 (class 2606 OID 16804)
-- Name: estado_orden_trabajo estado_orden_trabajo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estado_orden_trabajo
    ADD CONSTRAINT estado_orden_trabajo_pk PRIMARY KEY (id_estado);


--
-- TOC entry 3130 (class 2606 OID 16829)
-- Name: falla falla_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.falla
    ADD CONSTRAINT falla_pk PRIMARY KEY (id_falla);


--
-- TOC entry 3108 (class 2606 OID 16702)
-- Name: materiales_insumos materiales_insumos_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.materiales_insumos
    ADD CONSTRAINT materiales_insumos_pk PRIMARY KEY (id_material_insumo);


--
-- TOC entry 3110 (class 2606 OID 16716)
-- Name: orden_compra orden_compra_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_compra
    ADD CONSTRAINT orden_compra_pk PRIMARY KEY (id_orden_compra, id_proveedor, id_material_insumo);


--
-- TOC entry 3124 (class 2606 OID 16796)
-- Name: orden_trabajo orden_trabajo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_trabajo
    ADD CONSTRAINT orden_trabajo_pk PRIMARY KEY (id_orden_trabajo);


--
-- TOC entry 3116 (class 2606 OID 16743)
-- Name: partes partes_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.partes
    ADD CONSTRAINT partes_pk PRIMARY KEY (id_parte);


--
-- TOC entry 3118 (class 2606 OID 16754)
-- Name: partes_por_equipo partes_por_equipo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.partes_por_equipo
    ADD CONSTRAINT partes_por_equipo_pk PRIMARY KEY (id_equipo, id_parte);


--
-- TOC entry 3120 (class 2606 OID 16762)
-- Name: procedimiento procedimiento_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procedimiento
    ADD CONSTRAINT procedimiento_pk PRIMARY KEY (id_procedimiento);


--
-- TOC entry 3122 (class 2606 OID 16776)
-- Name: procedimiento_por_equipo procedimiento_por_equipo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procedimiento_por_equipo
    ADD CONSTRAINT procedimiento_por_equipo_pk PRIMARY KEY (id_procedimiento, id_equipo, id_material_insumo);


--
-- TOC entry 3128 (class 2606 OID 16818)
-- Name: programacion programacion_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.programacion
    ADD CONSTRAINT programacion_pk PRIMARY KEY (id_programacion);


--
-- TOC entry 3102 (class 2606 OID 16678)
-- Name: proveedores proveedores_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.proveedores
    ADD CONSTRAINT proveedores_pk PRIMARY KEY (id_proveedor);


--
-- TOC entry 3112 (class 2606 OID 16727)
-- Name: proveedores_por_insumo proveedores_por_insumo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.proveedores_por_insumo
    ADD CONSTRAINT proveedores_por_insumo_pk PRIMARY KEY (id_material_insumo, id_proveedor);


--
-- TOC entry 3104 (class 2606 OID 16686)
-- Name: recurso_humano recurso_humano_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.recurso_humano
    ADD CONSTRAINT recurso_humano_pk PRIMARY KEY (id_recurso_humano);


--
-- TOC entry 3132 (class 2606 OID 16837)
-- Name: tipo_falla tipo_falla_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_falla
    ADD CONSTRAINT tipo_falla_pk PRIMARY KEY (id_tipo_falla);


--
-- TOC entry 3100 (class 2606 OID 16670)
-- Name: tipo_mantenimiento tipo_mantenimiento_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_mantenimiento
    ADD CONSTRAINT tipo_mantenimiento_pk PRIMARY KEY (id_tipo_mantenimiento);


--
-- TOC entry 3106 (class 2606 OID 16694)
-- Name: tipo_programacion tipo_programacion_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_programacion
    ADD CONSTRAINT tipo_programacion_pk PRIMARY KEY (id_tipo_programacion);


--
-- TOC entry 3139 (class 2606 OID 16869)
-- Name: partes_por_equipo equipo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.partes_por_equipo
    ADD CONSTRAINT equipo FOREIGN KEY (id_equipo) REFERENCES public.equipo(id_equipo) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3142 (class 2606 OID 16884)
-- Name: procedimiento_por_equipo equipo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procedimiento_por_equipo
    ADD CONSTRAINT equipo FOREIGN KEY (id_equipo) REFERENCES public.equipo(id_equipo) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3153 (class 2606 OID 16934)
-- Name: bitacora_de_fallas equipo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bitacora_de_fallas
    ADD CONSTRAINT equipo FOREIGN KEY (id_equipo) REFERENCES public.equipo(id_equipo) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3148 (class 2606 OID 16946)
-- Name: orden_trabajo equipo_ordentrabajo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_trabajo
    ADD CONSTRAINT equipo_ordentrabajo FOREIGN KEY (id_equipo) REFERENCES public.equipo(id_equipo) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3146 (class 2606 OID 16904)
-- Name: orden_trabajo estado_orden_trabajo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_trabajo
    ADD CONSTRAINT estado_orden_trabajo FOREIGN KEY (id_estado) REFERENCES public.estado_orden_trabajo(id_estado) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3152 (class 2606 OID 16929)
-- Name: bitacora_de_fallas falla; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bitacora_de_fallas
    ADD CONSTRAINT falla FOREIGN KEY (id_falla) REFERENCES public.falla(id_falla) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3136 (class 2606 OID 16854)
-- Name: orden_compra material_insumo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_compra
    ADD CONSTRAINT material_insumo FOREIGN KEY (id_material_insumo) REFERENCES public.materiales_insumos(id_material_insumo) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3137 (class 2606 OID 16859)
-- Name: proveedores_por_insumo material_insumo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.proveedores_por_insumo
    ADD CONSTRAINT material_insumo FOREIGN KEY (id_material_insumo) REFERENCES public.materiales_insumos(id_material_insumo) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3143 (class 2606 OID 16889)
-- Name: procedimiento_por_equipo material_insumo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procedimiento_por_equipo
    ADD CONSTRAINT material_insumo FOREIGN KEY (id_material_insumo) REFERENCES public.materiales_insumos(id_material_insumo) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3150 (class 2606 OID 16919)
-- Name: programacion orden_trabajo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.programacion
    ADD CONSTRAINT orden_trabajo FOREIGN KEY (id_orden_trabajo) REFERENCES public.orden_trabajo(id_orden_trabajo) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3140 (class 2606 OID 16874)
-- Name: partes_por_equipo partes; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.partes_por_equipo
    ADD CONSTRAINT partes FOREIGN KEY (id_parte) REFERENCES public.partes(id_parte) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3141 (class 2606 OID 16879)
-- Name: procedimiento_por_equipo procedimiento; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procedimiento_por_equipo
    ADD CONSTRAINT procedimiento FOREIGN KEY (id_procedimiento) REFERENCES public.procedimiento(id_procedimiento) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3147 (class 2606 OID 16909)
-- Name: orden_trabajo procedimiento; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_trabajo
    ADD CONSTRAINT procedimiento FOREIGN KEY (id_procedimiento) REFERENCES public.procedimiento(id_procedimiento) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3135 (class 2606 OID 16849)
-- Name: orden_compra proveedor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_compra
    ADD CONSTRAINT proveedor FOREIGN KEY (id_proveedor) REFERENCES public.proveedores(id_proveedor) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3138 (class 2606 OID 16864)
-- Name: proveedores_por_insumo proveedores; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.proveedores_por_insumo
    ADD CONSTRAINT proveedores FOREIGN KEY (id_proveedor) REFERENCES public.proveedores(id_proveedor) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3145 (class 2606 OID 16899)
-- Name: orden_trabajo recurso_humano; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_trabajo
    ADD CONSTRAINT recurso_humano FOREIGN KEY (id_recurso_humano) REFERENCES public.recurso_humano(id_recurso_humano) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3151 (class 2606 OID 16924)
-- Name: falla tipo_falla; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.falla
    ADD CONSTRAINT tipo_falla FOREIGN KEY (id_tipo_falla) REFERENCES public.tipo_falla(id_tipo_falla) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3144 (class 2606 OID 16894)
-- Name: orden_trabajo tipo_mantenimiento; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orden_trabajo
    ADD CONSTRAINT tipo_mantenimiento FOREIGN KEY (id_tipo_mantenimiento) REFERENCES public.tipo_mantenimiento(id_tipo_mantenimiento) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3149 (class 2606 OID 16914)
-- Name: programacion tipo_programacion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.programacion
    ADD CONSTRAINT tipo_programacion FOREIGN KEY (id_tipo_programacion) REFERENCES public.tipo_programacion(id_tipo_programacion) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


-- Completed on 2020-12-01 11:14:57 CST

--
-- PostgreSQL database dump complete
--

