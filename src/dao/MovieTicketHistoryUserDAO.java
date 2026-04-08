/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author ADMIN
 */
public class MovieTicketHistoryUserDAO {
    public List<Object[]> getInvoiceInfor(String idTaiKhoan) {
        List<Object[]> list = new ArrayList<>();
        String query = "SELECT hd.MaHD, p.TenPhim, FORMAT(hd.NgayLap, 'dd/MM/yyyy') as NgayDatVe, "
               + "FORMAT(sc.GioChieu, 'dd/MM/yyyy') as NgayChieu, "
               + "FORMAT(sc.GioChieu, 'HH:mm') as GioChieu, "
               + "STRING_AGG(g.TenGhe, ', ') as DanhSachGhe, "
               + "SUM(sc.GiaVe) as TongTien "
               + "FROM HoaDon hd "
               + "JOIN ChiTietHoaDon ct ON hd.MaHD = ct.MaHD "
               + "JOIN Ve v ON ct.MaVe = v.MaVe "
               + "JOIN SuatChieu sc ON v.MaSuatChieu = sc.MaSuatChieu "
               + "JOIN Phim p ON sc.MaPhim = p.MaPhim "
               + "JOIN Ghe g ON v.MaGhe = g.MaGhe "
               + "WHERE hd.IdTaiKhoan=?"
               + "GROUP BY hd.MaHD, p.TenPhim, hd.NgayLap, sc.GioChieu";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, idTaiKhoan);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
               Object[] row = {
                   rs.getString(1),
                   rs.getString(2),
                   rs.getString(3),
                   rs.getString(4),
                   rs.getString(5),
                   rs.getString(6),
                   rs.getInt(7)
               };
               list.add(row);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Object[]> timKiemHoaDonTheoPhim(String maTaiKhoan, String tenPhim) {
        List<Object[]> danhSachHoaDon = new ArrayList<>();

        // Xây dựng câu truy vấn SQL linh hoạt
        String sql = "SELECT hd.MaHD, p.TenPhim, FORMAT(hd.NgayLap, 'dd/MM/yyyy') as NgayDatVe, "
                + "FORMAT(sc.GioChieu, 'dd/MM/yyyy') as NgayChieu, "
                + "FORMAT(sc.GioChieu, 'HH:mm') as GioChieu, "
                + "STRING_AGG(g.TenGhe, ', ') as DanhSachGhe, "
                + "SUM(sc.GiaVe) as TongTien "
                + "FROM HoaDon hd "
                + "JOIN ChiTietHoaDon ct ON hd.MaHD = ct.MaHD "
                + "JOIN Ve v ON ct.MaVe = v.MaVe "
                + "JOIN SuatChieu sc ON v.MaSuatChieu = sc.MaSuatChieu "
                + "JOIN Phim p ON sc.MaPhim = p.MaPhim "
                + "JOIN Ghe g ON v.MaGhe = g.MaGhe "
                + "WHERE hd.IdTaiKhoan = ? ";

        // Thêm điều kiện tìm kiếm nếu có tên phim
        if (tenPhim != null && !tenPhim.trim().isEmpty()) {
            sql += "AND p.TenPhim LIKE ? ";
        }

        sql += "GROUP BY hd.MaHD, p.TenPhim, hd.NgayLap, sc.GioChieu";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, maTaiKhoan);

            // Thiết lập tham số tìm kiếm nếu có
            if (tenPhim != null && !tenPhim.trim().isEmpty()) {
                stmt.setString(2, "%" + tenPhim + "%");
            }

            // Thực thi truy vấn và xử lý kết quả
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] hoaDon = {
                    rs.getString("MaHD"),
                    rs.getString("TenPhim"),
                    rs.getString("NgayDatVe"),
                    rs.getString("NgayChieu"),
                    rs.getString("GioChieu"),
                    rs.getString("DanhSachGhe"),
                    rs.getDouble("TongTien")
                };
                danhSachHoaDon.add(hoaDon);
            }
            return danhSachHoaDon;
        } catch (Exception e) {
            System.err.println("Lỗi truy vấn database: " + e.getMessage());
            e.printStackTrace();
        }
        return null;

    }
}
