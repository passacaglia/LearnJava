create database mysite; 

use mysite; 

create table news
( 
id int primary key auto_increment, 
topic varchar(255),
content text,
publishtime datatime,
publishuser varchar(50),
hits int,
categoryid int, 
picture varchar(100) ); 

create table news_category
(
id int primary key auto_increment,
name varchar(20),
master varchar(20)
);

create table news_master
(
id int primary key auto_increment,
username varchar(20),
userpwd varchar(20),
total int,
categoryid int,
loginnum int,
registertime datetime
);


















