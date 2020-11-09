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

Create table sanpham
(id int, tensp nvarchar(100),gia bigint,hinhanh nvarchar(4000),
kichthuoc char(80),chieucaoyen char(20),sizebanh char(150),engine nvarchar(200),
CC char(20),congsuat nvarchar(50),CCnhot nvarchar(50),CCxang nvarchar(20),phanh nvarchar(50),gear nvarchar(20),primary key(id))
go

Create table hoadon
(MaHD char(100),username char(100),ngaymua date, primary key(MaHD))
go 

Create table ct_hoadon
(MaHD char(100),id int, soluong int, gia bigint, primary key(MAHD,id))
go 

alter table  ct_hoadon add constraint FK_CTHD_SP foreign key(id) references sanpham(id)
alter table ct_hoadon add constraint FK_CTHD_HD foreign key(MaHD) references hoadon(MaHD)  
alter table hoadon add constraint FK_HD_KH foreign key(username) references taikhoan(username) 
go

insert into admin values ('buingocduy','123')
go

insert into taikhoan values ('nguyenvana','123','nguyenvana@gmail.com',0904596810)
insert into taikhoan values ('nguyenvanb','123','nguyenvanb@gmail.com',0904596811)
insert into taikhoan values ('nguyenvanc','123','nguyenvanc@gmail.com',0904596812)
go

insert into sanpham values ('1','Click 2020','85','Hinh\vario.jpg',
'1919 x 679 x 1062 mm','769 mm','90/80-14 - 100/80- 14 48P Tubeless',N'PGM-Fi, xăng, 4 kỳ, 1 xy-lanh, làm mát bằng dung dịch',
'150 cc',N'9.7 kW (13.1 PS) / 8500 rpm','0,8L','5,5L',N'Thắng đĩa;Tang trống',N'Vô cấp')

insert into sanpham values ('2','Winner X','45','Hinh\winnerx.jpg',
'2.019 x 727 x 1.088 mm',' 795 mm','90/80-17M/C 46P Sau: 120/70-17M/C 58P',N'PGM-Fi, xăng, 4 kỳ, 1 xy-lanh, làm mát bằng dung dịch',
'149,1 cm3',N'11,5kW/9.000 vòng/phút',N'1.1 lít khi thay nhớt ; 1.3 lít khi rã máy','4,5L',N'Phanh đĩa;Phanh đĩa',N'6 Cấp')

insert into sanpham values ('3','CB150R SF','85','Hinh\CB150RSF.jpg',
'2.019 x 719 x 1.039 mm',' 797 mm','100/80-17 52P - 130/70-17 62P',N'4 thì, một xilanh, DOHC',
'149,16 cc',N'16,6 mã lực @ 9.000 vòng/phút',N'1.1 lít khi thay nhớt ; 1.3 lít khi rã máy','12L',N'Phanh đĩa;Phanh đĩa',N'6 Cấp')

insert into sanpham values ('4','Air Blade','50','Hinh\airblade.jpg',
'1.870mm x 686mm x 1.112mm','775 mm',N'90/80-14M/C 43P - 100/80 -14M/C 48P',N' Xăng, 4 kỳ, 1 xy lanh, làm mát bằng dung dịch',
'149,3 cm3',N'9,6kW/8.500 vòng/phút',N' 0,8 khi thay nhớt ; 0,9 khi rã máy','4,4L',N'Phanh đĩa ABS;Tang trống',N'Vô cấp')

insert into sanpham values ('5','Monkey 2020','85','Hinh\monkey.jpg',
'1.712 x 754 x 1.029 mm','776 mm','Maxxis Tortuga: 120/80-12 65J - 130/80-12 69J',N'SOHC xy-lanh đơn, làm mát bằng gió',
'125cc',N'9,6 mã lực tại 7.000 vòng/phút',N'0.9 lít khi thay nhớt ; 1.1 lít khi rã máy','5,7L',N'Phanh đĩa;Phanh đĩa',N'4 Cấp')

insert into sanpham values ('6','SH 2020','71','Hinh\SH.jpg',
'2.090 x 739 x 1.129 mm','799 mm','120/80-16 ; 100/80-16',N'PGM-FI, xăng, 4 kỳ, 1 xy-lanh, làm mát bằng dung dịch',
'124,8cm³ (SH 125i)',N'9,6kW/8.250 vòng/phút (SH 125i)',N'0,8 khi thay nhớt ; 0,9 khi rã máy','7,8L',N'Phanh đĩa ABS;Phanh đĩa',N'Vô cấp')
go

select * from taikhoan 
select * from sanpham where id='1' or id='2'

update taikhoan set password = '1233', email = 'abc@gamil.com' , phonenumber=0906999599 where username = 'nguyenthanhtuyen'

delete from sanpham where id = 'h4'

update sanpham set tensp = '',gia = '500000 VNĐ',hinhanh = '' ,kichthuoc = '',chieucaoyen = '',
sizebanh = '',engine = '',CC = '',congsuat = '',CCnhot = '',CCxang = '',phanh = '' ,gear = '' where id = 'h1'

