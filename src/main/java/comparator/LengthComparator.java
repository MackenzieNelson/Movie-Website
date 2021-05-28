package comparator;

import model.Movie;

import java.util.Comparator;

public class LengthComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie length1, Movie length2) {
        return length1.getLengthInMinutes().compareTo(length2.getLengthInMinutes());
    }
}
