
/*TÀI KHOẢN*/
Create table taikhoan
(Username varchar(100),
	Password varchar(100),
	HoTen nvarchar(50),
	NgaySinh datetime,
	Email varchar(50),
	Phone varchar(50),
	NgayBatDau datetime, 
	primary key(username));

/*LOẠI XE*/
Create table loaixe
(Maloai varchar(10),
	Tenloai nvarchar(100),
	primary key(MaLoai));

/*NHÀ CUNG CẤP*/
Create table nhacungcap
(MaNCC varchar(10), 
	TenNCC nvarchar(100), 
	Diachi nvarchar(200), 
	Email varchar(50), 
	SDT varchar(20), 
	primary key(MaNCC));

/*KHÁCH HÀNG*/
Create table khachhang
(MaKH int(11) AUTO_INCREMENT NOT NULL,
	TenKH nvarchar(100) DEFAULT NULL,
	DiaChi nvarchar(100) DEFAULT NULL,
	Email varchar(50) DEFAULT NULL,
	Phone varchar(50) DEFAULT NULL,
	Primary key(MaKH));

/*SẢN PHẨM*/
CREATE TABLE sanpham(
	MaSP varchar (10) NOT NULL,
	TenSP nvarchar (100) NOT NULL,	
	Maloai varchar(10) NOT NULL,
	GiaBan bigint,
	MaNCC varchar(10) NOT NULL,
	NamSanXuat varchar(10) NOT NULL,
	Primary key(MaSP));

/*KHO*/
CREATE TABLE kho
	(MaKho char (50) NOT NULL,
	TenKho nvarchar (50) NOT NULL,
	DiaChi nvarchar (200) NULL,
	Phone varchar (30) NULL,
	Primary key(MaKho));

/*CHI TIẾT KHO*/
CREATE TABLE ct_kho(
	CTMaKho int(11) AUTO_INCREMENT NOT NULL,
	MaKho char(50) not null,
	MaSP varchar(10) NOT NULL,
	Soluong int,
	Primary key (CTMaKho));

/*HÓA ĐƠN*/
CREATE TABLE hoadon(
	MaHoaDon int(20) AUTO_INCREMENT NOT NULL,	
	Ngay  date  NOT NULL,
	MaKH  int NOT NULL,
	HinhThucTT nvarchar (30) NOT NULL,
	TongTien bigint NOT NULL,
	Username varchar (100) NOT NULL,
	Primary key(MaHoaDon));

/*CT HÓA ĐƠN*/
CREATE TABLE ct_hoadon(
	MaCTHoaDon int(20) AUTO_INCREMENT NOT NULL,
	MaHoaDon int NOT NULL,
	MaSP varchar(10) NOT NULL,
	SoLuong int NOT NULL,
	ThanhTien bigint NOT NULL,
	Primary key(MaCTHoaDon));

/*PHIẾU NHẬP*/
CREATE TABLE phieunhap(
	MaPN int(20) AUTO_INCREMENT NOT NULL,
	Username varchar(100) NOT NULL,
	MaNCC varchar(10),
	NgayNhap date NOT NULL,
	MaKho char(50) NOT NULL,
    Primary key (MaPN));

/*CHI TIẾT PHIẾU NHẬP*/
CREATE TABLE ct_phieunhap(
	MaCTPN int(20) AUTO_INCREMENT NOT NULL,
	MaPN int NOT NULL,
	MaSP varchar(10) NOT NULL,
	SoLuong int NOT NULL,
	DonGiaNhap int NOT NULL,
    Primary key (MaCTPN));

/*PHIẾU XUẤT*/
CREATE TABLE phieuxuat(
	MaPX int(20) AUTO_INCREMENT NOT NULL,
	Username varchar(100) NOT NULL,
	MaKH int NOT NULL,
	NgayXuat date NOT NULL,
	MaKho char(50) NOT NULL,
	Primary key (MaPX));

/*CHI TIẾT PHIẾU XUẤT*/
CREATE TABLE ct_phieuxuat(
	MaCTPX int(20) AUTO_INCREMENT NOT NULL,
	MaPX int NOT NULL,
	MaSP varchar(10) NOT NULL,
	SoLuong int NOT NULL,
	DonGia int NOT NULL,
	Primary key (MaCTPX));

