--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: highscore; Type: TABLE; Schema: public; Owner: rickiecashwell
--

CREATE TABLE highscore (
    playerid integer NOT NULL,
    highscore integer,
    personname character varying(20) NOT NULL
);


ALTER TABLE highscore OWNER TO rickiecashwell;

--
-- Name: highscore_playerid_seq; Type: SEQUENCE; Schema: public; Owner: rickiecashwell
--

CREATE SEQUENCE highscore_playerid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE highscore_playerid_seq OWNER TO rickiecashwell;

--
-- Name: highscore_playerid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: rickiecashwell
--

ALTER SEQUENCE highscore_playerid_seq OWNED BY highscore.playerid;


--
-- Name: highscore playerid; Type: DEFAULT; Schema: public; Owner: rickiecashwell
--

ALTER TABLE ONLY highscore ALTER COLUMN playerid SET DEFAULT nextval('highscore_playerid_seq'::regclass);


--
-- Data for Name: highscore; Type: TABLE DATA; Schema: public; Owner: rickiecashwell
--

COPY highscore (playerid, highscore, personname) FROM stdin;
\.


--
-- Name: highscore_playerid_seq; Type: SEQUENCE SET; Schema: public; Owner: rickiecashwell
--

SELECT pg_catalog.setval('highscore_playerid_seq', 1, false);


--
-- Name: highscore highscore_pkey; Type: CONSTRAINT; Schema: public; Owner: rickiecashwell
--

ALTER TABLE ONLY highscore
    ADD CONSTRAINT highscore_pkey PRIMARY KEY (playerid);


--
-- PostgreSQL database dump complete
--

