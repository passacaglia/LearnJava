create database mysite; 

use mysite; 

create table news (
id int primary key auto_increment,
title varchar(255),
content text,
publishtime datetime );

insert into news values (null, 'news 001', 'news 001 content', now() );
insert into news values (null, '���ϴ�ս����', '���ϴ�ս����', now() );
insert into news values (null, '���󱻴�ſ����', '���󱻴�ſ����',now() );
insert into news values (null, '����Ҳ���ù�','����Ҳ���ù�', now() );
insert into news values (null, 'Ϲ˵', 'Ϲ˵', now() );
insert into news values (null, 'û��Ϲ˵', 'û��Ϲ˵', now());
insert into news values (null, '��ô����', '��ô����', now());
insert into news values (null, '��ôû�п���', '��ôû�п���', now());
insert into news values (null, '�������Ǻܴ��', '�������Ǻܴ��', now());
insert into news values (null, '�����ҽԺ��', '�����ҽԺ��', now());
insert into news values (null, '��ʿ������', '��ʿ������', now());



















