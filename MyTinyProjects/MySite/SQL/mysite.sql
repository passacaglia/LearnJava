create database mysite; 

use mysite; 

create table news (
id int primary key auto_increment,
title varchar(255),
content text,
publishtime datetime );

insert into news values (null, '1.֢״������������', '��Ӱ��������СЬ�ӡ���Ф��˵ľ��꡷��', now() );
insert into news values (null, ' 2.֢״������������', '��Ӱ��������̸̸�������衷��', now() );
insert into news values (null, '3.֢״���Ա�ʧ�䣻', '��Ӱ��������������������', now() );
insert into news values (null, '4.֢״�������ϰ���', '��Ӱ������������˵����', now() );
insert into news values (null, '5.֢״����˽��Į��', '��Ӱ�������������ؼҡ�', now() );
insert into news values (null, '20�������ﾭ���Ӱ(1)', '1.��������,2.�������� 3.�Ӽ�����,4.�����ռ�,5.���ܵ�����, ', now() );
insert into news values (null, '20�������ﾭ���Ӱ(2)', '6.����������,7.BJ�����ռ�,8.�������,9.������ɯ��΢Ц,10.��������,', now() );
insert into news values (null, '20�������ﾭ���Ӱ(3)', '11.��Ѫǿ��,12.��Ѫ����,13.�ؽ�����,14.���ϸ���ʦ,15.����,', now() );
insert into news values (null, '20�������ﾭ���Ӱ(4)', '16.��������,17.����������,18.��������,19.��������,20.���㡣', now() );
insert into news values (null, '���������������12����Ӱ(1)', '����̽�ɻ�ͷ������ʢ���ͬ־���񡷡����˿�ˡ���У԰�Եס�', now() );
insert into news values (null, '���������������12����Ӱ(2)', '���ҵ�Ұ����ʦ������ŮҲ���ա�������ʯͷ����ıɱ���֡�', now() );
insert into news values (null, '���������������12����Ӱ(3)', '���ٶ����ˡ�����Ϊ�����񡷡������ɡ���͵����Ե��', now() );

insert into news values (null, 'Memento1', 'Another John G. to look for ?', now() );
insert into news values (null, 'Lord of the Rings', 'One Ring to rule them all, One Ring to find them,One Ring to bring them all and in the darkness bind them. ', now() );