/*Ràng buộc SẢN PHẨM*/
alter table sanpham
add constraint FK_sp_ncc foreign key(MaNCC) references nhacungcap(MaNCC);
alter table sanpham
add constraint FK_sp_loai foreign key(Maloai) references loaixe(Maloai);

/*Ràng buộc CHI TIẾT KHO*/
alter table ct_kho
add constraint FK_ctk_sp foreign key(MaSP) references sanpham(MaSP);
alter table ct_kho
add constraint FK_ctk_k foreign key(MaKho) references kho(MaKho);

/*Ràng buộc HÓA ĐƠN*/
alter table hoadon
add constraint FK_hd_kh foreign key(MaKH) references khachhang(MaKH);
alter table hoadon
add constraint FK_hd_tk foreign key(Username) references taikhoan(Username);

/*Ràng buộc CHI TIẾT HÓA ĐƠN*/
alter table ct_hoadon
add constraint FK_cthd_hd foreign key(MaHoaDon) references hoadon(MaHoaDon);
alter table ct_hoadon
add constraint FK_cthd_sp foreign key(MaSP) references sanpham(MaSP);

/*Ràng buộc PHIẾU NHẬP*/
alter table phieunhap
add constraint FK_pn_ncc foreign key(MaNCC) references nhacungcap(MaNCC);
alter table phieunhap
add constraint FK_pn_tk foreign key(Username) references taikhoan(Username);

/*Ràng buộc CHI TIẾT PHIẾU NHẬP*/
alter table ct_phieunhap
add constraint FK_ctpn_pn foreign key(MaPN) references phieunhap(MaPN);
alter table ct_phieunhap
add constraint FK_ctpn_sp foreign key(MaSP) references sanpham(MaSP);

/*Ràng buộc PHIẾU XUẤT*/
alter table phieuxuat
add constraint FK_px_k foreign key(MaKho) references kho(MaKho);
alter table phieuxuat
add constraint FK_px_tk foreign key(Username) references taikhoan(Username);

/*Ràng buộc CHI TIẾT PHIẾU XUẤT*/
alter table ct_phieuxuat
add constraint FK_ctpx_px foreign key(MaPX) references phieuxuat(MaPX);
alter table ct_phieuxuat
add constraint FK_ctpx_tk foreign key(MaSP) references sanpham(MaSP);

/*Tài khoảng*/
insert into taikhoan values ('DUY','123','buingocduy','1999-06-06','buingocduy@gmail.com',0904596812,'2019-06-06');
insert into taikhoan values ('admin','123','admin','1999-06-06','admin@gmail.com',090999999,'2019-06-06');

/*Loại xe*/
insert into loaixe values ('XS',N'Xe số');
insert into loaixe values ('XCT',N'Xe côn tay');
insert into loaixe values ('XTG',N'Xe tay ga');

/*Nhà cung cấp*/
insert into nhacungcap values ('HONDA',N'Công ty HONDA Việt Nam',N'Tầng 8, Zen Plaza, 54-56 đường Nguyễn Trãi, quận 1, thành phố Hồ Chính Minh','cr@honda.com.vn','(84) 28-39256949');
insert into nhacungcap values ('YAMAHA',N'Công ty Yamaha Việt Nam',N'Thôn Bình An, Xã Trung Giã, Huyện Sóc Sơn, TP. Hà Nội','cskh@yamaha-motor.com.vn','18001588');
insert into nhacungcap values ('SUZUKI',N'Công ty TNHH Việt Nam Suzuki',N'Đường số 2, KCN Long Bình, P. Long Bình,TP. Biên Hòa, Đồng Nai','null','18006950');

