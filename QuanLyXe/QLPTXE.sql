Create database QLXE
go
use QLXE
go

Create table taikhoan
(Username varchar(100),Password varchar(100),HoTen nvarchar(50),NgaySinh datetime,Email varchar(50),Phone varchar(50),NgayBatDau datetime, primary key(username))
go 
Create table loaixe
(Maloai varchar(10),Tenloai nvarchar(100),primary key(MaLoai))
go
Create table nhacungcap
(MaNCC varchar(10), TenNCC nvarchar(100), Diachi nvarchar(200), Email varchar(50), SDT varchar(20), primary key(MaNCC))
go

/*Tài khoảng*/
insert into taikhoan values ('DUY','123','buingocduy',6/6/1999,'buingocduy@gmail.com',0904596812,26/12/2019)
insert into taikhoan values ('admin','123','admin',6/6/1999,'admin@gmail.com',090999999,09/09/2009)
go

/*Loại xe*/
insert into loaixe values ('XM',N'Xe Máy')
go

/*Nhà cung cấp*/
insert into nhacungcap values ('HONDA',N'Công ty HONDA Việt Nam',N'Tầng 8, Zen Plaza, 54-56 đường Nguyễn Trãi, quận 1, thành phố Hồ Chính Minh','cr@honda.com.vn','(84) 28-39256949')
go


select * from taikhoan
select * from loaixe
select * from nhacungcap
go

delete from loaixe where Maloai = 'XM'
