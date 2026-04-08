package dao;

import java.sql.*;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.swing.JOptionPane;
import model.Account;
import util.DBConnection;

public class AccountDao {

    // lấy danh sách tài khoản
    public List<Account> getAllAccounts() {
        List<Account> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM TaiKhoan WHERE Role <> 'user'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("Id");             // Sửa lại từ "ID" -> "Id"
                String username = rs.getString("Username"); // Viết đúng như trong bảng
                String password = rs.getString("Password");
                String role = rs.getString("Role");
                Account account = new Account(id, username, password, role);
                list.add(account);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Account> getAllUsers() {
        List<Account> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM TaiKhoan WHERE Role = 'user'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("Id");             // Sửa lại từ "ID" -> "Id"
                String username = rs.getString("Username"); // Viết đúng như trong bảng
                String password = rs.getString("Password");
                String role = rs.getString("Role");
                Account account = new Account(id, username, password, role);
                list.add(account);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean register(Account acc) {
        String sql = "INSERT INTO TaiKhoan (Id, Username, Email, Phone, Password, Role, Name, Sex, TrangThai) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, acc.getId());
            stmt.setString(2, acc.getUsername());
            stmt.setString(3, acc.getEmail());
            stmt.setString(4, acc.getPhone());
            stmt.setString(5, acc.getPassword());
            stmt.setString(6, acc.getRole());
            stmt.setString(7, acc.getName());
            stmt.setString(8, acc.getSex());
            stmt.setString(9, acc.getTrangthai());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //thêm tài khoản
    public boolean insertAccount(Account acc) {
        String sql = "INSERT INTO TaiKhoan (id, username, password, role) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, acc.getId());
            stmt.setString(2, acc.getUsername());
            stmt.setString(3, acc.getPassword());
            stmt.setString(4, acc.getRole());

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa tài khoản theo id kiểu String
    public boolean deleteAccountById(String id) {
        boolean success = false;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM TaiKhoan WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, id);  // dùng setString vì id là String
            int rowsDeleted = stmt.executeUpdate();
            success = rowsDeleted > 0;
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    public boolean isUsernameExistsExceptId(String id, String username) {
        String sql = "SELECT COUNT(*) FROM TaiKhoan WHERE username = ? AND id <> ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Nếu > 0 nghĩa là có username bị trùng (của người khác)
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Không trùng hoặc có lỗi
    }

    //check id username
    public boolean isIdOrUsernameExists(String id, String username) {
        String sql = "SELECT COUNT(*) FROM TaiKhoan WHERE id = ? OR username = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.setString(2, username);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Nếu số bản ghi > 0 là đã tồn tại
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;  // Không tồn tại hoặc lỗi thì trả về false
    }

    //chỉnh sửa
    public boolean updateAccount(Account acc) {
        String sql = "UPDATE TaiKhoan SET username = ?, password = ?, role = ? WHERE id = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, acc.getUsername());
            stmt.setString(2, acc.getPassword());
            stmt.setString(3, acc.getRole());
            stmt.setString(4, acc.getId());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // tìm kiếm
    public List<Account> searchById(String keyword) {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT * FROM TaiKhoan "
                + "WHERE (id COLLATE SQL_Latin1_General_CP1_CI_AS LIKE ? "
                + "OR username COLLATE SQL_Latin1_General_CP1_CI_AS LIKE ?) "
                + "AND role <> 'user'";
        try (Connection con = DBConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Account acc = new Account(
                        rs.getString("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                );
                list.add(acc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
