package dao;

import model.BillDetail;
import model.Showtime;
import model.Ticket;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetailBillDAO {

    // Lấy danh sách chi tiết hóa đơn theo mã hóa đơn
    public List<BillDetail> getBillDetailsByBillId(String billId) {
        List<BillDetail> details = new ArrayList<>();
        String sql = "SELECT * FROM ChiTietHoaDon WHERE MaHD = ?";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, billId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BillDetail detail = new BillDetail();
                detail.setBillId(rs.getString("MaHD"));
                detail.setTicketId(rs.getString("MaVe"));
                details.add(detail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return details;
    }

    // Lấy vé theo ID
    public Ticket getTicketById(String ticketId) {
        String sql = "SELECT * FROM Ve WHERE MaVe = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ticketId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Ticket(
                        rs.getString("MaVe"),
                        rs.getString("MaSuatChieu"),
                        rs.getString("MaGhe"),
                        rs.getString("TrangThai"),
                        rs.getTimestamp("ThoiGianDat")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // Lấy suất chiếu theo ID
    public Showtime getShowtimeById(String showtimeId) {
        String sql = "SELECT s.*, p.TenPhong, m.TenPhim "
                + "FROM SuatChieu s "
                + "JOIN PhongChieu p ON s.MaPhong = p.MaPhong "
                + "JOIN Phim m ON s.MaPhim = m.MaPhim "
                + "WHERE s.MaSuatChieu = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, showtimeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Showtime showtime = new Showtime();
                showtime.setId(rs.getString("MaSuatChieu")); 
                showtime.setMovieId(rs.getString("MaPhim")); 
                showtime.setMovieName(rs.getString("TenPhim")); 
                showtime.setScreenRoomId(rs.getString("MaPhong")); 
                showtime.setRoomName(rs.getString("TenPhong")); 
                showtime.setStartTime(rs.getTimestamp("GioChieu")); 
                showtime.setTicketPrice(rs.getDouble("GiaVe")); 
                showtime.setStatus(rs.getString("TrangThai")); 
                return showtime;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // Lấy tên ghế theo ID ghế
    public String getSeatNameById(String seatId) {
        String sql = "SELECT TenGhe FROM Ghe WHERE MaGhe = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, seatId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("TenGhe");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Không rõ";
    }
}
