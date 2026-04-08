package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Movie;
import util.DBConnection;

public class MovieDAO {

    public List<Movie> getAll() {
        List<Movie> list = new ArrayList<>();
        String sql = "SELECT * FROM Phim";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Movie movie = new Movie();
                movie.setId(rs.getString("MaPhim"));
                movie.setTitle(rs.getString("TenPhim"));
                movie.setGenre(rs.getString("TheLoai"));
                movie.setDuration(rs.getInt("ThoiLuong"));
                movie.setReleaseDate(rs.getDate("NgayKhoiChieu"));
                movie.setImage(rs.getString("HinhAnh"));
                movie.setDirector(rs.getString("DaoDien"));
                movie.setActors(rs.getString("DienVien"));
                movie.setDescription(rs.getString("MoTa"));
                list.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean isDuplicateMovie(String title, Date releaseDate) {
        String sql = "SELECT COUNT(*) FROM Phim WHERE TenPhim = ? AND NgayKhoiChieu = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, title);
            ps.setDate(2, releaseDate);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean isDuplicateMovieExcludingSelf(String id, String title, Date releaseDate) {
    String sql = "SELECT COUNT(*) FROM Phim WHERE TenPhim = ? AND NgayKhoiChieu = ? AND MaPhim != ?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, title);
        ps.setDate(2, releaseDate);
        ps.setString(3, id); // loại trừ chính nó

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

    public boolean insert(Movie movie) {
        if (isDuplicateMovie(movie.getTitle(), movie.getReleaseDate())) {
            System.out.println("Phim đã tồn tại, không thể thêm.");
            return false;
        }

        String sql = "INSERT INTO Phim (MaPhim, TenPhim, TheLoai, ThoiLuong, NgayKhoiChieu, HinhAnh, DaoDien, DienVien, MoTa) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, movie.getId());
            ps.setString(2, movie.getTitle());
            ps.setString(3, movie.getGenre());
            ps.setInt(4, movie.getDuration());
            ps.setDate(5, movie.getReleaseDate());
            ps.setString(6, movie.getImage());
            ps.setString(7, movie.getDirector());
            ps.setString(8, movie.getActors());
            ps.setString(9, movie.getDescription());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Movie movie) {
        String sql = "UPDATE Phim SET TenPhim=?, TheLoai=?, ThoiLuong=?, NgayKhoiChieu=?, HinhAnh=?, DaoDien=?, DienVien=?, MoTa=? " +
                     "WHERE MaPhim=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getGenre());
            ps.setInt(3, movie.getDuration());
            ps.setDate(4, movie.getReleaseDate());
            ps.setString(5, movie.getImage());
            ps.setString(6, movie.getDirector());
            ps.setString(7, movie.getActors());
            ps.setString(8, movie.getDescription());
            ps.setString(9, movie.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM Phim WHERE MaPhim=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    public Movie getById(String id) {
        String sql = "SELECT * FROM Phim WHERE MaPhim=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Movie movie = new Movie();
                    movie.setId(rs.getString("MaPhim"));
                    movie.setTitle(rs.getString("TenPhim"));
                    movie.setGenre(rs.getString("TheLoai"));
                    movie.setDuration(rs.getInt("ThoiLuong"));
                    movie.setReleaseDate(rs.getDate("NgayKhoiChieu"));
                    movie.setImage(rs.getString("HinhAnh"));
                    movie.setDirector(rs.getString("DaoDien"));
                    movie.setActors(rs.getString("DienVien"));
                    movie.setDescription(rs.getString("MoTa"));
                    return movie;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Movie> searchByTitle(String keyword) {
        List<Movie> list = new ArrayList<>();
        String sql = "SELECT * FROM Phim WHERE TenPhim LIKE ? OR TheLoai LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Movie movie = new Movie();
                    movie.setId(rs.getString("MaPhim"));
                    movie.setTitle(rs.getString("TenPhim"));
                    movie.setGenre(rs.getString("TheLoai"));
                    movie.setDuration(rs.getInt("ThoiLuong"));
                    movie.setReleaseDate(rs.getDate("NgayKhoiChieu"));
                    movie.setImage(rs.getString("HinhAnh"));
                    movie.setDirector(rs.getString("DaoDien"));
                    movie.setActors(rs.getString("DienVien"));
                    movie.setDescription(rs.getString("MoTa"));
                    list.add(movie);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
