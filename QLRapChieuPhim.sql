IF (EXISTS(SELECT * FROM sys.databases WHERE name = 'QLRapChieuPhim'))
USE master;
GO

-- Đặt chế độ SINGLE_USER để đóng các kết nối khác
ALTER DATABASE QLRapChieuPhim SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
GO

-- Xóa database
DROP DATABASE QLRapChieuPhim;
GO

CREATE DATABASE QLRapChieuPhim;
GO

USE QLRapChieuPhim;
GO

CREATE TABLE Phim (
    MaPhim NVARCHAR(10) PRIMARY KEY,
    TenPhim NVARCHAR(100) NOT NULL,
    TheLoai NVARCHAR(50),
    ThoiLuong INT,
    NgayKhoiChieu DATE,
    HinhAnh NVARCHAR(400),
	DaoDien NVARCHAR(100),
	DienVien NVARCHAR(100),
    MoTa NVARCHAR(500)
);

CREATE TABLE PhongChieu (
    MaPhong NVARCHAR(10) PRIMARY KEY,
    TenPhong NVARCHAR(50),
    SoGhe INT
);

CREATE TABLE SuatChieu (
    MaSuatChieu NVARCHAR(10) PRIMARY KEY,
    MaPhim NVARCHAR(10),
    MaPhong NVARCHAR(10),
    GioChieu DATETIME,
    GiaVe DECIMAL(10,2),
    TrangThai NVARCHAR(20),
    CONSTRAINT FK_SuatChieu_Phim FOREIGN KEY (MaPhim) REFERENCES Phim(MaPhim),
    CONSTRAINT FK_SuatChieu_PhongChieu FOREIGN KEY (MaPhong) REFERENCES PhongChieu(MaPhong)
);

CREATE TABLE Ghe (
    MaGhe NVARCHAR(10) PRIMARY KEY,
    MaPhong NVARCHAR(10),
    TenGhe NVARCHAR(10),
    CONSTRAINT FK_Ghe_PhongChieu FOREIGN KEY (MaPhong) REFERENCES PhongChieu(MaPhong)
);

CREATE TABLE TaiKhoan (
    Id NVARCHAR(10) PRIMARY KEY,
    Username NVARCHAR(50) UNIQUE,
    Email NVARCHAR(100),
    Phone NVARCHAR(20),
    Password NVARCHAR(100),
    Role NVARCHAR(255) DEFAULT 'user' CHECK (LEN(Role) > 0),
    Name NVARCHAR(100),
    Sex NVARCHAR(5),
    TrangThai NVARCHAR(20) DEFAULT N'Đang hoạt động',  -- Trạng thái: Hoạt động, Khoá, ...
    CreatedAt DATETIME DEFAULT GETDATE()
);

CREATE TABLE Ve (
    MaVe NVARCHAR(10) PRIMARY KEY,
    MaSuatChieu NVARCHAR(10),
    MaGhe NVARCHAR(10),
	IdTaiKhoan NVARCHAR(10),
    TrangThai NVARCHAR(20),
    ThoiGianDat DATETIME,
    
    CONSTRAINT UQ_Ve UNIQUE (MaSuatChieu, MaGhe),
    CONSTRAINT FK_Ve_SuatChieu FOREIGN KEY (MaSuatChieu) REFERENCES SuatChieu(MaSuatChieu),
    CONSTRAINT FK_Ve_Ghe FOREIGN KEY (MaGhe) REFERENCES Ghe(MaGhe),
	CONSTRAINT FK_Ve_TaiKhoan FOREIGN KEY (IdTaiKhoan) REFERENCES TaiKhoan(Id)
 
);

CREATE TABLE HoaDon (
    MaHD NVARCHAR(10) PRIMARY KEY,
    IdTaiKhoan NVARCHAR(10),
    NgayLap DATETIME DEFAULT GETDATE(),
    TongTien DECIMAL(10, 2),
    GhiChu NVARCHAR(255),

    CONSTRAINT FK_HoaDon_TaiKhoan FOREIGN KEY (IdTaiKhoan) REFERENCES TaiKhoan(Id)
);

