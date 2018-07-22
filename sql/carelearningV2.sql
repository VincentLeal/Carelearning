--
-- PostgreSQL database dump
--

-- Dumped from database version 10.3
-- Dumped by pg_dump version 10.3

-- Started on 2018-07-22 22:38:30

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2869 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 26010)
-- Name: exercise; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.exercise (
    id integer NOT NULL,
    question text NOT NULL,
    "goodAnswer" character varying NOT NULL,
    module text NOT NULL,
    type text NOT NULL,
    choice1 character varying NOT NULL,
    choice2 character varying NOT NULL,
    choice3 character varying NOT NULL
);


ALTER TABLE public.exercise OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 26008)
-- Name: exercise_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.exercise_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.exercise_id_seq OWNER TO postgres;

--
-- TOC entry 2870 (class 0 OID 0)
-- Dependencies: 196
-- Name: exercise_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.exercise_id_seq OWNED BY public.exercise.id;


--
-- TOC entry 207 (class 1259 OID 26203)
-- Name: image; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.image (
    id integer NOT NULL,
    label text NOT NULL,
    "exerciseId" integer,
    title text NOT NULL,
    url text NOT NULL
);


ALTER TABLE public.image OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 26201)
-- Name: image_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.image_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.image_id_seq OWNER TO postgres;

--
-- TOC entry 2871 (class 0 OID 0)
-- Dependencies: 206
-- Name: image_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.image_id_seq OWNED BY public.image.id;


--
-- TOC entry 201 (class 1259 OID 26032)
-- Name: lesson; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.lesson (
    id integer NOT NULL,
    module text NOT NULL,
    title text NOT NULL,
    content text NOT NULL
);


ALTER TABLE public.lesson OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 26030)
-- Name: lesson_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.lesson_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.lesson_id_seq OWNER TO postgres;

--
-- TOC entry 2872 (class 0 OID 0)
-- Dependencies: 200
-- Name: lesson_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.lesson_id_seq OWNED BY public.lesson.id;


--
-- TOC entry 199 (class 1259 OID 26021)
-- Name: result; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.result (
    id integer NOT NULL,
    date character varying NOT NULL,
    score integer NOT NULL,
    "exerciseId" integer,
    "studentId" integer
);


ALTER TABLE public.result OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 26019)
-- Name: result_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.result_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.result_id_seq OWNER TO postgres;

--
-- TOC entry 2873 (class 0 OID 0)
-- Dependencies: 198
-- Name: result_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.result_id_seq OWNED BY public.result.id;


--
-- TOC entry 203 (class 1259 OID 26043)
-- Name: revision_sheet; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.revision_sheet (
    id integer NOT NULL,
    favorite boolean NOT NULL,
    "studentId" integer,
    "lessonId" integer
);


ALTER TABLE public.revision_sheet OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 26041)
-- Name: revision_sheet_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.revision_sheet_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.revision_sheet_id_seq OWNER TO postgres;

--
-- TOC entry 2874 (class 0 OID 0)
-- Dependencies: 202
-- Name: revision_sheet_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.revision_sheet_id_seq OWNED BY public.revision_sheet.id;


--
-- TOC entry 205 (class 1259 OID 26167)
-- Name: student; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.student (
    id integer NOT NULL,
    firstname text NOT NULL,
    lastname text NOT NULL,
    password text NOT NULL,
    mail text NOT NULL,
    school text NOT NULL,
    register_date timestamp without time zone NOT NULL,
    role text DEFAULT 'user'::text NOT NULL
);


ALTER TABLE public.student OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 26165)
-- Name: student_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.student_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.student_id_seq OWNER TO postgres;

--
-- TOC entry 2875 (class 0 OID 0)
-- Dependencies: 204
-- Name: student_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.student_id_seq OWNED BY public.student.id;


--
-- TOC entry 2705 (class 2604 OID 26013)
-- Name: exercise id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exercise ALTER COLUMN id SET DEFAULT nextval('public.exercise_id_seq'::regclass);


--
-- TOC entry 2711 (class 2604 OID 26206)
-- Name: image id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image ALTER COLUMN id SET DEFAULT nextval('public.image_id_seq'::regclass);


--
-- TOC entry 2707 (class 2604 OID 26035)
-- Name: lesson id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lesson ALTER COLUMN id SET DEFAULT nextval('public.lesson_id_seq'::regclass);


--
-- TOC entry 2706 (class 2604 OID 26024)
-- Name: result id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.result ALTER COLUMN id SET DEFAULT nextval('public.result_id_seq'::regclass);


