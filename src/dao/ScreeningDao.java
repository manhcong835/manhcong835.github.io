package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Showtime;
import util.DBConnection;

public class ScreeningDao {
    
    public List<Showtime> getAllScreenings() {
        List<Showtime> list = new ArrayList<>();
        String sql = "SELECT sc.MaSuatChieu, sc.MaPhim, p.TenPhim, sc.MaPhong, pc.TenPhong, "
                   + "sc.GioChieu, sc.GiaVe, sc.TrangThai "
                   + "FROM SuatChieu sc "
                   + "JOIN Phim p ON sc.MaPhim = p.MaPhim "
                   + "JOIN PhongChieu pc ON sc.MaPhong = pc.MaPhong";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Showtime showtime = new Showtime();
                showtime.setId(rs.getString("MaSuatChieu"));
                showtime.setMovieId(rs.getString("MaPhim"));
                showtime.setMovieName(rs.getString("TenPhim"));
                showtime.setScreenRoomId(rs.getString("MaPhong"));
                showtime.setRoomName(rs.getString("TenPhong"));
                showtime.setStartTime(rs.getTimestamp("GioChieu"));
                showtime.setTicketPrice(rs.getDouble("GiaVe"));
                showtime.setStatus(rs.getString("TrangThai"));
                list.add(showtime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean addScreening(Showtime showtime) {
        String sql = "INSERT INTO SuatChieu (MaSuatChieu, MaPhim, MaPhong, GioChieu, GiaVe, TrangThai) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, showtime.getId());
            ps.setString(2, showtime.getMovieId());
            ps.setString(3, showtime.getScreenRoomId());
            ps.setTimestamp(4, showtime.getStartTime());
            ps.setDouble(5, showtime.getTicketPrice());
            ps.setString(6, showtime.getStatus());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateScreening(Showtime showtime) {
        String sql = "UPDATE SuatChieu SET MaPhim=?, MaPhong=?, GioChieu=?, GiaVe=?, TrangThai=? "
                   + "WHERE MaSuatChieu=?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, showtime.getMovieId());
            ps.setString(2, showtime.getScreenRoomId());
            ps.setTimestamp(3, showtime.getStartTime());
            ps.setDouble(4, showtime.getTicketPrice());
            ps.setString(5, showtime.getStatus());
            ps.setString(6, showtime.getId());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteScreening(String screeningId) throws SQLException{
        String sql = "DELETE FROM SuatChieu WHERE MaSuatChieu=?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, screeningId);
            return ps.executeUpdate() > 0;
        } 
    }
    
    public List<String> getAllMovies() {
        List<String> list = new ArrayList<>();
        String sql = "SELECT MaPhim, TenPhim FROM Phim";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                list.add(rs.getString("MaPhim") + " - " + rs.getString("TenPhim"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<String> getAllRooms() {
        List<String> list = new ArrayList<>();
        String sql = "SELECT MaPhong, TenPhong FROM PhongChieu";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                list.add(rs.getString("MaPhong") + " - " + rs.getString("TenPhong"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean isRoomAvailable(String roomId, Timestamp startTime, String movieId) {
        int duration = getMovieDuration(movieId);
        Timestamp endTime = new Timestamp(startTime.getTime() + (duration * 60 * 1000));
        
        String sql = "SELECT COUNT(*) FROM SuatChieu sc "
                   + "JOIN Phim p ON sc.MaPhim = p.MaPhim "
                   + "WHERE sc.MaPhong = ? AND "
                   + "((sc.GioChieu <= ? AND DATEADD(MINUTE, p.ThoiLuong, sc.GioChieu) >= ?) OR "
                   + "(sc.GioChieu <= ? AND DATEADD(MINUTE, p.ThoiLuong, sc.GioChieu) >= ?) OR "
                   + "(sc.GioChieu >= ? AND DATEADD(MINUTE, p.ThoiLuong, sc.GioChieu) <= ?))";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, roomId);
            ps.setTimestamp(2, endTime);
            ps.setTimestamp(3, startTime);
            ps.setTimestamp(4, endTime);
            ps.setTimestamp(5, endTime);
            ps.setTimestamp(6, startTime);
            ps.setTimestamp(7, endTime);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) == 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean isRoomAvailableForUpdate(String roomId, Timestamp startTime, String movieId, String currentScreeningId) {
        int duration = getMovieDuration(movieId);
        Timestamp endTime = new Timestamp(startTime.getTime() + (duration * 60 * 1000));
        
        String sql = "SELECT COUNT(*) FROM SuatChieu sc "
                   + "JOIN Phim p ON sc.MaPhim = p.MaPhim "
                   + "WHERE sc.MaPhong = ? AND sc.MaSuatChieu != ? AND "
                   + "((sc.GioChieu <= ? AND DATEADD(MINUTE, p.ThoiLuong, sc.GioChieu) >= ?) OR "
                   + "(sc.GioChieu <= ? AND DATEADD(MINUTE, p.ThoiLuong, sc.GioChieu) >= ?) OR "
                   + "(sc.GioChieu >= ? AND DATEADD(MINUTE, p.ThoiLuong, sc.GioChieu) <= ?))";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, roomId);
            ps.setString(2, currentScreeningId);
            ps.setTimestamp(3, endTime);
            ps.setTimestamp(4, startTime);
            ps.setTimestamp(5, endTime);
            ps.setTimestamp(6, endTime);
            ps.setTimestamp(7, startTime);
            ps.setTimestamp(8, endTime);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) == 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    private int getMovieDuration(String movieId) {
        String sql = "SELECT ThoiLuong FROM Phim WHERE MaPhim = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, movieId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("ThoiLuong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public String generateNewScreeningId() {
        String maxId = "SC000";
        String sql = "SELECT MAX(MaSuatChieu) FROM SuatChieu";
        
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                maxId = rs.getString(1);
                if (maxId == null) {
                    return "SC001";
                }
            }
            
            String prefix = "SC";
            int num = 0;
            if (maxId.startsWith(prefix)) {
                try {
                    num = Integer.parseInt(maxId.substring(prefix.length()));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            
            num++;
            if (num < 10) {
                return prefix + "00" + num;
            } else if (num < 100) {
                return prefix + "0" + num;
            } else {
                return prefix + num;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "SC001";
        }
    }
}