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

--SẢN PHẨM
CREATE TABLE sanpham(
	MaSP varchar (10) NOT NULL,
	TenSP nvarchar (100) NOT NULL,	
	Maloai varchar(10) NOT NULL,
	MaNCC varchar(10) NOT NULL,
	NamSanXuat varchar(10) NOT NULL,
	Primary key(MaSP))
go

--KHO
CREATE TABLE kho
	(MaKho int IDENTITY(1,1) NOT NULL,
	TenKho nvarchar (50) NOT NULL,
	DiaChi nvarchar (200) NULL,
	Phone varchar (30) NULL,
	Primary key(MaKho))
go

--CHI TIẾT KHO
CREATE TABLE ct_kho(
	CTMaKho int IDENTITY(1,1) NOT NULL,
	MaKho int not null,
	MaSP varchar(10) NOT NULL,
	Soluong int,
	Primary key (CTMaKho)
)

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

--PHIẾU NHẬP
CREATE TABLE phieunhap(
	MaPN int IDENTITY(1,1) NOT NULL,
	Username varchar(100) NOT NULL,
	MaNCC varchar(10),
	NgayNhap date NOT NULL,
	MaKho int NOT NULL,
    Primary key (MaPN))
go

--CHI TIẾT PHIẾU NHẬP
CREATE TABLE ct_phieunhap(
	MaCTPN int IDENTITY(1,1) NOT NULL,
	MaPN int NOT NULL,
	MaSP varchar(10) NOT NULL,
	SoLuong int NOT NULL,
	DonGiaNhap int NOT NULL,
    Primary key (MaCTPN))
go

--PHIẾU XUẤT
CREATE TABLE phieuxuat(
	MaPX int IDENTITY(1,1) NOT NULL,
	Username varchar(100) NOT NULL,
	MaKH int NOT NULL,
	NgayXuat date NOT NULL,
	MaKho int NOT NULL,
	Primary key (MaPX))
go

--CHI TIẾT PHIẾU XUẤT
CREATE TABLE ct_phieuxuat(
	MaCTPX int IDENTITY(1,1) NOT NULL,
	MaPX int NOT NULL,
	MaSP varchar(10) NOT NULL,
	SoLuong int NOT NULL,
	DonGia int NOT NULL,
	Primary key (MaCTPX))
go

--Ràng buộc SẢN PHẨM
alter table sanpham
add constraint FK_sp_ncc foreign key(MaNCC) references nhacungcap(MaNCC)
alter table sanpham
add constraint FK_sp_loai foreign key(Maloai) references loaixe(Maloai)
go

--Ràng buộc CHI TIẾT KHO
alter table ct_kho
add constraint FK_ctk_sp foreign key(MaSP) references sanpham(MaSP)
alter table ct_kho
add constraint FK_ctk_k foreign key(MaKho) references kho(MaKho)
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

--Ràng buộc PHIẾU NHẬP
alter table phieunhap
add constraint FK_pn_ncc foreign key(MaNCC) references nhacungcap(MaNCC)
alter table phieunhap
add constraint FK_pn_tk foreign key(Username) references taikhoan(Username)
go

--Ràng buộc CHI TIẾT PHIẾU NHẬP
alter table ct_phieunhap
add constraint FK_ctpn_pn foreign key(MaPN) references phieunhap(MaPN)
alter table ct_phieunhap
add constraint FK_ctpn_sp foreign key(MaSP) references sanpham(MaSP)
go

--Ràng buộc PHIẾU XUẤT
alter table phieuxuat
add constraint FK_px_k foreign key(MaKho) references kho(MaKho)
alter table phieuxuat
add constraint FK_px_tk foreign key(Username) references taikhoan(Username)
go

--Ràng buộc CHI TIẾT PHIẾU XUẤT
alter table ct_phieuxuat
add constraint FK_ctpx_px foreign key(MaPX) references phieuxuat(MaPX)
alter table ct_phieuxuat
add constraint FK_ctpx_tk foreign key(MaSP) references sanpham(MaSP)
go

/*Tài khoảng*/
insert into taikhoan values ('DUY','123','buingocduy',6/6/1999,'buingocduy@gmail.com',0904596812,26/12/2019)
insert into taikhoan values ('admin','123','admin',6/6/1999,'admin@gmail.com',090999999,09/09/2009)
go

/*Loại xe*/
insert into loaixe values ('XM',N'Xe số')
insert into loaixe values ('XCT',N'Xe côn tay')
insert into loaixe values ('XTG',N'Xe tay ga')
go

/*Nhà cung cấp*/
insert into nhacungcap values ('HONDA',N'Công ty HONDA Việt Nam',N'Tầng 8, Zen Plaza, 54-56 đường Nguyễn Trãi, quận 1, thành phố Hồ Chính Minh','cr@honda.com.vn','(84) 28-39256949')
insert into nhacungcap values ('YAMAHA',N'Công ty Yamaha Việt Nam',N'Thôn Bình An, Xã Trung Giã, Huyện Sóc Sơn, TP. Hà Nội','cskh@yamaha-motor.com.vn','18001588')
insert into nhacungcap values ('SUZUKI',N'Công ty TNHH Việt Nam Suzuki',N'Đường số 2, KCN Long Bình, P. Long Bình,TP. Biên Hòa, Đồng Nai','null','18006950')
go