--
-- TOC entry 2708 (class 2604 OID 26046)
-- Name: revision_sheet id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.revision_sheet ALTER COLUMN id SET DEFAULT nextval('public.revision_sheet_id_seq'::regclass);


--
-- TOC entry 2710 (class 2604 OID 26170)
-- Name: student id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student ALTER COLUMN id SET DEFAULT nextval('public.student_id_seq'::regclass);


--
-- TOC entry 2851 (class 0 OID 26010)
-- Dependencies: 197
-- Data for Name: exercise; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.exercise (id, question, "goodAnswer", module, type, choice1, choice2, choice3) VALUES (1, 'Reconstituez le schema de l''appareil digestif', '/', 'Digestif', 'Schéma', '/', '/', '/');
INSERT INTO public.exercise (id, question, "goodAnswer", module, type, choice1, choice2, choice3) VALUES (2, 'Qu''est ce l''anorexie', 'Une perte d''appetit', 'Psychiatrie', 'QCM', 'Une surdité soudiane', 'Une addiction à une drogue', 'Une sensation de vertige');
INSERT INTO public.exercise (id, question, "goodAnswer", module, type, choice1, choice2, choice3) VALUES (3, 'Anomalie dans le développement d''un tissu ou d''un organe, se traduisant par des malformations: _ _ _ plasie', 'dys', 'Ortho-Traumato', 'Suffixe et préfixe', '/', '/', '/');
INSERT INTO public.exercise (id, question, "goodAnswer", module, type, choice1, choice2, choice3) VALUES (4, 'Le volume de la perfusion est de 1l et la prescription indique que la perfusion doit être administrée en 12h, quel sera le débit de la perfusion', '28', 'Calcul de dose', 'Calcul de dose', 'Le débit d''une perfusion se calcule en divisant le volume de la perfusion converti en gouttes par le temps prescrit en minute. Ici nous avons donc (1000x20)/(12x60)=20000/720=27,777… gouttes/minute soit par excès 28 gouttes/minute.', '/', '/');
INSERT INTO public.exercise (id, question, "goodAnswer", module, type, choice1, choice2, choice3) VALUES (5, 'Qu''est ce que l''angine de poitrine', 'une maladie coronarienne', 'Cardio-vasculaire', 'QCM', 'un gros rhum avec un mal de gorge', 'équivaut à un infarctus', 'une insuffisance cardiaque');
INSERT INTO public.exercise (id, question, "goodAnswer", module, type, choice1, choice2, choice3) VALUES (6, 'Inflammation des amygdales : amygdal_ _ _', 'ite', 'ORL-Dermato-Stomato', 'Suffixe et préfixe', '/', '/', '/');
INSERT INTO public.exercise (id, question, "goodAnswer", module, type, choice1, choice2, choice3) VALUES (7, 'Le médecin prescrit 1g d''antalgique en perfusion. Cet antalgique se présente sous la forme d''une poche de perfusion prête à l''emploi de 100ml contenant 1g de produit actif. Le produit doit être administré en 30 minutes', '67', 'Calcul de dose', 'Calcul de dose', 'La démarche est la même que précédemment : (100x20)/30=66,66… gouttes/minute soit par excès 67 gouttes/minute.', '/', '/');
INSERT INTO public.exercise (id, question, "goodAnswer", module, type, choice1, choice2, choice3) VALUES (8, 'Qu''est ce que la fibromyalgie', 'maladie avec douleur musculaire', 'Neurologie', 'QCM', 'un froissement musculaire dû à un effort', 'des bouffées de chaleurs', 'une envie impérieuse d''uriner');
INSERT INTO public.exercise (id, question, "goodAnswer", module, type, choice1, choice2, choice3) VALUES (9, 'Tissu utérins qui se développe en dehors de l''utérus : _ _ _ _ métriose', 'endo', 'Gynécologie', 'Suffixe et préfixe', '/', '/', '/');
INSERT INTO public.exercise (id, question, "goodAnswer", module, type, choice1, choice2, choice3) VALUES (10, 'Vous devez administrer 5mg d''un produit X à un patient. Le produit X se présente sous forme d''ampoule de 15ml contenant 10mg de produit X Combien devez vous préléver', '7.5', 'Calcul de dose', 'Calcul de dose', 'Vous devez réaliser un produit en croix : 15 ml ==> 10mg - ? ml ==> 5mg - (5x15)/10 = 7,5 ml. Donc 7,5 ml dans l’ampoule', '/', '/');
INSERT INTO public.exercise (id, question, "goodAnswer", module, type, choice1, choice2, choice3) VALUES (11, 'Reconstituez le schéma du cerveau', '/', 'Neurologie', 'Schéma', '/', '/', '/');
INSERT INTO public.exercise (id, question, "goodAnswer", module, type, choice1, choice2, choice3) VALUES (12, 'Reconstituez l''appreil génital féminin', '/', 'Gynécologie', 'Schéma', '/', '/', '/');


