/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.MovieTicketHistoryUserDAO;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class MovieTicketHistoryUserController {
    private MovieTicketHistoryUserDAO movieTicketHistoryUserDAO;
    
    public MovieTicketHistoryUserController() {
        movieTicketHistoryUserDAO = new MovieTicketHistoryUserDAO();
    }
    public List<Object[]> getInvoiceInfor(String idTaiKhoan) {
        return movieTicketHistoryUserDAO.getInvoiceInfor(idTaiKhoan);
    }
    
    public List<Object[]> timKiemHoaDonTheoPhim(String maTaiKhoan, String tenPhim){
        return movieTicketHistoryUserDAO.timKiemHoaDonTheoPhim(maTaiKhoan, tenPhim);
    }
}
