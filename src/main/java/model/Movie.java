package model;

import java.io.Serializable;

public class Movie implements Serializable {

    private String title;
    private String director;
    private String lengthInMinutes;
    private String description;
    private String rating;

    public Movie() {

    }

    public Movie(String title, String director, String lengthInMinutes, String description, String rating) {
        this.title = title;
        this.director = director;
        this.lengthInMinutes = lengthInMinutes;
        this.description = description;
        this.rating = rating;

    }

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getDirector() {return director;}
    public void setDirector(String director) {this.director = director;}

    public String getLengthInMinutes() {return lengthInMinutes;}
    public void setLengthInMinutes(String lengthInMinutes) {this.lengthInMinutes = lengthInMinutes;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public String getRating() {return rating;}
    public void setRating(String rating) {this.rating = rating;}


    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", lengthInMinutes='" + lengthInMinutes + '\'' +
                ", description= '" + description + '\'' +
                ", rating= '" + rating + '\'' +
                '}';
    }




}
