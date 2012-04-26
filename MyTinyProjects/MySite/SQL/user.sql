use mysite;

create table user (
id int primary key auto_increment,
username varchar(255),
password varchar(255),
email varchar(255)
);

insert into user values (null, 'admin', 'admin', 'admin@test.org');