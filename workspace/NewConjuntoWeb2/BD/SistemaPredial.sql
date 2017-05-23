drop database SistemaPredial;

create schema if not exists SistemaPredial;

use SistemaPredial;

create table if not exists Conjunto
(
	id_Conjunto int auto_increment not null,
    status_ocupado boolean not null,
    valor double not null,
    medida varchar(6) not null,
    tempo int not null,
    obs varchar(200) not null,
    PRIMARY KEY (id_Conjunto)
)ENGINE = InnoDB;


