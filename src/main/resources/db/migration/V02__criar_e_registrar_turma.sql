
CREATE TABLE public.turma
(
    id bigserial NOT NULL,
    numero_turma character varying(255) COLLATE pg_catalog."default",
    numero_vagas integer,
    data_inicio date,
    curso_id integer,
    CONSTRAINT turma_pkey PRIMARY KEY (id),
    FOREIGN KEY (curso_id)
        REFERENCES public.curso (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.turma
    OWNER to postgres;

    INSERT INTO turma (numero_turma, numero_vagas, data_inicio, curso_id) VALUES ('1A', 40, '2020-08-20', 1);
