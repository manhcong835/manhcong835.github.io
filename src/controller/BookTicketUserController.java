/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.BookTicketUserDAO;
import java.util.ArrayList;
import java.util.List;
import model.Seat;
import model.Showtime;
import model.ShowtimeInfor;

/**
 *
 * @author ADMIN
 */
public class BookTicketUserController {
    private BookTicketUserDAO bookTicketUserDAO;
    
    public BookTicketUserController() {
        bookTicketUserDAO = new BookTicketUserDAO();
    }
    
    public List<ShowtimeInfor> getShowTime(String maPhim) {
        return bookTicketUserDAO.getShowtime(maPhim);
    }
    
    public List<Seat> getSeatsByRoomId(String showtimeId) {
        return bookTicketUserDAO.getSeatsByRoomId(showtimeId);
    }
    
    public ArrayList<String> searchSeatNameFromsShowTime(String status, String showtimeId) {
        return bookTicketUserDAO.searchSeatNameFromsShowTime(status, showtimeId);
    }
    
    public List<Showtime> showShowTime(String maPhim){
        return bookTicketUserDAO.showShowTime(maPhim);
    }
    
    public String getSeatId(String nameSeat, String roomId) {
        return bookTicketUserDAO.getSeatId(nameSeat, roomId);
    }
    
    public boolean datVe(String maVe, String showtimeId, String seatId, String titles, String idTaiKhoan) {
        return bookTicketUserDAO.datVe(maVe, showtimeId, seatId, titles, idTaiKhoan);
    }
    
    public boolean InsertHoaDon(String maHD, String IdTaiKhoan, Double totalAmount, String note) {
        return bookTicketUserDAO.InsertHoaDon(maHD, IdTaiKhoan,totalAmount, note);
    }
    
    public boolean InsertChiTietHoaDon(String maHD, String maVe) {
        return bookTicketUserDAO.InsertChiTietHoaDon(maHD, maVe);
    }
}
