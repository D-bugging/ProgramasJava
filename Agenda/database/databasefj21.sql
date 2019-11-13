show databases;

use fj21;

drop table contatos;

create table contatos(
	id bigint not null unique auto_increment,
    nome varchar(255) not null,
    email varchar(255) not null,
    endereco varchar(255) not null,
    dataNascimento date,
    primary key(id)
);

select * from contatos;