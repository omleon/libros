CREATE TABLE IF NOT EXISTS usuario (
    id serial,
    nombre VARCHAR(45) NOT NULL,
    comentarios VARCHAR(45) NULL,
    crear VARCHAR(45) NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS post (
    id serial,
    titulo VARCHAR(45) NOT NULL,
    autor VARCHAR(45) NULL,
    fecha VARCHAR(45) NULL,
    usuario_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (usuario_id) REFERENCES usuario (id)
);


CREATE TABLE IF NOT EXISTS comentario (
    id serial,
    fechaPublicacion VARCHAR(45) NOT NULL,
    caracteres VARCHAR(45) NULL,
    post_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (post_id) REFERENCES post (id)
);


