--
-- PostgreSQL database dump
--

-- Dumped from database version 13.6
-- Dumped by pg_dump version 13.6

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
-- Name: admin; Type: TABLE; Schema: public; Owner: vitamin
--

CREATE TABLE public.admin (
    id character varying NOT NULL,
    name character varying NOT NULL
);


ALTER TABLE public.admin OWNER TO vitamin;

--
-- Name: course; Type: TABLE; Schema: public; Owner: vitamin
--

CREATE TABLE public.course (
    id character varying NOT NULL,
    name character varying NOT NULL,
    teacher_id character varying NOT NULL,
    total integer NOT NULL,
    remain integer NOT NULL
);


ALTER TABLE public.course OWNER TO vitamin;

--
-- Name: operation; Type: TABLE; Schema: public; Owner: vitamin
--

CREATE TABLE public.operation (
    id character varying NOT NULL,
    method character(6) NOT NULL,
    pattern character varying NOT NULL,
    comment character varying NOT NULL
);


ALTER TABLE public.operation OWNER TO vitamin;

--
-- Name: role; Type: TABLE; Schema: public; Owner: vitamin
--

CREATE TABLE public.role (
    id character varying NOT NULL,
    name character varying
);


ALTER TABLE public.role OWNER TO vitamin;

--
-- Name: role_operation; Type: TABLE; Schema: public; Owner: vitamin
--

CREATE TABLE public.role_operation (
    role_id character varying NOT NULL,
    operation_id character varying NOT NULL
);


ALTER TABLE public.role_operation OWNER TO vitamin;

--
-- Name: selection; Type: TABLE; Schema: public; Owner: vitamin
--

CREATE TABLE public.selection (
    id character varying NOT NULL,
    student_id character varying NOT NULL,
    course_id character varying NOT NULL,
    score integer DEFAULT 0,
    create_time timestamp without time zone NOT NULL
);


ALTER TABLE public.selection OWNER TO vitamin;

--
-- Name: status; Type: TABLE; Schema: public; Owner: vitamin
--

CREATE TABLE public.status (
    id character varying NOT NULL,
    name character varying NOT NULL,
    comment character varying
);


ALTER TABLE public.status OWNER TO vitamin;

--
-- Name: student; Type: TABLE; Schema: public; Owner: vitamin
--

CREATE TABLE public.student (
    id character varying NOT NULL,
    name character varying NOT NULL
);


ALTER TABLE public.student OWNER TO vitamin;

--
-- Name: teacher; Type: TABLE; Schema: public; Owner: vitamin
--

CREATE TABLE public.teacher (
    id character varying NOT NULL,
    name character varying NOT NULL
);


ALTER TABLE public.teacher OWNER TO vitamin;

--
-- Name: user; Type: TABLE; Schema: public; Owner: vitamin
--

CREATE TABLE public."user" (
    id character varying NOT NULL,
    password character varying NOT NULL,
    role_id character varying NOT NULL
);


ALTER TABLE public."user" OWNER TO vitamin;

--
-- Name: vitamin_system; Type: TABLE; Schema: public; Owner: vitamin
--

CREATE TABLE public.vitamin_system (
    id character varying NOT NULL,
    status_id character varying NOT NULL
);


ALTER TABLE public.vitamin_system OWNER TO vitamin;

--
-- Data for Name: admin; Type: TABLE DATA; Schema: public; Owner: vitamin
--

COPY public.admin (id, name) FROM stdin;
a0000001	欧阳景辉
a0000002	欧阳华灿
\.


--
-- Data for Name: course; Type: TABLE DATA; Schema: public; Owner: vitamin
--

COPY public.course (id, name, teacher_id, total, remain) FROM stdin;
c001	数据结构	t0000001	100	100
\.


--
-- Data for Name: operation; Type: TABLE DATA; Schema: public; Owner: vitamin
--

COPY public.operation (id, method, pattern, comment) FROM stdin;
001	POST  	/login	登录
002	POST  	/logout	注销
003	GET   	/course	获取所有课程简略信息
004	GET   	/status	获取系统状态
1001	GET   	/student/info	获取学生信息
1002	GET   	/student/course/all	获取可选课程简略信息
1003	GET   	/student/selected	获取已选课程简略信息
1005	DELETE	/student/course/{id}	退课
1006	GET   	/student/score/{courseId}	查看成绩
2001	GET   	/teacher/info	获取教师信息
2002	GET   	/teacher/course	获取已添加课程简略信息
2003	POST  	/teacher/course	维护课程信息
2004	DELETE	/teacher/course/{id}	删除已添加课程
2005	POST  	/student/score	学生成绩评分
3001	GET   	/admin/info	获取管理员信息
3003	GET   	/admin/status	获取系统所有可能的状态
1004	POST  	/student/course	选课
3002	POST  	/admin/status	更改系统状态
\.


--
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: vitamin
--

COPY public.role (id, name) FROM stdin;
001	student
002	teacher
003	admin
\.


--
-- Data for Name: role_operation; Type: TABLE DATA; Schema: public; Owner: vitamin
--

