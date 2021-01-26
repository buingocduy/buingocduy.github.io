Create database QLXE
go
use QLXE
go

Create table taikhoan
(Username varchar(100),Password varchar(100),HoTen nvarchar(50),NgaySinh datetime,Email varchar(50),Phone varchar(50),NgayBatDau datetime, primary key(username))
go 

insert into taikhoan values ('DUY','123','buingocduy',6/6/1999,'buingocduy@gmail.com',0904596812,26/12/2019)
insert into taikhoan values ('admin','123','admin',6/6/1999,'admin@gmail.com',090999999,09/09/2009)
go

select * from taikhoan