--
-- TOC entry 2861 (class 0 OID 26203)
-- Dependencies: 207
-- Data for Name: image; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.image (id, label, "exerciseId", title, url) VALUES (1, 'Cerveau', 11, 'Le cerveau', 'https://i.imgur.com/spEe5WB.png');
INSERT INTO public.image (id, label, "exerciseId", title, url) VALUES (2, 'L''appareil génital féminin', 12, 'L''appareil génital féminin', 'https://i.imgur.com/c38sUOB.png');
INSERT INTO public.image (id, label, "exerciseId", title, url) VALUES (3, 'estomac', 1, 'L''appareil digestif', 'https://i.imgur.com/IoYGKT9.png');
INSERT INTO public.image (id, label, "exerciseId", title, url) VALUES (4, 'foie', 1, 'L''appareil digestif', 'https://i.imgur.com/TJEPnOE.png');
INSERT INTO public.image (id, label, "exerciseId", title, url) VALUES (5, 'gros intestin', 1, 'L''appareil digestif', 'https://i.imgur.com/mGiUhsd.png');
INSERT INTO public.image (id, label, "exerciseId", title, url) VALUES (6, 'intestin grêle', 1, 'L''appareil digestif', 'https://i.imgur.com/AnxPqtr.png');


--
-- TOC entry 2855 (class 0 OID 26032)
-- Dependencies: 201
-- Data for Name: lesson; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.lesson (id, module, title, content) VALUES (1, 'Psychiatrie', 'La schizophrénie', '"La schizophrénie est un trouble mental sévère et chronique appartenant à la classe des troubles psychotiques. Ce trouble apparaît généralement au début de l''''âge adulte (entre environ 15 et 30 ans). La recherche scientifique trouve une prévalence de 0');
INSERT INTO public.lesson (id, module, title, content) VALUES (2, 'Infectieux', 'Le paludisme', '"Le paludisme ou la malaria est une maladie infectieuse due à un parasite du genre Plasmodium');
INSERT INTO public.lesson (id, module, title, content) VALUES (3, 'Pneumologie', 'La mucoviscidose', '"La mucoviscidose (pour « maladie des mucus visqueux » en français)5 ou fibrose kystique (en anglais : cystic fibrosis');
INSERT INTO public.lesson (id, module, title, content) VALUES (4, 'Cardio-vasculaire', 'L''insuffisance cardiaque', '"L’insuffisance cardiaque (IC) ou défaillance cardiaque correspond à un état dans lequel une anomalie de la fonction cardiaque est responsable de l''''incapacité du myocarde à assurer un débit cardiaque suffisant pour couvrir les besoins énergétiques de l''''organisme.Cette défaillance peut être le reflet d''''une anomalie de la contraction du muscle cardiaque ventriculaire (dysfonction systolique) ou de remplissage (on parle alors de dysfonction diastolique)');
INSERT INTO public.lesson (id, module, title, content) VALUES (5, 'Ophtlamo', 'La cataracte', '"La cataracte est l''opacification partielle ou totale du cristallin');
INSERT INTO public.lesson (id, module, title, content) VALUES (6, 'Pneumologie', 'BPCO', '"La bronchopneumopathie chronique obstructive');
INSERT INTO public.lesson (id, module, title, content) VALUES (7, 'Urologie', 'Insuffisane rénale', '"Chaque minute');
INSERT INTO public.lesson (id, module, title, content) VALUES (8, 'Infectieux et VIH', 'Streptocoques', '"Les infections à streptocoques A (Streptococcus pyogenes) et B  (Streptococcus agalactiae) sont fréquentes. Souvent bénignes (infections non invasives)');
INSERT INTO public.lesson (id, module, title, content) VALUES (9, 'Pédiatrie', 'Bronchiolite', '"Une bronchiolite est une infection aiguë des voies aériennes inférieures d''origine virale');


