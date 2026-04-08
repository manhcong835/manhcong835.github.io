/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class ScreenRoom {
    private String id;
    private String name;
    private int seatCount;

    public ScreenRoom() {
    }

    public ScreenRoom(String id, String name, int seatCount) {
        this.id = id;
        this.name = name;
        this.seatCount = seatCount;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

}
