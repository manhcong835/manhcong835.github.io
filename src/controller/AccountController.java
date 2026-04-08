package controller;

import dao.AccountDao;
import java.util.List;
import model.Account;
import view.AccountPanel;

public class AccountController {

    private AccountDao dao;

    //constructor
    public AccountController() {
        dao = new AccountDao();
    }

    //
    public List<Account> getData() {
        return dao.getAllAccounts();
    }

    public List<Account> getAllUsers() {
        return dao.getAllUsers();
    }

    //thêm tài khoản
    public boolean addAccount(String id, String username, String password, String role) {
        if (username.isEmpty() || password.isEmpty() || role.isEmpty()) {
            return false;
        }
        Account acc = new Account(id, username, password, role);
        return dao.insertAccount(acc);
    }

    public boolean register(Account acc) {
        if (dao.isIdOrUsernameExists(acc.getId(), acc.getUsername())) {
            return false;
        }

        return dao.register(acc); // Thực hiện insert
    }

    // Xóa tài khoản theo id (String)
    public boolean deleteAccountById(String id) {
        return dao.deleteAccountById(id);
    }

    //check id username
    public boolean checkIdandUsername(String id, String username) {
        return dao.isIdOrUsernameExists(id, username);
    }
    
    public boolean isUsernameExistsExceptId(String id, String username) {
        return dao.isUsernameExistsExceptId(id, username);
    }

    //chỉnh sửa tài khoản
    public boolean updateAccount(String id, String username, String password, String role) {
        if (username.isEmpty() || password.isEmpty() || role.isEmpty()) {
            return false;
        }
        Account acc = new Account(id, username, password, role);
        return dao.updateAccount(acc);
    }
    // tìm kiếm

    public List<Account> searchAccountById(String keyword) {
        return dao.searchById(keyword);
    }
}