CREATE TABLE ChiTietHoaDon (
    MaHD NVARCHAR(10),
    MaVe NVARCHAR(10),
    PRIMARY KEY (MaHD, MaVe),

    CONSTRAINT FK_CTHD_HoaDon FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
    CONSTRAINT FK_CTHD_Ve FOREIGN KEY (MaVe) REFERENCES Ve(MaVe)
);

INSERT INTO PhongChieu (MaPhong, TenPhong, SoGhe) VALUES 
('P01', 'Phòng 1', 40),
('P02', 'Phòng 2', 40),
('P03', 'Phòng 3', 40)

INSERT INTO Ghe (MaGhe, MaPhong, TenGhe) VALUES
('P01_A1','P01','A1'), ('P01_A2','P01','A2'), ('P01_A3','P01','A3'), ('P01_A4','P01','A4'), ('P01_A5','P01','A5'), ('P01_A6','P01','A6'), ('P01_A7','P01','A7'), ('P01_A8','P01','A8'),
('P01_B1','P01','B1'), ('P01_B2','P01','B2'), ('P01_B3','P01','B3'), ('P01_B4','P01','B4'), ('P01_B5','P01','B5'), ('P01_B6','P01','B6'), ('P01_B7','P01','B7'), ('P01_B8','P01','B8'),
('P01_C1','P01','C1'), ('P01_C2','P01','C2'), ('P01_C3','P01','C3'), ('P01_C4','P01','C4'), ('P01_C5','P01','C5'), ('P01_C6','P01','C6'), ('P01_C7','P01','C7'), ('P01_C8','P01','C8'),
('P01_D1','P01','D1'), ('P01_D2','P01','D2'), ('P01_D3','P01','D3'), ('P01_D4','P01','D4'), ('P01_D5','P01','D5'), ('P01_D6','P01','D6'), ('P01_D7','P01','D7'), ('P01_D8','P01','D8'),
('P01_E1','P01','E1'), ('P01_E2','P01','E2'), ('P01_E3','P01','E3'), ('P01_E4','P01','E4'), ('P01_E5','P01','E5'), ('P01_E6','P01','E6'), ('P01_E7','P01','E7'), ('P01_E8','P01','E8');

-- Ghế phòng P02
INSERT INTO Ghe (MaGhe, MaPhong, TenGhe) VALUES
('P02_A1','P02','A1'), ('P02_A2','P02','A2'), ('P02_A3','P02','A3'), ('P02_A4','P02','A4'), ('P02_A5','P02','A5'), ('P02_A6','P02','A6'), ('P02_A7','P02','A7'), ('P02_A8','P02','A8'),
('P02_B1','P02','B1'), ('P02_B2','P02','B2'), ('P02_B3','P02','B3'), ('P02_B4','P02','B4'), ('P02_B5','P02','B5'), ('P02_B6','P02','B6'), ('P02_B7','P02','B7'), ('P02_B8','P02','B8'),
('P02_C1','P02','C1'), ('P02_C2','P02','C2'), ('P02_C3','P02','C3'), ('P02_C4','P02','C4'), ('P02_C5','P02','C5'), ('P02_C6','P02','C6'), ('P02_C7','P02','C7'), ('P02_C8','P02','C8'),
('P02_D1','P02','D1'), ('P02_D2','P02','D2'), ('P02_D3','P02','D3'), ('P02_D4','P02','D4'), ('P02_D5','P02','D5'), ('P02_D6','P02','D6'), ('P02_D7','P02','D7'), ('P02_D8','P02','D8'),
('P02_E1','P02','E1'), ('P02_E2','P02','E2'), ('P02_E3','P02','E3'), ('P02_E4','P02','E4'), ('P02_E5','P02','E5'), ('P02_E6','P02','E6'), ('P02_E7','P02','E7'), ('P02_E8','P02','E8');

