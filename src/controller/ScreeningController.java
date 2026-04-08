package controller;

//import com.microsoft.sqlserver.jdbc.SQLServerWarning;
import dao.ScreeningDao;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import model.Showtime;

public class ScreeningController {
    private ScreeningDao dao;
    
    public ScreeningController() {
        dao = new ScreeningDao();
    }
    
    public List<Showtime> getAllScreenings() {
        return dao.getAllScreenings();
    }
    
    public boolean addScreening(Showtime showtime) {
        return dao.addScreening(showtime);
    }
    
    public boolean updateScreening(Showtime showtime) {
        return dao.updateScreening(showtime);
    }
    
    public boolean deleteScreening(String screeningId) throws SQLException{
        return dao.deleteScreening(screeningId);
    }
    
    public List<String> getAllMovies() {
        return dao.getAllMovies();
    }
    
    public List<String> getAllRooms() {
        return dao.getAllRooms();
    }
    
    public boolean isRoomAvailable(String roomId, Timestamp startTime, String movieId) {
        return dao.isRoomAvailable(roomId, startTime, movieId);
    }
    
    public boolean isRoomAvailableForUpdate(String roomId, Timestamp startTime, String movieId, String currentScreeningId) {
        return dao.isRoomAvailableForUpdate(roomId, startTime, movieId, currentScreeningId);
    }
    
    public String generateNewScreeningId() {
        return dao.generateNewScreeningId();
    }
    
    public String extractIdFromCombinedString(String combinedString) {
        if (combinedString != null && combinedString.contains(" - ")) {
            return combinedString.split(" - ")[0];
        }
        return combinedString;
    }
}