
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

INSERT INTO curso (nome, carga_horaria, nota_minima) VALUES ('Arquitetura e Urbanismo', 9000, 7.0);
INSERT INTO curso (nome, carga_horaria, nota_minima) VALUES ('Ciência da Computação', 9000, 7.0);
INSERT INTO curso (nome, carga_horaria, nota_minima) VALUES ('Design', 4000, 7.0);
INSERT INTO curso (nome, carga_horaria, nota_minima) VALUES ('Farmácia', 8000, 7.0);