-- Ghế phòng P03
INSERT INTO Ghe (MaGhe, MaPhong, TenGhe) VALUES
('P03_A1','P03','A1'), ('P03_A2','P03','A2'), ('P03_A3','P03','A3'), ('P03_A4','P03','A4'), ('P03_A5','P03','A5'), ('P03_A6','P03','A6'), ('P03_A7','P03','A7'), ('P03_A8','P03','A8'),
('P03_B1','P03','B1'), ('P03_B2','P03','B2'), ('P03_B3','P03','B3'), ('P03_B4','P03','B4'), ('P03_B5','P03','B5'), ('P03_B6','P03','B6'), ('P03_B7','P03','B7'), ('P03_B8','P03','B8'),
('P03_C1','P03','C1'), ('P03_C2','P03','C2'), ('P03_C3','P03','C3'), ('P03_C4','P03','C4'), ('P03_C5','P03','C5'), ('P03_C6','P03','C6'), ('P03_C7','P03','C7'), ('P03_C8','P03','C8'),
('P03_D1','P03','D1'), ('P03_D2','P03','D2'), ('P03_D3','P03','D3'), ('P03_D4','P03','D4'), ('P03_D5','P03','D5'), ('P03_D6','P03','D6'), ('P03_D7','P03','D7'), ('P03_D8','P03','D8'),
('P03_E1','P03','E1'), ('P03_E2','P03','E2'), ('P03_E3','P03','E3'), ('P03_E4','P03','E4'), ('P03_E5','P03','E5'), ('P03_E6','P03','E6'), ('P03_E7','P03','E7'), ('P03_E8','P03','E8');

INSERT INTO Phim (MaPhim, TenPhim, TheLoai, ThoiLuong, NgayKhoiChieu, HinhAnh, DaoDien, DienVien, MoTa) VALUES
('P001', N'Avengers: Endgame', N'Hành động, Khoa học viễn tưởng', 181, '2019-04-26', 'avengers.jpg', N'Anthony Russo, Joe Russo', N'Robert Downey Jr., Chris Evans, Mark Ruffalo',
N'Avengers: Endgame là phần cuối của cuộc chiến với Thanos, nơi các siêu anh hùng còn sống sót hợp lực để đảo ngược sự tàn phá và đưa mọi người trở lại. Một hành trình đầy cảm xúc và sử thi.'),

('P002', N'Frozen II', N'Hoạt hình, Phiêu lưu, Âm nhạc', 103, '2019-11-22', 'frozen2.jpg', N'Chris Buck, Jennifer Lee', N'Idina Menzel, Kristen Bell, Josh Gad',
N'Elsa và Anna bước vào hành trình mới để khám phá nguồn gốc sức mạnh của Elsa và cứu lấy vương quốc Arendelle khỏi một mối nguy hiểm cổ xưa.'),

('P003', N'Inception', N'Hành động, Khoa học viễn tưởng', 148, '2010-07-16', 'inception.jpg', N'Christopher Nolan', N'Leonardo DiCaprio, Joseph Gordon-Levitt',
N'Một kẻ trộm chuyên nghiệp có khả năng xâm nhập vào giấc mơ để đánh cắp thông tin được thuê để cấy một ý tưởng vào tiềm thức của mục tiêu.'),

('P004', N'Interstellar', N'Khoa học viễn tưởng, Phiêu lưu', 169, '2014-11-07', 'interstellar.jpg', N'Christopher Nolan', N'Matthew McConaughey, Anne Hathaway',
N'Trong bối cảnh Trái Đất đang chết dần, một nhóm phi hành gia vượt không gian tìm hành tinh mới cho loài người. Một tác phẩm đầy tính nhân văn và khoa học.'),

