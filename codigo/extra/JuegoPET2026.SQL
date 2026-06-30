DROP SCHEMA if EXISTS juego_pet_2026;

CREATE SCHEMA if not exists juego_pet_2026;

use juego_pet_2026;

create table usuario (
    id INT UNIQUE NOT NULL auto_increment PRIMARY KEY,
    nombre VARCHAR(20) UNIQUE NOT NULL
);

CREATE Table mensajes (
    id int unique not null AUTO_INCREMENT PRIMARY key,
    mensaje varchar(150) not NULL,
    enviado TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_id int NOT NULL
);

alter TABLE mensajes
add CONSTRAINT fk_usuario_envia_mensajes Foreign Key (usuario_id) REFERENCES usuario (id) on UPDATE CASCADE on DELETE CASCADE;

show tables;