create database mysite; 

use mysite; 

create table news (
id int primary key auto_increment,
title varchar(255),
content text,
username varchar(45),
publishtime datetime
);

insert into news values (null, 'Memento1', 'Another John G. to look for ?', 'admin', now() );
insert into news values (null, 'Lord of the Rings', 'One Ring to rule them all, One Ring to find them,One Ring to bring them all and in the darkness bind them. ', 'admin', now() );











