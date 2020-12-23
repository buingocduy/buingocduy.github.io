Create database nguoidung
go

Use nguoidung
go
Create table admin
(username char(100),password char(100) primary key(username))
go 

Create table taikhoan
(username char(100),password char(100),email char(100),phonenumber char(12), primary key(username))
go 

Create table hoadon
(MaHD int IDENTITY(1,1),username char(100),tensp nvarchar(100),soluongmua  int,tonggia bigint, primary key(MaHD))
go 

Create table hang
(id int IDENTITY(1,1), tenhang nvarchar(30),logo char(4000),primary key (tenhang)) 
go

Create table sanpham
(id int IDENTITY(1,1), tensp nvarchar(100),gia bigint,hinhanh char(4000),
kichthuoc char(80),chieucaoyen char(20),sizebanh char(150),engine nvarchar(200),
CC char(20),congsuat nvarchar(50),CCnhot nvarchar(50),CCxang nvarchar(20),phanh nvarchar(100),gear nvarchar(20),tenhang nvarchar(30),primary key(id))
go

 
alter table hoadon add constraint FK_HD_KH foreign key(username) references taikhoan(username) 
alter table sanpham add constraint FK_sp_h foreign key(tenhang) references hang(tenhang) 
go

insert into admin values ('buingocduy','123')
go

insert into taikhoan values ('nguyenvana','123','nguyenvana@gmail.com',0904596810)
insert into taikhoan values ('nguyenvanb','123','nguyenvanb@gmail.com',0904596811)
insert into taikhoan values ('nguyenvanc','123','nguyenvanc@gmail.com',0904596812)
go

insert into hang values ('HONDA','Hinh\LOGO\HONDA.jpg')
insert into hang values ('YAMAHA','Hinh\LOGO\YAMAHA.jpg')
insert into hang values ('SUZUKI','Hinh\LOGO\SUZUKI.jpg')
go

--HONDA
insert into sanpham values ('Click 2020','3600','Hinh\HONDA\vario.jpg',
'1919 x 679 x 1062 mm','769 mm','90/80-14 - 100/80- 14 48P Tubeless',N'PGM-Fi, xăng, 4 kỳ, 1 xy-lanh, làm mát bằng dung dịch',
'150 cc',N'9.7 kW (13.1 PS) / 8500 rpm','0,8L','5,5L',N'Thắng đĩa;Tang trống',N'Vô cấp','HONDA')

insert into sanpham values ('Winner X','2000','Hinh\HONDA\winnerx.jpg',
'2.019 x 727 x 1.088 mm',' 795 mm','90/80-17M/C 46P Sau: 120/70-17M/C 58P',N'PGM-Fi, xăng, 4 kỳ, 1 xy-lanh, làm mát bằng dung dịch',
'149,1 cm3',N'11,5kW/9.000 vòng/phút',N'1.1 lít khi thay nhớt ; 1.3 lít khi rã máy','4,5L',N'Phanh đĩa;Phanh đĩa',N'6 Cấp','HONDA')

insert into sanpham values ('CB150R SF','4000','Hinh\HONDA\CB150RSF.jpg',
'2.019 x 719 x 1.039 mm',' 797 mm','100/80-17 52P - 130/70-17 62P',N'4 thì, một xilanh, DOHC',
'149,16 cc',N'16,6 mã lực @ 9.000 vòng/phút',N'1.1 lít khi thay nhớt ; 1.3 lít khi rã máy','12L',N'Phanh đĩa;Phanh đĩa',N'6 Cấp','HONDA')

insert into sanpham values ('Air Blade','2150','Hinh\HONDA\airblade.jpg',
'1.870mm x 686mm x 1.112mm','775 mm',N'90/80-14M/C 43P - 100/80 -14M/C 48P',N' Xăng, 4 kỳ, 1 xy lanh, làm mát bằng dung dịch',
'149,3 cm3',N'9,6kW/8.500 vòng/phút',N' 0,8 khi thay nhớt ; 0,9 khi rã máy','4,4L',N'Phanh đĩa ABS;Tang trống',N'Vô cấp','HONDA')

