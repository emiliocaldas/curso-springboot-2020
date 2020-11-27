CREATE TABLE public.usuario
(
    id serial,
    usuario character varying(15) NOT NULL,
    nombres character varying(20) NOT NULL,
    clave text NOT NULL,
    estado character varying(15),
    CONSTRAINT usuario_pkey PRIMARY KEY (id),
    CONSTRAINT usuario_uq_usuario UNIQUE (usuario)
)

TABLESPACE pg_default;

ALTER TABLE public.usuario
    OWNER to postgres;
    
INSERT INTO public.usuario(usuario, nombres, clave, estado) VALUES ('juanpablo', 'Juan Pablo Molina', '123', 'ACTIVO');
INSERT INTO public.usuario(usuario, nombres, clave, estado) VALUES ('rafael', 'Rafael Simancas', '123', 'ACTIVO');
INSERT INTO public.usuario(usuario, nombres, clave, estado) VALUES ('pablo', 'Pablo Rodriguez', '123', 'ACTIVO');
INSERT INTO public.usuario(usuario, nombres, clave, estado) VALUES ('emilio', 'Emilio Caldas', '123', 'ACTIVO');
INSERT INTO public.usuario(usuario, nombres, clave, estado) VALUES ('augusto', 'Augusto Muñoz', '123', 'ACTIVO');
INSERT INTO public.usuario(usuario, nombres, clave, estado) VALUES ('yenuri', 'Yenuri Córdova', '123', 'ACTIVO');
