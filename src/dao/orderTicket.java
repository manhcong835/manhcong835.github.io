/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;
import model.Seat;
import util.DBConnection;

/**
 *
 * @author ADMIN
 */
public class orderTicket {
    public boolean datVe(String showtimeId, String seatId) {
        String query = "INSERT INTO Ve (MaVe, TrangThai, ThoiGianDat, MaSuatChieu, MaGhe) VALUES (?, ?, GETDATE(), ?, ?)";
        try (
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            String maVe = "VE" + UUID.randomUUID().toString().substring(0,6).toUpperCase();
            preparedStatement.setString(1, maVe);
            preparedStatement.setString(2, "DaDat");
            preparedStatement.setString(3, showtimeId);
            preparedStatement.setString(4, seatId);
            
            int rows=preparedStatement.executeUpdate();
            return rows>0;
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
