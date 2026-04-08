package controller;

import dao.UserHomeDao;
import java.util.List;
import model.Movie;

public class UserHomeController {
    private UserHomeDao dao;

    // Constructor có đối số (vẫn giữ nguyên nếu bạn cần tiêm phụ thuộc)
    public UserHomeController(UserHomeDao dao) {
        this.dao = dao;
    }

    public UserHomeController() {
        this.dao = new UserHomeDao(); // khởi tạo dao mặc định
    }

    public List<Movie> getAllMovies() {
        return dao.getAllMovies();
    }
}
