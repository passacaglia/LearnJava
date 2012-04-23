create database mysite; 

use mysite; 

create table news (
id int primary key auto_increment,
title varchar(255),
content text,
publishtime datetime );

insert into news values (null, '1.症状：消沉绝望；', '电影处方：《小鞋子》《肖申克的救赎》。', now() );
insert into news values (null, ' 2.症状：心理抑郁；', '电影处方：《谈谈情跳跳舞》。', now() );
insert into news values (null, '3.症状：自卑失落；', '电影处方：《阿甘正传》。', now() );
insert into news values (null, '4.症状：交流障碍；', '电影处方：《对她说》。', now() );
insert into news values (null, '5.症状：自私冷漠；', '电影处方：《爱·回家》', now() );
insert into news values (null, '20部练口语经典电影(1)', '1.阿甘正传,2.电子情书 3.居家男人,4.公主日记,5.逃跑的新娘, ', now() );
insert into news values (null, '20部练口语经典电影(2)', '6.新岳父大人,7.BJ单身日记,8.奔腾年代,9.蒙娜丽莎的微笑,10.甜心先生,', now() );
insert into news values (null, '20部练口语经典电影(3)', '11.热血强人,12.铁血教练,13.重建人生,14.海上钢琴师,15.大话王,', now() );
insert into news values (null, '20部练口语经典电影(4)', '16.单身插班生,17.风流奇男子,18.妙手情真,19.完美男人,20.大鱼。', now() );
insert into news values (null, '让你心情好起来的12部电影(1)', '《神探飞机头》《我盛大的同志婚礼》《幸运库克》《校园卧底》', now() );
insert into news values (null, '让你心情好起来的12部电影(2)', '《我的野蛮老师》《美女也烦恼》《疯狂的石头》《谋杀快乐》', now() );
insert into news values (null, '让你心情好起来的12部电影(3)', '《少儿不宜》《我为玛丽狂》《美国派》《偷天情缘》', now() );

insert into news values (null, 'Memento1', 'Another John G. to look for ?', now() );
insert into news values (null, 'Lord of the Rings', 'One Ring to rule them all, One Ring to find them,One Ring to bring them all and in the darkness bind them. ', now() );











