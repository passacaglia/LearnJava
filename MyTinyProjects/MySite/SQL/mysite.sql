create database mysite; 

use mysite; 

create table news (
id int primary key auto_increment,
title varchar(255),
content text,
publishtime datetime );

insert into news values (null, 'news 001', 'news 001 content', now() );
insert into news values (null, '蚂蚁大战大象', '蚂蚁大战大象', now() );
insert into news values (null, '大象被打趴下了', '大象被打趴下了',now() );
insert into news values (null, '蚂蚁也不好过','蚂蚁也不好过', now() );
insert into news values (null, '瞎说', '瞎说', now() );
insert into news values (null, '没有瞎说', '没有瞎说', now());
insert into news values (null, '怎么可能', '怎么可能', now());
insert into news values (null, '怎么没有可能', '怎么没有可能', now());
insert into news values (null, '可能性是很大的', '可能性是很大的', now());
insert into news values (null, '大象进医院了', '大象进医院了', now());
insert into news values (null, '护士是蚂蚁', '护士是蚂蚁', now());



















