/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ShowtimeInfor;
import util.DBConnection;

/**
 *
 * @author ADMIN
 */
public class MovieRepository {
    public List<ShowtimeInfor> getMovie() {
        List<ShowtimeInfor> showtimeList = new ArrayList<>();
        String query = "SELECT MaSuatChieu, GioChieu, TenPhim, TenPhong FROM SuatChieu JOIN Phim ON Phim.MaPhim=SuatChieu.MaPhim JOIN PhongChieu ON SuatChieu.MaPhong=PhongChieu.MaPhong";
        try{
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
               ShowtimeInfor showtime = new ShowtimeInfor();
               showtime.setId(rs.getString(1));
               showtime.setStartTime(rs.getTimestamp(2));
               showtime.setTitle(rs.getString(3));
               showtime.setName(rs.getString(4));
               showtimeList.add(showtime);
           } 
            return showtimeList;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//    int getRoomIdByName(String roomName);
//    
//    int getRoomIdByShowtimeId(int showtimeId);
}
