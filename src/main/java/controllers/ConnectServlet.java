package controllers;

import comparator.LengthComparator;
import comparator.RatingComparator;
import comparator.TitleComparator;
import dao.MovieDao;
import dao.MovieDaoException;
import dao.MovieDaoImpl;
import model.Movie;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import utility.WorkbookUtility;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.File;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "connect", urlPatterns = "/connect")
public class ConnectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String target = "/view-all.jsp";
        //final String filePath = getServletContext().getRealPath(WorkbookUtility.INPUT_FILE);
        //final File inputFile = new File(filePath);

        // Fetch Information and use it to populate model
        try {
            // do the sort
            //final List<Movie> movies = WorkbookUtility.retrieveMovies(inputFile);

            final MovieDao movieDao = new MovieDaoImpl();
            final List<Movie> movies = movieDao.retrieveMovie();

            String sortType = request.getParameter("sortType");

            if (null != sortType && sortType.equals("title")) {
                Collections.sort(movies, new TitleComparator());
            } else if (null != sortType && sortType.equals("lengthInMinutes")) {
                Collections.sort(movies, new LengthComparator());
            } else if (null != sortType && sortType.equals("rating")) {
                Collections.sort(movies, new RatingComparator());
            }


            // attach model to the request
            request.setAttribute("movies", movies);

        } catch (MovieDaoException e) {
            e.printStackTrace();
        }


        // forward the request to the view
        getServletContext().getRequestDispatcher(target).forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