COPY public.role_operation (role_id, operation_id) FROM stdin;
001	001
001	002
001	003
001	004
001	1001
001	1002
001	1003
001	1004
001	1005
001	1006
002	001
002	002
002	003
002	004
002	2001
002	2002
002	2003
002	2004
002	2005
003	001
003	002
003	003
003	004
003	3001
003	3002
003	3003
\.


--
-- Data for Name: selection; Type: TABLE DATA; Schema: public; Owner: vitamin
--

COPY public.selection (id, student_id, course_id, score, create_time) FROM stdin;
\.


--
-- Data for Name: status; Type: TABLE DATA; Schema: public; Owner: vitamin
--

COPY public.status (id, name, comment) FROM stdin;
1	BEFORE_SELECTION	未开始：教师可以更改课程信息，学生无法选课
2	SELECTING	选课期间：教师无法更改课程信息，学生可以选课
3	AFTER_SELECTION	选课结束：教师无法更改课程信息，学生无法选课
4	AFTER_TERM	学期结束：教师仅可以更改分数信息，学生无法选课
5	ARCHIVE	归档：教师无法更改课程信息，学生无法选课
\.


--
-- Data for Name: student; Type: TABLE DATA; Schema: public; Owner: vitamin
--

COPY public.student (id, name) FROM stdin;
s0000001	张宇荫
s0000002	卢高谊
s0000003	龙浩邈
s0000004	龙乐咏
s0000005	谢高澹
s0000006	袁永望
s0000007	何弘扬
s0000008	汪高格
s0000009	邵伟诚
s0000010	萧涵育
s0000011	汪高超
s0000012	曾兴业
s0000013	彭高洁
s0000014	郭俊民
s0000015	姚鸿羽
s0000016	徐祺祥
s0000017	蔡宏胜
s0000018	蔡明喆
s0000019	蒋弘益
s0000020	彭良骥
s0000021	孟俊良
s0000022	姜俊力
s0000023	林宏富
s0000024	韩建章
s0000025	龙俊智
s0000026	邓天元
s0000027	郝安澜
s0000028	高鹏举
s0000029	蒋博艺
s0000030	冯飞语
s0000031	顾飞星
s0000032	曹绍祺
s0000033	傅波鸿
s0000034	张雨星
s0000035	梁彭薄
s0000036	张正业
s0000037	郭朋兴
s0000038	乔康盛
s0000039	罗开诚
s0000040	许和泽
s0000041	范温纶
s0000042	傅文德
s0000043	尹俊弼
s0000044	蒋嘉祥
s0000045	刘玉宸
s0000046	郝鹏鲸
s0000047	朱明诚
s0000048	唐思淼
s0000049	程修洁
s0000050	秦斯伯
s0000051	侯元洲
s0000052	任高邈
s0000053	吴成济
s0000054	朱刚洁
s0000055	张雨石
s0000056	贺承安
s0000057	魏天干
s0000058	李风华
s0000059	韩承嗣
s0000060	许俊语
s0000061	黎文德
s0000062	潘向笛
s0000063	曹学海
s0000064	史元恺
s0000065	胡安翔
s0000066	高向笛
s0000067	郑雨石
s0000068	郝兴修
s0000069	白文曜
s0000070	王明煦
s0000071	乔学民
s0000072	潘永新
s0000073	徐开诚
s0000074	余鸿禧
s0000075	高坚壁
s0000076	邵经国
s0000077	白成业
s0000078	姜建德
s0000079	康弘义
s0000080	顾安平
s0000081	于敏智
s0000082	金建中
s0000083	阎兴庆
s0000084	宋锐智
s0000085	孟彭魄
s0000086	高兴庆
s0000087	李学民
s0000088	邱宏富
s0000089	曹经艺
s0000090	邓温纶
s0000091	徐永思
s0000092	钟俊材
s0000093	顾宏义
s0000094	朱宏阔
s0000095	邹嘉胜
s0000096	姜弘壮
s0000097	秦宏胜
s0000098	余元嘉
s0000099	史建安
s0000100	赖俊郎
\.


--
-- Data for Name: teacher; Type: TABLE DATA; Schema: public; Owner: vitamin
--

COPY public.teacher (id, name) FROM stdin;
t0000001	薛文惠
t0000002	易语雪
t0000003	丁桂枫
t0000004	潘梓涵
t0000005	郑奇文
t0000006	钟思淼
t0000007	汤可心
t0000008	苏笑蓝
t0000009	张晗雨
t0000010	漕璇子
\.


--
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: vitamin
--

