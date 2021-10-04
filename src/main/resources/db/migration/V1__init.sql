create table usuarios(
id serial,
name varchar(50),
password varchar(100),
email varchar(50),
primary key(id));

create table wallet(
id serial,
name varchar(60),
value numeric(10,2),
primary key(id));

create table usuarios_wallet(
id serial,
wallet integer,
usuarios integer,
primary key(id),
foreign key(usuarios) references usuarios(id),
foreign key(wallet) references wallet(id));

create table wallet_items(
id serial,
wallet integer,
date date,
type varchar(2),
description varchar(500),
value numeric(10,2),
primary key(id),
foreign key(wallet) references wallet(id));