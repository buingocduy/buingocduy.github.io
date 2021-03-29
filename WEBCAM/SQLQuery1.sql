Create database QLKH
go
use QLKH
go

--KHÁCH HÀNG
Create table khachhang
(STT int IDENTITY(1,1) NOT NULL,
	HOTEN nvarchar(100),
	SDT varchar(20),
	NGAYVAO varchar(100), 
	GIOVAO varchar(100), 
	TENCONGTY nvarchar(200),
	LYDOVAO nvarchar(4000),
	HINHANH varchar(500),
	primary key(STT))

go


insert into khachhang values (N'DUY','0904596810','04/01/2021' ,'05:21:22',N'Nhựa Rạng Đông',N'Đi họp','G:\BuiNgocDuy\WEBCAM\src\images\2021-36-27-04-36-03.jpg')

DELETE FROM khachhang WHERE STT = '1' 

select * from khachhang where NGAYGIOVAO like '%04/01/2021%'

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