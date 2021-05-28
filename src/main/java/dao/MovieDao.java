package dao;

import model.Movie;

import java.util.List;

public interface MovieDao {

    void populate(String filePath) throws MovieDaoException;

    List<Movie> retrieveMovie() throws MovieDaoException;

    void insertMovie(Movie movie) throws MovieDaoException;

}
