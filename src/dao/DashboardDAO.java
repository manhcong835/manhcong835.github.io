package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import util.DBConnection;

public class DashboardDAO {

    public int getTotalPhim() {
        try {
            java.sql.Connection con = DBConnection.getConnection();
            String sql = "SELECT COUNT(*) FROM Phim";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getTotalSuatChieu() {
        try {
            java.sql.Connection con = DBConnection.getConnection();
            String sql = "SELECT COUNT(*) FROM SuatChieu";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getTotalAccount() {
        try {
            java.sql.Connection con = DBConnection.getConnection();
            String sql = "SELECT COUNT(*) FROM TaiKhoan";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getTotalTicket() {
        try {
            java.sql.Connection con = DBConnection.getConnection();
            String sql = "SELECT COUNT(*) FROM Ve";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double getTotalMoney() {
        try {
            java.sql.Connection con = DBConnection.getConnection();
            String sql = "SELECT SUM(sc.GiaVe) AS DoanhThu "
             + "FROM Ve v "
             + "JOIN SuatChieu sc ON v.MaSuatChieu = sc.MaSuatChieu ";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getDouble("DoanhThu");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
