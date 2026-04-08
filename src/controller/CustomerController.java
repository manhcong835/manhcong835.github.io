package controller;

import dao.CustomerDao;
import java.util.List;
import model.Account;

public class CustomerController {

    private CustomerDao dao;

    public CustomerController() {
        dao = new CustomerDao();
    }

    public List<Account> getAllUsers() {
        return dao.getAllUsers();
    }

    public boolean khoaTaiKhoan(String id) {
        return dao.updateTrangThai(id, "Không hoạt động");
    }

    public boolean moTaiKhoan(String id) {
        return dao.updateTrangThai(id, "Đang hoạt động");
    }
     public Account searchAccountById(String id) {
        return dao.searchById(id);
    }
}