/*Khách hàng*/
insert into khachhang (TenKH,DiaChi,Email,Phone) values (N'Bùi Ngọc Duy',N'439B/4 Hậu Giang P11, Q6, TP.HCM','buingocduy1999@gmail.com','0904596810');
insert into khachhang (TenKH,DiaChi,Email,Phone) values (N'Phan Hồng Tuấn',N'475A Điện Biên Phủ, P.25, Q.Bình Thạnh, TP.HCM','phanhongtuan@gmail.com','0904596810');
insert into khachhang (TenKH,DiaChi,Email,Phone) values (N'Huỳnh Lưu Trọng Vũ',N'475A Điện Biên Phủ, P.25, Q.Bình Thạnh, TP.HCM','huynhluutrongvu@gmail.com','0904596810');
insert into khachhang (TenKH,DiaChi,Email,Phone) values (N'Trần Văn Kỳ',N'475A Điện Biên Phủ, P.25, Q.Bình Thạnh, TP.HCM','tranvanky@gmail.com','0904596810');

/*Sản phẩm*/
insert into sanpham values ('WINX','WINNER X','XCT','41000000','HONDA','2020');
insert into sanpham values ('EX','EXCITER 150','XCT','50000000','YAMAHA','2020');
insert into sanpham values ('RAI','RAIDER 150','XCT','50000000','SUZUKI','2020');
insert into sanpham values ('VS','VISION 110','XTG','30000000','HONDA','2020');
insert into sanpham values ('FG','FREEGO 125','XTG','30000000','YAMAHA','2020');
insert into sanpham values ('GD','GD 110','XCT','22000000','SUZUKI','2020');

/*Hóa đơn*/
insert into hoadon (Ngay,MaKH,HinhThucTT,TongTien,Username) values ('2021-02-07',1,N'TIỀN MẶT',50000000,'admin');
insert into hoadon (Ngay,MaKH,HinhThucTT,TongTien,Username) values ('2021-02-07',2,N'TIỀN MẶT',30000000,'admin');
insert into hoadon (Ngay,MaKH,HinhThucTT,TongTien,Username) values ('2021-02-07',3,N'TIỀN MẶT',41000000,'admin');
insert into hoadon (Ngay,MaKH,HinhThucTT,TongTien,Username) values ('2021-02-07',4,N'TIỀN MẶT',30000000,'admin');
insert into hoadon (Ngay,MaKH,HinhThucTT,TongTien,Username) values ('2021-02-07',1,N'TIỀN MẶT',50000000,'admin');

/*Kho*/
insert into Kho values ('HONDA',N'Kho HONDA',N'439 Hậu Giang P11, Q6, TP.HCM','0777747747');
insert into Kho values ('YAMAHA',N'Kho YAMAHA',N'439 Hậu Giang P11, Q6, TP.HCM','0777747747');
insert into Kho values ('SUZUKI',N'Kho SUZUKI',N'439 Hậu Giang P11, Q6, TP.HCM','0777747747');

/*CT_Kho*/
insert into ct_kho (MaKho,MaSP,Soluong) values ('HONDA','WINX',9);
insert into ct_kho (MaKho,MaSP,Soluong) values ('HONDA','VS',9);
insert into ct_kho (MaKho,MaSP,Soluong) values ('YAMAHA','EX',9);
insert into ct_kho (MaKho,MaSP,Soluong) values ('YAMAHA','FG',9);
insert into ct_kho (MaKho,MaSP,Soluong) values ('SUZUKI','RAI',9);
insert into ct_kho (MaKho,MaSP,Soluong) values ('SUZUKI','GD',10);

/*CT_Hóa đơn*/
insert into ct_hoadon (MaHoaDon,MaSP,SoLuong,DonGia) values (1,'EX',1,50000000);
insert into ct_hoadon (MaHoaDon,MaSP,SoLuong,DonGia) values (2,'FG',1,30000000);
insert into ct_hoadon (MaHoaDon,MaSP,SoLuong,DonGia) values (3,'WINX',1,41000000);
insert into ct_hoadon (MaHoaDon,MaSP,SoLuong,DonGia) values (4,'VS',1,30000000);
insert into ct_hoadon (MaHoaDon,MaSP,SoLuong,DonGia) values (5,'RAI',1,50000000);

