--
-- PostgreSQL database dump
--

-- Dumped from database version 14.17
-- Dumped by pg_dump version 14.17

-- Started on 2025-04-23 22:02:20

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

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 3362 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 214 (class 1259 OID 16430)
-- Name: departamentos; Type: TABLE; Schema: public; Owner: administrador
--

CREATE TABLE public.departamentos (
    id integer NOT NULL,
    nombre character varying(100),
    descripcion text
);


ALTER TABLE public.departamentos OWNER TO administrador;

--
-- TOC entry 213 (class 1259 OID 16429)
-- Name: departamentos_id_seq; Type: SEQUENCE; Schema: public; Owner: administrador
--

CREATE SEQUENCE public.departamentos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.departamentos_id_seq OWNER TO administrador;

--
-- TOC entry 3363 (class 0 OID 0)
-- Dependencies: 213
-- Name: departamentos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: administrador
--

ALTER SEQUENCE public.departamentos_id_seq OWNED BY public.departamentos.id;


--
-- TOC entry 216 (class 1259 OID 16469)
-- Name: estados; Type: TABLE; Schema: public; Owner: administrador
--

CREATE TABLE public.estados (
    id integer NOT NULL,
    nombre character varying(50),
    descripcion text,
    es_final boolean
);


ALTER TABLE public.estados OWNER TO administrador;

--
-- TOC entry 215 (class 1259 OID 16468)
-- Name: estados_id_seq; Type: SEQUENCE; Schema: public; Owner: administrador
--

CREATE SEQUENCE public.estados_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.estados_id_seq OWNER TO administrador;

--
-- TOC entry 3364 (class 0 OID 0)
-- Dependencies: 215
-- Name: estados_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: administrador
--

ALTER SEQUENCE public.estados_id_seq OWNED BY public.estados.id;


--
-- TOC entry 210 (class 1259 OID 16407)
-- Name: roles; Type: TABLE; Schema: public; Owner: administrador
--

CREATE TABLE public.roles (
    id integer NOT NULL,
    nombre character varying(50) NOT NULL
);


ALTER TABLE public.roles OWNER TO administrador;

--
-- TOC entry 209 (class 1259 OID 16406)
-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: administrador
--

CREATE SEQUENCE public.roles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roles_id_seq OWNER TO administrador;

--
-- TOC entry 3365 (class 0 OID 0)
-- Dependencies: 209
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: administrador
--

ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;


--
-- TOC entry 218 (class 1259 OID 16478)
-- Name: tickets; Type: TABLE; Schema: public; Owner: administrador
--

CREATE TABLE public.tickets (
    id integer NOT NULL,
    titulo character varying(100),
    descripcion text,
    prioridad character varying(20),
    estado_id integer,
    creador_id integer,
    tecnico_id integer,
    departamento_id integer,
    fecha_creacion timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE public.tickets OWNER TO administrador;

--
-- TOC entry 217 (class 1259 OID 16477)
-- Name: tickets_id_seq; Type: SEQUENCE; Schema: public; Owner: administrador
--

CREATE SEQUENCE public.tickets_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tickets_id_seq OWNER TO administrador;

--
-- TOC entry 3366 (class 0 OID 0)
-- Dependencies: 217
-- Name: tickets_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: administrador
--

ALTER SEQUENCE public.tickets_id_seq OWNED BY public.tickets.id;


--
-- TOC entry 212 (class 1259 OID 16415)
-- Name: usuarios; Type: TABLE; Schema: public; Owner: administrador
--

CREATE TABLE public.usuarios (
    id integer NOT NULL,
    nombre character varying(100),
    email character varying(100),
    usuario character varying(50),
    contrasena character varying(100),
    rol_id integer,
    activo boolean DEFAULT true
);


ALTER TABLE public.usuarios OWNER TO administrador;

--
-- TOC entry 211 (class 1259 OID 16414)
-- Name: usuarios_id_seq; Type: SEQUENCE; Schema: public; Owner: administrador
--

CREATE SEQUENCE public.usuarios_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuarios_id_seq OWNER TO administrador;

--
-- TOC entry 3367 (class 0 OID 0)
-- Dependencies: 211
-- Name: usuarios_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: administrador
--

ALTER SEQUENCE public.usuarios_id_seq OWNED BY public.usuarios.id;


--
-- TOC entry 3187 (class 2604 OID 16433)
-- Name: departamentos id; Type: DEFAULT; Schema: public; Owner: administrador
--

ALTER TABLE ONLY public.departamentos ALTER COLUMN id SET DEFAULT nextval('public.departamentos_id_seq'::regclass);


--
-- TOC entry 3188 (class 2604 OID 16472)
-- Name: estados id; Type: DEFAULT; Schema: public; Owner: administrador
--

ALTER TABLE ONLY public.estados ALTER COLUMN id SET DEFAULT nextval('public.estados_id_seq'::regclass);


--
-- TOC entry 3184 (class 2604 OID 16410)
-- Name: roles id; Type: DEFAULT; Schema: public; Owner: administrador
--

ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);


--
-- TOC entry 3189 (class 2604 OID 16481)
-- Name: tickets id; Type: DEFAULT; Schema: public; Owner: administrador
--

ALTER TABLE ONLY public.tickets ALTER COLUMN id SET DEFAULT nextval('public.tickets_id_seq'::regclass);


--
-- TOC entry 3185 (class 2604 OID 16418)
-- Name: usuarios id; Type: DEFAULT; Schema: public; Owner: administrador
--

