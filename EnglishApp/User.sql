create database UserInfor
use UserInfor
go

create table userdb(
	userName varchar(20) primary key,
	password varchar(20) not null
)

insert into userdb(userName, password)
values('kien','123456')

drop table UserInfor