--
-- TOC entry 2853 (class 0 OID 26021)
-- Dependencies: 199
-- Data for Name: result; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.result (id, date, score, "exerciseId", "studentId") VALUES (2, '23/07/2018', 0, 6, 20);
INSERT INTO public.result (id, date, score, "exerciseId", "studentId") VALUES (3, '10/02/2012', 1, 8, 20);
INSERT INTO public.result (id, date, score, "exerciseId", "studentId") VALUES (4, '17/09/2013', 1, 9, 20);
INSERT INTO public.result (id, date, score, "exerciseId", "studentId") VALUES (5, '14/09/2013', 1, 10, 20);
INSERT INTO public.result (id, date, score, "exerciseId", "studentId") VALUES (6, '11/10/2015', 0, 1, 23);
INSERT INTO public.result (id, date, score, "exerciseId", "studentId") VALUES (7, '10/10/2015', 0, 8, 23);
INSERT INTO public.result (id, date, score, "exerciseId", "studentId") VALUES (8, '10/10/2013', 1, 3, 23);
INSERT INTO public.result (id, date, score, "exerciseId", "studentId") VALUES (9, '19/10/2073', 1, 1, 24);
INSERT INTO public.result (id, date, score, "exerciseId", "studentId") VALUES (10, '23/09/2016', 0, 5, 24);
INSERT INTO public.result (id, date, score, "exerciseId", "studentId") VALUES (11, '26/11/2018', 0, 2, 22);
INSERT INTO public.result (id, date, score, "exerciseId", "studentId") VALUES (12, '30/12/2017', 1, 6, 22);
INSERT INTO public.result (id, date, score, "exerciseId", "studentId") VALUES (13, '23/03/2017', 1, 3, 21);
INSERT INTO public.result (id, date, score, "exerciseId", "studentId") VALUES (14, '17/01/2017', 0, 1, 21);
INSERT INTO public.result (id, date, score, "exerciseId", "studentId") VALUES (15, '12/07/2017', 0, 1, 21);
INSERT INTO public.result (id, date, score, "exerciseId", "studentId") VALUES (1, '21/07/2018', 1, 1, 20);


--
-- TOC entry 2857 (class 0 OID 26043)
-- Dependencies: 203
-- Data for Name: revision_sheet; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2859 (class 0 OID 26167)
-- Dependencies: 205
-- Data for Name: student; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.student (id, firstname, lastname, password, mail, school, register_date, role) VALUES (1, 'Lucile', 'S', '$2a$10$.IliVXoKF5V.Nb0ImYLKL.CDM1yTG9sEGz9ewfgZStVvwSLKUDmw6', 'lukiletest@yopmail.com', 'ESGI', '2011-08-12 22:17:46.384', 'admin');
INSERT INTO public.student (id, firstname, lastname, password, mail, school, register_date, role) VALUES (18, 'Vincent', 'Leal', '$2a$10$BLNnZZa5LZklkrrY8uq5PO69JLLk3flqyyrrwb5WX8OqSfaavm5Zy', 'leal93190@gmail.com', 'ESGI', '2018-07-22 20:37:30.756', 'admin');
INSERT INTO public.student (id, firstname, lastname, password, mail, school, register_date, role) VALUES (19, 'Ben', 'Masmoud', '$2a$10$CPr0upEYJ69T12IyVdo4JOhR0OL2vwmzrSCJVIdLt9cPlDm2Me0gW', 'benben@gmail.com', 'ESGI', '2018-07-22 20:38:04.925', 'admin');
INSERT INTO public.student (id, firstname, lastname, password, mail, school, register_date, role) VALUES (20, 'Frédéric', 'Sananes', '$2a$10$vCX7dKxOX7IZB5/9HMhex.JWq76fQ3kZ5LmCJcuAu9L4/bx8v8h8i', 'fsesgi@yopmail.com', 'ESGI', '2018-07-22 20:39:13.553', 'user');
INSERT INTO public.student (id, firstname, lastname, password, mail, school, register_date, role) VALUES (21, 'Walter ', 'White', '$2a$10$klgFngd6IJinIjJgtG2ESuSWBRZMAPHZ9YrQxr.uKNuaLOy1shYs6', 'ww@yopmail.com', 'ESGI', '2018-07-22 20:39:57.838', 'user');
INSERT INTO public.student (id, firstname, lastname, password, mail, school, register_date, role) VALUES (22, 'Cersei', 'Lannister', '$2a$10$Tu12S19PITvqjKulWuFxpeJgBlRrlxOccVTeWUT9hlQdtlbtPkkX6', 'cl@yopmail.com', 'ESGI', '2018-07-22 20:40:14.459', 'user');
INSERT INTO public.student (id, firstname, lastname, password, mail, school, register_date, role) VALUES (23, 'Daryl', 'Dixon', '$2a$10$En2DQaiGXWCaHsDtVhVFpe/Y9UzY8uWdQZ3OafvE33B3dyyOGoqc2', 'dd@yopmail.com', 'ESGI', '2018-07-22 20:40:28.105', 'user');
INSERT INTO public.student (id, firstname, lastname, password, mail, school, register_date, role) VALUES (24, 'Dark', 'Vador', '$2a$10$UQya9I/VJ1xpNTkXeUcASuZN8Q.FXyAqVCeouYZ4cwvac8cWNATtm', 'dv@yopmail.com', 'ESGI', '2018-07-22 20:40:42.969', 'user');
INSERT INTO public.student (id, firstname, lastname, password, mail, school, register_date, role) VALUES (25, 'user', 'user', '$2a$10$Z0nxsaX/nW4y9GETbTOkZOeEIxkJ6JnyisZi5yPjV.Ve8iU09jPzK', 'user@yopmail.com', 'ESGI', '2018-07-22 22:23:38.615', 'user');


