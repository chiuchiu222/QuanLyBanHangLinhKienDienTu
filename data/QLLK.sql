Create database QLLK
USE [QLLK]

CREATE TABLE [dbo].[ChiTietHD](
	[maHD] [nvarchar](30) NOT NULL,
	[maLinhKien] [nvarchar](10) NOT NULL,
	[soLuong] [int] NOT NULL,
	[donGia] [money] NOT NULL,
	[giamGia] [money] NOT NULL,
	[thanhTien] [money] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maHD] ASC,
	[maLinhKien] ASC
));
GO

CREATE TABLE [dbo].[HoaDon](
	[maHD] [nvarchar](30) NOT NULL,
	[maNhanVien] [nvarchar](10) NOT NULL,
	[maKhach] [nvarchar](10) NOT NULL,
	[ngayBan] [date] NULL,
	[tongTien] [money] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maHD] ASC
));
GO

CREATE TABLE [dbo].[KhachHang](
	[maKhach] [nvarchar](10) NOT NULL,
	[tenKhach] [nvarchar](50) NOT NULL,
	[diaChi] [nvarchar](50) NOT NULL,
	[dienThoai] [nvarchar](50) NOT NULL,
	[email] [nvarchar](50),
PRIMARY KEY CLUSTERED 
(
	[maKhach] ASC
));
GO

CREATE TABLE [dbo].[LinhKien](
	[maLinhkien] [nvarchar](10) NOT NULL,
	[tenLinhkien] [nvarchar](50) NOT NULL,
	[maLoai] [nvarchar](10) NOT NULL,
	[soLuong] [int] NOT NULL,
	[donGiaNhap] [money] NOT NULL,
	[donGiaBan] [money] NOT NULL,
	[ngayNhap] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maLinhkien] ASC
));
GO

CREATE TABLE [dbo].[Loai](
	[maLoai] [nvarchar](10) NOT NULL,
	[tenLoai] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maLoai] ASC
));
GO

CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [nvarchar](10) NOT NULL,
	[tenNhanVien] [nvarchar](50) NOT NULL,
	[gioiTinh] [bit] NOT NULL,
	[ngaySinh] [date] NULL,
	[diaChi] [nvarchar](50) NULL,
	[dienThoai] [nvarchar](50) NOT NULL,
	[email] [nvarchar](50) NULL,
	[luong][money] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
));
GO
ALTER TABLE [dbo].[ChiTietHD]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHD_HoaDon] FOREIGN KEY([maHD])
REFERENCES [dbo].[HoaDon] ([maHD])
GO
ALTER TABLE [dbo].[ChiTietHD] CHECK CONSTRAINT [FK_ChiTietHD_HoaDon]
GO
ALTER TABLE [dbo].[ChiTietHD]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHD_LinhKien] FOREIGN KEY([maLinhKien])
REFERENCES [dbo].[LinhKien] ([maLinhkien])
GO
ALTER TABLE [dbo].[ChiTietHD] CHECK CONSTRAINT [FK_ChiTietHD_LinhKien]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([maKhach])
REFERENCES [dbo].[KhachHang] ([maKhach])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[LinhKien]  WITH CHECK ADD  CONSTRAINT [FK_LinhKien_Loai] FOREIGN KEY([maLoai])
REFERENCES [dbo].[Loai] ([maLoai])
GO
ALTER TABLE [dbo].[LinhKien] CHECK CONSTRAINT [FK_LinhKien_Loai]
GO