ALTER TABLE ONLY public.usuarios ALTER COLUMN id SET DEFAULT nextval('public.usuarios_id_seq'::regclass);


--
-- TOC entry 3352 (class 0 OID 16430)
-- Dependencies: 214
-- Data for Name: departamentos; Type: TABLE DATA; Schema: public; Owner: administrador
--

COPY public.departamentos (id, nombre, descripcion) FROM stdin;
\.


--
-- TOC entry 3354 (class 0 OID 16469)
-- Dependencies: 216
-- Data for Name: estados; Type: TABLE DATA; Schema: public; Owner: administrador
--

COPY public.estados (id, nombre, descripcion, es_final) FROM stdin;
\.


--
-- TOC entry 3348 (class 0 OID 16407)
-- Dependencies: 210
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: administrador
--

COPY public.roles (id, nombre) FROM stdin;
\.


--
-- TOC entry 3356 (class 0 OID 16478)
-- Dependencies: 218
-- Data for Name: tickets; Type: TABLE DATA; Schema: public; Owner: administrador
--

COPY public.tickets (id, titulo, descripcion, prioridad, estado_id, creador_id, tecnico_id, departamento_id, fecha_creacion) FROM stdin;
\.


--
-- TOC entry 3350 (class 0 OID 16415)
-- Dependencies: 212
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: administrador
--

COPY public.usuarios (id, nombre, email, usuario, contrasena, rol_id, activo) FROM stdin;
\.


--
-- TOC entry 3368 (class 0 OID 0)
-- Dependencies: 213
-- Name: departamentos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: administrador
--

SELECT pg_catalog.setval('public.departamentos_id_seq', 1, false);


--
-- TOC entry 3369 (class 0 OID 0)
-- Dependencies: 215
-- Name: estados_id_seq; Type: SEQUENCE SET; Schema: public; Owner: administrador
--

SELECT pg_catalog.setval('public.estados_id_seq', 1, false);


--
-- TOC entry 3370 (class 0 OID 0)
-- Dependencies: 209
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: administrador
--

SELECT pg_catalog.setval('public.roles_id_seq', 1, false);


--
-- TOC entry 3371 (class 0 OID 0)
-- Dependencies: 217
-- Name: tickets_id_seq; Type: SEQUENCE SET; Schema: public; Owner: administrador
--

SELECT pg_catalog.setval('public.tickets_id_seq', 1, false);


--
-- TOC entry 3372 (class 0 OID 0)
-- Dependencies: 211
-- Name: usuarios_id_seq; Type: SEQUENCE SET; Schema: public; Owner: administrador
--

SELECT pg_catalog.setval('public.usuarios_id_seq', 1, false);


--
-- TOC entry 3198 (class 2606 OID 16437)
-- Name: departamentos departamentos_pkey; Type: CONSTRAINT; Schema: public; Owner: administrador
--

ALTER TABLE ONLY public.departamentos
    ADD CONSTRAINT departamentos_pkey PRIMARY KEY (id);


--
-- TOC entry 3200 (class 2606 OID 16476)
-- Name: estados estados_pkey; Type: CONSTRAINT; Schema: public; Owner: administrador
--

ALTER TABLE ONLY public.estados
    ADD CONSTRAINT estados_pkey PRIMARY KEY (id);


--
-- TOC entry 3192 (class 2606 OID 16412)
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: administrador
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- TOC entry 3202 (class 2606 OID 16486)
-- Name: tickets tickets_pkey; Type: CONSTRAINT; Schema: public; Owner: administrador
--

ALTER TABLE ONLY public.tickets
    ADD CONSTRAINT tickets_pkey PRIMARY KEY (id);


--
-- TOC entry 3194 (class 2606 OID 16421)
-- Name: usuarios usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: administrador
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);


--
-- TOC entry 3196 (class 2606 OID 16423)
-- Name: usuarios usuarios_usuario_key; Type: CONSTRAINT; Schema: public; Owner: administrador
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_usuario_key UNIQUE (usuario);


--
-- TOC entry 3205 (class 2606 OID 16492)
-- Name: tickets tickets_creador_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: administrador
--

ALTER TABLE ONLY public.tickets
    ADD CONSTRAINT tickets_creador_id_fkey FOREIGN KEY (creador_id) REFERENCES public.usuarios(id);


--
-- TOC entry 3207 (class 2606 OID 16502)
-- Name: tickets tickets_departamento_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: administrador
--

ALTER TABLE ONLY public.tickets
    ADD CONSTRAINT tickets_departamento_id_fkey FOREIGN KEY (departamento_id) REFERENCES public.departamentos(id);


--
-- TOC entry 3204 (class 2606 OID 16487)
-- Name: tickets tickets_estado_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: administrador
--

ALTER TABLE ONLY public.tickets
    ADD CONSTRAINT tickets_estado_id_fkey FOREIGN KEY (estado_id) REFERENCES public.estados(id);


--
-- TOC entry 3206 (class 2606 OID 16497)
-- Name: tickets tickets_tecnico_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: administrador
--

ALTER TABLE ONLY public.tickets
    ADD CONSTRAINT tickets_tecnico_id_fkey FOREIGN KEY (tecnico_id) REFERENCES public.usuarios(id);


--
-- TOC entry 3203 (class 2606 OID 16424)
-- Name: usuarios usuarios_rol_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: administrador
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_rol_id_fkey FOREIGN KEY (rol_id) REFERENCES public.roles(id);


-- Completed on 2025-04-23 22:02:21

--
-- PostgreSQL database dump complete
--