insert into sanpham values ('Monkey 2020','3700','Hinh\HONDA\monkey.jpg',
'1.712 x 754 x 1.029 mm','776 mm','Maxxis Tortuga: 120/80-12 65J - 130/80-12 69J',N'SOHC xy-lanh đơn, làm mát bằng gió',
'125cc',N'9,6 mã lực tại 7.000 vòng/phút',N'0.9 lít khi thay nhớt ; 1.1 lít khi rã máy','5,7L',N'Phanh đĩa;Phanh đĩa',N'4 Cấp','HONDA')

insert into sanpham values ('SH 2020','3600','Hinh\HONDA\SH.jpg',
'2.090 x 739 x 1.129 mm','799 mm','120/80-16 ; 100/80-16',N'PGM-FI, xăng, 4 kỳ, 1 xy-lanh, làm mát bằng dung dịch',
'124,8cm³ (SH 125i)',N'9,6kW/8.250 vòng/phút (SH 125i)',N'0,8 khi thay nhớt ; 0,9 khi rã máy','7,8L',N'Phanh đĩa ABS;Phanh đĩa',N'Vô cấp','HONDA')

--YAMAHA
insert into sanpham values ('EXCITER 2021','2100','Hinh\YAMAHA\EXCITER.jpg',
'1.985mm x 670mm x 1.100mm','795 mm','120/80-16 ; 100/80-16',N'PGM-FI, xăng, 4 kỳ, SOHC, 1 xy-lanh, làm mát bằng dung dịch',
'149,7 cc',N'11,3 kW (15,4 PS) / 8.500 vòng/phút',N'Thay nhớt 0,95 lít - lọc nhớt 1,15 lít','4L',N'Đĩa đơn 245 mm; Đĩa đơn 203 mm',N'5 cấp','YAMAHA')

insert into sanpham values ('XSR 155 2020','3600','Hinh\YAMAHA\XSR.jpg',
' 2.000 x 805 x 1.080 (mm)','810 mm','110/70/17 - 140/70/17',N'PGM-FI, xăng, 4 kỳ, SOHC, 1 xy-lanh, làm mát bằng dung dịch',
'155 cm³',N'14,2 kW (19,3 PS)/ 10.000 vòng/phút​',N'thay nhớt 0.85 Lít (thay lọc nhớt là 0.95 Lít)','10L',N'Phanh đĩa ABS;Phanh đĩa',N'6 cấp','YAMAHA')

insert into sanpham values ('LATTE 2021','1700','Hinh\YAMAHA\LATTE.jpg',
'1,820 mm x 690 mm x 1,160 mm','790 mm',N'90/90-12 / 100/90-10',N'PGM-FI, xăng, 4 kỳ, 1 xy-lanh, SOHC, làm mát bằng gió',
'124,8cm³ ',N'6.1 kW (8.3 PS) / 6,500 vòng/phút',N'0,8 khi thay nhớt','6L',N'Phanh đĩa;Phanh tang trống',N'Vô cấp','YAMAHA')

insert into sanpham values ('MT-15 2021','3000','Hinh\YAMAHA\MT.jpg',
'800 x 1.965 x 1.065 mm',' 810 mm','110 / 70-17 M - 140 / 70-17 M',N'PGM-FI, xăng, 4 kỳ, 1 xy-lanh, SOHC, làm mát bằng dung dịch',
'155cm³',N'19 mã lực tại 10.000 v/ph',N'thay nhớt 0.85 Lít (thay lọc nhớt là 0.95 Lít)','7,8L',N'Đĩa đơn 292 mm;Đĩa dơn 220mm',N'6 cấp','YAMAHA')

insert into sanpham values ('NVX 2021','2300','Hinh\YAMAHA\NVX.jpg',
'1.980 mm x 700 mm x 1.150 mm','790 mm','110/80-14M/C 53P - 140/70-14M/C 62P',N'PGM-FI, xăng, Blue Core, 4 thì, 4 van, SOHC, làm mát bằng dung dịch',
'155,1 cc',N'11,3 kW (15,4 PS)/8.000 vòng/phút',N'0,9  khi thay nhớt' ,'5,5L',N'Phanh đĩa ABS;Phanh đĩa',N'Vô cấp','YAMAHA')