COPY public."user" (id, password, role_id) FROM stdin;
a0000001	a0000001	003
a0000002	a0000002	003
t0000003	t0000003	002
t0000006	t0000006	002
t0000008	t0000008	002
t0000002	t0000002	002
t0000010	t0000010	002
t0000005	t0000005	002
t0000007	t0000007	002
t0000009	t0000009	002
t0000001	t0000001	002
t0000004	t0000004	002
s0000054	s0000054	001
s0000081	s0000081	001
s0000005	s0000005	001
s0000021	s0000021	001
s0000094	s0000094	001
s0000095	s0000095	001
s0000012	s0000012	001
s0000030	s0000030	001
s0000100	s0000100	001
s0000048	s0000048	001
s0000093	s0000093	001
s0000073	s0000073	001
s0000098	s0000098	001
s0000042	s0000042	001
s0000003	s0000003	001
s0000010	s0000010	001
s0000067	s0000067	001
s0000083	s0000083	001
s0000038	s0000038	001
s0000059	s0000059	001
s0000077	s0000077	001
s0000015	s0000015	001
s0000076	s0000076	001
s0000052	s0000052	001
s0000096	s0000096	001
s0000031	s0000031	001
s0000090	s0000090	001
s0000037	s0000037	001
s0000066	s0000066	001
s0000028	s0000028	001
s0000097	s0000097	001
s0000041	s0000041	001
s0000082	s0000082	001
s0000086	s0000086	001
s0000022	s0000022	001
s0000004	s0000004	001
s0000033	s0000033	001
s0000069	s0000069	001
s0000063	s0000063	001
s0000078	s0000078	001
s0000064	s0000064	001
s0000039	s0000039	001
s0000049	s0000049	001
s0000050	s0000050	001
s0000020	s0000020	001
s0000025	s0000025	001
s0000070	s0000070	001
s0000056	s0000056	001
s0000011	s0000011	001
s0000060	s0000060	001
s0000075	s0000075	001
s0000007	s0000007	001
s0000058	s0000058	001
s0000051	s0000051	001
s0000068	s0000068	001
s0000014	s0000014	001
s0000009	s0000009	001
s0000092	s0000092	001
s0000045	s0000045	001
s0000062	s0000062	001
s0000080	s0000080	001
s0000087	s0000087	001
s0000002	s0000002	001
s0000055	s0000055	001
s0000088	s0000088	001
s0000044	s0000044	001
s0000043	s0000043	001
s0000061	s0000061	001
s0000065	s0000065	001
s0000026	s0000026	001
s0000013	s0000013	001
s0000091	s0000091	001
s0000099	s0000099	001
s0000018	s0000018	001
s0000035	s0000035	001
s0000001	s0000001	001
s0000019	s0000019	001
s0000072	s0000072	001
s0000016	s0000016	001
s0000053	s0000053	001
s0000047	s0000047	001
s0000071	s0000071	001
s0000089	s0000089	001
s0000079	s0000079	001
s0000085	s0000085	001
s0000032	s0000032	001
s0000074	s0000074	001
s0000023	s0000023	001
s0000036	s0000036	001
s0000029	s0000029	001
s0000046	s0000046	001
s0000027	s0000027	001
s0000040	s0000040	001
s0000057	s0000057	001
s0000084	s0000084	001
s0000008	s0000008	001
s0000034	s0000034	001
s0000006	s0000006	001
s0000017	s0000017	001
s0000024	s0000024	001
\.


--
-- Data for Name: vitamin_system; Type: TABLE DATA; Schema: public; Owner: vitamin
--

COPY public.vitamin_system (id, status_id) FROM stdin;
1	1
\.


--
-- Name: admin admin_pk; Type: CONSTRAINT; Schema: public; Owner: vitamin
--

ALTER TABLE ONLY public.admin
    ADD CONSTRAINT admin_pk PRIMARY KEY (id);


--
-- Name: course course_pk; Type: CONSTRAINT; Schema: public; Owner: vitamin
--

ALTER TABLE ONLY public.course
    ADD CONSTRAINT course_pk PRIMARY KEY (id);


--
-- Name: role role_pk; Type: CONSTRAINT; Schema: public; Owner: vitamin
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pk PRIMARY KEY (id);


--
-- Name: selection selection_pk; Type: CONSTRAINT; Schema: public; Owner: vitamin
--

ALTER TABLE ONLY public.selection
    ADD CONSTRAINT selection_pk PRIMARY KEY (id);


--
-- Name: status status_pk; Type: CONSTRAINT; Schema: public; Owner: vitamin
--

ALTER TABLE ONLY public.status
    ADD CONSTRAINT status_pk PRIMARY KEY (id);


--
-- Name: student student_pk; Type: CONSTRAINT; Schema: public; Owner: vitamin
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_pk PRIMARY KEY (id);


--
-- Name: vitamin_system system_status_pk; Type: CONSTRAINT; Schema: public; Owner: vitamin
--

ALTER TABLE ONLY public.vitamin_system
    ADD CONSTRAINT system_status_pk PRIMARY KEY (id);


--
-- Name: teacher teacher_pk; Type: CONSTRAINT; Schema: public; Owner: vitamin
--

ALTER TABLE ONLY public.teacher
    ADD CONSTRAINT teacher_pk PRIMARY KEY (id);


--
-- Name: user user_pk; Type: CONSTRAINT; Schema: public; Owner: vitamin
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pk PRIMARY KEY (id);


--
-- Name: operation webresource_pk; Type: CONSTRAINT; Schema: public; Owner: vitamin
--

ALTER TABLE ONLY public.operation
    ADD CONSTRAINT webresource_pk PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

