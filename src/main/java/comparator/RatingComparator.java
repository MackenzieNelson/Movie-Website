package comparator;

import model.Movie;

import java.util.Comparator;

public class RatingComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie rating1, Movie rating2) {
        return rating1.getRating().compareTo(rating2.getRating());
    }
}