---chen dữ liệu bảng loại
insert [dbo].[Loai] values ('BHP', 'Ban phim') 
insert [dbo].[Loai] values ('CXL', 'Chip xu ly') 
insert [dbo].[Loai] values ('MHI', 'Man hinh')
insert [dbo].[Loai] values ('CMH', 'Card man hinh')
insert [dbo].[Loai] values ('HDD', 'O cung HDD')
insert [dbo].[Loai] values ('SSD', 'O cung SSD')
insert [dbo].[Loai] values ('RAM', 'Bo nho Ram')
insert [dbo].[Loai] values ('CMT', 'Chuot may tinh')
insert [dbo].[Loai] values ('ADA', 'Adapter nguon')
insert [dbo].[Loai] values ('QTN', 'Quat tan nhiet')
insert [dbo].[Loai] values ('LMT', 'Loa may tinh')
insert [dbo].[Loai] values ('CAM', 'Webcam')
insert [dbo].[Loai] values ('CKN', 'Day cap ket noi')
go
--- chèn dữ liệu bảng nhân viên
insert [dbo].[NhanVien] values ('NV00001','Nguyen Hai Nam',0,'2001-09-28','Q12, TP.HCM','0123456789','hainamdev@gmail.com',4000)
insert [dbo].[NhanVien] values ('NV00002','Tran Thanh Tam',1,'2001-05-19','Q1, TP.HCM', '0111111111','tranthanhtam@gmail.com',5700)
insert [dbo].[NhanVien] values ('NV00003','Ngo Dinh Bao Yen',1,'2002-02-24','Di an, Binh Duong','0122222222','baoyen@gmail.com',4000)
insert [dbo].[NhanVien] values ('NV00004','Nguyen Quy Kha',0,'2000-07-27','Tuy Hoa, Phu Yen','0187654321','quykha@gmail.com',6200)
insert [dbo].[NhanVien] values ('NV00005','Nguyen Nhat Quang',0,'2001-05-12','Vong chom, Ben Tre','0123123123','nhatquang@gmail.com',4500)
insert [dbo].[NhanVien] values ('NV00006','Truong Thi Cam Ly',1,'2001-01-14','Thach Ha, Ha Tinh','0999999999','camly@gmail.com',6000)
go
--- chèn dữ liệu bảng Linh kiện

insert [dbo].[LinhKien] values ('LK00029','CPU Intel Core i5-9100F','CXL',0,2300,2899,'2020-09-12')
insert [dbo].[LinhKien] values ('LK00001','CPU Intel Core i3-9100F','CXL',20,1500,1799,'2020-10-12')
insert [dbo].[LinhKien] values ('LK00002','CPU Intel Core i3-10100F','CXL',10,2500,2799,'2020-10-19')
insert [dbo].[LinhKien] values ('LK00003','CPU Intel Core i3-8100','CXL',12,2900,3299,'2020-11-19')
insert [dbo].[LinhKien] values ('LK00004','CPU Intel Core i5-9400F','CXL',5,3000,3499,'2020-10-27')
insert [dbo].[LinhKien] values ('LK00005','CPU Intel Core i5-10400F','CXL',20,3800,4299,'2020-03-20')
insert [dbo].[LinhKien] values ('LK00006','CPU Intel Core i5-8400F','CXL',10,2500,2999,'2021-02-12')
insert [dbo].[LinhKien] values ('LK00007','CPU Intel Core i7-8700F','CXL',20,7300,7899,'2021-01-22')

insert [dbo].[LinhKien] values ('LK00008','Nguon Gigabyte PW400','ADA',30,500,799,'2021-01-12')
insert [dbo].[LinhKien] values ('LK00009','Nguon Deepcool DN450','ADA',15,520,799,'2021-02-20')
insert [dbo].[LinhKien] values ('LK00010','Nguon may tinh Cooler Master MWE400','ADA',12,600,899,'2020-12-19')
insert [dbo].[LinhKien] values ('LK00011','Nguon Deepcool DN500','ADA',5,790,999,'2021-02-27')
insert [dbo].[LinhKien] values ('LK00012','Nguon Gigabyte PB500','ADA',7,790,999,'2021-01-20')
insert [dbo].[LinhKien] values ('LK00013','Nguồn Gigabyte Aorus P850W','ADA',10,3400,3799,'2021-02-12')
insert [dbo].[LinhKien] values ('LK00014','Nguồn ANTEC EAG750','ADA',20,2300,2799,'2021-01-22')
insert [dbo].[LinhKien] values ('LK00034','Nguồn Gigabyte Aorus P550W','ADA',0,3400,3799,'2021-02-12')
insert [dbo].[LinhKien] values ('LK00035','Nguồn ANTEC EAG750GH','ADA',0,2500,2999,'2021-01-22')

