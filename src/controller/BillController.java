/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.BillDAO;
import java.util.List;
import model.Bill;

public class BillController {

    private BillDAO billDAO;

    public BillController() {
        billDAO = new BillDAO();
    }

    // Lấy tất cả hóa đơn
    public List<Bill> getAllBills() {
        return billDAO.getAllBills();
    }

    public String getCustomerNameById(String accountId) {
        return billDAO.getCustomerNameById(accountId);
    }

    // Tìm hóa đơn theo mã hoặc tên khách hàng
    public List<Bill> searchBills(String keyword) {
        return billDAO.searchBills(keyword);
    }

    // Xóa hóa đơn theo mã
    public boolean deleteBill(String billId) {
        return billDAO.deleteBill(billId);
    }
    
    public Bill getBillById(String billId) {
        return billDAO.getBillById(billId); 
    }

    public boolean hasShowtimeStarted(String billId) {
        return billDAO.hasShowtimeStarted(billId);
    }

}
