/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Bill;
import util.DBConnection;

/**
 *
 * @author Acer
 */

public class BillDAO {

    public List<Bill> getAllBills() {
        List<Bill> list = new ArrayList<>();
        String query = "SELECT * FROM HoaDon";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Bill bill = new Bill();
                bill.setBillId(rs.getString("MaHD"));
                bill.setAccountId(rs.getString("IdTaiKhoan"));
                bill.setCreatedAt(rs.getString("NgayLap"));
                bill.setTotalAmount(rs.getDouble("TongTien"));
                bill.setNote(rs.getString("GhiChu"));
                list.add(bill);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public String getCustomerNameById(String id) {
        String name = "";
        String query = "SELECT Name FROM TaiKhoan WHERE Id = ?";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                name = rs.getString("Name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return name;
    }

    public List<Bill> searchBills(String keyword) {
        List<Bill> list = new ArrayList<>();
        String query = """
        SELECT HoaDon.MaHD, TaiKhoan.Name AS TenKhachHang, HoaDon.NgayLap, HoaDon.TongTien
        FROM HoaDon
        INNER JOIN TaiKhoan ON HoaDon.IdTaiKhoan = TaiKhoan.Id
        WHERE HoaDon.MaHD LIKE ? OR TaiKhoan.Name LIKE ?
    """;

        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

            String wildcard = "%" + keyword + "%";
            ps.setString(1, wildcard);
            ps.setString(2, wildcard);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Bill bill = new Bill();
                    bill.setBillId(rs.getString("MaHD"));
                    bill.setAccountId(rs.getString("TenKhachHang")); // cần thêm thuộc tính này trong Bill
                    bill.setCreatedAt(rs.getString("NgayLap"));
                    bill.setTotalAmount(rs.getDouble("TongTien"));
                    list.add(bill);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean deleteBill(String billId) {
        String deleteDetails = "DELETE FROM ChiTietHoaDon WHERE MaHD = ?";
        String deleteBill = "DELETE FROM HoaDon WHERE MaHD = ?";
        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement ps1 = conn.prepareStatement(deleteDetails); PreparedStatement ps2 = conn.prepareStatement(deleteBill)) {

                ps1.setString(1, billId);
                ps1.executeUpdate();

                ps2.setString(1, billId);
                int affected = ps2.executeUpdate();

                conn.commit();
                return affected > 0;
            } catch (Exception e) {
                conn.rollback();
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Bill getBillById(String billId) {
    Bill bill = null;
    String query = """
        SELECT MaHD, IdTaiKhoan, NgayLap, TongTien, GhiChu
        FROM HoaDon
        WHERE MaHD = ?
    """;

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {

        ps.setString(1, billId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            bill = new Bill();
            bill.setBillId(rs.getString("MaHD"));
            bill.setAccountId(rs.getString("IdTaiKhoan"));
            bill.setCreatedAt(rs.getString("NgayLap"));
            bill.setTotalAmount(rs.getDouble("TongTien"));
            bill.setNote(rs.getString("GhiChu"));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return bill;
}


    public boolean hasShowtimeStarted(String billId) {
        String query = """
        SELECT TOP 1 1
        FROM ChiTietHoaDon cthd
        JOIN Ve v ON cthd.MaVe = v.MaVe
        JOIN SuatChieu s ON v.MaSuatChieu = s.MaSuatChieu
        WHERE cthd.MaHD = ? AND s.GioChieu < GETDATE()
    """;

        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, billId);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); // Có ít nhất một suất chiếu đã bắt đầu
        } catch (SQLException e) {
            e.printStackTrace();
            return true; 
        }
    }
    
    
}