insert [dbo].[LinhKien] values ('LK00015','Bàn phím cơ Rapoo V500 Alloy','BHP',10,500,799,'2021-01-12')
insert [dbo].[LinhKien] values ('LK00016','Bàn phím cơ Rapoo V500SE','BHP',15,520,799,'2021-02-20')
insert [dbo].[LinhKien] values ('LK00017','Bàn phím cơ HyperX Alloy','BHP',12,600,899,'2020-07-19')
insert [dbo].[LinhKien] values ('LK00018','Bàn phím cơ ZADEZ GT-03K','BHP',15,790,999,'2021-02-27')
insert [dbo].[LinhKien] values ('LK00019','Bàn phím cơ Durgod V104','BHP',10,790,999,'2021-01-20')
insert [dbo].[LinhKien] values ('LK00020','Bàn Phím cơ Kingston HyperX Alloy Origin','BHP',5,3400,3799,'2021-02-12')
insert [dbo].[LinhKien] values ('LK00021','Bàn phím cơ không dây Cooler Master SK621','BHP',9,2300,2799,'2021-01-22')
insert [dbo].[LinhKien] values ('LK00030','Bàn phím cơ Rapoo V450 Alloy','BHP',0,700,1099,'2021-01-12')
insert [dbo].[LinhKien] values ('LK00031','Bàn phím cơ Rapoo','BHP',0,620,999,'2021-02-20')

insert [dbo].[LinhKien] values ('LK00022','Webcam Logitech C170','CAM',10,500,799,'2021-01-12')
insert [dbo].[LinhKien] values ('LK00023','Webcam Logitech C270H','CAM',15,520,799,'2021-02-20')
insert [dbo].[LinhKien] values ('LK00024','Webcam Logitech C310','CAM',12,600,899,'2021-01-19')
insert [dbo].[LinhKien] values ('LK00025','Webcam Logitech C525','CAM',15,790,999,'2021-02-27')
insert [dbo].[LinhKien] values ('LK00026','Webcam Logitech C615','CAM',10,790,999,'2021-01-20')
insert [dbo].[LinhKien] values ('LK00027','Webcam Logitech C922','CAM',5,3400,3799,'2021-02-12')
insert [dbo].[LinhKien] values ('LK00028','Webcam Asus ROG Eye FullHD 60FPS','CAM',9,2300,2799,'2021-01-22')
insert [dbo].[LinhKien] values ('LK00032','Webcam Logitech E170','CAM',0,600,899,'2021-02-28')
insert [dbo].[LinhKien] values ('LK00033','Webcam Logitech D270H','CAM',0,1000,1499,'2021-02-20')

--MAX LK00072

insert [dbo].[LinhKien] values ('LK00036','Màn hình ASUS VG259Q','MHI',3,900,1499,'2020-09-20')
insert [dbo].[LinhKien] values ('LK00045','Màn hình ASUS VG279Q','MHI',5,356,531,'2021-02-23')
insert [dbo].[LinhKien] values ('LK00038','Màn hình ASUS VP279QGL','MHI',2,762,953,'2021-01-29')
insert [dbo].[LinhKien] values ('LK00041','Màn hình LG 24GL600F-B','MHI',7,893,942,'2020-12-10')
insert [dbo].[LinhKien] values ('LK00040','Màn hình ASUS ROG STRIX XG279Q-G','MHI',3,189,351,'2021-02-21')
insert [dbo].[LinhKien] values ('LK00042','Màn hình ASUS PROART PA278QV','MHI',8,762,942,'2020-11-18')

