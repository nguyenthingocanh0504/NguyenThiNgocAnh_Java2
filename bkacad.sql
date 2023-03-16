create database bkacad;

use bkacad;

create table students(
	id varchar(10) primary key,
    full_name varchar(30),
    gender tinyint(1),
    date_of_birth varchar(20),
    address varchar(255),
    phone varchar(20),
    email varchar(255),
    GPA double);
    
insert into students values('1', 'Nguyen Thi Ngoc Anh',1,'05/04/2000','Bac Giang','097564636','anh@gmail.com',4.0);

select*from students;