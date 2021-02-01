Create database QLXE
go
use QLXE
go

Create table taikhoan
(Username varchar(100),
	Password varchar(100),
	HoTen nvarchar(50),
	NgaySinh datetime,
	Email varchar(50),
	Phone varchar(50),
	NgayBatDau datetime, 
	primary key(username))
go 

Create table loaixe
(Maloai varchar(10),
	Tenloai nvarchar(100),
	primary key(MaLoai))
go

Create table nhacungcap
(MaNCC varchar(10), 
	TenNCC nvarchar(100), 
	Diachi nvarchar(200), 
	Email varchar(50), 
	SDT varchar(20), 
	primary key(MaNCC))
go

Create table khachhang
(MaKH int IDENTITY(1,1) NOT NULL,
	TenKH nvarchar(100) NOT NULL,
	DiaChi nvarchar(100) NULL,
	Email varchar(50) NULL,
	Phone varchar(50) NULL,
	Primary key(MaKH))
go

CREATE TABLE sanpham(
	MaSP varchar (10) NOT NULL,
	TenSP nvarchar (100) NOT NULL,	
	Maloai varchar(10) NOT NULL,
	MaNCC varchar(10) NOT NULL,
	NamSanXuat varchar(10) NOT NULL,
	Primary key(MaSP))
go

alter table sanpham
add constraint FK_sp_ncc foreign key(MaNCC) references nhacungcap(MaNCC)
alter table sanpham
add constraint FK_sp_loai foreign key(Maloai) references loaixe(Maloai)
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

/*Khách hàng*/
insert into khachhang values (N'Bùi Ngọc Duy',N'439B/4 Hậu Giang P11, Q6, TP.HCM','buingocduy1999@gmail.com','0904596810')
go

/*Sản phẩm*/
insert into sanpham values ('WINX','WINNER X','XCT','HONDA','2020')


select * from taikhoan
select * from loaixe
select * from nhacungcap
select * from khachhang
select * from sanpham

go

delete from loaixe where Maloai = 'XM'
