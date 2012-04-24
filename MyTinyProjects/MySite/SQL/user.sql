use mysite;

create table user (
username varchar(255) primary key,
password varchar(255),
email varchar(255)
);

insert into user values ('admin', 'admin', 'admin@test.org');