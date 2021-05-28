package controllers;

import dao.MovieDao;
import dao.MovieDaoException;
import dao.MovieDaoImpl;
import model.Movie;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import utility.WorkbookUtility;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "SearchServlet", urlPatterns = "/Search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // fetch list of people
        try {

            final MovieDao movieDao = new MovieDaoImpl();
            final List<Movie> movies = movieDao.retrieveMovie();

            String titleString = request.getParameter("title");
            String directorString = request.getParameter("director");
            // filter list
            if ((directorString.equals("") ) && titleString != null) {
                final List<Movie> filtered = movies.stream()
                        .filter((Movie m) -> m.getTitle().equalsIgnoreCase(titleString))
                        .collect(Collectors.toList());

                // attach the list to the request
                request.setAttribute("movies", filtered);
            } else if ((titleString.equals("") ) && (directorString != null)) {
                final List<Movie> filtered = movies.stream()
                        .filter((Movie m) -> m.getDirector().equalsIgnoreCase(directorString))
                        .collect(Collectors.toList());

                // attach the list to the request
                request.setAttribute("movies", filtered);
            }

        } catch (MovieDaoException e) {
            e.printStackTrace();
        }

        // forward request to the view
        getServletContext().getRequestDispatcher("/view-all.jsp").forward(request, response);
    }
}
