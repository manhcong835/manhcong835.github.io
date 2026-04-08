/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import util.DBConnection;

/**
 *
 * @author ADMIN
 */
public class CancelTicket {

    public boolean huyVe(String showtimeId, String seatId) {
        String query = "DELETE FROM Ve WHERE MaSuatChieu = ? AND MaGhe = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, showtimeId);
            stmt.setString(2, seatId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isCustomerTicket(String showtimeId, String seatId) {
        String query = """
        SELECT 1
        FROM Ve
        WHERE MaSuatChieu = ? AND MaGhe = ? AND IdTaiKhoan IS NOT NULL
    """;

        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, showtimeId);
            stmt.setString(2, seatId);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Có vé => là vé khách hàng
        } catch (SQLException e) {
            e.printStackTrace();
            return true; // Lỗi thì xử lý an toàn: không cho hủy
        }
    }

}
