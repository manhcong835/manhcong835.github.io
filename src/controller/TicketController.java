/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;
import dao.MovieRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Showtime;
import model.ShowtimeInfor;
import util.DBConnection;

public class TicketController {
    private MovieRepository movieRepository = new MovieRepository();
    public void showMovie(DefaultTableModel table) {
        List<ShowtimeInfor> showtimes = movieRepository.getMovie();
        table.setRowCount(0);
       for(ShowtimeInfor showtimeInfor : showtimes){
           Vector<Object> row = new Vector<>();
           row.add(showtimeInfor.getId());
           row.add(showtimeInfor.getStartTime());
           row.add(showtimeInfor.getTitle());
           row.add(showtimeInfor.getName());
           table.addRow(row);
       }
    }
    
    //Lấy bảng suất chiếu trong db
    public List<Showtime> showShowTime() {
        List<Showtime> list= new ArrayList<>();
        String query = "SELECT * FROM SuatChieu";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
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
    
//    ShowtimeInfor getShowtimeInfor(int selectedIndex);
}
