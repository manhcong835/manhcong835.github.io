package controller;

import dao.DashboardDAO;

public class DashboardController {
    private DashboardDAO dao;
    
     public DashboardController() {
        dao = new DashboardDAO(); 
    }
    
    public int getTotalPhim() {
        return dao.getTotalPhim();
    }
    
    public int getTotalSuatChieu() {
        return dao.getTotalSuatChieu();
    }
    
    public int getTotalAccount() {
        return dao.getTotalAccount();
    }
    
    public int getTotalTicket() {
        return dao.getTotalTicket();
    }
    
    public double getTotalMoney() {
        return dao.getTotalMoney();
    }
}
