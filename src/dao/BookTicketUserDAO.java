/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import model.Seat;
import model.Showtime;
import model.ShowtimeInfor;
import util.DBConnection;

/**
 *
 * @author ADMIN
 */
public class BookTicketUserDAO {
    
    //Tìm ra giờ chiếu và tên phòng theo tên phim để chọn Suất chiếu tương ứng với tên phim đó
    public List<ShowtimeInfor> getShowtime(String maPhim) {
        List<ShowtimeInfor> showtimeList = new ArrayList<>();
        String query = "SELECT GioChieu, TenPhong FROM SuatChieu JOIN PhongChieu ON SuatChieu.MaPhong=PhongChieu.MaPhong WHERE MaPhim=?";
        try{
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, maPhim);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
               ShowtimeInfor showtime = new ShowtimeInfor();
               showtime.setStartTime(rs.getTimestamp(1));
               showtime.setName(rs.getString(2));
               showtimeList.add(showtime);
           } 
            return showtimeList;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    } 
    
    //Tìm ra mã ghế và tên ghế theo mã suất chiếu
    public List<Seat> getSeatsByRoomId(String showtimeId){
        List<Seat> seats = new ArrayList<>();
        String query = "SELECT MaGhe, TenGhe FROM Ghe WHERE MaSuatChieu=?";
        try  {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, showtimeId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Seat seat=new Seat();
                seat.setId(rs.getString(1));
                seat.setScreenRoomId(rs.getString(2));
                seat.setSeatName(rs.getString(3));
                seats.add(seat);
            }
            return seats;
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    //Tìm ra ghế nào đã đặt, đưa các ghế đó vào trong 1 list
    public ArrayList<String> searchSeatNameFromsShowTime(String status, String showtimeId) {
        String query = "SELECT TenGhe FROM Ghe INNER JOIN Ve ON Ghe.MaGhe = Ve.MaGhe WHERE TrangThai=? AND MaSuatChieu=?";
        try {
            ArrayList<String> list= new ArrayList<>();
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, status);
            preparedStatement.setString(2, showtimeId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            if(!list.isEmpty()) return list;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    //Lấy bảng suất chiếu trong db
    public List<Showtime> showShowTime(String maPhim) {
        List<Showtime> list= new ArrayList<>();
        String query = "SELECT * FROM SuatChieu WHERE MaPhim=?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, maPhim);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()) {
                Showtime showtime= new Showtime();
                showtime.setId(rs.getString(1));
                showtime.setMovieId(rs.getString(2));
                showtime.setScreenRoomId(rs.getString(3));
                showtime.setStartTime(rs.getTimestamp(4));
                showtime.setTicketPrice(rs.getFloat(5));
                showtime.setStatus(rs.getString(6));
                list.add(showtime);
            }
            return list;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    //Lấy mã ghế theo tên ghế và mã phòng từ bảng ghế
    public String getSeatId(String nameSeat, String roomId) {
        String query = "SELECT MaGhe FROM Ghe WHERE TenGhe=? AND MaPhong=?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nameSeat);
            preparedStatement.setString(2, roomId);
            ResultSet rs=preparedStatement.executeQuery();

            if(rs.next())
            return rs.getString(1);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return "rong";
    }
    
    //Đặt vé
    public boolean datVe(String maVe, String showtimeId, String seatId, String titles, String IdTaiKhoan) {
        String query = "INSERT INTO Ve (MaVe, TrangThai, ThoiGianDat, MaSuatChieu, MaGhe, IdTaiKhoan) VALUES (?, ?, GETDATE(), ?, ?, ?)";
        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, maVe);
            preparedStatement.setString(2, "DaDat");
            preparedStatement.setString(3, showtimeId);
            preparedStatement.setString(4, seatId);
            preparedStatement.setString(5, IdTaiKhoan);

            int rows=preparedStatement.executeUpdate();
            return rows>0;
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean InsertHoaDon(String maHD, String IdTaiKhoan, Double totalAmount, String note) {
        String query = "INSERT INTO HoaDon (MaHD, IdTaiKhoan, NgayLap, TongTien, GhiChu) VALUES (?, ?, GETDATE(), ?, ?)";
        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, maHD);
            preparedStatement.setString(2, IdTaiKhoan);
            preparedStatement.setDouble(3, totalAmount);
            preparedStatement.setString(4, note);
            
            int rows=preparedStatement.executeUpdate();
            return rows>0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean InsertChiTietHoaDon(String maHD, String maVe) {
    String query = "INSERT INTO ChiTietHoaDon (MaHD, MaVe) VALUES (?, ?)";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        
        pstmt.setString(1, maHD);
        pstmt.setString(2, maVe);
        
        int rowsAffected = pstmt.executeUpdate();
        return rowsAffected > 0;
        
    } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