('P005', N'Parasite', N'Tâm lý, Kịch tính', 132, '2019-05-30', 'parasite.jpg', N'Bong Joon-ho', N'Song Kang-ho, Choi Woo-shik, Park So-dam',
N'Câu chuyện về sự chênh lệch giàu nghèo qua lăng kính của hai gia đình: một giàu sang và một nghèo đói, đan xen các yếu tố hài hước đen tối và bi kịch.'),

('P006', N'Spiderman: No Way Home', N'Hành động, Khoa học viễn tưởng', 148, '2021-12-17', 'spiderman.jpg', N'Jon Watts', N'Tom Holland, Zendaya, Benedict Cumberbatch',
N'Sau khi danh tính bị lộ, Peter Parker tìm đến Doctor Strange để thay đổi quá khứ – nhưng điều này gây ra sự rối loạn trong đa vũ trụ.'),

('P007', N'Joker', N'Tâm lý, Hình sự', 122, '2019-10-04', 'joker.jpg', N'Todd Phillips', N'Joaquin Phoenix, Robert De Niro',
N'Bối cảnh Gotham đầy hỗn loạn, Arthur Fleck – một người bị xã hội ruồng bỏ – dần biến thành kẻ phản diện Joker nổi tiếng.'),

('P008', N'Titanic', N'Tình cảm, Lịch sử', 195, '1997-12-19', 'titanic.jpg', N'James Cameron', N'Leonardo DiCaprio, Kate Winslet',
N'Một câu chuyện tình bi thương giữa Jack và Rose trên con tàu Titanic huyền thoại, dẫn đến một kết cục đầy nước mắt và mất mát.'),

('P009', N'Your Name', N'Tình cảm, Hoạt hình, Siêu nhiên', 112, '2016-08-26', 'yourname.jpg', N'Makoto Shinkai', N'Ryunosuke Kamiki, Mone Kamishiraishi',
N'Hai học sinh trung học ở hai vùng khác nhau tỉnh dậy trong cơ thể của nhau và dần kết nối bởi sợi dây định mệnh kỳ lạ.'),

('P010', N'The Dark Knight', N'Hành động, Hình sự', 152, '2008-07-18', 'joker.jpg', N'Christopher Nolan', N'Christian Bale, Heath Ledger',
N'Batman đối đầu với Joker – một tên tội phạm hỗn loạn, trong trận chiến giữa công lý và hỗn loạn, làm thay đổi Gotham mãi mãi.');

