package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import util.DBConnection;

public class CustomerDao {

    public List<Account> getAllUsers() {
        List<Account> list = new ArrayList<>();
        try {
            Connection con = (Connection) DBConnection.getConnection();
            String sql = "SELECT * FROM TaiKhoan WHERE Role = 'user'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Account acc = new Account();
                acc.setId(rs.getString("Id"));
                acc.setUsername(rs.getString("Username"));
                acc.setEmail(rs.getString("Email"));
                acc.setPhone(rs.getString("Phone"));
                acc.setName(rs.getString("Name"));
                acc.setSex(rs.getString("Sex"));
                acc.setTrangthai(rs.getString("TrangThai"));
                list.add(acc);
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean updateTrangThai(String id, String newStatus) {
        String sql = "UPDATE TaiKhoan SET TrangThai = ? WHERE Id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newStatus);
            stmt.setString(2, id);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public Account searchById(String id) {
        Account acc = null;
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT * FROM TaiKhoan WHERE Id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                acc = new Account();
                acc.setId(rs.getString("Id"));
                acc.setUsername(rs.getString("Username"));
                acc.setEmail(rs.getString("Email"));
                acc.setPhone(rs.getString("Phone"));
                acc.setName(rs.getString("Name"));
                acc.setSex(rs.getString("Sex"));
                acc.setTrangthai(rs.getString("TrangThai"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return acc;
    }

}
