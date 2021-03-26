Create database QLKH
go
use QLKH
go

--KHÁCH HÀNG
Create table khachhang
(STT int IDENTITY(1,1) NOT NULL,
	HOTEN nvarchar(100),
	NGAYGIOVAO varchar(100), 
	HINHANH varchar(500),
	primary key(STT))

go

insert into khachhang values (N'DUY','02/01/2021 05:21:22' , 'G:\BuiNgocDuy\WEBCAM\src\images\2021-36-27-04-36-03.jpg')

select * from khachhang where NGAYGIOVAO like '%02/01/2021%'