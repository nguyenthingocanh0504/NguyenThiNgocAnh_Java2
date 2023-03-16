create database quan_ly_san_pham;

use quan_ly_san_pham;

create table products(
	id int primary key auto_increment,
    product_name varchar(30) not null,
    product_price int check (product_price>0),
    product_size varchar(2),
    product_color varchar(20),
    brand_id int,
    constraint FK_Products_Brands foreign key (brand_id) references brands(id));

create table brands(
	id int primary key auto_increment,
    brand_name varchar(40) not null,
    brand_address varchar(100));
    
select*from products;