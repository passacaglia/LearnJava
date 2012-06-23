create database contacts;

create table contacts (
id int primary key auto_increment not null,
name char(45),
email char(45)
);

insert into contacts values (null, 'Jack', 'jack@rock.com');