insert into sanpham values ('FreeGo 2021','1500','Hinh\YAMAHA\FREEGO.jpg',
' 1.905 x 690 x 1.110 mm','780 mm','100/90-12 59J - 110/90-12 64L',N'Blue Core, 4 thì, làm mát không khí, 1 xy-lanh',
'124,8cm³',N'9,4 mã lực @ 8.000 vòng/phút',N'0,84 L','4,2L',N'Đĩa đơn, piston đơn;Tang trống',N'Vô cấp','YAMAHA')


--SUZUKI
insert into sanpham values ('AXELO 125','1300','Hinh\SUZUKI\AXELO.jpg',
'1.895 x 715x 1.075 mm','775mm','70/90 - 17M/C, 80/90 - 17M/C',N'Xăng, 4 thì, 1 xy-lanh, SOHC - Làm mát không khí',
'124 cm3',N'7,06/8.000 (KW/vòng/phút)',N'0.8L khi thay, 1L khi thay lọc nhớt','4.3L',
N'đĩa đơn, đĩa đơn',N'4 cấp côn tay','SUZUKI')

insert into sanpham values ('RAIDER 2021','2200','Hinh\SUZUKI\RAIDER.jpg',
'1.960 x 675 x 980 mm','765 mm','70/90-17; 80/90/17',N'PGM-FI, xăng, 4 kỳ, SOHC, 1 xy-lanh, làm mát bằng dung dịch',
'147,3 cm³',N'18,45 mã lực / 10.000 vòng/phút​',N'thay nhớt 0.85 Lít (thay lọc nhớt là 0.95 Lít)','4L',
N'Phanh đĩa ABS;Phanh đĩa',N'6 cấp','SUZUKI')

insert into sanpham values ('GSX150 BANDIT','3000','Hinh\SUZUKI\GSXBANDIT.jpg',
'2.000 x 745 x 1.035 mm','785 mm','90/80-17M/C / 130/70-17M/C 62P',N'DOHC, 4 thì, làm mắt bằng dung dịch, phun xăng điện tử EFI',
'150cc',N'18,9 mã lực tại 10.500 vòng/phút',N'1,3 lít','11L',
N'đĩa đơn, đĩa đơn',N'6 Cấp','SUZUKI')

insert into sanpham values ('GSX R150','3000','Hinh\SUZUKI\GSXR.jpg',
'2.020 x 700 x 1.075 mm','785 mm','90/80-17M/C / 130/70-17M/C 62P',N'DOHC, 4 thì, làm mắt bằng dung dịch, phun xăng điện tử EFI',
'150cc',N'18,9 mã lực tại 10.500 vòng/phút',N'1,3 lít','11L',
N'đĩa đơn, đĩa đơn',N'6 Cấp','SUZUKI')

insert into sanpham values ('GD110','1300','Hinh\SUZUKI\GD.jpg',
'1.905 x 745 x 1.065 mm','766 mm','2,50 - 17 38L, 2,75 - 17 47P',N'SOHC, 4 thì, xi lanh đơn, làm mát không khí',
'112,8 cm3',N'6,2 kW / 8,000 vòng / phút',N'0.9 lít khi thay nhớt, 1.1 lít khi rã máy','8.5L',
N'Đùm;Đùm',N'4 số côn tay','SUZUKI')

insert into sanpham values ('GSX S150','3000','Hinh\SUZUKI\GSXS.jpg',
'2.000 x 745 x 1.035 mm','785 mm','90/80-17M/C / 130/70-17M/C 62P',N'DOHC, 4 thì, làm mắt bằng dung dịch, phun xăng điện tử EFI',
'150cc',N'18,9 mã lực tại 10.500 vòng/phút',N'1,3 lít','11L',
N'đĩa đơn, đĩa đơn',N'6 Cấp','SUZUKI')

go

select username from taikhoan where username = 'nguyenvana'

select * from hoadon 

select * from sanpham where tenhang = 'HONDA'

select * from hang where not id = 1

update hang set  logo = 'Hinh\LOGO\HONDA.jpg' where tenhang = 'HONDA'

delete from sanpham where tensp = 'EXCITER 2021'

update sanpham set tensp = '',gia = '500000 VNĐ',hinhanh = '' ,kichthuoc = '',chieucaoyen = '',
sizebanh = '',engine = '',CC = '',congsuat = '',CCnhot = '',CCxang = '',phanh = '' ,gear = '' where id = 'h1'