INSERT INTO Phim (MaPhim, TenPhim, TheLoai, ThoiLuong, NgayKhoiChieu, HinhAnh, DaoDien, DienVien, MoTa) VALUES
('P011', N'Mission: Impossible – The Final Reckoning', N'Hành động, Gián điệp', 170, '2025-05-23', 'mi_final_reckoning.jpg', N'Christopher McQuarrie', N'Tom Cruise, Simon Pegg, Ving Rhames, Hayley Atwell', N'Điệp viên Ethan Hunt cùng đồng đội đối mặt với mối đe dọa AI toàn cầu trong phần kết của loạt Mission: Impossible.'),  
('P012', N'Captain America: Brave New World', N'Siêu anh hùng, Hành động', 130, '2025-02-14', 'captain_america_bnw.jpg', N'Julius Onah', N'Anthony Mackie, Harrison Ford, Danny Ramirez', N'Sam Wilson đảm nhận danh hiệu Captain America, chống lại âm mưu quốc tế đầy nguy hiểm.'),  
('P013', N'Snow White (2025)', N'Phiêu lưu, Nhạc kịch, Fantasy', 109, '2025-03-01', 'snow_white_2025.jpg', N'Marc Webb', N'Rachel Zegler, Gal Gadot, Andrew Burnap', N'Phiên bản người đóng của Snow White với hoàng hậu, phép thuật và câu chuyện cổ tích kinh điển.'),  
('P014', N'Tron: Ares', N'Khoa học viễn tưởng, Hành động', 0, '2025-10-10', 'tron_ares.jpg', N'Joachim Rønning', N'Jared Leto, Greta Lee, Evan Peters, Jeff Bridges', N'Một AI vượt ranh giới số — sự chênh vênh giữa thế giới ảo và thực trong Tron universe.'),  
('P015', N'The Conjuring: Last Rites', N'Horror, Siêu nhiên', 135, '2025-09-05', 'the_conjuring_last_rites.jpg', N'Michael Chaves', N'Vera Farmiga, Patrick Wilson, Mia Tomlinson, Ben Hardy', N'Chương cuối của loạt The Conjuring, xoay quanh điều tra các hiện tượng siêu nhiên.'),  
('P016', N'Black Phone 2', N'Horror, Kinh dị', 0, '2025-10-17', 'black_phone_2.jpg', N'Scott Derrickson', NULL, N'Nối dài câu chuyện của The Black Phone (2022), nhiều tình tiết rùng rợn và ám ảnh.'),  
('P017', N'Zootopia 2 (2025)', N'Hoạt hình, Phiêu lưu, Gia đình', 0, '2025-11-26', 'zootopia_2.jpg', N'Jared Bush & Byron Howard', NULL, N'Judy Hopps và Nick Wilde trở lại với một vụ án mới tại Zootopia.'),  
('P018', N'After the Hunt', N'Drama, Lãng mạn', 0, '2025-10-10', 'after_the_hunt.jpg', N'Luca Guadagnino', N'Julia Roberts, Andrew Garfield, Ayo Edebiri', N'Chuyện về một giáo sư tại Yale đối mặt những biến cố trong cuộc sống và tình yêu.'),  
('P019', N'The Running Man (2025)', N'Khoa học viễn tưởng, Hành động', 0, '2025-11-14', 'the_running_man_2025.jpg', N'Edgar Wright', NULL, N'Một tái hiện mới từ tiểu thuyết cùng tên — sinh tồn, mưu mẹo và hành động căng thẳng.'),  
('P020', N'Marty Supreme (2025)', N'Drama, Thể thao', 0, '2025-12-25', 'marty_supreme.jpg', N'Josh Safdie', N'Timothée Chalamet, Odessa A’zion, Gwyneth Paltrow', N'Tiểu sử về vận động viên bóng bàn Marty Reisman — từ vinh quang đến những thử thách tâm lý.')
;

INSERT INTO SuatChieu (MaSuatChieu, MaPhim, MaPhong, GioChieu, GiaVe, TrangThai) VALUES 
('SC001', 'P001', 'P01', '2025-06-15 08:30:00', 90000, N'Đang chiếu'),
('SC002', 'P002', 'P02', '2025-06-15 10:30:00', 95000, N'Đang chiếu'),
('SC003', 'P003', 'P03', '2025-06-15 13:00:00', 100000, N'Đang chiếu'),
('SC004', 'P004', 'P01', '2025-06-15 15:30:00', 105000, N'Đang chiếu'),
('SC005', 'P005', 'P02', '2025-06-15 18:00:00', 110000, N'Đang chiếu'),
('SC006', 'P006', 'P03', '2025-06-15 20:30:00', 100000, N'Đang chiếu'),

('SC007', 'P007', 'P01', '2025-06-16 08:00:00', 95000, N'Đang chiếu'),
('SC008', 'P008', 'P02', '2025-06-16 10:15:00', 105000, N'Đang chiếu'),
('SC009', 'P009', 'P03', '2025-06-16 13:00:00', 100000, N'Đang chiếu'),
('SC010', 'P010', 'P01', '2025-06-16 15:45:00', 120000, N'Đang chiếu'),
('SC011', 'P001', 'P02', '2025-06-16 18:30:00', 95000, N'Đang chiếu'),
('SC012', 'P002', 'P03', '2025-06-16 21:00:00', 100000, N'Đang chiếu'),

