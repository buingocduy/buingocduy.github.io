Create database nguoidung

Use nguoidung
go

Create table taikhoan
(username char(100),password char(100),email char(100),phonenumber char(12),khoa bit, primary key(username))
go 

Create table sanpham
(id char(10), tensp nvarchar(100),gia nvarchar(50),hinhanh nvarchar(100),
kichthuoc char(80),chieucaoyen char(20),sizebanh char(150),engine nvarchar(200),
CC char(20),congsuat nvarchar(50),CCnhot nvarchar(50),CCxang nvarchar(20),phanh nvarchar(50),gear nvarchar(20),primary key(id))
go

insert into taikhoan values ('buingocduy','123','buingocduy1999@gmail.com',0904596810,1)
insert into taikhoan values ('nguyenthanhtuyen','123','thanhtuyen990322@gmail.com',0772767594,0)
go

insert into sanpham values ('h1','Click 2020',N'85.000.000 VNĐ','Hinh\vario.jpg',
'1919 x 679 x 1062 mm','769 mm','90/80-14 - 100/80- 14 48P Tubeless',N'PGM-Fi, xăng, 4 kỳ, 1 xy-lanh, làm mát bằng dung dịch',
'150 cc',N'9.7 kW (13.1 PS) / 8500 rpm','0,8L','5,5L',N'Thắng đĩa;Tang trống',N'Vô cấp')

insert into sanpham values ('h2','Winner X',N'45.000.000 VNĐ','Hinh\winnerx.jpg',
'2.019 x 727 x 1.088 mm',' 795 mm','90/80-17M/C 46P Sau: 120/70-17M/C 58P',N'PGM-Fi, xăng, 4 kỳ, 1 xy-lanh, làm mát bằng dung dịch',
'149,1 cm3',N'11,5kW/9.000 vòng/phút',N'1.1 lít khi thay nhớt ; 1.3 lít khi rã máy','4,5L',N'Phanh đĩa;Phanh đĩa',N'6 Cấp')

insert into sanpham values ('h2','CB150R ST','85.000.000VNĐ','Hinh\CB150RST.jpg')
insert into sanpham values ('h3','Winner X','45.000.000VNĐ','Hinh\winnerx.jpg')
insert into sanpham values ('h4','Air Blade','55.000.000VNĐ','Hinh\airblade.jpg')
insert into sanpham values ('h5','Monkey 2020','84.990.000VNĐ','Hinh\monkey.jpg')
insert into sanpham values ('h6','SH 2020','70.990.000VNĐ','Hinh\SH.jpg')
go


select * from taikhoan 
select * from sanpham 

update taikhoan set password = '123', email = 'abc@gamil.com' ,khoa =  1, phonenumber=0906999599 where username = 'nguyenthanhtuyen'

delete from sanpham where id = 'h2'

update sanpham set tensp = '',gia = '500000 VNĐ',hinhanh = '' ,kichthuoc = '',chieucaoyen = '',
sizebanh = '',engine = '',CC = '',congsuat = '',CCnhot = '',CCxang = '',phanh = '' ,gear = '' where id = 'h1'