insert [dbo].[LinhKien] values ('LK00043','CARD Màn hình NVIDIA QUADRO P2200','CMH',3,172,351,'2021-01-30')
insert [dbo].[LinhKien] values ('LK00044','VGA CARD NVIDIA QUADRO P620 2GB GDDR5','CMH',5,1008,1499,'2021-02-21')
insert [dbo].[LinhKien] values ('LK00056','CARD Màn hình INNO3D GTX 1050TI','CMH',6,953,1499,'2020-02-15')
insert [dbo].[LinhKien] values ('LK00046','CARD Màn hình INNO3D RTX 3070 ICHILL X4','CMH',1,831,953,'2020-01-30')
insert [dbo].[LinhKien] values ('LK00047','CARD Màn hình PALIT GTX 1050TI STORMX','CMH',3,753,832,'2021-01-16')
insert [dbo].[LinhKien] values ('LK00037','CARD Màn hình INNO3D RTX 3070 ICHILL X3','CMH',9,469,651,'2021-02-13')

insert [dbo].[LinhKien] values ('LK00049','HDD Seagate Barracuda 1TB 7200rpmH','HDD',2,972,1498,'2020-02-25')
insert [dbo].[LinhKien] values ('LK00050','HDD Seagate 1TB 2.5inch SATA 3 - ST1000LM048','HDD',3,823,1131,'2021-01-27')
insert [dbo].[LinhKien] values ('LK00062','HDD 3TB Blue 5400rpm','HDD',5,753,964,'2021-03-14')
insert [dbo].[LinhKien] values ('LK00052','HDD WD Red 2TB 5400rpm','HDD',3,783,842,'2020-12-20')
insert [dbo].[LinhKien] values ('LK00053','HDD Blue 6TB 5400rpm','HDD',9,981,1893,'2020-11-24')

insert [dbo].[LinhKien] values ('LK00039','SSD SAMSUNG 860 EVO 1TB 2.5 INCH SATA3','SSD',3,753,832,'2020-11-28')
insert [dbo].[LinhKien] values ('LK00054','SSD ADATA SU650 120GB 2.5 INCH SATA3','SSD',1,513,762,'2021-01-20')
insert [dbo].[LinhKien] values ('LK00055','SSD WD BLUE 250GB M.2 SATA III','SSD',6,942,1488,'2020-02-24')
insert [dbo].[LinhKien] values ('LK00069','SSD KINGSTON A400 120GB 2.5 INCH SATA3','SSD',4,573,751,'2021-03-19')
insert [dbo].[LinhKien] values ('LK00057','SSD SAMSUNG 860 EVO 250GB M.2 2280','SSD',9,1103,1499,'2021-01-20')

insert [dbo].[LinhKien] values ('LK00071','RAM DESKTOP GSKILL TRIDENT Z NEO','RAM',4,245,531,'2021-02-20')
insert [dbo].[LinhKien] values ('LK00048','RAM DESKTOP DDR4 MICRON ECC 16GB/2133MHZ','RAM',3,953,1478,'2020-04-18')
insert [dbo].[LinhKien] values ('LK00059','RAM 4 KINGSTON ECC 16GB/2666MHZ','RAM',5,753,861,'2020-11-28')
insert [dbo].[LinhKien] values ('LK00060','RAM DESKTOP AVEXIR 1BW BUDGET 8GB','RAM',4,783,852,'2020-12-05')
insert [dbo].[LinhKien] values ('LK00061','RAM KINGMAX Zeus RGB 16GB','RAM',7,953,1583,'2021-12-09')
insert [dbo].[LinhKien] values ('LK00063','RAM DESKTOP KINGSTON HYPERX FURY RBG','RAM',4,782,942,'2021-02-08')
insert [dbo].[LinhKien] values ('LK00074','RAM Laptop Kingston 4GB 2666MHz DDR4 CL19','RAM',2,531,682,'2020-12-09')