--
-- TOC entry 2876 (class 0 OID 0)
-- Dependencies: 196
-- Name: exercise_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.exercise_id_seq', 1, false);


--
-- TOC entry 2877 (class 0 OID 0)
-- Dependencies: 206
-- Name: image_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.image_id_seq', 1, false);


--
-- TOC entry 2878 (class 0 OID 0)
-- Dependencies: 200
-- Name: lesson_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.lesson_id_seq', 9, true);


--
-- TOC entry 2879 (class 0 OID 0)
-- Dependencies: 198
-- Name: result_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.result_id_seq', 1, false);


--
-- TOC entry 2880 (class 0 OID 0)
-- Dependencies: 202
-- Name: revision_sheet_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.revision_sheet_id_seq', 1, false);


--
-- TOC entry 2881 (class 0 OID 0)
-- Dependencies: 204
-- Name: student_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.student_id_seq', 25, true);


--
-- TOC entry 2713 (class 2606 OID 26018)
-- Name: exercise exercise_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exercise
    ADD CONSTRAINT exercise_pkey PRIMARY KEY (id);


--
-- TOC entry 2723 (class 2606 OID 26211)
-- Name: image image_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image
    ADD CONSTRAINT image_pkey PRIMARY KEY (id);


--
-- TOC entry 2717 (class 2606 OID 26040)
-- Name: lesson lesson_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lesson
    ADD CONSTRAINT lesson_pkey PRIMARY KEY (id);


--
-- TOC entry 2715 (class 2606 OID 26029)
-- Name: result result_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.result
    ADD CONSTRAINT result_pkey PRIMARY KEY (id);


--
-- TOC entry 2719 (class 2606 OID 26048)
-- Name: revision_sheet revision_sheet_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.revision_sheet
    ADD CONSTRAINT revision_sheet_pkey PRIMARY KEY (id);


--
-- TOC entry 2721 (class 2606 OID 26175)
-- Name: student student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_pkey PRIMARY KEY (id);


--
-- TOC entry 2725 (class 2606 OID 26176)
-- Name: result fk_0fc4ec97d21deeba52ab2f8ba72; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.result
    ADD CONSTRAINT fk_0fc4ec97d21deeba52ab2f8ba72 FOREIGN KEY ("studentId") REFERENCES public.student(id);


--
-- TOC entry 2726 (class 2606 OID 26075)
-- Name: revision_sheet fk_30461366a6778b9e00b6cebde35; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.revision_sheet
    ADD CONSTRAINT fk_30461366a6778b9e00b6cebde35 FOREIGN KEY ("lessonId") REFERENCES public.lesson(id);


--
-- TOC entry 2727 (class 2606 OID 26181)
-- Name: revision_sheet fk_dd8fa8650d01eec08643564ec4c; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.revision_sheet
    ADD CONSTRAINT fk_dd8fa8650d01eec08643564ec4c FOREIGN KEY ("studentId") REFERENCES public.student(id);


--
-- TOC entry 2728 (class 2606 OID 26213)
-- Name: image fk_f0d305ae8dd00b1ef3f68c540b2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image
    ADD CONSTRAINT fk_f0d305ae8dd00b1ef3f68c540b2 FOREIGN KEY ("exerciseId") REFERENCES public.exercise(id);


--
-- TOC entry 2724 (class 2606 OID 26060)
-- Name: result fk_f940ba3897eb69092738e361f51; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.result
    ADD CONSTRAINT fk_f940ba3897eb69092738e361f51 FOREIGN KEY ("exerciseId") REFERENCES public.exercise(id);


-- Completed on 2018-07-22 22:38:30

--
-- PostgreSQL database dump complete
--

