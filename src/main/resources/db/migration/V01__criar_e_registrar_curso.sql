
CREATE TABLE public.curso
(
    id bigserial NOT NULL,
    carga_horaria integer,
    nome character varying(255) COLLATE pg_catalog."default",
    nota_minima double precision,
    CONSTRAINT curso_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.curso
    OWNER to postgres;


INSERT INTO curso (nome, carga_horaria, nota_minima) VALUES ('Engenharia Civil', 10, 7.0);
INSERT INTO curso (nome, carga_horaria, nota_minima) VALUES ('Ciência da Computação', 10, 7.0);
INSERT INTO curso (nome, carga_horaria, nota_minima) VALUES ('Sistemas de Informação', 10, 7.0);
INSERT INTO curso (nome, carga_horaria, nota_minima) VALUES ('Análise e Desenvolvimento de Sistemas', 5, 7.0);
INSERT INTO curso (nome, carga_horaria, nota_minima) VALUES ('Gestão Hospitalar', 6, 6.0);
INSERT INTO curso (nome, carga_horaria, nota_minima) VALUES ('Licenciatura em Pedagogia', 4, 6.0);
INSERT INTO curso (nome, carga_horaria, nota_minima) VALUES ('Marketing', 4, 6.0);
INSERT INTO curso (nome, carga_horaria, nota_minima) VALUES ('Design de Games', 8, 7.0);
INSERT INTO curso (nome, carga_horaria, nota_minima) VALUES ('Serviços Judiciais', 4, 6.0);
INSERT INTO curso (nome, carga_horaria, nota_minima) VALUES ('Teologia', 8, 6.0);
INSERT INTO curso (nome, carga_horaria, nota_minima) VALUES ('Gestão do Agronegócio', 6, 6.0);
INSERT INTO curso (nome, carga_horaria, nota_minima) VALUES ('Ciências Econômicas', 8, 7.0);
INSERT INTO curso (nome, carga_horaria, nota_minima) VALUES ('Ciências Contábeis', 8, 7.0);
INSERT INTO curso (nome, carga_horaria, nota_minima) VALUES ('Secretariado Executivo', 6, 6.0);
INSERT INTO curso (nome, carga_horaria, nota_minima) VALUES ('Gestão da Qualidade', 8, 6.0);
INSERT INTO curso (nome, carga_horaria, nota_minima) VALUES ('Design Gráfico', 4, 6.0);
