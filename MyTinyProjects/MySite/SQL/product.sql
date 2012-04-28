use mysite; 

create table product (
id int primary key auto_increment,
title varchar(255),
content text,
username varchar(45),
publishtime datetime
);

insert into product values (null, 'product 001', 'Product 001 detail.', 'admin', now() );
insert into product values (null, 'product 002', 'Product 002 detail.', 'admin', now() );











