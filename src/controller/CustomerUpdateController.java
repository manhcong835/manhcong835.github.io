/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CustomerUpdateDao;
import model.Account;

public class CustomerUpdateController {
    private CustomerUpdateDao dao;
    private Account currentAccount;

    public CustomerUpdateController() {
        dao = new CustomerUpdateDao();
    }

    public Account getCustomerById(String id) {
        return dao.getCustomerById(id);
    }
    public boolean saveCustomer(Account account) {
        return dao.updateCustomer(account);
    }
    
    public boolean updateCustomerInfo(Account account) {
        return dao.updateCustomerInfo(account);
    }

    public boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
}