/*PHIẾU NHẬP*/
insert into phieunhap (Username,MaNCC,NgayNhap,MaKho) values ('DUY','HONDA','2020-02-07','HONDA');
insert into phieunhap (Username,MaNCC,NgayNhap,MaKho) values ('DUY','YAMAHA','2020-02-07','YAMAHA');
insert into phieunhap (Username,MaNCC,NgayNhap,MaKho) values ('DUY','SUZUKI','2020-02-07','SUZUKI');

/*CT PHIẾU NHẬP*/
insert into ct_phieunhap (MaPN,MaSP,SoLuong,DonGiaNhap) values (1,'WINX',10,35000000);
insert into ct_phieunhap (MaPN,MaSP,SoLuong,DonGiaNhap) values (1,'VS',10,20000000);
insert into ct_phieunhap (MaPN,MaSP,SoLuong,DonGiaNhap) values (2,'EX',10,40000000);
insert into ct_phieunhap (MaPN,MaSP,SoLuong,DonGiaNhap) values (2,'FG',10,20000000);
insert into ct_phieunhap (MaPN,MaSP,SoLuong,DonGiaNhap) values (3,'RAI',10,40000000);
insert into ct_phieunhap (MaPN,MaSP,SoLuong,DonGiaNhap) values (3,'GD',10,15000000);

/*PHIẾU XUẤT*/
insert into phieuxuat (Username,MaKH,NgayXuat,MaKho) values ('DUY',1,'2021-02-07','YAMAHA');
insert into phieuxuat (Username,MaKH,NgayXuat,MaKho) values ('DUY',2,'2021-02-07','YAMAHA');
insert into phieuxuat (Username,MaKH,NgayXuat,MaKho) values ('DUY',3,'2021-02-07','HONDA');
insert into phieuxuat (Username,MaKH,NgayXuat,MaKho) values ('DUY',4,'2021-02-07','HONDA');
insert into phieuxuat (Username,MaKH,NgayXuat,MaKho) values ('DUY',1,'2021-02-07','SUZUKI');

/*CT PHIẾU XUẤT*/
insert into ct_phieuxuat (MaPX,MaSP,SoLuong,DonGia) values (1,'EX',1,50000000);
insert into ct_phieuxuat (MaPX,MaSP,SoLuong,DonGia)  values (2,'FG',1,30000000);
insert into ct_phieuxuat (MaPX,MaSP,SoLuong,DonGia)  values (3,'WINX',1,41000000);
insert into ct_phieuxuat (MaPX,MaSP,SoLuong,DonGia)  values (4,'VS',1,30000000);
insert into ct_phieuxuat (MaPX,MaSP,SoLuong,DonGia)  values (5,'RAI',1,50000000);

select * from taikhoan;
select * from loaixe; 
select * from nhacungcap;
select * from khachhang;
select * from sanpham;
select * from kho;
select * from ct_kho;
select * from hoadon;
select * from ct_hoadon;
select * from phieunhap;
select * from ct_phieuNhap;
select * from phieuxuat;
select * from ct_phieuxuat;


select * from khachhang where SDT <> '0'

Hàm kiểm tra tồn tại
IF EXISTS (SELECT * FROM ct_phieuxuat Where MaSP = 'EX') 
BEGIN
	Update ct_kho SET Soluong = 
	 ((select 'Soluongnhap'=Sum(SoLuong) from ct_phieunhap where MaSP = 'EX') - 
	 (select 'Soluongxuat' =Sum(SoLuong) from ct_phieuxuat where MaSP = 'EX')) 
	 Where MaSP = 'EX'
END
ELSE 
	 Update ct_kho SET Soluong = (select 'Soluongnhap'=Sum(SoLuong) from ct_phieunhap where MaSP = 'EX') Where MaSP = 'EX'


-- Hàm kiểm tra tồn tại
IF EXISTS (SELECT * FROM ct_phieunhap Where MaPN = 4 AND MaSP = 'VS') 
BEGIN
	PRINT 'DA TON TAI'
END
ELSE INSERT INTO ct_phieunhap(MaPN,MaSP,Soluong,DonGiaNhap) VALUES ('4','VS','20','3000000')


Update ct_kho SET 

