create database formulario;

create table if not exists formulario.usuario(
usuario_id int not null auto_increment,           
nombre varchar(50) not null,
apellido varchar(50) not null,
telefono varchar(15) not null,
correo varchar(50) not null,
direccion varchar(200) not null,
primary key (usuario_id)
)engine= InnoDB default character set= utf8mb3;

select * from formulario.usuario;