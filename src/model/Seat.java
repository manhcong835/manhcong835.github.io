/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Seat {
    private String id;
    private String screenRoomId;
    private String seatName;

    public Seat() {
    }

    public Seat(String id, String screenRoomId, String seatName) {
        this.id = id;
        this.screenRoomId = screenRoomId;
        this.seatName = seatName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScreenRoomId() {
        return screenRoomId;
    }

    public void setScreenRoomId(String screenRoomId) {
        this.screenRoomId = screenRoomId;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }
    
}
