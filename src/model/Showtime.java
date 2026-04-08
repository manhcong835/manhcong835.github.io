package model;

import java.sql.Timestamp;

public class Showtime {
    private String id;
    private String movieId;
    private String movieName;
    private String screenRoomId;
    private String roomName;
    private Timestamp startTime;
    private double ticketPrice;
    private String status;

    // Constructors
    public Showtime() {
    }

    public Showtime(String id, String movieId, String screenRoomId, Timestamp startTime, 
                   double ticketPrice, String status) {
        this.id = id;
        this.movieId = movieId;
        this.screenRoomId = screenRoomId;
        this.startTime = startTime;
        this.ticketPrice = ticketPrice;
        this.status = status;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getScreenRoomId() {
        return screenRoomId;
    }

    public void setScreenRoomId(String screenRoomId) {
        this.screenRoomId = screenRoomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}