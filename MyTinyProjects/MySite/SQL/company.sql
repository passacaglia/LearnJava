use mysite; 

create table company (
id int primary key auto_increment,
title varchar(255),
content text,
username varchar(45),
publishtime datetime
);

insert into company values (null, 'about', 'Company info.', 'admin', now() );
insert into company values (null, 'contactus', 'Contact us.', 'admin', now() );











