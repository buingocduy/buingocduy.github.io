Create database QLXE
go
use QLXE
go

--TÀI KHOẢN
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

--LOẠI XE
Create table loaixe
(Maloai varchar(10),
	Tenloai nvarchar(100),
	primary key(MaLoai))
go

--NHÀ CUNG CẤP
Create table nhacungcap
(MaNCC varchar(10), 
	TenNCC nvarchar(100), 
	Diachi nvarchar(200), 
	Email varchar(50), 
	SDT varchar(20), 
	primary key(MaNCC))
go

--KHÁCH HÀNG
Create table khachhang
(MaKH int IDENTITY(1,1) NOT NULL,
	TenKH nvarchar(100) NOT NULL,
	DiaChi nvarchar(100) NULL,
	Email varchar(50) NULL,
	Phone varchar(50) NULL,
	Primary key(MaKH))
go

--KHO
CREATE TABLE Kho
	(MaKho int IDENTITY(1,1) NOT NULL,
	TenKho nvarchar (50) NOT NULL,
	DiaChi nvarchar (200) NULL,
	Phone varchar (30) NULL,
	Primary key(MaKho))
go

--SẢN PHẨM
CREATE TABLE sanpham(
	MaSP varchar (10) NOT NULL,
	TenSP nvarchar (100) NOT NULL,	
	Maloai varchar(10) NOT NULL,
	MaNCC varchar(10) NOT NULL,
	NamSanXuat varchar(10) NOT NULL,
	Primary key(MaSP))
go

--HÓA ĐƠN
CREATE TABLE hoadon(
	MaHoaDon int IDENTITY(1,1) NOT NULL,	
	Ngay  date  NOT NULL,
	MaKH  int NOT NULL,
	HinhThucTT nvarchar (30) NOT NULL,
	TongTien bigint NOT NULL,
	Username varchar (100) NOT NULL,
	Primary key(MaHoaDon))
go

--CT HÓA ĐƠN
CREATE TABLE ct_hoadon(
	MaCTHoaDon int IDENTITY(1,1) NOT NULL,
	MaHoaDon int NOT NULL,
	MaSP varchar(10) NOT NULL,
	SoLuong int NOT NULL,
	DonGia bigint NOT NULL,
	Primary key(MaCTHoaDon))
go

--Ràng buộc SẢN PHẨM
alter table sanpham
add constraint FK_sp_ncc foreign key(MaNCC) references nhacungcap(MaNCC)
alter table sanpham
add constraint FK_sp_loai foreign key(Maloai) references loaixe(Maloai)
go

--Ràng buộc HÓA ĐƠN
alter table hoadon
add constraint FK_hd_kh foreign key(MaKH) references khachhang(MaKH)
alter table hoadon
add constraint FK_hd_tk foreign key(Username) references taikhoan(Username)
go

--Ràng buộc CHI TIẾT HÓA ĐƠN
alter table ct_hoadon
add constraint FK_cthd_hd foreign key(MaHoaDon) references hoadon(MaHoaDon)
alter table ct_hoadon
add constraint FK_cthd_sp foreign key(MaSP) references sanpham(MaSP)
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

/*Kho*/
insert into Kho values (N'Kho 1',N'439 Hậu Giang P11, Q6, TP.HCM','0777747747')
go

/*Khách hàng*/
insert into khachhang values (N'Bùi Ngọc Duy',N'439B/4 Hậu Giang P11, Q6, TP.HCM','buingocduy1999@gmail.com','0904596810')
go

/*Sản phẩm*/
insert into sanpham values ('WINX','WINNER X','XCT','HONDA','2020')
go

/*Hóa đơn*/
insert into hoadon values ('2021-02-07',2,N'TIỀN MẶT',400000,'admin')
go

select * from taikhoan
select * from loaixe
select * from nhacungcap
select * from khachhang
select * from sanpham
select * from hoadon where Ngay = '10/02/2021'

go

delete from loaixe where Maloai = 'XM'
