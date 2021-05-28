package controllers;

import com.google.common.base.Strings;
import dao.MovieDao;
import dao.MovieDaoException;
import dao.MovieDaoImpl;
import model.Movie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddNewMovieServlet", urlPatterns = "/AddNewMovie")
public class AddNewMovieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get the information submitted by user
        try {
            final String title = request.getParameter("title");
            final String lengthInMinutes = request.getParameter("lengthInMinutes");
            final String director = request.getParameter("director");
            final String description = request.getParameter("description");
            final String rating = request.getParameter("rating");

            if(Strings.isNullOrEmpty(title)
                    || Strings.isNullOrEmpty(lengthInMinutes)
                    || Strings.isNullOrEmpty(director)
                    || Strings.isNullOrEmpty(description)
                    || Strings.isNullOrEmpty(rating)) {
                //user did not submit all necessary info
                request.setAttribute("message", "Please complete all fields to submit the form.");

            } else {
                // user submitted all necessary info
                final MovieDao movieDao = new MovieDaoImpl();

                // Create a movie object with the info
                final Movie movie = new Movie(title, lengthInMinutes, director, description, rating);

                // insert the movie into the Database using the MovieDao
                movieDao.insertMovie(movie);
                request.setAttribute("message", "The movie was added.");
            }

        } catch (MovieDaoException e) {
            e.printStackTrace();
            request.setAttribute("message", e.getMessage());
        }

        getServletContext().getRequestDispatcher("/add-movie.jsp").forward(request, response);

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


}
