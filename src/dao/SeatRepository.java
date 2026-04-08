/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Seat;
import util.DBConnection;

/**
 *
 * @author ADMIN
 */
public class SeatRepository {
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
            return list;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