insert [dbo].[LinhKien] values ('LK00066','Chuột LANJUN M1344 PLUS VIRGOROUS','CMT',4,564,831,'2021-01-22')
insert [dbo].[LinhKien] values ('LK00058','Chuột FUHLEN M70 OPTICAL WIRELESS ĐEN','CMT',6,153,315,'2021-01-05')
insert [dbo].[LinhKien] values ('LK00068','Chuột LOGITECH G604 LIGHTSPEED WIRELESS HERO GAMING BLACK','CMT',7,753, 864,'2020-03-20')
insert [dbo].[LinhKien] values ('LK00051','Chuột RAPOO N120 ĐEN','CMT',4,641,851,'2021-02-09')

insert [dbo].[LinhKien] values ('LK00073','Quạt case Xigmatek X20F (RGB FIXED)','QTN',0,642,783,'2020-02-19')
insert [dbo].[LinhKien] values ('LK00070','Quạt CPU ID-COOLING SE-234-RGB','QTN',0,315,624,'2020-01-05')
insert [dbo].[LinhKien] values ('LK00064','Quạt CPU ID-Cooling SE-224-RGB','QTN',0,943,1125,'2021-01-20')
insert [dbo].[LinhKien] values ('LK00072','Quạt case ID-COOLING DF-12025-ARGB TRIO','QTN',0,521,657,'2021-02-04')
insert [dbo].[LinhKien] values ('LK00065','Quạt CPU ID-Cooling SE-214-LGA115X','QTN',0,612,842,'2020-12-20')
--Max LK00084
insert [dbo].[LinhKien] values ('LK00084','Loa vi tính Microlab M-108BT','LMT',2,531,682,'2020-12-09')
insert [dbo].[LinhKien] values ('LK00074','Loa Vi Tính 2.1 Microlab M108','LMT',3,953,1478,'2020-04-18')
insert [dbo].[LinhKien] values ('LK00080','Loa Vi Tính 2.1 SOUNDMAX A980','LMT',4,245,531,'2021-02-20')
insert [dbo].[LinhKien] values ('LK00076','Loa Vi Tính 2.1 Microlab M108','LMT',4,783,852,'2020-12-05')
insert [dbo].[LinhKien] values ('LK00077','Loa Vi Tính SOUNDMAX A826','LMT',7,953,1583,'2021-12-09')
insert [dbo].[LinhKien] values ('LK00078','Loa Vi Tính 4.1 MICROTEK MT-665BT ','LMT',4,782,942,'2021-02-08')

insert [dbo].[LinhKien] values ('LK00079','RAM Laptop Kingston 4GB 2666MHz DDR4 CL19','CKN',5,453,682,'2020-12-09')
insert [dbo].[LinhKien] values ('LK00075','RAM 4 KINGSTON ECC 16GB/2666MHZ','CKN',7,586,753,'2020-11-28')
insert [dbo].[LinhKien] values ('LK00082','RAM 4 KINGSTON ECC 16GB/2666MHZ','CKN',9,864,1057,'2020-11-28')
insert [dbo].[LinhKien] values ('LK00083','RAM DESKTOP AVEXIR 1BW BUDGET 8GB','CKN',3,237,587,'2020-12-05')
insert [dbo].[LinhKien] values ('LK00081','RAM DESKTOP DDR4 MICRON ECC 16GB/2133MHZ','CKN',2,257,357,'2020-04-18')
insert [dbo].[LinhKien] values ('LK00073','RAM DESKTOP GSKILL TRIDENT Z NEO','CKN',1,672,865,'2021-02-20')

go

