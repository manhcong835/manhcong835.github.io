/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

public class Ticket {
    private String id;
    private String showtimeId;
    private String customerId;
    private String seatId;
    private String status;
    private java.sql.Timestamp bookingTime;

    public Ticket() {
    }

    public Ticket(String id, String showtimeId, String seatId, String status, Timestamp bookingTime) {
        this.id = id;
        this.showtimeId = showtimeId;
        this.seatId = seatId;
        this.status = status;
        this.bookingTime = bookingTime;
    }
    
    public Ticket(String id, String showtimeId, String customerId, String seatId, String status, Timestamp bookingTime) {
        this.id = id;
        this.showtimeId = showtimeId;
        this.customerId=customerId;
        this.seatId = seatId;
        this.status = status;
        this.bookingTime = bookingTime;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(String showtimeId) {
        this.showtimeId = showtimeId;
    }
    
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Timestamp bookingTime) {
        this.bookingTime = bookingTime;
    }
    
}