Soluong=
(select Sum(SoLuong) as 'Soluongnhap'
from ct_phieunhap
where MaSP = 'EX') 
-
(select Sum(SoLuong) as 'Soluongxuat'
from ct_phieuxuat
where MaSP = 'EX') 
from ct_kho
Where MaSP = 'EX'

Select Soluong From ct_kho Where MaSP = 'EX' 

delete from kho where MaKho = '1'	

select * from ct_hoadon where MaHoaDon = '1'

select SUM(TongTien) as 'TongTien'
from hoadon 
where Ngay between '2021-02-07' and '2021-02-09' 

SELECT 'TongTien'=SUM(TongTien) FROM hoadon WHERE Ngay between '2021-02-07' and '2021-02-07'

select TenSP,DonGia,'SoLuong'=SUM(SoLuong),'TongTien'=(DonGia * SUM(SoLuong))
from ct_hoadon,hoadon,sanpham  
where ct_hoadon.MaHoaDon = hoadon.MaHoaDon and sanpham.MaSP = ct_hoadon.MaSP and hoadon.Ngay between '2021-02-07' and '2021-02-07' 
Group by TenSP,DonGia

select 'SoLuong'=SUM(SoLuong), 'TongTien'=SUM(TongTien)
from ct_hoadon,hoadon
where ct_hoadon.MaHoaDon = hoadon.MaHoaDon and Ngay between '2021-02-07' and '2021-02-07' 

--tính tổng hoá đơn theo ngày
select * , 'tong'= (select 'TONG'=sum(TongTien) from hoadon where  Ngay between '2021-05-29' and '2021-05-30') 
from hoadon
where  Ngay between '2021-02-07' and '2021-05-29'

select MaHoaDon,Ngay,SDT,TongTien,Username,GhiChu
FROM hoadon
where Ngay between '2021-02-07' and '2021-05-29'
 
select 'TONG' = sum(TongTien) from hoadon where  Ngay between '2021-02-07' and '2021-02-09' 
group by MaHoaDon,Ngay,SDT,TongTien,Username,GhiChu

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

--Tính tổng chi tiết hoá đơn từng sản phẩm theo ngày
select TenSP, GiaBan, 'SoLuong'=SUM(SoLuong), 'TongTien'=(SUM(SoLuong) * GiaBan) 
from ct_hoadon,hoadon,sanpham  
where ct_hoadon.MaHoaDon = hoadon.MaHoaDon and sanpham.MaSP = ct_hoadon.MaSP and Ngay between '2021-05-29' and '2021-05-30' 
Group by TenSP,GiaBan

select TenSP, GiaBan, 'SoLuong'=SUM(SoLuong), 'TongTien'=(SUM(SoLuong) * GiaBan),
"TongĐG" = (SELECT "TONGGG"= sum(TongTien)
	FROM "dbo"."hoadon" hoadon
	WHERE Ngay between '2021-05-29' and '2021-05-30' ),
"TongCG" = (SELECT "TONGCG"= sum(ThanhTien)
	 FROM ct_hoadon,hoadon
	 WHERE ct_hoadon.MaHoaDon = hoadon.MaHoaDon and Ngay between '2021-05-29' and '2021-05-30'), 
"TongSL" = (SELECT "TONGSL"= sum(SoLuong)
            FROM hoadon,ct_hoadon
            WHERE ct_hoadon.MaHoaDon = hoadon.MaHoaDon and Ngay between '2021-05-29' and '2021-05-30'), 
"TongGG" = (
	(SELECT "TONGCG"= sum(ThanhTien)
	 FROM ct_hoadon,hoadon
	 WHERE ct_hoadon.MaHoaDon = hoadon.MaHoaDon and Ngay between '2021-05-29' and '2021-05-30')
-
	(SELECT "TONGGG"= sum(TongTien)
	FROM "dbo"."hoadon" hoadon
	WHERE Ngay between '2021-05-29' and '2021-05-30' ))
from ct_hoadon,hoadon,sanpham  
where ct_hoadon.MaHoaDon = hoadon.MaHoaDon and sanpham.MaSP = ct_hoadon.MaSP and Ngay between '2021-05-29' and '2021-05-30'  
Group by TenSP,GiaBan
*/