---cái này insert rồi
insert [dbo].[KhachHang] values ('KH00001','Nguyen Thi Binh','Q12, TP.HCM','0342567832' , 'binh@gmail.com' )
insert [dbo].[KhachHang] values ('KH00002','Tran Binh Trong','Q1, TP.HCM','0897667832' , 'binhtrong@gmail.com' )
insert [dbo].[KhachHang] values ('KH00003','Tran Van Cuong','Dong Thap','0867634763' , 'cuong19012002@gmail.com' )
insert [dbo].[KhachHang] values ('KH00004','Nguyen Van Chien','Vong Chom, Ben Tre','0882629034' , '01633583298chien@gmail.com' )
insert [dbo].[KhachHang] values ('KH00005','Nguyen Van Danh','Quang Ngai','0973593883' , 'tdanh9508@gmail.com' )
insert [dbo].[KhachHang] values ('KH00006','Hoang Quoc Duy','Phu Yen','0384746022' , 'Justinduy81@gmail.com' )
insert [dbo].[KhachHang] values ('KH00007','Pham Quoc Duy','Q9, TP.HCM','0387608723' , 'phamquocduy2402@gmail.com' )
insert [dbo].[KhachHang] values ('KH00008','Tran Thuy Duong','Thanh Xuan, Ha Noi','0292315215' , 'thuyduongheocon809@gmail.com' )
insert [dbo].[KhachHang] values ('KH00009','Ngo Tan Dat','Binh Thanh, TP.HCM','0864328982' , 'ngotandat26112002@gmail.com' )
insert [dbo].[KhachHang] values ('KH00010','Tran Thi Thao Nhi','Bac Lieu','0925814342' , 'nime63526332@gmail.com' )
insert [dbo].[KhachHang] values ('KH00011','Hoang Thi Hien','Ca Mau','0844784378' , 'hoanghienle69@gmail.com' )
insert [dbo].[KhachHang] values ('KH00012','Tran Van Tran','Cao Bang','0354656797' , 'trantran.th8@gmail.com' )
insert [dbo].[KhachHang] values ('KH00013','Nguyen Quoc Thao','Ba Ria Vung Tau','0996589477' , 'acquynhobebong@gmail.com' )
insert [dbo].[KhachHang] values ('KH00014','Dinh Le Hong Nhung','Da Nang','0322554566' , 'Comotkhonghai59@gmail.com' )
insert [dbo].[KhachHang] values ('KH00015','Vo Quoc Khang','Ha Nam','0755899787' , 'vohvkhang@gmail.com' )
insert [dbo].[KhachHang] values ('KH00016','Ly Hai Huy','Ha Tinh','0745554267' , 'zed155200@gmail.com' )
insert [dbo].[KhachHang] values ('KH00017','Dinh Yen Nhung','Lang Son','0255469767' , 'hivongseth3@gmail.com' )
insert [dbo].[KhachHang] values ('KH00018','Luu Van Hoang','Ha Giang','0123344537' , 'Luuhoang06102002@gmail.com' )
insert [dbo].[KhachHang] values ('KH00019','Tran Binh Minh','Thach That, Ha Noi','0365678605' , 'minh2452@gmail.com' )
insert [dbo].[KhachHang] values ('KH00020','Tran Binh Trong Nam','Quang Tri','0567858565' , 'nam260102@gmail.com.vn' )
insert [dbo].[KhachHang] values ('KH00021','Tran Van Ngoc','Q3, TP.HCM','0474674545' , 'vanngocpentakill@gmail.com' )
insert [dbo].[KhachHang] values ('KH00022','Nguyen Thanh Nhan','Q1, TP.HCM','0694472266' , 'Thanhnhan16.2.2002@gmail.com' )
insert [dbo].[KhachHang] values ('KH00023','Tran Van Chi','Tay Ninh','0335445678' , 'Pdnchannel1@gmail.com' )
insert [dbo].[KhachHang] values ('KH00024','Dinh Van Huy','Binh Duong','0333243235' , 'phatassassin06062002@gmail.com' )
insert [dbo].[KhachHang] values ('KH00025','Hoang Thanh phong','Binh Phuoc','0757895997' , 'phongthcshp500@gmail.com' )
insert [dbo].[KhachHang] values ('KH00026','Dinh Huy Sang','Long AN','0134343446' , 'sangnn8@gmail.com')
go

