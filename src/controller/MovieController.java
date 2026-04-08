/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.MovieDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import model.Movie;

public class MovieController {
    private MovieDAO movieDAO;

    public MovieController() {
        movieDAO = new MovieDAO();
    }

    public boolean isDuplicateMovie(String title, Date releaseDate){
        return movieDAO.isDuplicateMovie(title, releaseDate);
    }
    
    public boolean isDuplicateMovieExcludingSelf(String id, String title, Date releaseDate){
        return movieDAO.isDuplicateMovieExcludingSelf(id, title, releaseDate);
    }
    
    public List<Movie> getAllMovies() {
        return movieDAO.getAll();
    }

    public Movie getMovieById(String id) {
        return movieDAO.getById(id);
    }

    public boolean addMovie(Movie movie) {
        return movieDAO.insert(movie);
    }

    public boolean updateMovie(Movie movie) {
        return movieDAO.update(movie);
    }

    public boolean deleteMovie(String id) throws SQLException{
        return movieDAO.delete(id);
    }

    public List<Movie> searchMoviesByTitle(String keyword) {
        return movieDAO.searchByTitle(keyword);
    }
}
