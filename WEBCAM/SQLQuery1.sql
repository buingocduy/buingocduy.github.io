Create database QLKH
go
use QLKH
go

--KHÁCH HÀNG
Create table khachhang
(STT int IDENTITY(1,1) NOT NULL,
	HOTEN nvarchar(100),
	SDT varchar(20),
	CMND varchar(20),
	NGAYVAO Datetime, 
	GIOVAO varchar(100), 
	TENCONGTY nvarchar(200),
	LYDOVAO nvarchar(4000),
	HINHANH varchar(500),
	HINHANHWEB varchar(500),
	primary key(STT))

go


insert into khachhang values (N'Anh Tài','00000000','0000000','2021-04-10' ,'05:21:22',N'Nhựa Rạng Đông',N'Đi làm','D:\WEBCAM\src\images\30-53-2021-09-53-13.jpg','images\30-53-2021-09-53-13.jpg')
insert into khachhang values (N'Anh Tài','00000000','0000000','2021-04-10' ,'06:21:22',N'Nhựa Rạng Đông',N'Đi làm','D:\WEBCAM\src\images\30-53-2021-09-53-13.jpg','images\30-53-2021-09-53-13.jpg')
insert into khachhang values (N'Anh Tài','00000000','0000000','2021-04-11' ,'05:21:22',N'Nhựa Rạng Đông',N'Đi làm','D:\WEBCAM\src\images\30-53-2021-09-53-13.jpg','images\30-53-2021-09-53-13.jpg')

DELETE FROM khachhang WHERE STT = '1' 

select * from khachhang where NGAYVAO between '03/30/2021' and '2021-04-10'

select * from khachhang order by NGAYVAO desc , GIOVAO desc

/*
SELECT
     khachhang."STT" AS khachhang_STT,
     khachhang."HOTEN" AS khachhang_HOTEN,
     khachhang."SDT" AS khachhang_SDT,
     khachhang."NGAYVAO" AS khachhang_NGAYVAO,
     khachhang."GIOVAO" AS khachhang_GIOVAO,
     khachhang."TENCONGTY" AS khachhang_TENCONGTY,
     khachhang."LYDOVAO" AS khachhang_LYDOVAO,
     khachhang."HINHANH" AS khachhang_HINHANH
FROM
     "dbo"."khachhang" khachhang
WHERE
     khachhang."NGAYVAO" = '04/01/2021'

*/