insert [dbo].[HoaDon] values ('HD00001','NV00001','KH00001','2021-05-19','6598')
insert [dbo].[HoaDon] values ('HD00002','NV00005','KH00002','2021-03-23','4798')
insert [dbo].[HoaDon] values ('HD00003','NV00006','KH00003','2021-01-15','4697')
insert [dbo].[HoaDon] values ('HD00004','NV00003','KH00004','2021-02-23','6498')
insert [dbo].[HoaDon] values ('HD00005','NV00004','KH00005','2021-03-29','1998')
insert [dbo].[HoaDon] values ('HD00006','NV00003','KH00006','2021-01-01','9996')
insert [dbo].[HoaDon] values ('HD00007','NV00001','KH00007','2021-02-23','6698')
insert [dbo].[HoaDon] values ('HD00008','NV00005','KH00008','2021-01-24','1598')
insert [dbo].[HoaDon] values ('HD00009','NV00001','KH00009','2021-05-12','999')
insert [dbo].[HoaDon] values ('HD00010','NV00005','KH00010','2021-03-23','4498')
insert [dbo].[HoaDon] values ('HD00011','NV00006','KH00011','2021-01-17','14595')
insert [dbo].[HoaDon] values ('HD00012','NV00003','KH00012','2021-02-28','1499')
insert [dbo].[HoaDon] values ('HD00013','NV00004','KH00013','2021-03-25','8998')
insert [dbo].[HoaDon] values ('HD00014','NV00003','KH00014','2021-01-30','999')
insert [dbo].[HoaDon] values ('HD00015','NV00001','KH00015','2021-02-23','4996')
insert [dbo].[HoaDon] values ('HD00016','NV00005','KH00016','2021-01-25','16196')

insert [dbo].[HoaDon] values ('HD00017','NV00001','KH00017','2021-05-17','3599')

insert [dbo].[HoaDon] values ('HD00018','NV00005','KH00018','2021-03-12','4997')

insert [dbo].[HoaDon] values ('HD00019','NV00006','KH00019','2021-01-23','4199')

insert [dbo].[HoaDon] values ('HD00020','NV00003','KH00020','2021-02-10','4698')

insert [dbo].[HoaDon] values ('HD00021','NV00004','KH00021','2021-03-04','3799')

insert [dbo].[HoaDon] values ('HD00022','NV00003','KH00022','2021-01-01','3599')

insert [dbo].[HoaDon] values ('HD00023','NV00001','KH00023','2021-02-12','3799')

insert [dbo].[HoaDon] values ('HD00024','NV00005','KH00024','2021-01-16','5098')

insert [dbo].[HoaDon] values ('HD00025','NV00001','KH00025','2021-02-12','999')

insert [dbo].[HoaDon] values ('HD00026','NV00005','KH00026','2021-03-16','1898')
go

insert [dbo].[ChiTietHD] values ('HD00001','LK00027',1,3799,0,3799)
insert [dbo].[ChiTietHD] values ('HD00001','LK00014',1,2799,0,2799)

insert [dbo].[ChiTietHD] values ('HD00002','LK00027',1,3799,0,3799)
insert [dbo].[ChiTietHD] values ('HD00002','LK00019',1,999,0,999)

insert [dbo].[ChiTietHD] values ('HD00003','LK00017',1,899,0,899)
insert [dbo].[ChiTietHD] values ('HD00003','LK00025',1,999,0,999)

insert [dbo].[ChiTietHD] values ('HD00004','LK00027',1,3799,100,3699)
insert [dbo].[ChiTietHD] values ('HD00004','LK00035',1,2999,0,2799)

insert [dbo].[ChiTietHD] values ('HD00005','LK00025',2,999,0,1998)

insert [dbo].[ChiTietHD] values ('HD00006','LK00028',1,2799,0,2799)
insert [dbo].[ChiTietHD] values ('HD00006','LK00005',1,4299,100,4199)
insert [dbo].[ChiTietHD] values ('HD00006','LK00033',2,1499,0,2998)