('SC013', 'P003', 'P01', '2025-06-17 09:00:00', 110000, N'Sắp chiếu'),
('SC014', 'P004', 'P02', '2025-06-17 11:30:00', 95000, N'Sắp chiếu'),
('SC015', 'P005', 'P03', '2025-06-17 14:00:00', 105000, N'Sắp chiếu'),
('SC016', 'P006', 'P01', '2025-06-17 16:30:00', 100000, N'Sắp chiếu'),
('SC017', 'P007', 'P02', '2025-06-17 19:00:00', 95000, N'Sắp chiếu'),
('SC018', 'P008', 'P03', '2025-06-17 21:30:00', 120000, N'Sắp chiếu'),

('SC019', 'P009', 'P01', '2025-06-18 08:15:00', 90000, N'Sắp chiếu'),
('SC020', 'P010', 'P02', '2025-06-18 10:45:00', 95000, N'Sắp chiếu'),
('SC021', 'P001', 'P03', '2025-06-18 13:15:00', 100000, N'Sắp chiếu'),
('SC022', 'P002', 'P01', '2025-06-18 15:45:00', 105000, N'Sắp chiếu'),
('SC023', 'P003', 'P02', '2025-06-18 18:15:00', 110000, N'Sắp chiếu'),
('SC024', 'P004', 'P03', '2025-06-18 20:45:00', 100000, N'Sắp chiếu'),

('SC025', 'P005', 'P01', '2025-06-15 09:00:00', 95000, N'Đang chiếu'),
('SC026', 'P006', 'P02', '2025-06-16 12:30:00', 100000, N'Đang chiếu'),
('SC027', 'P007', 'P03', '2025-06-17 17:45:00', 105000, N'Sắp chiếu'),
('SC028', 'P008', 'P01', '2025-06-18 19:30:00', 110000, N'Sắp chiếu'),
('SC029', 'P009', 'P02', '2025-06-15 11:15:00', 100000, N'Đang chiếu'),
('SC030', 'P010', 'P03', '2025-06-16 20:00:00', 95000, N'Đang chiếu');


INSERT INTO TaiKhoan (Id, Username, Email, Phone, Password, Role, Name, Sex)
VALUES
('TK001', 'adminbcc', 'chungbc@gmail.com', '0912345678', '123456', N'Quản lý tất cả', N'Bùi Cao Chung', N'Nam'),
('TK002', 'adminbhh', 'hoangbh@gmail.com', '0912345679', '123456', N'Quản lý tất cả', N'Bùi Huy Hoàng', N'Nam'),
('TK003', 'admindvh', 'hoadv@gmail.com', '0912345680', '123456', N'Quản lý phim, Quản lý suất chiếu', N'Đặng Văn Hòa', N'Nam'),
('TK004', 'adminnhd', 'duynh@gmail.com', '0912345681', '123456', N'Quản lý khách hàng', N'Nguyễn Hữu Duy', N'Nam'),
('TK005', 'adminntn', 'nguyetnt@gmail.com', '0912345682', '123456', N'Quản lý vé, Quản lý hóa đơn', N'Nguyễn Thu Nguyệt', N'Nữ'),
('KH001', 'customer1', 'anle@gmail.com', '0988001122', '123456', 'user', N'Lê Văn An', N'Nam'),
('KH002', 'customer2', 'maingt@gmail.com', '0988777666', '123456', 'user', N'Nguyễn Thị Mai', N'Nữ'),
('KH003', 'customer3', 'cuongph@gmail.com', '0977111222', '123456', 'user', N'Phạm Hùng Cường', N'Nam'),
('KH004', 'customer4', 'hanght@gmail.com', '0966555444', '123456', 'user', N'Hoàng Thanh Hằng', N'Nữ'),
('KH005', 'customer5', 'longnv@gmail.com', '0955333444', '123456', 'user', N'Ngô Văn Long', N'Nam');


select * from Ve
select * from SuatChieu
select * from TaiKhoan
select * from Phim
select * from ChiTietHoaDon