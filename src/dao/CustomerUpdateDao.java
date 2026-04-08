/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Account;
import util.DBConnection;
import java.sql.*;

public class CustomerUpdateDao {

    private Connection conn;

    public CustomerUpdateDao() {
        conn = DBConnection.getConnection();
    }

    public Account getCustomerById(String id) {
        Account account = null;
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT * FROM TaiKhoan WHERE Id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                account = new Account();
                account.setId(rs.getString("Id"));
                account.setUsername(rs.getString("Username"));
                account.setEmail(rs.getString("Email"));
                account.setPassword(rs.getString("Password"));
                account.setPhone(rs.getString("Phone"));
                account.setName(rs.getString("Name"));
                account.setSex(rs.getString("Sex"));
                account.setRole(rs.getString("Role"));
                account.setTrangthai(rs.getString("TrangThai"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    public boolean updateCustomer(Account account) {
        String sql = "UPDATE TaiKhoan SET Username = ?, Password = ?, Email = ?, Phone = ?, Sex = ?, Name = ? WHERE Id = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, account.getUsername());
            stmt.setString(2, account.getPassword());
            stmt.setString(3, account.getEmail());
            stmt.setString(4, account.getPhone());
            stmt.setString(5, account.getSex());
            stmt.setString(6, account.getName());
            stmt.setString(7, account.getId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateCustomerInfo(Account account) {
        String sql = "UPDATE TaiKhoan SET Username = ?, Name = ?, Email = ?, Phone = ?, Sex = ? WHERE Id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, account.getUsername()); // Cho phép sửa username
            stmt.setString(2, account.getName());
            stmt.setString(3, account.getEmail());
            stmt.setString(4, account.getPhone());
            stmt.setString(5, account.getSex());
            stmt.setString(6, account.getId()); // Sử dụng ID

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean isEmailExists(String email, String currentUsername) {
        String sql = "SELECT COUNT(*) FROM TaiKhoan WHERE Email=? AND Username<>?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, currentUsername);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
