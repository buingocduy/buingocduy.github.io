create database QLUSER
go
Use QLUSER
go

create table taikhoan (Tenuser Nvarchar(100),Matkhau varchar(100),Duongdan varchar(100),Quyen int, primary key (Tenuser))

select * from taikhoan where Quyen = 1

insert into taikhoan (Tenuser,Matkhau,Duongdan,Quyen) values ('DUY','123','C/:',1)