/*Kho*/
insert into Kho values (N'Kho 1',N'439 Hậu Giang P11, Q6, TP.HCM','0777747747')
go

/*CT_Kho*/
insert into ct_kho values (1,'EX',5)
insert into ct_kho values (1,'WINX',5)
insert into ct_kho values (1,'RAI',5)
go

/*Khách hàng*/
insert into khachhang values (N'Bùi Ngọc Duy',N'439B/4 Hậu Giang P11, Q6, TP.HCM','buingocduy1999@gmail.com','0904596810')
insert into khachhang values (N'Phan Hồng Tuấn',N'475A Điện Biên Phủ, P.25, Q.Bình Thạnh, TP.HCM','phanhongtuan@gmail.com','0904596810')
insert into khachhang values (N'Huỳnh Lưu Trọng Vũ',N'475A Điện Biên Phủ, P.25, Q.Bình Thạnh, TP.HCM','huynhluutrongvu@gmail.com','0904596810')
insert into khachhang values (N'Trần Văn Kỳ',N'475A Điện Biên Phủ, P.25, Q.Bình Thạnh, TP.HCM','tranvanky@gmail.com','0904596810')
go

/*Sản phẩm*/
insert into sanpham values ('WINX','WINNER X','XCT','HONDA','2020')
insert into sanpham values ('EX','EXCITER 150','XCT','YAMAHA','2020')
insert into sanpham values ('RAI','RAIDER 150','XCT','SUZUKI','2020')
go

/*Hóa đơn*/
insert into hoadon values ('2021-02-07',1,N'TIỀN MẶT',400000,'admin')
insert into hoadon values ('2021-02-08',2,N'TIỀN MẶT',400000,'admin')
insert into hoadon values ('2021-02-09',3,N'TIỀN MẶT',400000,'admin')
insert into hoadon values ('2021-02-10',4,N'TIỀN MẶT',400000,'admin')
insert into hoadon values ('2021-02-11',1,N'TIỀN MẶT',400000,'admin')
go

/*CT_Hóa đơn*/
insert into ct_hoadon values (12,'EX',1,400000)
insert into ct_hoadon values (13,'EX',2,400000)
insert into ct_hoadon values (14,'EX',3,400000)
insert into ct_hoadon values (15,'EX',4,400000)
insert into ct_hoadon values (16,'EX',1,400000)
go


/*PHIẾU NHẬP*/
insert into phieunhap values ('DUY','HONDA','2020-02-07',1)
insert into phieunhap values ('DUY','YAMAHA','2020-02-07',1)
insert into phieunhap values ('DUY','SUZUKI','2020-02-07',1)
go

/*CT PHIẾU NHẬP*/
insert into ct_phieunhap values (1,'EX',5,15000)
insert into ct_phieunhap values (1,'WINX',5,15000)
insert into ct_phieunhap values (1,'RAI',5,15000)
go

/*PHIẾU XUẤT*/
insert into phieuxuat values ('DUY',1,'2021-02-07',1)
go

/*CT PHIẾU XUẤT*/
insert into ct_phieuxuat values (1,'EX',1,40000)
go

select * from taikhoan
select * from loaixe 
select * from nhacungcap 
select * from khachhang
select * from sanpham
select * from kho
select * from ct_kho
select * from hoadon
select * from ct_hoadon
select * from phieunhap
select * from ct_phieuNhap
select * from phieuxuat
select * from ct_phieuxuat
go


delete from ct_hoadon where MaHoaDon = '4'

select * from ct_hoadon where MaHoaDon = '1'


select Ngay, MaSP, SoLuong, MaKH, HinhThucTT, TongTien, Username 
from ct_hoadon, hoadon
where hoadon.MaHoaDon = ct_hoadon.MaHoaDon and Ngay between '2021-02-07' and '2021-02-09'  

select * from hoadon where  Ngay between '2021-02-07' and '2021-02-09' 

UPDATE ct_phieuxuat SET MaPX = '1',MaSP ='EX',SoLuong = '4',DonGia = '40000' WHERE MaCTPX = '1'

Select 'TongTien'=sum(DonGia) 
From ct_hoadon 
Where MaHoaDon = '12' 

select 'SoLuong'=SUM(SoLuong)
from ct_hoadon
where MaHoaDon = '12'


select 'DonGia'=sum(DonGia)
from ct_hoadon
where MaHoaDon = '12'


UPDATE hoadon 
SET TongTien = 
(select 'TongTien'=sum(SoLuong * DonGia)
from ct_hoadon
where MaHoaDon = '12'
Group by MaHoaDon)
where MaHoaDon = '12'
