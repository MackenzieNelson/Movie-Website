package dao;

import model.Movie;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import utility.DBUtility;
import utility.WorkbookUtility;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MovieDaoImpl implements MovieDao {

    final static String DROP_TABLE = "drop table if exists movie;";
    final static String CREATE_TABLE = "create table movie (id integer primary key autoincrement, title text, lengthInMinutes text, director text, description text, rating text);";
    final static String SELECT_ALL_FROM_MOVIE = "select * from movie;";

    @Override
    public void populate(String filePath) throws MovieDaoException {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DBUtility.createConnection();
            statement = connection.createStatement();

            statement.setQueryTimeout(DBUtility.TIMEOUT);

            statement.executeUpdate(DROP_TABLE);
            statement.executeUpdate(CREATE_TABLE);

            // populate the database from workbook utility
            final File inputFile = new File(filePath);
            final List<Movie> movies = WorkbookUtility.retrieveMovies(inputFile);

            for (final Movie movie : movies) {
                final String insertValues = "insert into movie (title, lengthInMinutes, director, description, rating)" +
                        "values ('" + movie.getTitle() + "', '" + movie.getLengthInMinutes() + "', '" + movie.getDirector() + "', '" + movie.getDescription() + "', '" + movie.getRating() + "');";

                System.out.println(insertValues); // Log the sql that we just inserted

                statement.executeUpdate(insertValues);
            }
        } catch (ClassNotFoundException | SQLException | InvalidFormatException | IOException e) {
            e.printStackTrace();
            throw new MovieDaoException("Error: Unable to populate database.");
        }
    }

    @Override
    public List<Movie> retrieveMovie() throws MovieDaoException {
        // create the list of movies
        final List<Movie> movies = new ArrayList<Movie>();

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DBUtility.createConnection();
            statement = connection.createStatement();

            statement.setQueryTimeout(DBUtility.TIMEOUT);

            //fetch all from the movie table
            final ResultSet results = statement.executeQuery(SELECT_ALL_FROM_MOVIE);

            // loop through the result
            while(results.next()) {

                final String title = results.getString("title");
                final String lengthInMinutes = results.getString("lengthInMinutes");
                final String director = results.getString("director");
                final String description = results.getString("description");
                final String rating = results.getString("rating");

                movies.add(new Movie(title, lengthInMinutes, director, description, rating));

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new MovieDaoException("Error: unable to retrieve the list of movies");

        }
        return movies;
    }

    @Override
    public void insertMovie(Movie movie) throws MovieDaoException {

        // set upt connection and statement
        Connection connection = null;
        PreparedStatement insertStatement = null;

        try {
            connection = DBUtility.createConnection();

            final String sqlString = "insert into movie (title, lengthInMinutes, director, description, rating) values(?, ?, ?, ?, ?);";

            insertStatement = connection.prepareStatement(sqlString);

            insertStatement.setString(1, movie.getTitle());
            insertStatement.setString(2, movie.getLengthInMinutes());
            insertStatement.setString(3, movie.getDirector());
            insertStatement.setString(4, movie.getDescription());
            insertStatement.setString(5, movie.getRating());


            insertStatement.setQueryTimeout(DBUtility.TIMEOUT);

            insertStatement.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new MovieDaoException("Error: Unable to insert movie");
        }

    }
}
