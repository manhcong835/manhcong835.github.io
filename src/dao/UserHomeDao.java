package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Movie;
import util.DBConnection;

public class UserHomeDao {

//        public List<Movie> getAllMovies() {
//            List<Movie> list = new ArrayList<>();
//            try {
//                String sql = "SELECT * FROM Phim";
//                Connection con = DBConnection.getConnection();
//                Statement stmt = con.createStatement();
//                ResultSet rs = stmt.executeQuery(sql);
//                while (rs.next()) {
//                    Movie m = new Movie(
//                     rs.getString("MaPhim"),
//                     rs.getString("TenPhim"),
//                     rs.getString("TheLoai"),
//                     rs.getInt("ThoiLuong"),
//                     rs.getDate("NgayKhoiChieu"),
//                     rs.getString("HinhAnh"),
//                     rs.getString("DaoDien"),
//                     rs.getString("DienVien"),
//                     rs.getString("MoTa")
//                    );
//                    list.add(m);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return list;
//        }
    public List<Movie> getAllMovies() {
        List<Movie> list = new ArrayList<>();
        try {
            String sql = "SELECT DISTINCT p.* FROM Phim p "
             + "JOIN SuatChieu s ON p.MaPhim = s.MaPhim";
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Movie m = new Movie(
                 rs.getString("MaPhim"),
                 rs.getString("TenPhim"),
                 rs.getString("TheLoai"),
                 rs.getInt("ThoiLuong"),
                 rs.getDate("NgayKhoiChieu"),
                 rs.getString("HinhAnh"),
                 rs.getString("DaoDien"),
                 rs.getString("DienVien"),
                 rs.getString("MoTa")
                );
                list.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
