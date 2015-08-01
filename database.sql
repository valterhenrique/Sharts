--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.4
-- Dumped by pg_dump version 9.4.4
-- Started on 2015-08-01 11:35:35

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 176 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2011 (class 0 OID 0)
-- Dependencies: 176
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 172 (class 1259 OID 16459)
-- Name: pie_chart; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE pie_chart (
    id integer NOT NULL,
    country character varying,
    weight double precision
);


ALTER TABLE pie_chart OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 16465)
-- Name: pie_chart_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE pie_chart_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE pie_chart_id_seq OWNER TO postgres;

--
-- TOC entry 2012 (class 0 OID 0)
-- Dependencies: 173
-- Name: pie_chart_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE pie_chart_id_seq OWNED BY pie_chart.id;


--
-- TOC entry 174 (class 1259 OID 16467)
-- Name: ring_chart; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ring_chart (
    id integer NOT NULL,
    date date,
    security character varying,
    weighting double precision
);


ALTER TABLE ring_chart OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 16473)
-- Name: ring_chart_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ring_chart_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ring_chart_id_seq OWNER TO postgres;

--
-- TOC entry 2013 (class 0 OID 0)
-- Dependencies: 175
-- Name: ring_chart_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ring_chart_id_seq OWNED BY ring_chart.id;


--
-- TOC entry 1889 (class 2604 OID 16475)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pie_chart ALTER COLUMN id SET DEFAULT nextval('pie_chart_id_seq'::regclass);


--
-- TOC entry 1890 (class 2604 OID 16476)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ring_chart ALTER COLUMN id SET DEFAULT nextval('ring_chart_id_seq'::regclass);


--
-- TOC entry 2000 (class 0 OID 16459)
-- Dependencies: 172
-- Data for Name: pie_chart; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY pie_chart (id, country, weight) FROM stdin;
\.


--
-- TOC entry 2014 (class 0 OID 0)
-- Dependencies: 173
-- Name: pie_chart_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('pie_chart_id_seq', 1097, true);


--
-- TOC entry 2002 (class 0 OID 16467)
-- Dependencies: 174
-- Data for Name: ring_chart; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY ring_chart (id, date, security, weighting) FROM stdin;
\.


--
-- TOC entry 2015 (class 0 OID 0)
-- Dependencies: 175
-- Name: ring_chart_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ring_chart_id_seq', 800, true);


--
-- TOC entry 2010 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-08-01 11:35:35

--
-- PostgreSQL database dump complete
--

