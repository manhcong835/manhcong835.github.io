package controller;

import dao.DetailBillDAO;
import model.BillDetail;
import model.Showtime;
import model.Ticket;

import java.util.List;

public class DetailBillController {
    private DetailBillDAO detailBillDAO;

    public DetailBillController() {
        detailBillDAO = new DetailBillDAO();
    }

    // Lấy danh sách các chi tiết hóa đơn theo billId
    public List<BillDetail> getBillDetailsByBillId(String billId) {
        return detailBillDAO.getBillDetailsByBillId(billId);
    }

    // Lấy đối tượng Ticket theo ticketId
    public Ticket getTicketById(String ticketId) {
        return detailBillDAO.getTicketById(ticketId);
    }

    // Lấy đối tượng Showtime theo showtimeId
    public Showtime getShowtimeById(String showtimeId) {
        return detailBillDAO.getShowtimeById(showtimeId);
    }

    // Lấy tên ghế theo seatId
    public String getSeatNameById(String seatId) {
        return detailBillDAO.getSeatNameById(seatId);
    }
}
