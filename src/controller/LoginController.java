package controller;

import dao.LoginDao;
import model.Account;

public class LoginController {
    private LoginDao loginDao;
    
    public LoginController() {
        loginDao = new LoginDao();
    }
    
    public Account login(String username, String password) {
        return loginDao.checkLogin(username, password);
    }
}