insert [dbo].[ChiTietHD] values ('HD00007','LK00029',1,2899,100,2899)
insert [dbo].[ChiTietHD] values ('HD00007','LK00013',1,3799,0,3799)

insert [dbo].[ChiTietHD] values ('HD00008','LK00023',2,799,0,799)

insert [dbo].[ChiTietHD] values ('HD00009','LK00026',1,999,0,999)

insert [dbo].[ChiTietHD] values ('HD00010','LK00012',1,999,100,899)
insert [dbo].[ChiTietHD] values ('HD00010','LK00004',1,3499,0,3499)

insert [dbo].[ChiTietHD] values ('HD00011','LK00034',1,3799,200,3599)
insert [dbo].[ChiTietHD] values ('HD00011','LK00005',1,4299,100,4199)
insert [dbo].[ChiTietHD] values ('HD00011','LK00033',2,1499,0,2998)
insert [dbo].[ChiTietHD] values ('HD00011','LK00027',1,3799,0,3799)

insert [dbo].[ChiTietHD] values ('HD00012','LK00033',1,1499,0,1499)

insert [dbo].[ChiTietHD] values ('HD00013','LK00007',1,3799,200,7899)
insert [dbo].[ChiTietHD] values ('HD00013','LK00011',1,4299,100,999)

insert [dbo].[ChiTietHD] values ('HD00014','LK00019',1,999,0,999)

insert [dbo].[ChiTietHD] values ('HD00015','LK00033',2,1499,0,2998)
insert [dbo].[ChiTietHD] values ('HD00015','LK00025',2,999,0,1998)

insert [dbo].[ChiTietHD] values ('HD00016','LK00022',1,3799,200,3599)
insert [dbo].[ChiTietHD] values ('HD00016','LK00001',3,4299,300,12597)

insert [dbo].[ChiTietHD] values ('HD00017','LK00022',1,3799,200,3599)

insert [dbo].[ChiTietHD] values ('HD00018','LK00026',2,999,0,1998)
insert [dbo].[ChiTietHD] values ('HD00018','LK00006',1,2999,0,2999)

insert [dbo].[ChiTietHD] values ('HD00019','LK00005',1,4299,100,4199)

insert [dbo].[ChiTietHD] values ('HD00020','LK00032',1,899,0,899)
insert [dbo].[ChiTietHD] values ('HD00020','LK00020',1,3799,0,3799)

insert [dbo].[ChiTietHD] values ('HD00021','LK00020',1,3799,0,3799)

insert [dbo].[ChiTietHD] values ('HD00022','LK00022',1,3799,200,3599)

insert [dbo].[ChiTietHD] values ('HD00023','LK00027',1,3799,0,3799)

insert [dbo].[ChiTietHD] values ('HD00024','LK00017',1,899,0,899)
insert [dbo].[ChiTietHD] values ('HD00024','LK00005',1,4299,100,4199)

insert [dbo].[ChiTietHD] values ('HD00025','LK00026',1,999,0,999)

insert [dbo].[ChiTietHD] values ('HD00026','LK00017',1,899,0,899)
insert [dbo].[ChiTietHD] values ('HD00026','LK00025',1,999,0,999)
go

select cthd.maLinhKien, [tenLinhkien], [maLoai], [donGiaBan], soLuong = sum(cthd.soLuong) , doanhThu =  sum(thanhTien), Tu = min(ngayban),Den = Max(ngayBan) 
from [dbo].[ChiTietHD] cthd join [dbo].[LinhKien] lk on cthd.maLinhKien = lk.maLinhKien join [dbo].[HoaDon] hd on cthd.maHD = hd.maHD
---where hd.ngayBan >= '2021-05-18' and hd.ngayBan <= '2021-05-20'
group by cthd.maLinhKien, [tenLinhkien], [maLoai], [donGiaBan]


 